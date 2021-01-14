<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>我要上传</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Update</h1>
<div style="background-color: black">
    <a style="color: white; margin-left: 20px" href="HomeServlet">首页</a>
    <a style="color: white; margin-left: 20px" href="update.jsp">我要上传！</a>
    <a style="color: white; margin-left: 20px" href="UploadServlet">我的上传</a>
    <a style="color: white; margin-left: 20px" href="FavouriteServlet">我的收藏</a>
    <a style="color: white;margin-left: 30px" href="index.jsp">注销</a>
</div>
<hr/>
<div id="update">
    <form action="UpdateServlet" method="get">
        <input type="hidden" name="id" size="200"/>
        <label>
            <input type="text" required="required" placeholder="URL" name="url" size="200"/><br/>
        </label>
        <label>
            <input type="text" required="required" placeholder="TITLE" name="title"/><br/>
        </label>
        <a>
            <button class="but" type="submit">上传</button>
        </a>
    </form>
</div>
</body>
</html>
