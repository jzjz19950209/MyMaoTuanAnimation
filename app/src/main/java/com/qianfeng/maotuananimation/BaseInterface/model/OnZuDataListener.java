package com.qianfeng.maotuananimation.BaseInterface.model;

import com.qianfeng.maotuananimation.BaseInterface.model.bean.ZuBean;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public interface OnZuDataListener {
    public void onResponse(ZuBean zuBean);
    public void onFailer(String msg);
}
