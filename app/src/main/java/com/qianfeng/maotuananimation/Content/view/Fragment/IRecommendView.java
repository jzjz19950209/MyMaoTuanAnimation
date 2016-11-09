package com.qianfeng.maotuananimation.Content.view.Fragment;

import com.qianfeng.maotuananimation.Content.model.bean.Rec_contentBean;
import com.qianfeng.maotuananimation.Content.model.bean.ScollBean;
import com.qianfeng.maotuananimation.Content.model.bean.T_Bean;

import java.util.List;

/**
 * Created by qf on 2016/11/9.
 */

public interface IRecommendView {
    void initScoll(List<ScollBean> list);
    void initDayVideo(List<T_Bean> list);
    void initHotVideo(List<T_Bean> list);
    void initCoser(List<T_Bean> list);
    void initGameCarousel(List<T_Bean> list);
    void initGameFourList(List<T_Bean> list);
    void initRec_content(List<Rec_contentBean> list);
}
