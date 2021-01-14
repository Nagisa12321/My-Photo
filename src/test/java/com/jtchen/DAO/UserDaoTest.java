package com.jtchen.DAO;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    UserDao dao = new UserDao();

    @org.junit.Test
    public void insert() {
        dao.insert("123", "123", "123");
    }

    @Test
    public void login() {
        assertTrue(dao.login("123", "123"));
        assertFalse(dao.login("123", "456"));
        assertTrue(dao.login("cjt123", "123"));
        assertFalse(dao.login("12213123123", "123123123"));
    }

    @Test
    public void getUser() {
        System.out.println(dao.getUser("123123"));
    }
}