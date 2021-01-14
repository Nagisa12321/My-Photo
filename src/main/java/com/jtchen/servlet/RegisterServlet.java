package com.jtchen.servlet;

import com.jtchen.DAO.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static com.jtchen.utils.ConnectionUtils.urlPrefix;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        var dao = new UserDao();
        // TODO: 2021/1/12 操作数据库记录注册
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        // TODO: 2021/1/13 如果有用户存在, 跳转到某个页面
        if(dao.insert(name, id, password)) {
            // 重定向
            request.getRequestDispatcher("/do/registered_successful.html").forward(request, response);
        } else {
            request.getRequestDispatcher("/do/registered_failed.html").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
