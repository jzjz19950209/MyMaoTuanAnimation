package com.qianfeng.maotuananimation.BaseInterface.presenter;

import android.os.Handler;

import com.qianfeng.maotuananimation.BaseInterface.model.IZuData;
import com.qianfeng.maotuananimation.BaseInterface.model.IZuDataImpl;
import com.qianfeng.maotuananimation.BaseInterface.model.OnZuDataListener;
import com.qianfeng.maotuananimation.BaseInterface.model.bean.ZuBean;
import com.qianfeng.maotuananimation.BaseInterface.view.IZuView;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public class ZuPresenter {
    private IZuData iZuData;
    private IZuView iZuView;
    private Handler handler=new Handler();

    public ZuPresenter(IZuView iZuView) {
        this.iZuView = iZuView;
        iZuData=new IZuDataImpl();
    }

    public void start(String id)
    {
        iZuData.getZu(id, new OnZuDataListener() {
            @Override
            public void onResponse(final ZuBean zuBean) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iZuView.updateZu(zuBean);
                    }
                });
            }

            @Override
            public void onFailer(String msg) {

            }
        });
    }
}
