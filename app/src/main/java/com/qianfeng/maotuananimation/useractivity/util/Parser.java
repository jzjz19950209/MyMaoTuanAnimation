package com.qianfeng.maotuananimation.useractivity.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bigname on 2016/11/10.
 */

public class Parser {

    public static UserBean parser(String json){
        UserBean userBean = null;
        try {
            JSONObject jo = new JSONObject(json);
            String id = jo.getString("id");
            String sex = jo.getString("sex");
            String nickname = jo.getString("nickname");
            String birthday = jo.getString("birthday");
            String group_num = jo.getString("group_num");
            String superscript = jo.getString("superscript");
            String sign = jo.getString("sign");
            String head_pic = jo.getString("head_pic");
//            String hx_username = jo.getString("hx_username");
            String city = jo.getString("city");
            String show_location = jo.getString("show_location");
            String last_id = jo.getString("last_id");
//            boolean is_focus = jo.getBoolean("is_focus");
            String fans = jo.getString("fans");
            String focus = jo.getString("focus");
            boolean have_next = jo.getBoolean("have_next");
            int age = jo.getInt("age");

            userBean = new UserBean(id,sex,nickname,birthday,group_num,superscript,sign,null,head_pic,
                    show_location,fans,focus,city,age,null,have_next,last_id);

            JSONArray new_tips = jo.getJSONArray("new_tips");
            List<String> strList = new ArrayList<>();
            for (int i = 0; i < new_tips.length(); i++) {
                String string = new_tips.getString(i);
                strList.add(string);
            }
            userBean.setNew_tips(strList);

            List<TimeLineBean> timeLineList = new ArrayList<>();
            JSONArray time_line = jo.getJSONArray("time_line");
            for (int i = 0; i < time_line.length(); i++) {
                JSONObject datas = time_line.getJSONObject(i);
                String time = datas.getString("time");
                boolean is_member = datas.getBoolean("is_member");
                String hx_id = datas.getString("hx_id");
                String idid = datas.getString("id");
                String pic = datas.getString("pic");
                String titletitle = datas.getString("title");
                String desc1 = datas.getString("desc1");
                String desc2 = datas.getString("desc2");
                String desc3 = datas.getString("desc3");
                String desc4 = datas.getString("desc4");
                String type = datas.getString("type");
                TimeLineBean timeLineBean = new TimeLineBean(time,is_member,hx_id,idid,titletitle,
                        pic,desc1,desc2,desc3,desc4,type);
                timeLineList.add(timeLineBean);
            }
            userBean.setTime_lines(timeLineList);

        } catch (JSONException e) {
            Log.d("bigname_log", "parser: "+e.getMessage());
        }

        return userBean;
    }
}
