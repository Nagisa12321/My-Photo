package com.jtchen.DAO;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhotoDaoTest {

    PhotoDao dao = new PhotoDao();
    @Test
    public void getAll() {
        var list = dao.getAll();
        for (var photo : list) {
            System.out.println(photo);
        }
    }

    @Test
    public void getPhoto() {
    }

    @Test
    public void getUserPhoto() {
        System.out.println(dao.getUserPhoto("2"));
    }
}