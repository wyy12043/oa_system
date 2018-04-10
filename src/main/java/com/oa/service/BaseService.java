package com.oa.service;


import com.oa.util.PageUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wyy
 * @date 2018/3/27
 */
public interface BaseService<T>{
    public T get(int id) throws SQLException;

    public List<T> getAll() throws SQLException;

    public List<T> find(T t) throws SQLException;

    public void save(T t) throws SQLException;

    public void update(T t) throws SQLException;

    public void delete(int id) throws SQLException;

    public int count() throws SQLException;

    public PageUtils<T> getPage(int pageno, int pagesize) throws SQLException;
}
