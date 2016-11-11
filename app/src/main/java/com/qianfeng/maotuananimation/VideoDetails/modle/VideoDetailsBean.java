package com.qianfeng.maotuananimation.VideoDetails.modle;

import java.util.List;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class VideoDetailsBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String imgUrl;//图片地址
    private String area;//地区
    private String character;//主演
    private String updataTime;//更新时间
    private String time;//上映时间
    private String comment_num;//评论数
    private String score;//得分
    private String intro;//简介
    private String total_num;//集数
    private List<String> watchUser;//谁在看
    private List<String> from_site;//播放源
    private List<String> episodeUrl;

    public List<String> getEpisodeUrl() {
        return episodeUrl;
    }

    public void setEpisodeUrl(List<String> episodeUrl) {
        this.episodeUrl = episodeUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getUpdataTime() {
        return updataTime;
    }

    public void setUpdataTime(String updataTime) {
        this.updataTime = updataTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment_num() {
        return comment_num;
    }

    public void setComment_num(String comment_num) {
        this.comment_num = comment_num;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTotal_num() {
        return total_num;
    }

    public void setTotal_num(String total_num) {
        this.total_num = total_num;
    }

    public List<String> getWatchUser() {
        return watchUser;
    }

    public void setWatchUser(List<String> watchUser) {
        this.watchUser = watchUser;
    }

    public List<String> getFrom_site() {
        return from_site;
    }

    public void setFrom_site(List<String> from_site) {
        this.from_site = from_site;
    }

    public VideoDetailsBean() {

    }

    public VideoDetailsBean(String imgUrl, String area, String character, String updataTime,
                            String time, String comment_num, String score, String intro,
                            String total_num, List<String> watchUser, List<String> from_site) {
        this.imgUrl = imgUrl;
        this.area = area;
        this.character = character;
        this.updataTime = updataTime;
        this.time = time;
        this.comment_num = comment_num;
        this.score = score;
        this.intro = intro;
        this.total_num = total_num;
        this.watchUser = watchUser;
        this.from_site = from_site;
    }
}
