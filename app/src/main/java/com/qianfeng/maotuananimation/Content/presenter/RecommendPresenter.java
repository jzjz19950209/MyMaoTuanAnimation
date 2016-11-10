package com.qianfeng.maotuananimation.Content.presenter;

import com.qianfeng.maotuananimation.Content.model.IDataRecommend;
import com.qianfeng.maotuananimation.Content.model.IDataRecommendImpl;
import com.qianfeng.maotuananimation.Content.model.bean.Rec_contentBean;
import com.qianfeng.maotuananimation.Content.model.bean.ScollBean;
import com.qianfeng.maotuananimation.Content.model.bean.T_Bean;
import com.qianfeng.maotuananimation.Content.model.listener.OnLoadRec_contentListener;
import com.qianfeng.maotuananimation.Content.model.listener.OnLoadScollListener;
import com.qianfeng.maotuananimation.Content.model.listener.OnLoad_T_Listener;
import com.qianfeng.maotuananimation.Content.view.Fragment.IRecommendView;

import java.util.List;

/**
 * Created by qf on 2016/11/9.
 */

public class RecommendPresenter {
    private IDataRecommend iDataRecommend;
    private IRecommendView iRecommendView;

    public RecommendPresenter(IRecommendView iRecommendView) {
        this.iRecommendView = iRecommendView;
        iDataRecommend=new IDataRecommendImpl();
    }
    public void upDateData(){

                iDataRecommend.getScollData(new OnLoadScollListener() {
                    @Override
                    public void onRespond(List<ScollBean> list) {
                        iRecommendView.initScoll(list);

                    }

                    @Override
                    public void onFailure(String msg) {
                    }
                });
                iDataRecommend.getHotVideo(new OnLoad_T_Listener() {
                    @Override
                    public void onRespond(List<T_Bean> list) {
                        iRecommendView.initHotVideo(list);
                    }

                    @Override
                    public void onFailure(String msg) {

                    }
                });
                iDataRecommend.getRec_content(new OnLoadRec_contentListener() {
                    @Override
                    public void onRespond(List<Rec_contentBean> list) {
                        iRecommendView.initRec_content(list);
                    }

                    @Override
                    public void onFailure(String msg) {

                    }
                });
                iDataRecommend.getGameFourList(new OnLoad_T_Listener() {
                    @Override
                    public void onRespond(List<T_Bean> list) {
                        iRecommendView.initGameFourList(list);
                    }

                    @Override
                    public void onFailure(String msg) {

                    }
                });
                iDataRecommend.getCoser(new OnLoad_T_Listener() {
                    @Override
                    public void onRespond(List<T_Bean> list) {
                        iRecommendView.initCoser(list);
                    }

                    @Override
                    public void onFailure(String msg) {

                    }
                });
    }
}
