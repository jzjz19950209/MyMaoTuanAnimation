package com.qianfeng.maotuananimation.BaseInterface.presenter;

import android.os.Handler;

import com.qianfeng.maotuananimation.BaseInterface.model.IFaceData;
import com.qianfeng.maotuananimation.BaseInterface.model.IFaceDataImpl;
import com.qianfeng.maotuananimation.BaseInterface.model.OnFaceDataListener;
import com.qianfeng.maotuananimation.BaseInterface.model.bean.FaceBean;
import com.qianfeng.maotuananimation.BaseInterface.view.IFaceView;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class FacePresenter {
    private IFaceView iFaceView;
    private IFaceData iFaceData;
    private Handler handler=new Handler();

    public FacePresenter(IFaceView iFaceView) {
        this.iFaceView = iFaceView;
        iFaceData=new IFaceDataImpl();
    }

    public void start(String x,String y)
    {
        iFaceData.getFace(x, y, new OnFaceDataListener() {
            @Override
            public void onResponsed(final FaceBean bean) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iFaceView.upDateFace(bean);
                    }
                });
            }

            @Override
            public void onFailed(String msg) {

            }
        });
    }

    public void start(String id)
    {
        iFaceData.getFace(id, new OnFaceDataListener() {
            @Override
            public void onResponsed(final FaceBean bean) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iFaceView.upDateFace(bean);
                    }
                });
            }

            @Override
            public void onFailed(String msg) {

            }
        });
    }
}
