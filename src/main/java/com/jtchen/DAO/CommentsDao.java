package com.jtchen.DAO;

import com.jtchen.DAO.impl.BasicDao;
import com.jtchen.beans.Comments;

import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/14 10:04
 */
public class CommentsDao extends BasicDao<Comments> {
    private final static String add = "insert ignore into jt_photo.comments values (?,?,?)";
    private final static String get = "select * from jt_photo.comments where jt_photo.comments.photo_id=?";


    // 通过user_id, pid, 添加评论
    public void add(String user_name, int photo_id, String comment) {
        update(add, user_name, photo_id, comment);
    }

    // 通过photo获取该图片评论
    public List<Comments> get(int photo_id) {
        return toForList(Comments.class, get, photo_id);
    }
}
