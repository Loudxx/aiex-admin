# aix-admin

#### 介绍
aix后台管理平台

采用前后端分离的模式，前端开源两个框架：aix-react(基于 React、Ant Design)、aix-vue (基于 Vue、Element-UI)。 
后端分为框架实现aix-framework, boot版本aix-admin, cloud版本aix-cloud  
借鉴ddd领域驱动，增加领域层，适用于复杂项目开发  

整体架构



工程结构
aix-admin  
├── aix-application -- 应用服务层，主要作为各个领域的聚合和事件相关  
├── aix-domain -- 领域服务层，业务的组装  
├── aix-infra -- 基础设施层，持久化层mapper和资源层同域或跨域调用实现    
├── aix-interfaces- -- 接口层, 提供不同应用间接口调用  
├── aix-web -- 应用层，可以是web, app等用户请求处理，不包含业务规则，具体业务在领域层实现  

开发中。。。








