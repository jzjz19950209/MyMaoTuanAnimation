package com.qianfeng.maotuananimation.Content.model;

import com.qianfeng.maotuananimation.Content.model.listener.OnLoadRec_contentListener;
import com.qianfeng.maotuananimation.Content.model.listener.OnLoadScollListener;
import com.qianfeng.maotuananimation.Content.model.listener.OnLoad_T_Listener;

/**
 * Created by qf on 2016/11/9.
 */

public interface IDataRecommend {
    void getScollData(OnLoadScollListener onLoadScollListener);
    void getDayVideo(OnLoad_T_Listener onLoad_t_listener);
    void getHotVideo(OnLoad_T_Listener onLoad_t_listener);
    void getCoser(OnLoad_T_Listener onLoad_t_listener);
    void getGameCarousel(OnLoad_T_Listener onLoad_t_listener);
    void getGameFourList(OnLoad_T_Listener onLoad_t_listener);
    void getRec_content(OnLoadRec_contentListener onLoadRec_contentListener);
}
