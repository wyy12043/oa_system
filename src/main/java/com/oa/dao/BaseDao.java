package com.oa.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author wyy
 * @date 2018/3/27
 */
public interface BaseDao <T>{
    public T get(int id) throws SQLException;

    public List<T> getAll() throws SQLException;

    public List<T> find(T t) throws SQLException;

    public void insert(T t) throws SQLException;

    public void update(T t) throws SQLException;

    public void delete(int id) throws SQLException;

    public int count() throws SQLException;

    public List<T> getPage(Map<String, Integer> map) throws SQLException;
}
