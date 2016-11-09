package com.qianfeng.maotuananimation.BaseInterface.model;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public interface IFaceData {
    public void getFace(String x, String y, OnFaceDataListener onFaceDataListener);
    public void getFace(String id, OnFaceDataListener onFaceDataListener);
}
