package com.qianfeng.maotuananimation.sortfragment.presenter;


import com.qianfeng.maotuananimation.sortfragment.model.ICallBack;
import com.qianfeng.maotuananimation.sortfragment.model.IGetChannel;
import com.qianfeng.maotuananimation.sortfragment.model.IGetChannelImpl;

/**
 * Created by Bigname on 2016/11/8.
 */
public class ChannelPresenter {
    IGetChannel iGetChannel;
//    IUpdateRv iUpdateRv;

    public ChannelPresenter() {
        this.iGetChannel = new IGetChannelImpl();
//        this.iUpdateRv = iUpdateRv;
    }
    public void start(String url, ICallBack iCallBack) {
        iGetChannel.igetChannel(url, iCallBack);
    }
}
