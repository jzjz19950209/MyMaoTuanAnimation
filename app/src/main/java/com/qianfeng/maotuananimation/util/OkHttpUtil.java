package com.qianfeng.maotuananimation.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class OkHttpUtil {
    private static OkHttpClient client;
    public final static String TUANURL="http://manhua.haomee.cn/?&pf=1&android_version=19&app_version=5717&app_channel=91%E5%B8%82%E5%9C%BA&m=New&a=groupHomePage&location_y=113.340762&location_x=23.176336&Luid=";
    public final static String FACEURL="http://manhua.haomee.cn/?&pf=1&android_version=19&app_version=5717&app_channel=91%E5%B8%82%E5%9C%BA&m=Group&a=newGroupList&last_id=0&location_x=23.176336&location_y=113.340762";
    public final static String TUIURL="http://manhua.haomee.cn/?&pf=1&android_version=19&app_version=5717&app_channel=91%E5%B8%82%E5%9C%BA&m=New&a=recGroupTypeClick&location_y=113.340762&id=146&location_x=23.176336&Luid=&last_id=0&limit=10";
    public final static String MENGURL="http://manhua.haomee.cn/?&pf=1&android_version=19&app_version=5717&app_channel=91%E5%B8%82%E5%9C%BA&m=Group&a=search&needPage=1&order=new&word=%E4%BE%A6%E6%8E%A2&location_y=113.340762&location_x=23.176336&Luid=&last_id=0&limit=10&type=1";


    public static OkHttpClient getClient() {
        client = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).build();
        return client;
    }
}
