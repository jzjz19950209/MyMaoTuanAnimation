package com.qianfeng.maotuananimation.useractivity.presenter;

import android.util.Log;

import com.qianfeng.maotuananimation.useractivity.model.ICallBack;
import com.qianfeng.maotuananimation.useractivity.model.IGetDatas;
import com.qianfeng.maotuananimation.useractivity.model.IGetDatasImpl;
import com.qianfeng.maotuananimation.useractivity.util.UserBean;
import com.qianfeng.maotuananimation.useractivity.view.fragment.timefragment.IUpdateLv;


/**
 * Created by Bigname on 2016/11/10.
 */

public class TimeFragmentPresenter {
    IGetDatas iGetDatas;
    IUpdateLv iUpdateLv;

    public TimeFragmentPresenter(IUpdateLv iUpdateLv) {
        this.iUpdateLv = iUpdateLv;
        this.iGetDatas = new IGetDatasImpl();
    }

    public void start(String url) {
        iGetDatas.getData(url, new ICallBack() {
            @Override
            public void onFailed(String string) {
                Log.d("bigname_log", "onFailed: "+string);
            }

            @Override
            public void onSucessed(UserBean userBean) {
                Log.d("bigname_log", "onSucessed: "+userBean);
                iUpdateLv.updateLv(userBean);
            }
        });
    }
}
