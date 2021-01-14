package com.jtchen.DAO;


import com.jtchen.DAO.impl.BasicDao;
import com.jtchen.beans.User;

import java.sql.SQLException;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/13 0:52
 */
public class UserDao extends BasicDao<User> {
    private final static String select = "select * from jt_photo.users where user_id=?";
    private final static String insert = "insert into jt_photo.users (user_name, user_id, user_password) VALUES (?,?,?)";

    public UserDao() {
    }

    // 插入用户列表
    public boolean insert(String name, String id, String password) {
        return update(insert, name, id, password);
    }

    // 查询用户登陆密码是否正确
    public boolean login(String id, String pwd) {
        try {
            var temp = getObj(User.class, select, id);
            if (temp == null) return false;
            String temp1 = temp.getUser_password();
            return pwd.equals(temp1);
        } catch (SQLException e) {
            return false;
        }
    }


    // 得到一个用户
    public User getUser(String id) {
        try {
            return getObj(User.class, select, id);
        } catch (SQLException e) {
            return null;
        }
    }
}
