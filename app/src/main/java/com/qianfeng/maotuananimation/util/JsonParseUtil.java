package com.qianfeng.maotuananimation.util;

import com.qianfeng.maotuananimation.BaseInterface.model.bean.FaceBean;
import com.qianfeng.maotuananimation.BaseInterface.model.bean.TuanBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class JsonParseUtil {

    public static TuanBean parseTuan(String json)
    {
        TuanBean bean=new TuanBean();
        List<TuanBean.RecBean> rList=new ArrayList<>();
        List<String> sList=new ArrayList<>();
        List<TuanBean.NearbyBean> tList=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(json);
            JSONArray rec = jsonObject.getJSONArray("rec");
            for (int i = 0; i < rec.length(); i++) {
                JSONObject object = rec.getJSONObject(i);
                TuanBean.RecBean recBean=new TuanBean.RecBean();
                recBean.setPic(object.getString("pic"));
                recBean.setGoto_type(object.getInt("goto_type"));
                recBean.setTitle(object.getString("title"));
                recBean.setId(object.getString("id"));
                recBean.setIs_locked(object.getBoolean("is_locked"));
                rList.add(recBean);
            }
            bean.setRec(rList);
            JSONArray tips =  jsonObject.getJSONArray("tips");
            for (int i = 0; i < tips.length(); i++) {
                sList.add(tips.getString(i));
            }
            bean.setTips(sList);
            JSONArray nearby = jsonObject.getJSONArray("nearby");
            for (int i = 0; i < nearby.length(); i++) {
                JSONObject object = nearby.getJSONObject(i);
                TuanBean.NearbyBean nearbyBean=new TuanBean.NearbyBean();
                nearbyBean.setId(object.getString("id"));
                nearbyBean.setName(object.getString("name"));
                nearbyBean.setDesc(object.getString("desc"));
                JSONArray tips1 = object.getJSONArray("tips");
                List<String> s=new ArrayList<>();
                for (int j = 0; j < tips1.length(); j++) {
                    s.add(tips1.getString(j));
                }
                nearbyBean.setTips(s);
                nearbyBean.setCreate_time(object.getString("create_time"));
                nearbyBean.setSuccess_time(object.getString("success_time"));
                nearbyBean.setTotal(object.getString("total"));
                nearbyBean.setCur_num(object.getString("cur_num"));
                nearbyBean.setIcon(object.getString("icon"));
                nearbyBean.setLevel(object.getString("level"));
                nearbyBean.setOwner(object.getString("owner"));
                nearbyBean.setHx_id(object.getString("hx_id"));
                nearbyBean.setMember_content(object.getString("member_content"));
                nearbyBean.setLast_day(object.getString("last_day"));
                nearbyBean.setActive_day(object.getString("active_day"));
                nearbyBean.setRec_list(object.getString("rec_list"));
                nearbyBean.setIs_rec(object.getString("is_rec"));
                nearbyBean.setIs_black(object.getString("is_black"));
                nearbyBean.setPic(object.getString("pic"));
                nearbyBean.setSuperscript(object.getString("superscript"));
                nearbyBean.setDeputy(object.getString("deputy"));
                nearbyBean.setIs_deal(object.getString("is_deal"));
                JSONArray level_tips = object.getJSONArray("level_tips");
                List<String> a=new ArrayList<>();
                for (int j = 0; j < level_tips.length(); j++) {
                    a.add(level_tips.getString(j));
                }
                nearbyBean.setLevel_tips(a);
                nearbyBean.setIs_cartoon(object.getString("is_cartoon"));
                nearbyBean.setIs_video(object.getString("is_video"));
                nearbyBean.setNuantuan_number(object.getString("nuantuan_number"));
                nearbyBean.setLocation_x(object.getString("location_x"));
                nearbyBean.setLocation_y(object.getString("location_y"));
                nearbyBean.setCity(object.getString("city"));
                nearbyBean.setAdd_need_check(object.getString("add_need_check"));
                nearbyBean.setHot_value(object.getString("hot_value"));
                nearbyBean.setIs_white(object.getString("is_white"));
                nearbyBean.setUpdate_time(object.getString("update_time"));
                nearbyBean.setA(object.getString("a"));
                nearbyBean.setIs_member(object.getBoolean("is_member"));
                nearbyBean.setDistance(object.getString("distance"));
                tList.add(nearbyBean);
            }
            bean.setNearby(tList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bean;
    }


    public static FaceBean parseFace(String json)
    {
        FaceBean faceBean=new FaceBean();
        List<FaceBean.ListBean> bList=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(json);
            if (jsonObject.has("need_tips")) {
                faceBean.setNeed_tips(jsonObject.getBoolean("need_tips"));
            }
            faceBean.setLast_id(jsonObject.getString("last_id"));
            faceBean.setHave_next(jsonObject.getBoolean("have_next"));
            JSONArray list=jsonObject.getJSONArray("list");
            for (int i = 0; i < list.length(); i++) {
                FaceBean.ListBean bean=new FaceBean.ListBean();
                JSONObject object = list.getJSONObject(i);
                bean.setId(object.getString("id"));
                bean.setName(object.getString("name"));
                bean.setDesc(object.getString("desc"));
                List<String> ltips=new ArrayList<>();
                JSONArray tips = object.getJSONArray("tips");
                for (int j = 0; j < tips.length(); j++) {
                    ltips.add(tips.getString(j));
                }
                bean.setTips(ltips);
                bean.setCreate_time(object.getString("create_time"));
                bean.setTotal(object.getString("total"));
                bean.setCur_num(object.getString("cur_num"));
                bean.setIcon(object.getString("icon"));
                bean.setOwner(object.getString("owner"));
                if (object.has("member")) {
                    bean.setMember(object.getString("member"));
                }
                bean.setHx_id(object.getString("hx_id"));
                bean.setMember_content(object.getString("member_content"));
                bean.setLast_day(object.getString("last_day"));
                bean.setActive_day(object.getString("active_day"));
                bean.setRec_list(object.getString("rec_list"));
                bean.setPic(object.getString("pic"));
                bean.setSuperscript(object.getString("superscript"));
                bean.setCity(object.getString("city"));
                bean.setLocation_x(object.getString("location_x"));
                bean.setLocation_y(object.getString("location_y"));
                bean.setIs_member(object.getBoolean("is_member"));
                bean.setDistance(object.getString("distance"));
                bList.add(bean);
            }
            faceBean.setList(bList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return faceBean;
    }
}
