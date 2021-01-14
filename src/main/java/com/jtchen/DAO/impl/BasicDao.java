package com.jtchen.DAO.impl;

import com.jtchen.utils.ConnectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/12 21:59
 */
public class BasicDao<Item> {

    private static ResultSet executeQuery(Connection conn, String sql, Object... params) throws SQLException {
        //1、sql预编译
        PreparedStatement pst = conn.prepareStatement(sql);

        //2、设置?
        if (params != null && params.length > 0) {
            // 数组的下标是从0开始，?的编号是1开始
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
        }

        //3、查询
        return pst.executeQuery();
    }

    private int executeUpdate(Connection conn, String sql, Object... params) {
        try {

            //1、sql预编译
            PreparedStatement pst = conn.prepareStatement(sql);

            //2、设置sql中的?
            if (params != null && params.length > 0) {
                // 数组的下标是从0开始，？的编号是1开始
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i + 1, params[i]);
                }
            }
            //3、执行sql
            int len = pst.executeUpdate();
            //4、释放资源
            ConnectionUtils.closeConnection();
            return len;
        } catch (SQLException s) {
            return 0;
        }
    }

    // 通过sql语句来获取相应表项(多个对象)
    public List<Item> toForList(
            Class<Item> clazz,
            String sql,
            Object... objects) {
        var list = new ArrayList<Item>();
        try {
            // 打通链接
            Connection conn = ConnectionUtils.establishConnection();

            // 结果集
            assert conn != null;
            ResultSet rs = executeQuery(conn, sql, objects);

            // 获取结果集的元数据
            ResultSetMetaData metaData = rs.getMetaData();

            // 获取结果中总列数
            int count = metaData.getColumnCount();

            while (rs.next()) {
                // 遍历的行

                // 每一行是一个对象
                Item obj = clazz.getDeclaredConstructor().newInstance();
                // 每一行有很多列
                // for的作用是为obj对象的每一个属性设置值
                getEveryCol(clazz, rs, metaData, count, obj);
                // 把obj对象放到集合中
                list.add(obj);
            }
            // 释放资源
            ConnectionUtils.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private void getEveryCol(Class<Item> clazz, ResultSet rs, ResultSetMetaData metaData, int count, Item obj) throws SQLException, NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < count; i++) {

            // (1)每一列的名称
            // 获取第几列的名称，如果有别名获取别名，如果没有别名获取列名
            String fieldName = metaData.getColumnLabel(i + 1);

            // (2)每一列的值
            // 获取第几列的值
            Object value = rs.getObject(i + 1);

            // (3)获取属性对象
            Field field = clazz.getDeclaredField(fieldName);

            // (4)设置可见性
            field.setAccessible(true);

            // (5)设置属性值
            field.set(obj, value);

        }
    }

    public Item getObj(Class<Item> clazz,
                       String sql,
                       Object... objects) throws SQLException {
        try {
            Item obj = clazz.getDeclaredConstructor().newInstance();
            // 打通链接
            Connection conn = ConnectionUtils.establishConnection();

            // 结果集
            assert conn != null;
            ResultSet rs = executeQuery(conn, sql, objects);

            // 获取结果集的元数据
            ResultSetMetaData metaData = rs.getMetaData();

            // 获取结果中总列数
            int count = metaData.getColumnCount();

            if (!rs.next()) return null;
            // 每一行有很多列
            // for的作用是为obj对象的每一个属性设置值
            getEveryCol(clazz, rs, metaData, count, obj);
            // 释放资源
            ConnectionUtils.closeConnection();
            return obj;
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 增, 删, 改数据库
    public boolean update(String sql, Object... objects) {
        try {
            // 打通链接
            Connection conn = ConnectionUtils.establishConnection();

            // 结果集
            assert conn != null;
            boolean res = executeUpdate(conn, sql, objects) > 0;
            // 释放资源
            ConnectionUtils.closeConnection();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
