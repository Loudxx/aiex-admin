# aiex-admin平台


#### 介绍
aiex-admin（AI eXecution Admin）人工智能驱动的后台管理平台

采用前后端分离的模式，前端开源两个框架：aiex-react(基于 React、Ant Design)、aiex-vue (基于 Vue、Element-UI)。 
后端分为框架实现aiex-framework, boot版本aiex-admin, cloud版本aiex-cloud  
借鉴ddd领域驱动，增加领域层，适用于复杂项目开发  

演示地址：http://www.aix0.top/#/auth/login  
前端项目地址-基于vben5:https://github.com/Loudxx/aiex-vben  
框架地址：https://github.com/Loudxx/aiex-framework

整体架构


工程结构
aiex-admin  
├── aiex-application -- 应用服务层，主要作为各个领域的聚合和事件相关  
├── aiex-domain -- 领域服务层，业务的组装  
├── aiex-infra -- 基础设施层，持久化层mapper和资源层同域或跨域调用实现    
├── aiex-interfaces- -- 接口层, 提供不同应用间接口调用  
├── aiex-web -- 应用层，可以是web, app等用户请求处理，不包含业务规则，具体业务在领域层实现  

