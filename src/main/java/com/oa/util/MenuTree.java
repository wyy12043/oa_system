package com.oa.util;


import com.oa.model.Menu;

import java.util.List;

/**
 * 每个实体类：代表一个一级菜单
 * @author wyy
 * @date 2018/3/29
 */
public class MenuTree {
    private int id;
    private String text;
    private List<Menu> children;

    //state：节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。

    private String state = "closed";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
