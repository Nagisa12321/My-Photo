package com.jtchen.servlet;

import com.jtchen.DAO.PhotoDao;
import com.jtchen.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        PhotoDao dao = new PhotoDao();
        String url = request.getParameter("url");
        String title = request.getParameter("title");
        if (dao.add(title, url, u.getId())) {
            // 重定向
            request.getRequestDispatcher("/do/update_success.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/do/update_failed.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
