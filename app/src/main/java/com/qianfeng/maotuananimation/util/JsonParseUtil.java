package com.qianfeng.maotuananimation.util;

import com.qianfeng.maotuananimation.BaseInterface.model.bean.FaceBean;
import com.qianfeng.maotuananimation.BaseInterface.model.bean.TuanBean;
import com.qianfeng.maotuananimation.BaseInterface.model.bean.ZuBean;

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

    public static ZuBean parseZu(String json)
    {
        ZuBean zuBean=new ZuBean();
        try {
            JSONObject jsonObject=new JSONObject(json);
            zuBean.setId(jsonObject.getString("id"));
            zuBean.setName(jsonObject.getString("name"));
            zuBean.setDesc(jsonObject.getString("desc"));
            List<String> t=new ArrayList<>();
            JSONArray tips = jsonObject.getJSONArray("tips");
            for (int i = 0; i < tips.length(); i++) {
                t.add(tips.getString(i));
            }
            zuBean.setTips(t);
            zuBean.setCreate_time(jsonObject.getString("create_time"));
            zuBean.setSuccess_time(jsonObject.getString("success_time"));
            zuBean.setTotal(jsonObject.getString("total"));
            zuBean.setCur_num(jsonObject.getString("cur_num"));
            zuBean.setIcon(jsonObject.getString("icon"));
            zuBean.setLevel(jsonObject.getString("level"));
            ZuBean.OwnerBean owner=new ZuBean.OwnerBean();
            owner.setId(jsonObject.getJSONObject("owner").getString("id"));
            owner.setUsername(jsonObject.getJSONObject("owner").getString("username"));
            owner.setNickname(jsonObject.getJSONObject("owner").getString("nickname"));
            owner.setMobile(jsonObject.getJSONObject("owner").getString("mobile"));
            owner.setHead_pic(jsonObject.getJSONObject("owner").getString("head_pic"));
            owner.setSex(jsonObject.getJSONObject("owner").getString("sex"));
            owner.setSign(jsonObject.getJSONObject("owner").getString("sign"));
            owner.setBirthday(jsonObject.getJSONObject("owner").getString("birthday"));
            owner.setHx_username(jsonObject.getJSONObject("owner").getString("hx_username"));
            owner.setHx_password(jsonObject.getJSONObject("owner").getString("hx_password"));
            owner.setSuperscript(jsonObject.getJSONObject("owner").getString("superscript"));
            owner.setUser_level_group(jsonObject.getJSONObject("owner").getString("user_level_group"));
            owner.setUser_level_group_tip(jsonObject.getJSONObject("owner").getString("user_level_group_tip"));
            zuBean.setOwner(owner);
            List<ZuBean.MemberBean> mList=new ArrayList<>();
            for (int i = 0; i < jsonObject.getJSONArray("member").length(); i++) {
                ZuBean.MemberBean m=new ZuBean.MemberBean();
                JSONObject member = jsonObject.getJSONArray("member").getJSONObject(i);
                m.setId(member.getString("id"));
                m.setUsername(member.getString("username"));
                m.setNickname(member.getString("nickname"));
                m.setMobile(member.getString("mobile"));
                m.setHead_pic(member.getString("head_pic"));
                m.setSex(member.getString("sex"));
                m.setSign(member.getString("sign"));
                m.setBirthday(member.getString("birthday"));
                m.setHx_username(member.getString("hx_username"));
                m.setHx_password(member.getString("hx_password"));
                m.setSuperscript(member.getString("superscript"));
                m.setUser_level_group(member.getString("user_level_group"));
                m.setUser_level_group_tip(member.getString("user_level_group_tip"));
                mList.add(m);
            }
            zuBean.setMember(mList);
            zuBean.setHx_id(jsonObject.getString("hx_id"));
            zuBean.setLast_day(jsonObject.getString("last_day"));
            zuBean.setActive_day(jsonObject.getString("active_day"));
            zuBean.setRec_list(jsonObject.getString("rec_list"));
            zuBean.setAll_active_date(jsonObject.getString("all_active_date"));
            zuBean.setIs_rec(jsonObject.getString("is_rec"));
            zuBean.setIs_black(jsonObject.getString("is_black"));
            zuBean.setPic(jsonObject.getString("pic"));
            zuBean.setSuperscript(jsonObject.getString("superscript"));
            zuBean.setIs_deal(jsonObject.getString("is_deal"));
            JSONArray level_tips = jsonObject.getJSONArray("level_tips");
            List<String> le=new ArrayList<>();
            for (int i = 0; i < level_tips.length(); i++) {
                le.add(level_tips.getString(i));
            }
            zuBean.setLevel_tips(le);
            zuBean.setIs_cartoon(jsonObject.getString("is_cartoon"));
            zuBean.setIs_video(jsonObject.getString("is_video"));
            zuBean.setNuantuan_number(jsonObject.getString("nuantuan_number"));
            zuBean.setLocation_x(jsonObject.getString("location_x"));
            zuBean.setLocation_y(jsonObject.getString("location_y"));
            zuBean.setCity(jsonObject.getString("city"));
            zuBean.setAdd_need_check(jsonObject.getBoolean("add_need_check"));
            zuBean.setHot_value(jsonObject.getString("hot_value"));
            zuBean.setIs_white(jsonObject.getString("is_white"));
            zuBean.setUpdate_time(jsonObject.getString("update_tiem"));
            zuBean.setDistance(jsonObject.getString("distance"));
            zuBean.setIs_member(jsonObject.getBoolean("is_member"));
            zuBean.setBirthday(jsonObject.getString("birthday"));
            zuBean.setUser_level_group(jsonObject.getString("user_level_group"));
            zuBean.setUser_level_group_tip(jsonObject.getString("user_level_group_tip"));
            zuBean.setIs_deputy(jsonObject.getBoolean("is_deputy"));
            zuBean.setHave_next(jsonObject.getBoolean("have_next"));
            zuBean.setLast_id(jsonObject.getString("last_id"));
            zuBean.setIs_owner(jsonObject.getBoolean("is_owner"));
            zuBean.setUser_score(jsonObject.getString("user_score"));
            zuBean.setLevel_day(jsonObject.getString("level_day"));
            zuBean.setLevel_percent(jsonObject.getString("level_percent"));
            zuBean.setError(jsonObject.getInt("error"));
            List<String> tanmu=new ArrayList<>();
            JSONArray danmu = jsonObject.getJSONArray("danmu");
            for (int i = 0; i < danmu.length(); i++) {
                tanmu.add(danmu.getString(i));
            }
            zuBean.setDanmu(tanmu);
            zuBean.setHave_new_pic(jsonObject.getBoolean("have_new_pic"));
            zuBean.setIsBan(jsonObject.getBoolean("isBan"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return zuBean;
    }
}
