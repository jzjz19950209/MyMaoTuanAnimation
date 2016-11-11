package com.qianfeng.maotuananimation.VideoDetails.modle.bean;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class CommentBean {
    private String userface;
    private String username;
    private String content;
    private String good_num;
    private String reply_num;
    private String create_time;
    private String userUid;


    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }


    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGood_num() {
        return good_num;
    }

    public void setGood_num(String good_num) {
        this.good_num = good_num;
    }

    public String getReply_num() {
        return reply_num;
    }

    public void setReply_num(String reply_num) {
        this.reply_num = reply_num;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public CommentBean() {

    }

    public CommentBean(String userface, String username, String content, String good_num, String reply_num, String create_time) {

        this.userface = userface;
        this.username = username;
        this.content = content;
        this.good_num = good_num;
        this.reply_num = reply_num;
        this.create_time = create_time;
    }
}
