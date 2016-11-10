package com.qianfeng.maotuananimation.BaseInterface.model;

import com.qianfeng.maotuananimation.util.JsonParseUtil;
import com.qianfeng.maotuananimation.util.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class ITuanDataImpl implements ITuanData {

    @Override
    public void getTuanData(String x, String y, final OnTuanDataListener onTuanDataListener) {

        Request request=new Request.Builder().url(OkHttpUtil.TUANURL).build();
        OkHttpUtil.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful())
                {
                    onTuanDataListener.onResponse(JsonParseUtil.parseTuan(response.body().string()));
                }
            }
        });
    }
}
