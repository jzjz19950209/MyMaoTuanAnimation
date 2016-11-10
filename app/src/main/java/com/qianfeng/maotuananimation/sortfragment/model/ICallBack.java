package com.qianfeng.maotuananimation.sortfragment.model;


import com.qianfeng.maotuananimation.sortfragment.bean.ChannelBean;

import java.util.List;

/**
 * Created by Bigname on 2016/11/8.
 */
public interface ICallBack {
    void onFailed(String failStr);

    void onSucessed(List<ChannelBean> list);

}
