package com.qianfeng.maotuananimation;

import android.os.Handler;

import com.qianfeng.maotuananimation.Content.model.listener.OnLoadScollListener;
import com.qianfeng.maotuananimation.Content.model.listener.OnLoad_T_Listener;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by qf on 2016/11/9.
 */

public class OkHttpUtils {
    private static OkHttpClient client=new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS).build();
    private static Handler mHandler=new Handler();

   public static void get_T_Data(final int id, String httpurl, final OnLoad_T_Listener onLoad_t_Listener){
        final Request request=new Request.Builder().url(httpurl).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                onLoad_t_Listener.onFailure(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String result = response.body().string();
                    switch (id) {
                        case MyDataUtils.DAYVIDEO:
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    onLoad_t_Listener.onRespond(ParseJson.ParseJson_dayVideo(result));
                                }
                            });
                            break;
                        case MyDataUtils.HOTVIDEO:
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    onLoad_t_Listener.onRespond(ParseJson.ParseJson_hotVideo(result));
                                }
                            });
                            break;
                        case MyDataUtils.COSER:
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    onLoad_t_Listener.onRespond(ParseJson.ParseJson_coser(result));
                                }
                            });
                            break;
                        case MyDataUtils.GAMECAROUSEL:
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    onLoad_t_Listener.onRespond(ParseJson.ParseJson_gameCarousel(result));
                                }
                            });
                            break;
                        case MyDataUtils.GAMEFOURLIST:
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    onLoad_t_Listener.onRespond(ParseJson.ParseJson_gameFourList(result));
                                }
                            });
                            break;
                    }
                }
            }
        });
   }

   public static void getScollData(String httpurl, final OnLoadScollListener onLoadScollListener){
       Request request=new Request.Builder().url(httpurl).build();
       client.newCall(request).enqueue(new Callback() {
           @Override
           public void onFailure(Call call, IOException e) {
               onLoadScollListener.onFailure(e.getMessage());
           }

           @Override
           public void onResponse(Call call, Response response) throws IOException {
               final String result = response.body().string();
               mHandler.post(new Runnable() {
                   @Override
                   public void run() {
                       onLoadScollListener.onRespond();
                   }
               });

           }
       });
   }

}
