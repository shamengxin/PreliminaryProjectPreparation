<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>mytitle</title>
    <script src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<%--
    例如我们现在写一个学生信息管理系统

    学生信息管理系统中，有学生模块

    对于学生模块基本的增删改查的操作，我们是需要4个Servlet
    它们分别是
        StudentSaveServlet.java
        StudentUpdateServlet.java
        StudentDeleteServlet.java
        StudentSelectServlet.java
    一个Servlet负责处理一个请求（一个需求）

    未来的实际项目开发中，我们不仅仅只有一个模块，而且模块中也不仅仅只有增删改查的操作

    教师模块
        TeacherSaveServlet.java
        TeacherUpdateServlet.java
        TeacherDeleteServlet.java
        TeacherSelectServlet.java

    课程模块
        CourseSaveServlet.java
        CourseUpdateServlet.java
        CourseDeleteServlet.java
        CourseSelectServlet.java

    以上加在一起我们使用了12个servlet

    未来的实际项目开发中，对于Servlet的创建，是按照模块划分的
    一个模块由一个统一的Servlet来处理

    例如上述需求，一共有学生，教师，课程3个模块，我们就应该使用3个servelt来处理
--%>

<h3>学生信息管理系统</h3>
<br>

<a href="student/save.do">添加操作</a><br><br>
<a href="student/update.do">修改操作</a><br><br>
<a href="student/delete.do">删除操作</a><br><br>
<a href="student/select.do">查询操作</a><br><br>
</body>
</html>
