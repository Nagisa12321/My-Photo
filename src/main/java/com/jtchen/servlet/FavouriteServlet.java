package com.jtchen.servlet;

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
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "FavouriteServlet", value = "/FavouriteServlet")
public class FavouriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        FavouritesDao dao = new FavouritesDao();
        var tmpList = dao.getList(u.getId());

        var list = new ArrayList<Photo>();
        PhotoDao pDao = new PhotoDao();
        for (var f : tmpList) {
            Photo o = pDao.getPhoto(String.valueOf(f.getPhoto_id()));
            if (o != null)
                list.add(o);
        }

        request.setAttribute("photo list", new ArrayList<>(list));

        // 删除收藏
        if (Objects.equals(request.getParameter("action"), String.valueOf(1))) {
            int pid = Integer.parseInt(request.getParameter("pid"));
            dao.delete(u.getId(), pid);
        }

        request.getRequestDispatcher("/favourites.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
