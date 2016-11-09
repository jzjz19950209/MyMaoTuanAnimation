package com.qianfeng.maotuananimation.BaseInterface.model;

import com.qianfeng.maotuananimation.BaseInterface.model.bean.FaceBean;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public interface OnFaceDataListener {
    public void onResponsed(FaceBean bean);
    public void onFailed(String msg);
}
