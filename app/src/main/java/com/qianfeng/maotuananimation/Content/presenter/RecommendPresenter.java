package com.qianfeng.maotuananimation.Content.presenter;

import com.qianfeng.maotuananimation.Content.model.IDataRecommend;
import com.qianfeng.maotuananimation.Content.model.IDataRecommendImpl;
import com.qianfeng.maotuananimation.Content.model.bean.ScollBean;
import com.qianfeng.maotuananimation.Content.model.listener.OnLoadScollListener;
import com.qianfeng.maotuananimation.Content.view.Fragment.IRecommendView;
import com.qianfeng.maotuananimation.MyDataUtils;
import com.qianfeng.maotuananimation.OkHttpUtils;

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
        OkHttpUtils.getRecommendData(MyDataUtils.RECOMMEND_DATA);
        iDataRecommend.getScollData(new OnLoadScollListener() {
            @Override
            public void onRespond(List<ScollBean> list) {
                iRecommendView.initScoll(list);
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
