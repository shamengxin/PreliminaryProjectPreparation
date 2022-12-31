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

                // $("#msg").html(123)

                /*
                    关于同步和异步：

                    设置
                        async:true 异步
                            通过观察得到结果，下面的alert弹框没有等到上面的ajax执行完毕，就执行了
                            全程是两根线程，一根主线程负责执行方法中普通的代码，一根线程负责执行ajax
                            两根线程彼此之间相互独立，相互是不受影响的

                        async:false 同步
                            通过观察得到结果，下面的alert弹框必须要等到上面的ajax执行完毕后，才能够执行
                            全程是一根线程，线程是按照代码从上向下的顺序依次执行
                            下面的代码必须要等到上面的代码执行完毕后，才能执行

                        未来实际项目开发中，一般情况下，我们都是使用异步请求可以有效的提升用户体验
                        在特殊需求下，也会使用到同步
                 */



                $.ajax({
                    url:"myServlet01.do",//访问后台servlet地址
                    //data:"key1=value&key2=value2",//为后台传递参数
                    type:"get",//请求方式 get/post
                    dataType:"text",//从后台接收数据的方式，text：接收普通文本 json：接收json格式的文本
                    async:false,//
                    success:function (data){//回调函数（该函数的执行时机是后台执行完毕后，改函数才会执行）

                        //data：从后台响应回来的数据
                        $("#msg").html(data)
                    }
                })

                alert(123)

            })



        })

    </script>
</head>
<body>

<button id="djBtn">点击</button>
<br>
<br>
<div id="msg" style="width: 200px;height: 200px;background-color: pink">

</div>

<br>
<br>
<div style="width: 200px;height: 200px;background-color: pink">
    bcdks
</div>

</body>
</html>
