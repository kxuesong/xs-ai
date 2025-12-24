# 若依 AI 平台 - 代码规范文档

> 本文档记录开发过程中的常见错误及正确规范，避免重复犯错。

## 重要提醒 ⚠️

**所有 VO 类必须添加 `@AutoMapper` 注解！**

否则会出现运行时错误：`cannot find converter from XXX to XXXVo`

## 一、包名导入规范

### 问题分析

在 `ruoyi-game-design` 模块中发现了大量错误的包名引用，共涉及 **41 个文件**。这些错误主要是因为：

1. **手动编写代码时误用了不存在的包名**
2. **从其他项目复制代码时未检查包名差异**
3. **缺少明确的包名映射文档**
4. **IDE 自动导入功能可能选择了错误的类**

### 正确的包名映射表

| 功能模块 | ❌ 错误包名 | ✅ 正确包名 | 涉及类 |
|---------|-----------|-----------|--------|
| **分页相关** | `org.ruoyi.common.mybatis.core.page` | `org.ruoyi.core.page` | PageQuery, TableDataInfo |
| **Mapper 基类** | `org.ruoyi.common.mybatis.core.mapper` | `org.ruoyi.core.mapper` | BaseMapperPlus |
| **实体基类** | `org.ruoyi.common.mybatis.core.domain` | `org.ruoyi.core.domain` | BaseEntity |
| **Excel 注解** | `org.ruoyi.excel.annotation` | `org.ruoyi.common.excel.annotation` | ExcelDictFormat, ExcelEnumFormat |
| **Excel 转换器** | `org.ruoyi.excel.convert` | `org.ruoyi.common.excel.convert` | ExcelDictConvert |

### 正确使用示例

#### 1. Service 接口

```java
package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;           // ✅ 正确
import org.ruoyi.core.page.TableDataInfo;       // ✅ 正确
import org.ruoyi.game.domain.Game;
import org.ruoyi.game.domain.vo.GameVo;

import java.util.Collection;
import java.util.List;

public interface IGameService {
    TableDataInfo<GameVo> queryPageList(Game game, PageQuery pageQuery);
    // ...
}
```

#### 2. Service 实现类

```java
package org.ruoyi.game.service.impl;

import org.ruoyi.core.page.PageQuery;           // ✅ 正确
import org.ruoyi.core.page.TableDataInfo;       // ✅ 正确
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements IGameService {
    // ...
}
```

#### 3. Controller

```java
package org.ruoyi.game.controller;

import org.ruoyi.core.page.PageQuery;           // ✅ 正确
import org.ruoyi.core.page.TableDataInfo;       // ✅ 正确
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {
    // ...
}
```

#### 4. Mapper 接口

```java
package org.ruoyi.game.mapper;

import org.ruoyi.core.mapper.BaseMapperPlus;    // ✅ 正确
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GameMapper extends BaseMapperPlus<Game, GameVo> {
    // ...
}
```

#### 5. Domain 实体类

```java
package org.ruoyi.game.domain;

import org.ruoyi.core.domain.BaseEntity;        // ✅ 正确
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("game")
public class Game extends BaseEntity {
    // ...
}
```

#### 6. VO 类（含 Excel 导出）

```java
package org.ruoyi.game.domain.vo;

import io.github.linpeilie.annotations.AutoMapper;                       // ✅ 必须导入
import org.ruoyi.game.domain.Game;                           // ✅ 导入对应的实体类
import com.alibaba.excel.annotation.ExcelProperty;
import org.ruoyi.common.excel.annotation.ExcelDictFormat;     // ✅ 正确
import org.ruoyi.common.excel.convert.ExcelDictConvert;      // ✅ 正确
import lombok.Data;

@Data
@AutoMapper(target = Game.class)                             // ✅ 必须添加此注解！
public class GameVo {
    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_normal_disable")
    private String status;
}
```

**⚠️ 重要：所有 VO 类必须添加 `@AutoMapper` 注解！**
- 这是 mapstruct-plus 生成对象转换器的关键
- 缺少此注解会导致运行时错误：`cannot find converter from XXX to XXXVo`
- `target` 参数指向对应的实体类（Entity）

## 二、开发流程规范

### 2.1 使用代码生成器（推荐）

**强烈建议使用项目内置的代码生成器**，它已经配置了正确的包名：

1. 访问代码生成器页面
2. 配置表信息和字段
3. 生成代码会自动使用正确的包名：
   - `org.ruoyi.core.page.*`
   - `org.ruoyi.core.mapper.*`
   - `org.ruoyi.core.domain.*`
   - `org.ruoyi.common.excel.*`

### 2.2 手动编写代码时的检查清单

如果必须手动编写代码，请遵循以下步骤：

- [ ] **参考同模块中其他功能的代码**（如 `ruoyi-chat`, `ruoyi-generator`）
- [ ] **使用 IDE 自动导入前先检查包名**
- [ ] **导入后验证包名是否为 `org.ruoyi.core.*` 或 `org.ruoyi.common.excel.*`**
- [ ] **⚠️ VO 类必须添加 `@AutoMapper` 注解**
- [ ] **编译前运行包名检查脚本**（见下方）

### 2.3 从其他模块复制代码时

- [ ] **复制后立即检查所有 import 语句**
- [ ] **确认包名符合本项目规范**
- [ ] **运行包名检查脚本验证**

## 三、快速修复工具

### 3.1 自动修复包名错误

项目根目录下的 `fix-imports.ps1` 可以自动修复包名错误：

```powershell
# 执行修复
cd d:\Fun2Lern\FunAI
powershell -ExecutionPolicy Bypass -File fix-imports.ps1
```

该脚本会自动替换所有错误的包名引用。

### 3.2 自动添加 @AutoMapper 注解

如果 VO 类缺少 `@AutoMapper` 注解，使用以下脚本批量添加：

```powershell
# 执行修复
cd d:\Fun2Lern\FunAI
powershell -ExecutionPolicy Bypass -File add-automapper.ps1
```

该脚本会：
- 自动检测所有 VO 类
- 添加必要的 import 语句
- 添加 `@AutoMapper` 注解并指向对应的实体类

**修复完成后必须重新编译：**

```bash
cd xs-ai
mvn clean compile -DskipTests
```

### 手动检查命令

```bash
# 检查是否存在错误的包名引用
cd xs-ai/ruoyi-modules/ruoyi-game-design
grep -r "org\.ruoyi\.common\.mybatis\.core\|org\.ruoyi\.excel\." --include="*.java" .

# 如果有输出，说明存在错误引用
```

## 四、IDE 配置建议

### IDEA 自动导入设置

为避免 IDE 自动导入错误的包：

1. **Settings** → **Editor** → **General** → **Auto Import**
2. **优化导入顺序**，将常用包放在前面
3. **遇到多个同名类时，手动选择正确的包**

### 代码模板配置

创建 IDEA Live Template，包含正确的 import 语句：

```java
// Service 模板
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;

// Mapper 模板
import org.ruoyi.core.mapper.BaseMapperPlus;

// Entity 模板
import org.ruoyi.core.domain.BaseEntity;
```

## 五、提交前检查清单

每次提交代码前，请执行：

```bash
# 1. 运行包名修复脚本
powershell -ExecutionPolicy Bypass -File fix-imports.ps1

# 2. 运行 @AutoMapper 注解修复脚本
powershell -ExecutionPolicy Bypass -File add-automapper.ps1

# 3. 检查是否还有错误的包名
cd xs-ai/ruoyi-modules/ruoyi-game-design
grep -r "org\.ruoyi\.common\.mybatis\.core\|org\.ruoyi\.excel\." --include="*.java" .

# 4. 清理并重新编译（必须！）
cd xs-ai
mvn clean compile -DskipTests -pl ruoyi-modules/ruoyi-game-design -am

# 5. 重启应用验证
```

## 六、常见问题 FAQ

### Q1: 为什么不是 `org.ruoyi.common.mybatis.core.page`？

**A:** 虽然 MyBatis 相关功能在 `ruoyi-common-mybatis` 模块中，但为了简化包名和统一规范，实际的类位于 `org.ruoyi.core.*` 包下。

### Q2: 如何快速找到正确的包名？

**A:**
1. 参考代码生成器模板（`ruoyi-generator/src/main/resources/vm/java/`）
2. 参考其他已有模块（如 `ruoyi-chat`）
3. 查看本文档的映射表

### Q3: 新建模块时应该注意什么？

**A:**
1. 优先使用代码生成器
2. 如果手动编写，复制 `ruoyi-chat` 或 `ruoyi-generator` 模块的代码结构
3. 编写完成后运行 `fix-imports.ps1` 脚本验证

### Q4: 遇到 "cannot find converter from XXX to XXXVo" 错误怎么办？

**A:** 这是因为 VO 类缺少 `@AutoMapper` 注解导致的。

**原因分析：**
- 项目使用 mapstruct-plus 进行对象转换
- mapstruct-plus 需要通过 `@AutoMapper` 注解在编译时生成转换器
- 缺少注解会导致运行时找不到转换器

**解决方案：**
1. 运行自动修复脚本：
   ```bash
   powershell -ExecutionPolicy Bypass -File add-automapper.ps1
   ```

2. 或手动添加注解：
   ```java
   import io.github.linpeilie.annotations.AutoMapper;
   import org.ruoyi.game.domain.Game;

   @Data
   @AutoMapper(target = Game.class)  // 添加此注解
   public class GameVo {
       // ...
   }
   ```

3. 重新编译项目：
   ```bash
   cd xs-ai
   mvn clean compile -DskipTests
   ```

4. 重启应用

**重要提示：** 只修改代码不重新编译是没用的！mapstruct-plus 需要在编译时生成转换器类。

### Q5: 遇到"非法字符: '\ufeff'"错误怎么办？

**A:** 这是文件开头包含 UTF-8 BOM（字节顺序标记）导致的。

**原因：**
- 某些编辑器或脚本会在保存文件时添加 UTF-8 BOM
- Java 编译器不允许源代码文件包含 BOM
- BOM 字符 `\ufeff` 会导致编译失败

**解决方案：**

方法1：使用命令行移除 BOM
```bash
cd xs-ai/ruoyi-modules/ruoyi-game-design/src/main/java/org/ruoyi/game/domain/vo
sed -i '1s/^\xEF\xBB\xBF//' *.java
```

方法2：`add-automapper.ps1` 脚本已内置 BOM 移除功能
```bash
powershell -ExecutionPolicy Bypass -File add-automapper.ps1
```

方法3：配置编辑器
- IDEA: Settings → Editor → File Encodings → "UTF-8" (不要选择 "UTF-8 with BOM")
- VS Code: 文件右下角点击编码 → 选择 "UTF-8"（不是 "UTF-8 with BOM"）

**预防措施：**
- 始终使用纯 UTF-8 编码（无 BOM）
- 避免使用 Windows 记事本编辑代码
- 推荐使用 IDEA、VS Code 等专业 IDE

## 七、相关资源

- **代码生成器模板位置**: `xs-ai/ruoyi-modules/ruoyi-generator/src/main/resources/vm/java/`
- **参考模块**: `xs-ai/ruoyi-modules/ruoyi-chat/`
- **自动修复脚本**: `fix-imports.ps1`
- **项目文档**: `CLAUDE.md`

---

**最后更新**: 2025-12-23
**维护者**: 开发团队
**版本**: 1.0.0
