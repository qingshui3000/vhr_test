# vhr_test
vhr  微人事，Spring Boot + VUE全栈项目开发  
day1：  

​	搭建服务端环境，创建项目目录；  

​    创建MySQL数据表；  

​    部署到了github；  

day2:

​	实现了基于SpringSecurity的登陆模块；

​	经测试有bug，账密正确但登陆失败；

day3：

​	已修复登录模块bug，经检查是hr没有实现通过hr_role关联表获取该hr角色的方法和sql语句；

​	使用Vue和Element UI实现了登录页面；

​	使用axios进行登录的接口访问和路由跳转；

day4:

​	实现根据不同用户的角色权限动态加载主页面侧边栏菜单功能；

​	实现了后端接口：主要是menu的query（根据role_id）；

​	实现了前端页面，包括路由的配置、封装了一些axios请求在utils.js里，导入了一些二级菜单页面静态资源；

​	debug：主要是拼写错误、导包错误和多余未实现的模块引发的错误；

day5:

​	实现了查看所有员工资料的功能；

​	实现了后端接口：employee以及joblevel、nation等表的联合查询并实现了分页；

​	实现了前端页面，员工信息的table和js中设置参数并初始化；

​	安装了Font-Awesome图标库并在页面中使用；

​	debug：初始化的很多参数并未声明，故不进行渲染；

​	仍然存在的问题：因copy源码带来了冗余方法、关键字、参数等（已删除一部分），前端控制台有报错信息；

​									formatDate未解释错误；

day6:

​	文档不全、没有视频、不懂vue、不懂axios、自己太菜，故放弃该项目😭😭🐷；