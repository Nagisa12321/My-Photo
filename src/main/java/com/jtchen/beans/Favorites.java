package com.jtchen.beans;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/13 22:29
 */
public class Favorites {
    private String user_id;
    private int photo_id;

    public Favorites() {
    }

    public Favorites(String user_id, int photo_id) {
        this.user_id = user_id;
        this.photo_id = photo_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public int getPhoto_id() {
        return photo_id;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "user_id='" + user_id + '\'' +
                ", photo_id='" + photo_id + '\'' +
                '}';
    }
}
