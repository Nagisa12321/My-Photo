package com.jtchen.beans;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/13 22:31
 */
public class Comments {
    private String user_name;
    private int photo_id;
    private String user_comment;

    public Comments() {
    }

    @Override
    public String toString() {
        return "Comments{" +
                "user_id='" + user_name + '\'' +
                ", photo_id=" + photo_id +
                ", user_comment='" + user_comment + '\'' +
                '}';
    }

    public Comments(String user_id, int photo_id, String user_comment) {
        this.user_name = user_id;
        this.photo_id = photo_id;
        this.user_comment = user_comment;
    }

    public String getUser_name() {
        return user_name;
    }

    public int getPhoto_id() {
        return photo_id;
    }

    public String getUser_comment() {
        return user_comment;
    }

}
