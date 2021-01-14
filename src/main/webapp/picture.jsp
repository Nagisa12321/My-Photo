<%@ page import="java.util.ArrayList" %>
<%@ page import="com.jtchen.beans.Photo" %>
<%@ page import="com.jtchen.beans.User" %>
<%@ page import="com.jtchen.beans.Comments" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>

</head>
<body>
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

        setInterval("changeColor()", 15);
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
    Object tmp = request.getAttribute("photo");
    Photo p = (Photo) tmp;
%>
<div align="center">
    <img src="<%=p.getPhoto_url()%>" title="<%=p.getPhoto_title()%>" style=""/>
</div>

<div style="background-color: black">
    <a style="color: white; margin-left: 20px" href="PhotoServlet?action=2&pid=<%=p.getPhoto_id()%>">收藏</a>
    <a style="color: white; margin-left: 20px" href="update.jsp">我要上传！</a>
    <a style="color: white;margin-left: 30px" href="index.jsp">注销</a>
</div>
<div>
    <form action="PhotoServlet?action=3&pid=<%=p.getPhoto_id()%>" method="post">
        <label>
            <input type="text" required="required" placeholder="我要bb" name="comment"/>
        </label>
        <a>
            <button class="but" type="submit">bb</button>
        </a>
    </form>
</div>
<%
    Object tmp2 = request.getAttribute("comment list");
    ArrayList<Comments> list = (ArrayList<Comments>) tmp2;

    for (Comments comments : list) {
%>
<h3 style="color: brown"><%=comments.getUser_name()%>  BB道：</h3><h4><%=comments.getUser_comment()%></h4>
<%
    }%>


</body>
</html>
