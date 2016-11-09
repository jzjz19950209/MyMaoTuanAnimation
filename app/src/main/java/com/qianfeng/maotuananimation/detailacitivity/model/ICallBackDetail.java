package com.qianfeng.maotuananimation.detailacitivity.model;


import com.qianfeng.maotuananimation.sortfragment.bean.DetailsBean;

import java.util.List;

/**
 * Created by Bigname on 2016/11/8.
 */
public interface ICallBackDetail {
    void onFailed(String failStr);

    void onSucessed(List<DetailsBean> list);
}
