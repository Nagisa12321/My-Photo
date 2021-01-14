package com.jtchen.DAO;

import org.junit.Test;

import static org.junit.Assert.*;

public class FavouritesDaoTest {

    FavouritesDao dao = new FavouritesDao();
    @Test
    public void addFav() {
        assertTrue(dao.addFav("test1", 1));
        assertFalse(dao.addFav("test1", 1));
    }

    @Test
    public void delete() {
        dao.delete("test1", 1);
    }
}