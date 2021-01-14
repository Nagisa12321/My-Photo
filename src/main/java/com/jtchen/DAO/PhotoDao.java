package com.jtchen.DAO;

import com.jtchen.DAO.impl.BasicDao;
import com.jtchen.beans.Photo;

import java.sql.SQLException;
import java.util.List;


/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/13 0:50
 */
public class PhotoDao extends BasicDao<Photo> {
    private static final String getAll = "select * from jt_photo.photos";
    private static final String add = "insert into jt_photo.photos values (default, ?, ?, ?)";
    private static final String get = "select * from jt_photo.photos where photo_id = ?";
    private static final String getUserP = "select * from jt_photo.photos where jt_photo.photos.user_id=?";
    private static final String delete = "delete from jt_photo.photos where photo_id=?";

    // 获取相册列表
    public List<Photo> getAll() {
        return toForList(Photo.class, getAll);
    }

    // 增加图片
    public boolean add(String title, String url, String user_id) {
        return update(add, title, url, user_id);
    }

    // 获取单个照片
    public Photo getPhoto(String pid) {
        try {
            return getObj(Photo.class, get, pid);
        } catch (SQLException throwables) {
            return null;
        }
    }

    public List<Photo> getUserPhoto(String user_id) {
        return toForList(Photo.class, getUserP, user_id);
    }

    public void remove(String photo_id) {
        update(delete, photo_id);
    }
}
