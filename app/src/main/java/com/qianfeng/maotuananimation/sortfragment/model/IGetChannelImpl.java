package com.qianfeng.maotuananimation.sortfragment.model;

import android.os.Handler;
import android.util.Log;

import com.qianfeng.maotuananimation.sortfragment.bean.ChannelBean;
import com.qianfeng.maotuananimation.sortfragment.util.NetUtil;
import com.qianfeng.maotuananimation.sortfragment.util.Parser1;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Bigname on 2016/11/8.
 */
public class IGetChannelImpl implements IGetChannel {
    Handler handler = new Handler();
    @Override
    public void igetChannel(String url, final ICallBack iCallBack) {
        Request request = new Request.Builder().url(url).build();
        NetUtil.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iCallBack.onFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
                    final List<ChannelBean> list = Parser1.parser(json);
                    Log.d("bigname_log", "onResponse: "+list.size());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iCallBack.onSucessed(list);
                        }
                    });
                }
            }
        });
    }
}
