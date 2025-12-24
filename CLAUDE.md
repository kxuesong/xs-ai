# CLAUDE.md

本文件为 Claude Code (claude.ai/code) 在此仓库中工作时提供指导。

**📋 编码规范：** 编写代码时，请严格遵循 [架构设计与开发规范](docs/架构设计与开发规范.md)，包括设计原则、命名规范、分层架构、数据库设计等。

## 项目概述

RuoYi AI 是基于 Spring Boot 3.4.4 和 Java 17 构建的企业级 AI 助手平台。深度集成多个 AI 平台（FastGPT、扣子 Coze、DIFY），支持知识图谱 RAG，提供 AI 工作流编排能力。

**相关仓库：**
- 后端服务（本仓库）：Java/Spring Boot 后端服务
- 用户前端：Vue 3 用户界面
- 管理后台：Vue 3 管理面板

## 构建与开发命令

### 构建项目

```bash
# 清理并编译整个项目
mvn clean compile

# 跳过测试构建
mvn clean package -DskipTests

# 使用特定环境构建（dev 是默认环境）
mvn clean package -P dev
mvn clean package -P prod

# 只构建 admin 模块（应用入口）
cd ruoyi-admin && mvn clean package -DskipTests
```

### 运行应用

```bash
# 从 admin 模块运行
cd ruoyi-admin
mvn spring-boot:run

# 或运行构建后的 JAR
java -jar ruoyi-admin/target/ruoyi-admin.jar

# 指定环境运行
java -jar ruoyi-admin/target/ruoyi-admin.jar --spring.profiles.active=dev
```

**默认端口：** 6039
**访问地址：** http://localhost:6039

### 测试

```bash
# 运行所有测试
mvn test

# 运行指定模块测试
cd ruoyi-modules/ruoyi-chat && mvn test

# 运行指定环境的测试（匹配 @Tag 注解）
mvn test -P dev
mvn test -P prod

# 构建时跳过测试
mvn clean install -DskipTests
```

测试使用 JUnit 5 的 `@Tag` 注解来匹配 Maven profiles（dev、prod、local）。被排除的测试使用 `@Tag("exclude")`。

### 代码生成

项目包含基于 Velocity 模板的代码生成器（`ruoyi-generator` 模块）：

```bash
# 通过运行中的应用访问代码生成器
# 访问：http://localhost:6039/tool/gen
```

## 架构总览

### 多模块结构

```
ruoyi-ai/
├── ruoyi-common/          # 共享基础设施（21个子模块）
│   ├── ruoyi-common-core      # 核心工具类
│   ├── ruoyi-common-chat      # OpenAI 客户端与聊天框架
│   ├── ruoyi-common-mybatis   # MyBatis-Plus ORM 层
│   ├── ruoyi-common-satoken   # Sa-Token 认证
│   ├── ruoyi-common-redis     # Redis 集成
│   └── ...                    # Excel、OSS、日志、安全等
├── ruoyi-modules/         # 业务模块
│   ├── ruoyi-chat            # 多平台 AI 对话服务
│   ├── ruoyi-system          # 系统管理
│   ├── ruoyi-graph           # 知识图谱（Neo4j + RAG）
│   ├── ruoyi-aihuman         # 数字人/虚拟形象
│   ├── ruoyi-workflow        # AI 工作流编排
│   ├── ruoyi-generator       # 代码生成器
│   └── ruoyi-wechat          # 微信集成
├── ruoyi-modules-api/     # DTO 和 API 契约
│   ├── ruoyi-chat-api        # 聊天实体（ChatMessage、ChatSession 等）
│   ├── ruoyi-knowledge-api   # 知识库实体
│   └── ruoyi-system-api      # 系统实体
├── ruoyi-extend/          # 扩展能力
│   ├── ruoyi-ai-copilot      # Spring AI + MCP 集成
│   └── ruoyi-mcp-server      # 模型上下文协议服务器
└── ruoyi-admin/           # 应用入口
```

### AI 集成架构

**多平台聊天服务模式：**
- `IChatService` 接口定义标准聊天操作
- 每个 AI 平台有专门的实现：
  - `OpenAIServiceImpl` - OpenAI GPT 模型
  - `FastGPTServiceImpl` - FastGPT 平台
  - `CozeServiceImpl` - 字节跳动扣子平台
  - `DifyServiceImpl` - DIFY 平台
  - `OllamaServiceImpl` - 本地 Ollama 模型
  - `DeepSeekChatImpl`、`QianWenAiChatServiceImpl`、`ZhipuAiChatServiceImpl`
- `ChatServiceFactory` - 路由请求到相应的服务实现
- `BillingChatServiceProxy` - 包装所有服务进行 token 使用跟踪

**知识图谱 + RAG 架构：**
- **双存储方案：**
  - Neo4j 存储实体关系图谱
  - Weaviate/Milvus 进行语义向量搜索
- **LangChain4j 集成**用于基于 LLM 的实体提取
- **图谱服务：**
  - `GraphExtractionService` - 从文档提取实体
  - `GraphStoreService` - 存储到 Neo4j
  - `GraphRAGService` - 检索并增强查询
- **多 LLM 提供商**支持图谱操作（OpenAI、DeepSeek、DIFY、通义千问、智谱）

**Spring AI + MCP 集成：**
- 位于 `ruoyi-extend/ruoyi-ai-copilot`
- 使用 Spring AI 1.0.0 和 OpenAI starter
- MCP（模型上下文协议）客户端，支持可扩展工具生态
- MCP 服务器配置文件：`ruoyi-admin/src/main/resources/mcp-server.json`
- ChatClient 与工具回调提供器

### 数据库架构

**主数据库（MySQL）：**
- MyBatis-Plus 3.5.11 作为 ORM
- 通过 `dynamic-datasource-spring-boot3-starter` 支持动态数据源
- 实体扫描：`org.ruoyi.**.domain`
- Mapper 扫描：`org.ruoyi.**.mapper`
- HikariCP 连接池（最大 20，最小空闲 10）
- dev 环境使用 p6spy 进行 SQL 监控

**向量数据库（Weaviate/Milvus）：**
- 在 `VectorStoreProperties.java` 中配置
- Weaviate 默认：http://127.0.0.1:6038，类名：LocalKnowledge
- Milvus 选项：http://localhost:19530，集合名：LocalKnowledge

**知识图谱（Neo4j）：**
- Driver 版本：5.26.0
- Cypher DSL 版本：2024.1.0
- LangChain4j Neo4j：1.2.0-beta8
- 通过 `GraphProperties.java` 配置

**Redis：**
- Redisson 3.20.1 提供分布式特性
- Lock4j 用于分布式锁
- 用于缓存和 Sa-Token 存储

### 安全架构

**Sa-Token 认证（v1.34.0）：**
- Token 名称：`Authorization`
- Token 格式：`Bearer <JWT>`
- Token 有效期：7 天（604800 秒）
- JWT 模式：简单模式（`StpLogicJwtForSimple`）
- 允许同账号并发登录
- Token 存储：通过自定义 `PlusSaTokenDao` 存储到 Redis

**安全排除路径：**
跳过认证的关键路径（在 `SecurityProperties` 中配置）：
- `/chat/send` - 主要聊天接口
- `/chat/upload` - 文件上传
- `/pay/returnUrl`、`/pay/notifyUrl` - 支付回调
- `/doc.html`、`/swagger-ui/**` - API 文档
- `/resource/oss/upload` - 对象存储上传

**权限系统：**
- `SaPermissionImpl` - 自定义权限提供者
- `LoginHelper` - 登录工具和用户上下文
- `UserActionListener` - 跟踪登录/登出事件

### API 层结构

**主要控制器：**
- `ChatController`（`/chat`）- 主要聊天接口
  - `POST /chat/send` - SSE 流式聊天
  - `POST /chat/upload` - 上传文件作为上下文
  - `POST /chat/audio` - 语音转文字
  - `POST /chat/speech` - 文字转语音
- `GraphInstanceController` - 知识图谱管理
- `GraphQueryController` - 图谱查询
- `KnowledgeController` - 知识库 CRUD
- `ChatModelController` - AI 模型配置
- `PromptTemplateController` - 提示词管理
- `WorkflowController` - 工作流编排

**响应模式：**
- 流式响应使用 SSE（Server-Sent Events）通过 `SseEmitter`
- 非流式使用标准 JSON
- 使用 `@Valid` 注解进行验证

## 配置说明

### 核心配置文件

**应用配置：**
- `ruoyi-admin/src/main/resources/application.yml` - 基础配置
- `ruoyi-admin/src/main/resources/application-dev.yml` - 开发环境
- `ruoyi-admin/src/main/resources/application-prod.yml` - 生产环境

**Maven Profiles：**
- `dev`（默认）- 开发环境，debug 日志级别
- `prod` - 生产环境，warn 日志级别
- `local` - 本地开发

**MCP 配置：**
- `ruoyi-admin/src/main/resources/mcp-server.json` - MCP 服务器定义

**日志配置：**
- `ruoyi-admin/src/main/resources/logback-plus.xml` - Logback 配置

### 环境特定配置

**开发环境（application-dev.yml）：**
- 数据库：MySQL 在 117.72.148.218:3306/xs-ai
- Redis：127.0.0.1:6379
- SQL 日志：通过 p6spy 启用
- Weaviate：127.0.0.1:6038

**重要：** 本地运行前需更新数据库凭据和外部服务地址。

### 数据库初始化

```bash
# 从 SQL 脚本初始化数据库
mysql -u username -p xs-ai < script/sql/ruoyi-ai.sql

# 增量更新脚本位于
ls script/sql/update/
```

## 开发模式

### 添加新的 AI 聊天服务

1. 在 `ruoyi-modules/ruoyi-chat/service/chat/impl/` 创建 `IChatService` 实现
2. 在 `ChatModeType` 枚举中添加对应类型
3. 工厂会通过 Spring 的 `List<IChatService>` 注入自动发现
4. 计费代理会自动包装以跟踪 token 使用

示例结构：
```java
@Service
public class CustomAiServiceImpl implements IChatService {
    @Override
    public SseEmitter sendMessage(ChatRequest request) {
        // 实现流式逻辑
    }

    @Override
    public boolean supports(String category) {
        return "CUSTOM_AI".equals(category);
    }
}
```

### 添加知识图谱 LLM 提供商

1. 在 `ruoyi-modules/ruoyi-graph/service/llm/` 实现 `IGraphLLMService`
2. 处理从文档中提取实体
3. 返回结构化的实体关系数据

### 扩展 MCP 工具

1. 在 `mcp-server.json` 添加工具配置
2. 在 Spring AI ChatClient 中实现工具回调
3. 所有使用 MCP 的 AI 聊天服务都可使用该工具

### 自定义计费逻辑

修改 `ruoyi-modules/ruoyi-chat/service/` 中的 `BillingChatServiceProxy` 以调整：
- Token 计数算法
- 成本计算公式
- 扣费时机

## 重要技术细节

### Web 服务器：Undertow（非 Tomcat）
- IO 线程：8
- 工作线程：256
- 缓冲区大小：512 字节
- 直接内存缓冲启用
- 高并发场景性能更优

### 注解处理器
构建需要以下注解处理器：
- Lombok（代码生成）
- MapStruct Plus（Bean 映射）
- Therapi Javadoc（运行时 javadoc 访问）
- Spring Boot Configuration Processor

### 支持的数据库
虽然默认使用 MySQL，但项目支持：
- MySQL（主要）
- PostgreSQL
- Oracle（ojdbc8）
- SQL Server（mssql-jdbc）

驱动依赖在 `ruoyi-admin/pom.xml` 中。

### 异步与调度
- `@EnableAsync` - 启用异步操作
- `@EnableScheduling` - 启用定时任务
- Spring 上下文中有自定义线程池配置
- 图谱提取异步运行

### 文件上传限制
- 单个文件：50MB
- 总请求大小：200MB
- 在 `spring.servlet.multipart` 中配置

## 常见问题与解决方案

### 构建问题

**注解处理器错误：**
确保 Maven compiler 插件配置了所有注解处理器。检查 `pom.xml` 第 412-438 行。

**模块依赖解析：**
在构建单个模块前，从根目录运行 `mvn clean install` 将所有模块安装到本地 Maven 仓库。

**Flatten 插件警告：**
`flatten-maven-plugin` 会将 `${revision}` 替换为实际版本。这是预期行为。

### 运行时问题

**端口 6039 已被占用：**
在 `application.yml` 中修改 `server.port` 或终止现有进程。

**数据库连接错误：**
验证 MySQL 正在运行且 `application-dev.yml` 中的凭据正确。

**Redis 连接错误：**
确保 Redis 运行在 127.0.0.1:6379 或更新配置。

**Sa-Token 登录失败：**
检查 Redis 连接 - Sa-Token 通过自定义 DAO 将会话数据存储在 Redis 中。

**向量数据库连接错误：**
启动应用前必须运行 Weaviate/Milvus。如使用不同端点需更新 `VectorStoreProperties`。

**Neo4j 图谱错误：**
验证 Neo4j 可访问且凭据在 `GraphProperties` 中正确配置。

## 部署

### Docker 部署

`script/deploy/` 中提供的脚本：
- `one-step-script/deploy-cn.sh` - 一键部署（中文）
- `one-step-script/deploy-en.sh` - 一键部署（英文）
- `build-docker-images/scripts/build-ruoyi-admin-image.sh` - 构建后端镜像
- `deploy/` - 部署配置

详细说明见 `docs/RuoYi-AI 后端部署教程（Docker 部署版）.md`。

### 生产构建

```bash
# 使用生产环境构建
mvn clean package -P prod -DskipTests

# JAR 输出位置
ls ruoyi-admin/target/ruoyi-admin.jar
```

## 文档资源

- **官方文档**：https://doc.pandarobot.chat
- **在线演示**：https://web.pandarobot.chat（demo/demo123）
- **管理后台**：https://admin.pandarobot.chat（admin/admin123）
- **API 文档**：http://localhost:6039/doc.html（本地运行时）

## 模块依赖关系

```
ruoyi-admin（应用入口）
  ├── ruoyi-system
  ├── ruoyi-chat
  │     └── ruoyi-chat-api
  ├── ruoyi-graph
  ├── ruoyi-workflow
  │     └── ruoyi-workflow-api
  ├── ruoyi-generator
  └── ruoyi-aihuman

所有模块都依赖：
  ├── ruoyi-common-core
  ├── ruoyi-common-web
  ├── ruoyi-common-satoken
  ├── ruoyi-common-mybatis
  └── 根据需要依赖其他 ruoyi-common-* 模块
```

修改模块依赖时，需确保父 POM（`pom.xml`）的 `<dependencyManagement>` 部分已包含该依赖。
