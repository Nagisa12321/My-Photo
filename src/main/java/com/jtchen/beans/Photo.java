package com.jtchen.beans;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/12 21:36
 */
public class Photo {
    private int photo_id;
    private String photo_title;
    private String photo_url;
    private String user_id;

    public int getPhoto_id() {
        return photo_id;
    }

    public String getPhoto_title() {
        return photo_title;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photo_id=" + photo_id +
                ", photo_title='" + photo_title + '\'' +
                ", photo_url='" + photo_url + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }

    public String getUser_id() {
        return user_id;
    }

    public Photo() {
    }

    public Photo(int photo_id, String photo_title, String photo_url, String user_id) {
        this.photo_id = photo_id;
        this.photo_title = photo_title;
        this.photo_url = photo_url;
        this.user_id = user_id;
    }
}
