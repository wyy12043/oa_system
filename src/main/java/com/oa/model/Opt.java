package com.oa.model;

/**
 * @author wyy
 * @date 2018/4/9
 */
public class Opt {
    private int id ;
    private String name ;
    private String action ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Opt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
