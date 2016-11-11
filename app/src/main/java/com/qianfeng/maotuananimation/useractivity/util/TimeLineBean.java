package com.qianfeng.maotuananimation.useractivity.util;

/**
 * Created by Bigname on 2016/11/10.
 */

public class TimeLineBean {
    /*
    *       "time":"2016-01-31",
            "is_member":false,
            "hx_id":"154937505500627388",
            "id":"89757",
            "title":"加入了团聊",
            "pic":"http://haomee.b0.upaiyun.com/haomee/1455622198385.jpg",
            "desc1":"I NEED YOU。",
            "desc2":"12/400 上饶市广丰县",
            "desc3":"团简介：一把伞，一句话，一滴泪，一个人。",
            "desc4":"",
            "type":"4"
    * */
    private String time;
    private boolean is_member;
    private String hx_id;
    private String id;
    private String title;
    private String pic;
    private String desc1;
    private String desc2;
    private String desc3;
    private String desc4;
    private String type;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean getIs_member() {
        return is_member;
    }

    public void setIs_member(boolean is_member) {
        this.is_member = is_member;
    }

    public String getHx_id() {
        return hx_id;
    }

    public void setHx_id(String hx_id) {
        this.hx_id = hx_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3;
    }

    public String getDesc4() {
        return desc4;
    }

    public void setDesc4(String desc4) {
        this.desc4 = desc4;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TimeLineBean() {

    }

    public TimeLineBean(String time, boolean is_member, String hx_id, String id, String title,
                        String pic, String desc1, String desc2, String desc3, String desc4, String type) {
        this.time = time;
        this.is_member = is_member;
        this.hx_id = hx_id;
        this.id = id;
        this.title = title;
        this.pic = pic;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.desc3 = desc3;
        this.desc4 = desc4;
        this.type = type;
    }
}
