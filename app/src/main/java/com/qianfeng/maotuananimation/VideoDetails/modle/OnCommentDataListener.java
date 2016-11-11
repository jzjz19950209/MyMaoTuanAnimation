package com.qianfeng.maotuananimation.VideoDetails.modle;


import com.qianfeng.maotuananimation.VideoDetails.modle.bean.CommentBean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public interface OnCommentDataListener {
    public void onResponsed(List<CommentBean> list);
    public void onFailed(String msg);
}
