package com.qianfeng.maotuananimation.sortfragment.bean;

/**
 * Created by Bigname on 2016/11/8.
 */
public class DetailsBean {
    private String video_id;
    private String name;
    private String score;
    private String score_person_num;
    private String score_total_num;
    private String intro;
    private String area;
    private String cover;//封面
    private String character;//演员
    private String cur_num;
    private String total_num;
    private String isover;
    private String category;//标签（热血，冒险，竞技）
    private String director;//
    private String update_time;
    private String topic_intro;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public DetailsBean(String video_id, String name, String score_person_num, String score_total_num,
                       String intro, String area, String cover, String character, String cur_num, String total_num,
                       String isover, String category, String director, String update_time, String topic_intro, String score) {
        this.video_id = video_id;
        this.name = name;
        this.score_person_num = score_person_num;
        this.score_total_num = score_total_num;
        this.intro = intro;
        this.area = area;
        this.cover = cover;
        this.character = character;
        this.cur_num = cur_num;
        this.total_num = total_num;
        this.isover = isover;
        this.category = category;
        this.director = director;
        this.update_time = update_time;
        this.topic_intro = topic_intro;
        this.score = score;

    }

    public DetailsBean() {

    }

    @Override
    public String toString() {
        return "DetailsBean{" +
                "video_id='" + video_id + '\'' +
                ", name='" + name + '\'' +
                ", score_person_num='" + score_person_num + '\'' +
                ", score_total_num='" + score_total_num + '\'' +
                ", intro='" + intro + '\'' +
                ", area='" + area + '\'' +
                ", cover='" + cover + '\'' +
                ", character='" + character + '\'' +
                ", cur_num='" + cur_num + '\'' +
                ", total_num='" + total_num + '\'' +
                ", isover='" + isover + '\'' +
                ", category='" + category + '\'' +
                ", director='" + director + '\'' +
                ", update_time='" + update_time + '\'' +
                ", topic_intro='" + topic_intro + '\'' +
                '}';
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore_person_num() {
        return score_person_num;
    }

    public void setScore_person_num(String score_person_num) {
        this.score_person_num = score_person_num;
    }

    public String getScore_total_num() {
        return score_total_num;
    }

    public void setScore_total_num(String score_total_num) {
        this.score_total_num = score_total_num;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCur_num() {
        return cur_num;
    }

    public void setCur_num(String cur_num) {
        this.cur_num = cur_num;
    }

    public String getTotal_num() {
        return total_num;
    }

    public void setTotal_num(String total_num) {
        this.total_num = total_num;
    }

    public String getIsover() {
        return isover;
    }

    public void setIsover(String isover) {
        this.isover = isover;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getTopic_intro() {
        return topic_intro;
    }

    public void setTopic_intro(String topic_intro) {
        this.topic_intro = topic_intro;
    }
}
