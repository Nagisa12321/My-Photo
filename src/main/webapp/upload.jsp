<%@ page import="java.util.ArrayList" %>
<%@ page import="com.jtchen.beans.Photo" %>
<%@ page import="com.jtchen.beans.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>

</head>
<body>
<div style="float: left; color: brown; width: 100px">
    <img src="./img/img.jpg" width="100">
</div>
<%
    User u = (User) request.getSession().getAttribute("user");
    if (u == null) request.getRequestDispatcher("/index.jsp").forward(request, response);
    String name = u.getName();
%>
<h1>转眼间家乡的SAKULA又开了呢, 该回家了,

    <div id="blink"><%=name%>
    </div>
    <script language="javascript">
        function changeColor() {
            let color = "#f00|#0f0|#00f|#880|#808|#088|yellow|green|blue|gray";
            color = color.split("|");
            document.getElementById("blink").style.color = color[parseInt(Math.random() * color.length)];
        }

        setInterval("changeColor()", 20);
    </script>
</h1>
<div style="background-color: black">
    <a style="color: white; margin-left: 20px" href="HomeServlet">首页</a>
    <a style="color: white; margin-left: 20px" href="update.jsp">我要上传！</a>
    <a style="color: white; margin-left: 20px" href="UploadServlet">我的上传</a>
    <a style="color: white; margin-left: 20px" href="FavouriteServlet">我的收藏</a>
    <a style="color: white;margin-left: 30px" href="index.jsp">注销</a>
</div>

<hr/>
<%
    Object tmp = request.getAttribute("photo list");
    if (tmp == null) request.getRequestDispatcher("/index.jsp").forward(request, response);
    ArrayList<Photo> list = (ArrayList<Photo>) tmp;
    for (Photo photo : list) {
%>
<form action="UploadServlet?action=1&pid=<%=photo.getPhoto_id()%>" method="post">
    <img src="<%=photo.getPhoto_url()%>" height="300px" title="<%=photo.getPhoto_title()%>"/>
    <a>
        <button class="but" type="submit">删除</button>
    </a>
</form>
<%
    }%>
</body>
</html>
