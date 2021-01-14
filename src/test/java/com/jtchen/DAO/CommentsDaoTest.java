package com.jtchen.DAO;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommentsDaoTest {

    CommentsDao dao = new CommentsDao();
    @Test
    public void add() {
        dao.add("123", 123, "just a test");
        dao.add("123", 123, "just a test2");
    }

    @Test
    public void get() {
        var list = dao.get(18);
        System.out.println(list);
        var list2 = dao.get(44);
        System.out.println(list2);
    }
}