package com.qianfeng.maotuananimation.BaseInterface.presenter;

import android.os.Handler;

import com.qianfeng.maotuananimation.BaseInterface.model.IMengData;
import com.qianfeng.maotuananimation.BaseInterface.model.IMengDataImpl;
import com.qianfeng.maotuananimation.BaseInterface.model.OnFaceDataListener;
import com.qianfeng.maotuananimation.BaseInterface.model.bean.FaceBean;
import com.qianfeng.maotuananimation.BaseInterface.view.fragment.IMengView;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public class MengPresenter {
    private IMengData iMengData;
    private IMengView iMengView;
    private Handler handler=new Handler();

    public MengPresenter(IMengView iMengView) {
        this.iMengView = iMengView;
        iMengData=new IMengDataImpl();
    }


    public void start(String word,String order)
    {
        iMengData.getMeng(word, order, new OnFaceDataListener() {
            @Override
            public void onResponsed(final FaceBean bean) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iMengView.upDateMeng(bean);
                    }
                });
            }

            @Override
            public void onFailed(String msg) {

            }
        });
    }
}
