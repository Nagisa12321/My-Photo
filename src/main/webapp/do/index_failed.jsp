<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        h5 {
            color: brown;
        }
    </style>
    <%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Login.css"/>--%>
</head>
<body>

<div id="login">
    <h1>Login</h1>
    <form action="LoginServlet" method="get">
        <label>
            <input type="text" required="required" placeholder="ID" name="id"/>
        </label>
        <label>
            <input type="password" required="required" placeholder="PASSWORD" name="password"/>
        </label>
        <a>
            <button class="but" type="submit">登录</button>
        </a>
    </form>
    <a href="${pageContext.request.contextPath}/registered.html">
        <button class="but" type="button">注册</button>
    </a>
    <h5>用户名或者密码错误请重新输入</h5>
</div>

</body>
</html>