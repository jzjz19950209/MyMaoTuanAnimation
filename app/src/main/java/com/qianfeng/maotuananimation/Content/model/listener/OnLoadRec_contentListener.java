package com.qianfeng.maotuananimation.Content.model.listener;

import com.qianfeng.maotuananimation.Content.model.bean.Rec_contentBean;

import java.util.List;

/**
 * Created by qf on 2016/11/9.
 */

public interface OnLoadRec_contentListener {
    void onRespond(List<Rec_contentBean> list);
    void onFailure(String msg);
}
