package com.jtchen.servlet;

import com.jtchen.DAO.PhotoDao;
import com.jtchen.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "UploadServlet", value = "/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        PhotoDao dao = new PhotoDao();
        var list = dao.getUserPhoto(u.getId());

        request.setAttribute("photo list", list);

        // 删除上传
        if (Objects.equals(request.getParameter("action"), String.valueOf(1))) {
            int pid = Integer.parseInt(request.getParameter("pid"));
            dao.remove(String.valueOf(pid));
        }

        request.getRequestDispatcher("/upload.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
