package com.jtchen.DAO;

import com.jtchen.DAO.impl.BasicDao;
import com.jtchen.beans.Favorites;

import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/13 22:35
 */
public class FavouritesDao extends BasicDao<Favorites> {
    private final static String addFav = "insert into jt_photo.favorites values (?, ?)";
    private final static String getList = "select * from jt_photo.favorites where user_id=?";
    private final static String delete = "delete from jt_photo.favorites where jt_photo.favorites.user_id = ? and jt_photo.favorites.photo_id = ?";

    // 通过user_id和photo_id 添加喜欢
    public boolean addFav(String user_id, int photo_id) {
        var list = getList(user_id);
        for (var f : list)
            if (f.getPhoto_id() == photo_id)
                return false;
        return update(addFav, user_id, photo_id);
    }

    // 通过user_id获得图片收藏表
    public List<Favorites> getList(String user_id) {
        return toForList(Favorites.class, getList, user_id);
    }

    // 删除某用户喜欢的pid
    public void delete(String user_id, int photo_id) {
        update(delete, user_id, photo_id);
    }


}
