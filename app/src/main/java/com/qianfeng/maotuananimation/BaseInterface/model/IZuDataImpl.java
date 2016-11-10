package com.qianfeng.maotuananimation.BaseInterface.model;

import com.qianfeng.maotuananimation.util.JsonParseUtil;
import com.qianfeng.maotuananimation.util.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public class IZuDataImpl implements IZuData {
    @Override
    public void getZu(String id, final OnZuDataListener onZuDataListener) {
        String replace = OkHttpUtil.ZUURL.replace("88048", id);
        Request request=new Request.Builder().url(replace).build();
        OkHttpUtil.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful())
                {
                    onZuDataListener.onResponse(JsonParseUtil.parseZu(response.body().string()));
                }
            }
        });
    }
}
