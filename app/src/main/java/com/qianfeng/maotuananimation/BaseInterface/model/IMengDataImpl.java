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

public class IMengDataImpl implements IMengData{
    @Override
    public void getMeng(String word, String order, final OnFaceDataListener onFaceDataListener) {
        String aNew = OkHttpUtil.MENGURL.replace("%E4%BE%A6%E6%8E%A2", word).replace("new", order);
        Request request=new Request.Builder().url(aNew).build();
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
