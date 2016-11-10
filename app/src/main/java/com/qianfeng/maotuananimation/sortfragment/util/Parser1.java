package com.qianfeng.maotuananimation.sortfragment.util;

import android.util.Log;

import com.qianfeng.maotuananimation.sortfragment.bean.ChannelBean;
import com.qianfeng.maotuananimation.sortfragment.bean.DetailsBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bigname on 2016/11/8.
 */
public class Parser1 {
    public static List<ChannelBean> parser(String json) {
        List<ChannelBean> list = new ArrayList<>();
        try {
            JSONArray jo = new JSONArray(json);
            JSONObject datas = jo.getJSONObject(1);
            JSONArray jsonList = datas.getJSONArray("list");
            for (int i = 0; i < jsonList.length(); i++) {
                JSONObject con = jsonList.getJSONObject(i);
                String id = con.getString("id");
                String name = con.getString("name");
                String pic = con.getString("pic");
                boolean is_lock = con.getBoolean("is_lock");
                list.add(new ChannelBean(id, name, pic, is_lock));
            }
        } catch (JSONException e) {
            Log.d("bigname_log", "parser: "+e.getMessage());
        }
        return list;
    }
/*
    private String video_id;
    private String name;
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
* */
    public static List<DetailsBean> parser2(String json) {
        List<DetailsBean> list = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(json);
            String count = jo.getString("count");
            JSONArray array = jo.getJSONArray("list");
            for (int i = 0; i < array.length(); i++) {
                JSONObject datas = array.getJSONObject(i);
                String video_id = datas.getString("video_id");
                String name = datas.getString("name");
                String score_person_num = datas.getString("score_person_num");
                String score_total_num = datas.getString("score_total_num");
                String intro = datas.getString("intro");
                String area = datas.getString("area");
                String cover = datas.getString("cover");
                String character = datas.getString("character");
                String cur_num = datas.getString("cur_num");
                String total_num = datas.getString("total_num");
                String isover = datas.getString("is_over");
                String category = datas.getString("category");
                String director = datas.getString("director");
                String update_time = datas.getString("update_time");
                String topic_intro = datas.getString("topic_intro");
                String score = datas.getString("score");
                list.add(new DetailsBean(video_id,name,score_person_num,score_total_num,intro,
                            area,cover,character,cur_num,total_num,isover,category,director,update_time
                            ,topic_intro,score));
            }
        } catch (JSONException e) {
            Log.d("bigname_log", "parser2: " + e.getMessage());
        }
        return list;
    }
}
