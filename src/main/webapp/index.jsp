<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<script type="text/javascript">
    $(function(){
        $("#btn").click(function(){
            var json = $("#form").serialize();
            console.info(JSON.stringify(json));

            $.ajax({
                url : "/user/",
                type : "POST",
                // contentType : "application/json;charset=utf-8",
                data : json,
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
                success : function(data){
                    alert(data.data.username);
                    console.info(data);
                }
            })
        });

        $("#deleteUserBtn").click(function(){
            var id = $("#delete_id").val();

            $.ajax({
                url : "/user/"+id,
                type : "DELETE",
                success : function(data){
                    console.info(data);
                }
            })
        });

        $("#uploadBtn").click(function(){
           /* var file = $("#file").val();
            if (file === null) {
                alert("请选择一个MP3文件");
            }
            if(!/\.mp3|\.MP3/.test(file)){
                alert("仅支持上传MP3文件");
                return;
            }
            alert(file);
            console.info(file);*/
            $.ajax({
                url : "/upload/",
                type : "POST",
                processData: false,
                contentType: false,
                data : new FormData($("#uploadForm")[0]),
                success : function(data){
                    alert(data.msg);
                }
            })
        });
    })
</script>
<body>
    <form action="" method="post" id="form">
        <input type="text" name="username" id="username" placeholder="用户名"/><br>
        <input type="password" name="password" id="password" placeholder="用户密码"/><br>
        <input type="text" name="sex" id="sex" placeholder="性别"/><br>
        <input type="text" name="email" id="email" placeholder="邮箱"/><br>
        <input type="text" name="phone" id="phone" placeholder="电话"/><br>
        <input type="text" name="address" id="address" placeholder="地址"/><br>
        <input type="text" name="hobby" id="hobby" placeholder="爱好"/><br>
        <button id="btn" type="button">提交</button>
    </form>
<div>
    查询用户信息:<br>
    <form action="" method="get" id="getInfoForm">
        <input type="text" name="id" id="id" placeholder="输入id查询用户信息">
        <button type="button" id="getInfoBtn">查询</button>
    </form>

    删除用户信息:<br>
    <form action="" method="delete" id="deleteUserForm">
        <input type="text" name="id" id="delete_id" placeholder="删除用户的id号">
        <button type="button" id="deleteUserBtn">删除</button>
    </form>
</div>
<div>
    <span>文件上传</span>
    <form action="/upload/" method="POST" id="uploadForm" enctype="multipart/form-data">
        <input type="file" name="file">
        <button type="button" id="uploadBtn">上传</button>
        <%--<input type="submit" value="上传">--%>
    </form>
</div>
</body>
</html>
