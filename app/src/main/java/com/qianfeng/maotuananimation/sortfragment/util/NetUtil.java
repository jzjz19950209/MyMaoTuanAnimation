package com.qianfeng.maotuananimation.sortfragment.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Bigname on 2016/11/8.
 */
public class NetUtil {
    public static OkHttpClient client = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).build();
}
