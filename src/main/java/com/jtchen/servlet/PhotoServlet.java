package com.jtchen.servlet;

import com.jtchen.DAO.CommentsDao;
import com.jtchen.DAO.FavouritesDao;
import com.jtchen.DAO.PhotoDao;
import com.jtchen.beans.Photo;
import com.jtchen.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PhotoServlet", value = "/PhotoServlet")
public class PhotoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User u = (User) request.getSession().getAttribute("user");
        String pid = request.getParameter("pid");
        String action = request.getParameter("action");

        PhotoDao pDao = new PhotoDao();
        Photo photo = pDao.getPhoto(pid);
        request.setAttribute("photo", photo);

        CommentsDao cDao = new CommentsDao();
        var list = cDao.get(Integer.parseInt(pid));
        request.setAttribute("comment list", list);

        if (action.equals(String.valueOf(2))) {
            FavouritesDao fDao = new FavouritesDao();
            if (!fDao.addFav(u.getId(), Integer.parseInt(pid))) {
                request.getRequestDispatcher("/do/picture_failed.jsp?action=1&pid=" + pid).forward(request, response);
            } else {
                request.getRequestDispatcher("/do/picture_successful.jsp?action=1&pid=" + pid).forward(request, response);
            }
        }

        if (action.equals(String.valueOf(3))) {
            String comment = request.getParameter("comment");
            CommentsDao dao = new CommentsDao();
            dao.add(u.getName(), Integer.parseInt(pid), comment);
            request.getRequestDispatcher("/picture.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/picture.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
