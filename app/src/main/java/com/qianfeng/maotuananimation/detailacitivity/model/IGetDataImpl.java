package com.qianfeng.maotuananimation.detailacitivity.model;

import android.os.Handler;

import com.qianfeng.maotuananimation.sortfragment.bean.DetailsBean;
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
public class IGetDataImpl implements IGetData{
    Handler handler = new Handler();
    @Override
    public void iGetDatas(String url, final ICallBackDetail iCallBack) {
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
                    final List<DetailsBean> list = Parser1.parser2(json);
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
