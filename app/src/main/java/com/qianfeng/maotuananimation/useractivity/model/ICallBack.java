package com.qianfeng.maotuananimation.useractivity.model;


import com.qianfeng.maotuananimation.useractivity.util.UserBean;

/**
 * Created by Bigname on 2016/11/10.
 */
public interface ICallBack {
    void onFailed(String string);

    void onSucessed(UserBean userBean);
}
