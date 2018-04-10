package com.oa.util;

import java.util.List;

/**
 * 适用于easyui的分页工具类
 * @author wyy
 * @date 2018/3/29
 */
public class PageUtils<T> {
    /**
     * easyui组件只识别rows
     * 数据名称必须写为rows
     */
    private List<T> rows;

    /**
     * 总页数
     */
    private int pages;
    /**
     * 总条数
     */
    private int total;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
