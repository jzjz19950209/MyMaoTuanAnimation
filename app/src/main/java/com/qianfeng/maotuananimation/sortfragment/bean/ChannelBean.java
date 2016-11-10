package com.qianfeng.maotuananimation.sortfragment.bean;

/**
 * Created by Bigname on 2016/11/8.
 */
public class ChannelBean {
    private String id;
    private String name;
    private String pic;
    private boolean is_lock;

    public ChannelBean() {
    }

    public ChannelBean(String id, String name, String pic, boolean is_lock) {

        this.id = id;
        this.name = name;
        this.pic = pic;
        this.is_lock = is_lock;
    }

    @Override
    public String toString() {
        return "ChannelBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", is_lock=" + is_lock +
                '}';
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

    public boolean is_lock() {
        return is_lock;
    }

    public void setIs_lock(boolean is_lock) {
        this.is_lock = is_lock;
    }
}
