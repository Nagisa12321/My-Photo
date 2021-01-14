package com.jtchen.beans;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/12 21:36
 */
public class User {
    private String user_name;
    private String user_id;
    private String user_password;

    public User(String name, String id, String password) {
        this.user_name = name;
        this.user_id = id;
        this.user_password = password;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }

    public String getName() {
        return user_name;
    }

    public String getId() {
        return user_id;
    }

    public String getUser_password() {
        return user_password;
    }
}
