<%--
  Created by IntelliJ IDEA.
  User: 付元顺
  Date: 2018/11/1
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<script type="text/javascript">
    $(function(){
        $("#btn").click(function(){
             var json = $("#form").serialize();
            console.info(json);

            $.ajax({
                url : "/user/",
                type : "POST",
                dataType : "json",
                // contentType : "application/json",
                data : JSON.stringify(json),
                success : function(data){
                    alert(data.msg);
                }
            })
        });

        $("#getInfoBtn").click(function(){
            var id = $("#id").val();

            $.ajax({
                url : "/user/"+id,
                type : "GET",
                async : false,
                // contentType : "application/json",
                success : function(data){
                    alert(data.data.username);
                    console.info(data);
                }
            })
        });
    })
</script>
<body>
<div style="margin : 0 auto;">
    <form method="post" action="" id="form">
        <input type="text" name="username" id="username" placeholder="用户名"/><br>
        <input type="password" name="password" id="password" placeholder="用户密码"/><br>
        <input type="text" name="sex" id="sex" placeholder="性别"/><br>
        <input type="text" name="email" id="email" placeholder="邮箱"/><br>
        <input type="text" name="phone" id="phone" placeholder="电话"/><br>
        <input type="text" name="address" id="address" placeholder="地址"/><br>
        <input type="text" name="hobby" id="hobby" placeholder="爱好"/><br>
        <button id="btn" type="button">提交</button>
    </form>
    查询用户信息:<br>
    <form action="" method="get" id="getInfoForm">
        <input type="text" name="id" id="id" placeholder="输入id查询用户信息">
        <button type="button" id="getInfoBtn">查询</button>
    </form>
</div>
</body>
</html>
