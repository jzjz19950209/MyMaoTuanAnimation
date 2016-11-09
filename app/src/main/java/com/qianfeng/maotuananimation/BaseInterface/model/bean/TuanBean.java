package com.qianfeng.maotuananimation.BaseInterface.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class TuanBean {

    /**
     * goto_type : 1
     * pic : http://cdn.haomee.cn/manhua/upload/14356435802
     * title : 美男
     * id : 146
     * is_locked : false
     */

    private List<RecBean> rec;
    private List<String> tips;
    /**
     * id : 88048
     * name : h纯爱
     * desc : 腐女快入～!纯洁滴娃娃表过来!
     * tips : ["同人女","肉番","胖次","异性恋","黑化"]
     * create_time : 1449155436
     * success_time : 1449239793
     * total : 200
     * cur_num : 3
     * icon : http://haomee.b0.upaiyun.com/haomee/1449155313069.jpg
     * level : 1
     * owner : 1415088
     * hx_id : 136043062462775832
     * member_content : |||小首呐|||哇奥|||嘿嘿嘿，我来找动漫来了|||。
     * last_day : 2015-12-05
     * active_day : 2
     * rec_list : 0
     * is_rec : 0
     * is_black : 0
     * pic : http://haomee.b0.upaiyun.com/haomee/1449155366896.jpg
     * superscript :
     * deputy :
     * is_deal : 1
     * level_tips : ["漫娃","漫民","漫臣","漫王","漫皇"]
     * is_cartoon : 0
     * is_video : 0
     * nuantuan_number : 0
     * location_x : 23.160315
     * location_y : 113.344945
     * city : 广州市天河区
     * add_need_check : 1
     * hot_value : 24
     * is_white : 0
     * new_tips : []
     * update_time : 2015-12-03 23:10:36
     * a : 0.020203999999996114
     * is_member : false
     * distance : 1.8 km
     */

    private List<NearbyBean> nearby;

    public List<RecBean> getRec() {
        return rec;
    }

    public void setRec(List<RecBean> rec) {
        this.rec = rec;
    }

    public List<String> getTips() {
        return tips;
    }

    public void setTips(List<String> tips) {
        this.tips = tips;
    }

    public List<NearbyBean> getNearby() {
        return nearby;
    }

    public void setNearby(List<NearbyBean> nearby) {
        this.nearby = nearby;
    }

    public static class RecBean {
        private int goto_type;
        private String pic;
        private String title;
        private String id;
        private boolean is_locked;

        public int getGoto_type() {
            return goto_type;
        }

        public void setGoto_type(int goto_type) {
            this.goto_type = goto_type;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIs_locked() {
            return is_locked;
        }

        public void setIs_locked(boolean is_locked) {
            this.is_locked = is_locked;
        }
    }

    public static class NearbyBean {
        private String id;
        private String name;
        private String desc;
        private String create_time;
        private String success_time;
        private String total;
        private String cur_num;
        private String icon;
        private String level;
        private String owner;
        private String hx_id;
        private String member_content;
        private String last_day;
        private String active_day;
        private String rec_list;
        private String is_rec;
        private String is_black;
        private String pic;
        private String superscript;
        private String deputy;
        private String is_deal;
        private String is_cartoon;
        private String is_video;
        private String nuantuan_number;
        private String location_x;
        private String location_y;
        private String city;
        private String add_need_check;
        private String hot_value;
        private String is_white;
        private String update_time;
        private String a;
        private boolean is_member;
        private String distance;
        private List<String> tips;
        private List<String> level_tips;
        private List<?> new_tips;

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

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getSuccess_time() {
            return success_time;
        }

        public void setSuccess_time(String success_time) {
            this.success_time = success_time;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getCur_num() {
            return cur_num;
        }

        public void setCur_num(String cur_num) {
            this.cur_num = cur_num;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getHx_id() {
            return hx_id;
        }

        public void setHx_id(String hx_id) {
            this.hx_id = hx_id;
        }

        public String getMember_content() {
            return member_content;
        }

        public void setMember_content(String member_content) {
            this.member_content = member_content;
        }

        public String getLast_day() {
            return last_day;
        }

        public void setLast_day(String last_day) {
            this.last_day = last_day;
        }

        public String getActive_day() {
            return active_day;
        }

        public void setActive_day(String active_day) {
            this.active_day = active_day;
        }

        public String getRec_list() {
            return rec_list;
        }

        public void setRec_list(String rec_list) {
            this.rec_list = rec_list;
        }

        public String getIs_rec() {
            return is_rec;
        }

        public void setIs_rec(String is_rec) {
            this.is_rec = is_rec;
        }

        public String getIs_black() {
            return is_black;
        }

        public void setIs_black(String is_black) {
            this.is_black = is_black;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getSuperscript() {
            return superscript;
        }

        public void setSuperscript(String superscript) {
            this.superscript = superscript;
        }

        public String getDeputy() {
            return deputy;
        }

        public void setDeputy(String deputy) {
            this.deputy = deputy;
        }

        public String getIs_deal() {
            return is_deal;
        }

        public void setIs_deal(String is_deal) {
            this.is_deal = is_deal;
        }

        public String getIs_cartoon() {
            return is_cartoon;
        }

        public void setIs_cartoon(String is_cartoon) {
            this.is_cartoon = is_cartoon;
        }

        public String getIs_video() {
            return is_video;
        }

        public void setIs_video(String is_video) {
            this.is_video = is_video;
        }

        public String getNuantuan_number() {
            return nuantuan_number;
        }

        public void setNuantuan_number(String nuantuan_number) {
            this.nuantuan_number = nuantuan_number;
        }

        public String getLocation_x() {
            return location_x;
        }

        public void setLocation_x(String location_x) {
            this.location_x = location_x;
        }

        public String getLocation_y() {
            return location_y;
        }

        public void setLocation_y(String location_y) {
            this.location_y = location_y;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAdd_need_check() {
            return add_need_check;
        }

        public void setAdd_need_check(String add_need_check) {
            this.add_need_check = add_need_check;
        }

        public String getHot_value() {
            return hot_value;
        }

        public void setHot_value(String hot_value) {
            this.hot_value = hot_value;
        }

        public String getIs_white() {
            return is_white;
        }

        public void setIs_white(String is_white) {
            this.is_white = is_white;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public boolean isIs_member() {
            return is_member;
        }

        public void setIs_member(boolean is_member) {
            this.is_member = is_member;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public List<String> getTips() {
            return tips;
        }

        public void setTips(List<String> tips) {
            this.tips = tips;
        }

        public List<String> getLevel_tips() {
            return level_tips;
        }

        public void setLevel_tips(List<String> level_tips) {
            this.level_tips = level_tips;
        }

        public List<?> getNew_tips() {
            return new_tips;
        }

        public void setNew_tips(List<?> new_tips) {
            this.new_tips = new_tips;
        }
    }
}
