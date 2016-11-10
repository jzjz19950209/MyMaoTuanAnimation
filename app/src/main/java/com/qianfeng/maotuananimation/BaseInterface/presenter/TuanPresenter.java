package com.qianfeng.maotuananimation.BaseInterface.presenter;

import android.os.Handler;

import com.qianfeng.maotuananimation.BaseInterface.model.ITuanData;
import com.qianfeng.maotuananimation.BaseInterface.model.ITuanDataImpl;
import com.qianfeng.maotuananimation.BaseInterface.model.OnTuanDataListener;
import com.qianfeng.maotuananimation.BaseInterface.model.bean.TuanBean;
import com.qianfeng.maotuananimation.BaseInterface.view.fragment.ITuanView;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class TuanPresenter{
    private ITuanData iTuanData;
    private ITuanView iTuanView;
    private Handler mHandler=new Handler();

    public TuanPresenter(ITuanView iTuanView) {
        this.iTuanView = iTuanView;
        iTuanData=new ITuanDataImpl();
    }

    public void start(String x,String y)
    {
        iTuanData.getTuanData(x, y, new OnTuanDataListener() {
            @Override
            public void onResponse(final TuanBean bean) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iTuanView.updateView(bean);
                    }
                });
            }

            @Override
            public void onFailed(String msg) {

            }
        });
    }
}
