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

        $(function (){

            $("#djBtn").click(function (){


                $.ajax({
                    url:"myServlet04.do",
                    type:"get",
                    dataType:"json",
                    success:function (data){

                        // alert(data)

                        $("#id1").html(data.s1.id)
                        $("#name1").html(data.s1.name)
                        $("#age1").html(data.s1.age)

                        $("#id2").html(data.s2.id)
                        $("#name2").html(data.s2.name)
                        $("#age2").html(data.s2.age)

                    }
                })
            })
        })

    </script>
</head>
<body>

<button id="djBtn">点击</button>
<br>
<br>
学员1：<br>
编号：<span id="id1"></span><br>
姓名；<span id="name1"></span><br>
年龄：<span id="age1"></span><br>

<br>
<br>
学员2：<br>
编号：<span id="id2"></span><br>
姓名；<span id="name2"></span><br>
年龄：<span id="age2"></span><br>

</body>
</html>
