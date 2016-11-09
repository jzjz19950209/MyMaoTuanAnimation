package com.qianfeng.maotuananimation.Content.model.listener;

import com.qianfeng.maotuananimation.Content.model.bean.T_Bean;

import java.util.List;

/**
 * Created by qf on 2016/11/9.
 */

public interface OnLoad_T_Listener {
    void onRespond(List<T_Bean> list);
    void onFailure(String msg);
}
