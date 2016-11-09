package com.qianfeng.maotuananimation;

import com.qianfeng.maotuananimation.Content.model.bean.Rec_contentBean;
import com.qianfeng.maotuananimation.Content.model.bean.ScollBean;
import com.qianfeng.maotuananimation.Content.model.bean.T_Bean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qf on 2016/11/9.
 */

public class ParseJson {
    private static List<ScollBean> scollBeanList=new ArrayList<>();
    private static List<Rec_contentBean> rec_contentBeanList=new ArrayList<>();

    public static List<ScollBean> parseJson_scoll(String json){
        ScollBean scollBean=null;
//        DayVideoBean dayVideoBean=null;
//        HotVideoBean hotVideoBean=null;
//        CoserBean coserBean=null;
//        GameCarouselBean gameCarouselBean=null;
//        GameFourListBean gameFourListBean=null;
//        Rec_contentBean rec_contentBean=null;
        try {
            JSONObject jsonObject=new JSONObject(json);
            JSONArray scoll = jsonObject.getJSONArray("scoll");
            for (int i=0;i<scoll.length();i++){
                String id=scoll.getJSONObject(i).getString("id");
                String pic=scoll.getJSONObject(i).getString("pic");
                scollBean=new ScollBean();
                scollBean.setId(id);
                scollBean.setPic(pic);
            }
            scollBeanList.add(scollBean);

//            JSONArray dayVideo = jsonObject.getJSONArray("dayVideo");
//            for (int i=0;i<dayVideo.length();i++){
//                String id=dayVideo.getJSONObject(i).getString("id");
//                String name=dayVideo.getJSONObject(i).getString("name");
//                String pic=dayVideo.getJSONObject(i).getString("pic");
//                dayVideoBean=new DayVideoBean();
//                dayVideoBean.setId(id);
//                dayVideoBean.setName(name);
//                dayVideoBean.setPic(pic);
//            }
//            dayVideoBeenList.add(dayVideoBean);
//
//            JSONArray hot_video = jsonObject.getJSONArray("hot_video");
//            for (int i = 0; i < hot_video.length(); i++) {
//                String id=hot_video.getJSONObject(i).getString("id");
//                String name=hot_video.getJSONObject(i).getString("name");
//                String pic=hot_video.getJSONObject(i).getString("pic");
//                hotVideoBean=new HotVideoBean();
//                hotVideoBean.setPic(pic);
//                hotVideoBean.setName(name);
//                hotVideoBean.setId(id);
//            }
//            hotVideoBeanList.add(hotVideoBean);
//
//            JSONArray coser = jsonObject.getJSONArray("coser");
//            for (int i = 0; i < coser.length(); i++) {
//                String id=coser.getJSONObject(i).getString("id");
//                String pic=coser.getJSONObject(i).getString("pic");
//                String name=coser.getJSONObject(i).getString("name");
//                coserBean=new CoserBean(id,name,pic);
//            }
//            coserBeenList.add(coserBean);
//
//            JSONArray gameCarousel = jsonObject.getJSONArray("gameCarousel");
//            for (int i = 0; i < gameCarousel.length(); i++) {
//                String id=gameCarousel.getJSONObject(i).getString("id");
//                String name=gameCarousel.getJSONObject(i).getString("name");
//                String pic=gameCarousel.getJSONObject(i).getString("pic");
//                gameCarouselBean=new GameCarouselBean(id,name,pic);
//            }
//            gameCarouselBeanList.add(gameCarouselBean);
//
//            JSONArray gameFourList = jsonObject.getJSONArray("gameFourList");
//            for (int i = 0; i < gameFourList.length(); i++) {
//                String id=gameFourList.getJSONObject(i).getString("id");
//                String name=gameFourList.getJSONObject(i).getString("name");
//                String pic=gameFourList.getJSONObject(i).getString("pic");
//                gameFourListBean=new GameFourListBean(id,name,pic);
//            }
//            gameFourListBeanList.add(gameFourListBean);
//
//            JSONArray rec_content = jsonObject.getJSONArray("rec_content");
//            for (int i = 0; i < rec_content.length(); i++) {
//                String id=rec_content.getJSONObject(i).getString("id");
//                String name=rec_content.getJSONObject(i).getString("name");
//                String pic=rec_content.getJSONObject(i).getString("pic");
//                String url=rec_content.getJSONObject(i).getString("url");
//                rec_contentBean=new Rec_contentBean(id,name,pic,url);
//            }
//            rec_contentBeanList.add(rec_contentBean);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return scollBeanList;
    }


    public static List<T_Bean> ParseJson_dayVideo(String json){
        T_Bean t_bean=null;
        List<T_Bean> t_beenList=new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray dayVideo = jsonObject.getJSONArray("dayVideo");
            for (int i=0;i<dayVideo.length();i++){
                String id=dayVideo.getJSONObject(i).getString("id");
                String name=dayVideo.getJSONObject(i).getString("name");
                String pic=dayVideo.getJSONObject(i).getString("pic");
                t_bean=new T_Bean();
                t_bean.setId(id);
                t_bean.setName(name);
                t_bean.setPic(pic);
            }
            t_beenList.add(t_bean);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return t_beenList;
    }
    public static List<T_Bean> ParseJson_hotVideo(String json){
        T_Bean t_bean=null;
        List<T_Bean> t_beenList=new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray hot_video = jsonObject.getJSONArray("hot_video");
            for (int i=0;i<hot_video.length();i++){
                String id=hot_video.getJSONObject(i).getString("id");
                String name=hot_video.getJSONObject(i).getString("name");
                String pic=hot_video.getJSONObject(i).getString("pic");
                t_bean=new T_Bean();
                t_bean.setId(id);
                t_bean.setName(name);
                t_bean.setPic(pic);
            }
            t_beenList.add(t_bean);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return t_beenList;
    }
    public static List<T_Bean> ParseJson_coser(String json){
        T_Bean t_bean=null;
        List<T_Bean> t_beenList=new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray coser = jsonObject.getJSONArray("coser");
            for (int i=0;i<coser.length();i++){
                String id=coser.getJSONObject(i).getString("id");
                String name=coser.getJSONObject(i).getString("name");
                String pic=coser.getJSONObject(i).getString("pic");
                t_bean=new T_Bean();
                t_bean.setId(id);
                t_bean.setName(name);
                t_bean.setPic(pic);
            }
            t_beenList.add(t_bean);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return t_beenList;
    }
    public static List<T_Bean> ParseJson_gameCarousel(String json){
        T_Bean t_bean=null;
        List<T_Bean> t_beenList=new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray gameCarousel = jsonObject.getJSONArray("gameCarousel");
            for (int i=0;i<gameCarousel.length();i++){
                String id=gameCarousel.getJSONObject(i).getString("id");
                String name=gameCarousel.getJSONObject(i).getString("name");
                String pic=gameCarousel.getJSONObject(i).getString("pic");
                t_bean=new T_Bean();
                t_bean.setId(id);
                t_bean.setName(name);
                t_bean.setPic(pic);
            }
            t_beenList.add(t_bean);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return t_beenList;
    }
    public static List<T_Bean> ParseJson_gameFourList(String json){
        T_Bean t_bean=null;
        List<T_Bean> t_beenList=new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray gameFourList = jsonObject.getJSONArray("gameFourList");
            for (int i=0;i<gameFourList.length();i++){
                String id=gameFourList.getJSONObject(i).getString("id");
                String name=gameFourList.getJSONObject(i).getString("name");
                String pic=gameFourList.getJSONObject(i).getString("pic");
                t_bean=new T_Bean();
                t_bean.setId(id);
                t_bean.setName(name);
                t_bean.setPic(pic);
            }
            t_beenList.add(t_bean);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return t_beenList;
    }
    public static List<Rec_contentBean> ParseJson_Rec_content(String json){
        Rec_contentBean rec_contentBean=null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray rec_content = jsonObject.getJSONArray("rec_content");
            for (int i=0;i<rec_content.length();i++){
                String id=rec_content.getJSONObject(i).getString("id");
                String name=rec_content.getJSONObject(i).getString("name");
                String pic=rec_content.getJSONObject(i).getString("pic");
                rec_contentBean=new Rec_contentBean();
                rec_contentBean.setId(id);
                rec_contentBean.setName(name);
                rec_contentBean.setPic(pic);
            }
            rec_contentBeanList.add(rec_contentBean);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rec_contentBeanList;
    }
}
