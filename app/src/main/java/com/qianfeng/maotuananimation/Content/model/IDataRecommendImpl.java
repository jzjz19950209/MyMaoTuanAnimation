package com.qianfeng.maotuananimation.Content.model;

import com.qianfeng.maotuananimation.Content.model.listener.OnLoadRec_contentListener;
import com.qianfeng.maotuananimation.Content.model.listener.OnLoadScollListener;
import com.qianfeng.maotuananimation.Content.model.listener.OnLoad_T_Listener;
import com.qianfeng.maotuananimation.MyDataUtils;
import com.qianfeng.maotuananimation.OkHttpUtils;

/**
 * Created by qf on 2016/11/9.
 */

public class IDataRecommendImpl implements IDataRecommend {

    @Override
    public void getScollData(OnLoadScollListener onLoadScollListener) {
        OkHttpUtils.getScollData(MyDataUtils.RECOMMEND_DATA,onLoadScollListener);
    }

    @Override
    public void getDayVideo(OnLoad_T_Listener onLoad_t_listener) {
        OkHttpUtils.get_T_Data(MyDataUtils.DAYVIDEO,MyDataUtils.RECOMMEND_DATA,onLoad_t_listener);
    }

    @Override
    public void getHotVideo(OnLoad_T_Listener onLoad_t_listener) {
        OkHttpUtils.get_T_Data(MyDataUtils.HOTVIDEO,MyDataUtils.RECOMMEND_DATA,onLoad_t_listener);
    }

    @Override
    public void getCoser(OnLoad_T_Listener onLoad_t_listener) {
        OkHttpUtils.get_T_Data(MyDataUtils.COSER,MyDataUtils.RECOMMEND_DATA,onLoad_t_listener);
    }

    @Override
    public void getGameCarousel(OnLoad_T_Listener onLoad_t_listener) {
        OkHttpUtils.get_T_Data(MyDataUtils.GAMECAROUSEL,MyDataUtils.RECOMMEND_DATA,onLoad_t_listener);
    }

    @Override
    public void getGameFourList(OnLoad_T_Listener onLoad_t_listener) {
        OkHttpUtils.get_T_Data(MyDataUtils.GAMEFOURLIST,MyDataUtils.RECOMMEND_DATA,onLoad_t_listener);
    }

    @Override
    public void getRec_content(OnLoadRec_contentListener onLoadRec_contentListener) {
        OkHttpUtils.getRec_contentData(MyDataUtils.RECOMMEND_DATA,onLoadRec_contentListener);
    }
}
