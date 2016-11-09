package com.qianfeng.maotuananimation.detailacitivity.presenter;


import com.qianfeng.maotuananimation.detailacitivity.model.ICallBackDetail;
import com.qianfeng.maotuananimation.detailacitivity.model.IGetData;
import com.qianfeng.maotuananimation.detailacitivity.model.IGetDataImpl;

/**
 * Created by Bigname on 2016/11/8.
 */
public class RvPresenter {
    IGetData iGetData;
    public RvPresenter() {
        iGetData = new IGetDataImpl();
    }

    public void start(String url, ICallBackDetail iCallBackDetail) {
        iGetData.iGetDatas(url,iCallBackDetail);
    }

}
