# ssm_crud_20181122



整合一个查询系统 

功能点
1. 分页
2. 数据校验
Jquery前端校验+JSR303后端校验
3. Ajax
Bootstrap+Jquery 页面元素和Ajax
4. Rest风格的URI；使用HTTP协议请求方式的动词来表示对资源的操作（GET（查询）， POST（新增），PUT（修改），DELETE(删除)）
技术点
基础框架-ssm（SpringMVC+Spring_MyBatis）
数据库- Mysql
前框框架-bootstrap快速搭建简洁美观的界面
项目的依赖管理-maven
分页-pagehelper
逆向工程-MyBatis Generator
基础环境搭建
1. 创建一个maven工程
2. 引入项目依赖的jar包
spring
springmvc
mybatis
数据库连接池、驱动包
其他（jstl、servlet-api、junit）
3. 引入bootstrap前端框架
4. 编写ssm整合的关键配置文件
web.xml, springmvc spring mybatis, 使用mybatis的逆向工程生成对应的bean和mapper
5. 测试mapper
CRUD
1、访问index.jsp界面
2、index.jsp界面发送出来查询员工列表请求
3、EmployeeController来接受请求，查出员工数据
4、跳转到list.jsp界面进行展示
