package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.UnitGradeReward;
import org.ruoyi.game.domain.vo.UnitGradeRewardVo;

import java.util.Collection;
import java.util.List;

/**
 * 单位品质奖励 Service 接口
 *
 * @author ruoyi
 */
public interface IUnitGradeRewardService {

    /**
     * 查询单位品质奖励
     *
     * @param id 品质奖励ID
     * @param region 区域标识
     * @return 单位品质奖励
     */
    UnitGradeRewardVo queryById(Integer id, String region);

    /**
     * 查询单位品质奖励列表（分页）
     *
     * @param unitGradeReward 查询条件
     * @param pageQuery 分页参数
     * @return 单位品质奖励集合
     */
    TableDataInfo<UnitGradeRewardVo> queryPageList(UnitGradeReward unitGradeReward, PageQuery pageQuery);

    /**
     * 查询单位品质奖励列表（不分页）
     *
     * @param unitGradeReward 查询条件
     * @return 单位品质奖励集合
     */
    List<UnitGradeRewardVo> queryList(UnitGradeReward unitGradeReward);

    /**
     * 新增单位品质奖励
     *
     * @param unitGradeReward 单位品质奖励
     * @return 结果
     */
    Boolean insertByBo(UnitGradeReward unitGradeReward);

    /**
     * 修改单位品质奖励
     *
     * @param unitGradeReward 单位品质奖励
     * @return 结果
     */
    Boolean updateByBo(UnitGradeReward unitGradeReward);

    /**
     * 批量删除单位品质奖励
     *
     * @param ids 品质奖励ID集合
     * @param region 区域标识
     * @return 结果
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
