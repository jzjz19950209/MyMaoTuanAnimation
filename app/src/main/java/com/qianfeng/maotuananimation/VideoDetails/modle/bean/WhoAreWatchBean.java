package com.qianfeng.maotuananimation.VideoDetails.modle.bean;

/**
 * Created by Administrator on 2016/11/11 0011.
 */

public class WhoAreWatchBean {
    private String uid;
    private String nickname;
    private String head_pic;

    public String getHead_pic() {
        return head_pic;
    }

    public void setHead_pic(String head_pic) {
        this.head_pic = head_pic;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public WhoAreWatchBean() {

    }

    public WhoAreWatchBean(String uid, String nickname) {

        this.uid = uid;
        this.nickname = nickname;
    }
}
