package com.qianfeng.maotuananimation.Content.model.listener;

import com.qianfeng.maotuananimation.Content.model.bean.ScollBean;

import java.util.List;



/**
 * Created by qf on 2016/11/9.
 */

public interface OnLoadScollListener {
    void onRespond(List<ScollBean> list);
    void onFailure(String msg);
}
