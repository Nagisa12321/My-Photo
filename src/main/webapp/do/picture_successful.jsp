<%@ page import="com.jtchen.beans.Photo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object tmp = request.getAttribute("photo");
    Photo p = (Photo) tmp;
%>
<html>
<head>
    <title>添加收藏成功</title>
    <meta charset="UTF-8">
</head>
<body>
<h1 style="color: darkgreen">添加成功</h1><br/>
<div style="background-color: black">
    <a style="color: white;margin-left: 30px" href="../index.jsp">注销</a>
</div>
<a href="HomeServlet">返回首页</a>
<a href="PhotoServlet?action=1&pid=<%=p.getPhoto_id()%>">回到图片</a>
</body>
</html>
