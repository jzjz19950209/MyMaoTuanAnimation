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

public class IFaceDataImpl implements IFaceData{
    @Override
    public void getFace(String x, String y, final OnFaceDataListener onFaceDataListener) {
        Request request=new Request.Builder().url(OkHttpUtil.FACEURL).build();
        OkHttpUtil.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful())
                {
                    onFaceDataListener.onResponsed(JsonParseUtil.parseFace(response.body().string()));
                }
            }
        });
    }

    @Override
    public void getFace(String id, final OnFaceDataListener onFaceDataListener) {
        String replace = OkHttpUtil.TUIURL.replace("146", id);
        Request request=new Request.Builder().url(replace).build();
        OkHttpUtil.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful())
                {
                    onFaceDataListener.onResponsed(JsonParseUtil.parseFace(response.body().string()));
                }
            }
        });
    }


}
