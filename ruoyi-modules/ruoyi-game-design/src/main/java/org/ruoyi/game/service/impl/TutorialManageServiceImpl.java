package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.game.domain.TutorialCondition;
import org.ruoyi.game.domain.TutorialEvent;
import org.ruoyi.game.domain.TutorialFlow;
import org.ruoyi.game.domain.TutorialTitle;
import org.ruoyi.game.domain.vo.*;
import org.ruoyi.game.service.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 教程综合管理 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class TutorialManageServiceImpl implements ITutorialManageService {

    private final ITutorialFlowService tutorialFlowService;
    private final ITutorialConditionService tutorialConditionService;
    private final ITutorialEventService tutorialEventService;
    private final ITutorialTitleService tutorialTitleService;

    @Override
    public List<TutorialListItemVo> getTutorialList(String region) {
        // 1. 查询所有流程
        TutorialFlow queryFlow = new TutorialFlow();
        if (StringUtils.isNotBlank(region)) {
            queryFlow.setRegion(region);
        }
        List<TutorialFlowVo> allFlows = tutorialFlowService.queryList(queryFlow);

        // 2. 构建流程ID映射，提升查询性能
        Map<Integer, TutorialFlowVo> flowMap = allFlows.stream()
            .collect(Collectors.toMap(TutorialFlowVo::getId, flow -> flow));

        // 3. 找出所有起始流程（没有被其他流程的nextStepId引用的流程）
        Set<Integer> nextStepIds = allFlows.stream()
            .map(TutorialFlowVo::getNextStepId)
            .filter(Objects::nonNull)
            .filter(id -> id != 0)
            .collect(Collectors.toSet());

        List<TutorialFlowVo> startFlows = allFlows.stream()
            .filter(flow -> !nextStepIds.contains(flow.getId()))
            .collect(Collectors.toList());

        // 4. 查询所有条件和事件（一次性加载）
        TutorialCondition queryCondition = new TutorialCondition();
        if (StringUtils.isNotBlank(region)) {
            queryCondition.setRegion(region);
        }
        List<TutorialConditionVo> allConditions = tutorialConditionService.queryList(queryCondition);

        TutorialEvent queryEvent = new TutorialEvent();
        if (StringUtils.isNotBlank(region)) {
            queryEvent.setRegion(region);
        }
        List<TutorialEventVo> allEvents = tutorialEventService.queryList(queryEvent);

        TutorialTitle queryTitle = new TutorialTitle();
        if (StringUtils.isNotBlank(region)) {
            queryTitle.setRegion(region);
        }
        List<TutorialTitleVo> allTitles = tutorialTitleService.queryList(queryTitle);

        // 5. 按 tutorialFlow 分组条件，提升查询性能
        Map<Integer, List<TutorialConditionVo>> conditionsByFlow = allConditions.stream()
            .collect(Collectors.groupingBy(TutorialConditionVo::getTutorialFlow));

        // 6. 为每个起始流程构建列表项
        return startFlows.stream().map(startFlow -> {
            TutorialListItemVo item = new TutorialListItemVo();
            item.setStartFlowId(startFlow.getId());
            item.setName(startFlow.getNote());
            item.setRegion(startFlow.getRegion());

            // 计算流程链的步骤数（使用优化后的方法）
            List<TutorialFlowVo> flowChain = getFlowChainOptimized(startFlow.getId(), flowMap);
            item.setStepCount(flowChain.size());

            // 计算关联的条件数量（使用预分组的数据）
            int conditionCount = flowChain.stream()
                .mapToInt(flow -> conditionsByFlow.getOrDefault(flow.getId(), Collections.emptyList()).size())
                .sum();
            item.setConditionCount(conditionCount);

            // 计算关联的事件数量（去重）
            Set<Integer> eventIds = flowChain.stream()
                .map(TutorialFlowVo::getEventScript)
                .filter(Objects::nonNull)
                .filter(id -> id != 0)
                .collect(Collectors.toSet());
            item.setEventCount(eventIds.size());

            // 标题数量（同区域的所有标题）
            item.setTitleCount(allTitles.size());

            return item;
        }).collect(Collectors.toList());
    }

    @Override
    public TutorialFullDataVo getTutorialFullData(Integer startFlowId, String region) {
        TutorialFullDataVo fullData = new TutorialFullDataVo();

        // 1. 获取流程链
        List<TutorialFlowVo> flowChain = getFlowChain(startFlowId, region);
        fullData.setFlowChain(flowChain);

        // 2. 获取流程链中所有流程的ID
        Set<Integer> flowIds = flowChain.stream()
            .map(TutorialFlowVo::getId)
            .collect(Collectors.toSet());

        // 3. 查询关联的条件
        TutorialCondition queryCondition = new TutorialCondition();
        if (StringUtils.isNotBlank(region)) {
            queryCondition.setRegion(region);
        }
        List<TutorialConditionVo> allConditions = tutorialConditionService.queryList(queryCondition);
        List<TutorialConditionVo> conditions = allConditions.stream()
            .filter(c -> flowIds.contains(c.getTutorialFlow()))
            .collect(Collectors.toList());
        fullData.setConditions(conditions);

        // 4. 查询关联的事件
        Set<Integer> eventIds = flowChain.stream()
            .map(TutorialFlowVo::getEventScript)
            .filter(Objects::nonNull)
            .filter(id -> id != 0)
            .collect(Collectors.toSet());

        if (!eventIds.isEmpty()) {
            TutorialEvent queryEvent = new TutorialEvent();
            if (StringUtils.isNotBlank(region)) {
                queryEvent.setRegion(region);
            }
            List<TutorialEventVo> allEvents = tutorialEventService.queryList(queryEvent);
            List<TutorialEventVo> events = allEvents.stream()
                .filter(e -> eventIds.contains(e.getId()))
                .collect(Collectors.toList());
            fullData.setEvents(events);
        } else {
            fullData.setEvents(new ArrayList<>());
        }

        // 5. 查询标题（同区域的所有标题）
        TutorialTitle queryTitle = new TutorialTitle();
        if (StringUtils.isNotBlank(region)) {
            queryTitle.setRegion(region);
        }
        List<TutorialTitleVo> titles = tutorialTitleService.queryList(queryTitle);
        fullData.setTitles(titles);

        return fullData;
    }

    @Override
    public List<TutorialFlowVo> getFlowChain(Integer startFlowId, String region) {
        TutorialFlow queryFlow = new TutorialFlow();
        if (StringUtils.isNotBlank(region)) {
            queryFlow.setRegion(region);
        }
        List<TutorialFlowVo> allFlows = tutorialFlowService.queryList(queryFlow);
        return getFlowChainInternal(startFlowId, region, allFlows);
    }

    /**
     * 优化的流程链构建（使用HashMap，O(1)查询）
     */
    private List<TutorialFlowVo> getFlowChainOptimized(Integer startFlowId, Map<Integer, TutorialFlowVo> flowMap) {
        List<TutorialFlowVo> chain = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        Integer currentId = startFlowId;
        while (currentId != null && currentId != 0) {
            // 防止循环引用
            if (visited.contains(currentId)) {
                break;
            }
            visited.add(currentId);

            // O(1) 时间复杂度查找
            TutorialFlowVo currentFlow = flowMap.get(currentId);
            if (currentFlow == null) {
                break;
            }

            chain.add(currentFlow);

            // 获取下一步ID
            currentId = currentFlow.getNextStepId();

            // 防止死循环（最多100步）
            if (chain.size() >= 100) {
                break;
            }
        }

        return chain;
    }

    /**
     * 递归构建流程链（兼容旧方法，但已不推荐使用）
     * @deprecated 使用 getFlowChainOptimized 代替
     */
    @Deprecated
    private List<TutorialFlowVo> getFlowChainInternal(Integer startFlowId, String region, List<TutorialFlowVo> allFlows) {
        Map<Integer, TutorialFlowVo> flowMap = allFlows.stream()
            .filter(f -> StringUtils.isBlank(region) || region.equals(f.getRegion()))
            .collect(Collectors.toMap(TutorialFlowVo::getId, flow -> flow));
        return getFlowChainOptimized(startFlowId, flowMap);
    }
}
