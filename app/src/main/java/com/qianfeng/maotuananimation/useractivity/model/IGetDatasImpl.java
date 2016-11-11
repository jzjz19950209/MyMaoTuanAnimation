package com.qianfeng.maotuananimation.useractivity.model;

import android.os.Handler;

import com.qianfeng.maotuananimation.useractivity.util.Parser;
import com.qianfeng.maotuananimation.useractivity.util.UserBean;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Bigname on 2016/11/10.
 */

public class IGetDatasImpl implements IGetDatas {
    Handler handler = new Handler();
    @Override
    public String getData(String url, final ICallBack iCallBack) {
        String result = null;
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iCallBack.onFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final UserBean userBean= Parser.parser(response.body().string());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iCallBack.onSucessed(userBean);
                        }
                    });
                }
            }
        });
        return result;
    }

}
