package com.jtchen.servlet;

import com.jtchen.DAO.UserDao;
import com.jtchen.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var dao = new UserDao();
        // TODO: 2021/1/12 操作数据库记录注册

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        User u = dao.getUser(id);
        HttpSession session = request.getSession();
        session.setAttribute("user", u);

        if (!dao.login(id, password)) {
            // 重定向
            request.getRequestDispatcher("/do/index_failed.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("HomeServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
