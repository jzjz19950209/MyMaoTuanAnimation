package com.qianfeng.maotuananimation.useractivity.util;

import java.util.List;

/**
 * Created by Bigname on 2016/11/10.
 */

public class UserBean {
    private String id;
    private String sex;
    private String nickname;
    private String birthday;
    private String group_num;
    private String superscript;//初代，画王...
    private String sign;
    private List<String> new_tips;
    private String head_pic;
    private String show_location;
    private String fans;
    private String focus;
    private String city;
    private int age;
    private List<TimeLineBean> time_lines;
    private boolean have_next;
    private String last_id;

    public UserBean(String id, String sex, String nickname, String birthday, String group_num,
                    String superscript, String sign, List<String> new_tips, String head_pic,
                    String show_location, String fans,
                    String focus, String city, int age, List<TimeLineBean> time_lines,
                    boolean have_next, String last_id) {
        this.id = id;
        this.sex = sex;
        this.nickname = nickname;
        this.birthday = birthday;
        this.group_num = group_num;
        this.superscript = superscript;
        this.sign = sign;
        this.new_tips = new_tips;
        this.head_pic = head_pic;
        this.show_location = show_location;
        this.fans = fans;
        this.focus = focus;
        this.city = city;
        this.age = age;
        this.time_lines = time_lines;
        this.have_next = have_next;
        this.last_id = last_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGroup_num() {
        return group_num;
    }

    public void setGroup_num(String group_num) {
        this.group_num = group_num;
    }

    public String getSuperscript() {
        return superscript;
    }

    public void setSuperscript(String superscript) {
        this.superscript = superscript;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public List<String> getNew_tips() {
        return new_tips;
    }

    public void setNew_tips(List<String> new_tips) {
        this.new_tips = new_tips;
    }

    public String getHead_pic() {
        return head_pic;
    }

    public void setHead_pic(String head_pic) {
        this.head_pic = head_pic;
    }

    public String getShow_location() {
        return show_location;
    }

    public void setShow_location(String show_location) {
        this.show_location = show_location;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<TimeLineBean> getTime_lines() {
        return time_lines;
    }

    public void setTime_lines(List<TimeLineBean> time_lines) {
        this.time_lines = time_lines;
    }

    public boolean getHave_next() {
        return have_next;
    }

    public void setHave_next(boolean have_next) {
        this.have_next = have_next;
    }

    public String getLast_id() {
        return last_id;
    }

    public void setLast_id(String last_id) {
        this.last_id = last_id;
    }

    public UserBean() {

    }
}
