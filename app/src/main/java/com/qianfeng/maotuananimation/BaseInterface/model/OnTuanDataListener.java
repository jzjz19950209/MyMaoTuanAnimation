package com.qianfeng.maotuananimation.BaseInterface.model;

import com.qianfeng.maotuananimation.BaseInterface.model.bean.TuanBean;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public interface OnTuanDataListener {
    public void onResponse(TuanBean bean);
    public void onFailed(String msg);
}
