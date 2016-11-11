package com.qianfeng.maotuananimation.Content.model.bean;

/**
 * Created by qf on 2016/11/9.
 */

public class T_Bean {
    private String id;
    private String name;
    private String pic;

    public T_Bean() {
    }

    @Override
    public String toString() {
        return "T_Bean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }

    public T_Bean(String id, String name, String pic) {
        this.id = id;
        this.name = name;
        this.pic = pic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
