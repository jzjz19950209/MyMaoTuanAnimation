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
        OkHttpUtils.getScollData(onLoadScollListener);
    }

    @Override
    public void getDayVideo(OnLoad_T_Listener onLoad_t_listener) {
        OkHttpUtils.getT_Data(MyDataUtils.DAYVIDEO,onLoad_t_listener);
    }

    @Override
    public void getHotVideo(OnLoad_T_Listener onLoad_t_listener) {
        OkHttpUtils.getT_Data(MyDataUtils.HOTVIDEO,onLoad_t_listener);
    }

    @Override
    public void getCoser(OnLoad_T_Listener onLoad_t_listener) {
        OkHttpUtils.getT_Data(MyDataUtils.COSER,onLoad_t_listener);
    }

    @Override
    public void getGameCarousel(OnLoad_T_Listener onLoad_t_listener) {
        OkHttpUtils.getT_Data(MyDataUtils.GAMECAROUSEL,onLoad_t_listener);
    }

    @Override
    public void getGameFourList(OnLoad_T_Listener onLoad_t_listener) {
        OkHttpUtils.getT_Data(MyDataUtils.GAMEFOURLIST,onLoad_t_listener);
    }

    @Override
    public void getRec_content(OnLoadRec_contentListener onLoadRec_contentListener) {
        OkHttpUtils.getRec_contentData(onLoadRec_contentListener);
    }
}
