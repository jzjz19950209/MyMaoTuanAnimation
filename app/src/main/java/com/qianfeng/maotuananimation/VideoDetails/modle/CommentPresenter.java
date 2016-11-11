package com.qianfeng.maotuananimation.VideoDetails.modle;

import android.os.Handler;

import com.qianfeng.maotuananimation.VideoDetails.modle.bean.CommentBean;
import com.qianfeng.maotuananimation.VideoDetails.modle.view.ICommentView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class CommentPresenter {
    private ICommentData iCommentData;
    private ICommentView iCommentView;
    private Handler handler=new Handler();

    public CommentPresenter(ICommentView iCommentView) {
        this.iCommentView = iCommentView;
        iCommentData=new ICommentDataImpl();
    }
    public void start(){
        iCommentData.getCommentData(new OnCommentDataListener() {
            @Override
            public void onResponsed(final List<CommentBean> list) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                    iCommentView.updataComment(list);
                    }
                });
            }

            @Override
            public void onFailed(String msg) {

            }
        });
    }
}
