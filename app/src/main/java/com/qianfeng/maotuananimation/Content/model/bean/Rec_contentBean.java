package com.qianfeng.maotuananimation.Content.model.bean;

/**
 * Created by qf on 2016/11/9.
 */

public class Rec_contentBean {
    private String id;
    private String name;
    private String pic;
    private String url;

    public Rec_contentBean() {
    }

    public Rec_contentBean(String id, String name, String pic, String url) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
