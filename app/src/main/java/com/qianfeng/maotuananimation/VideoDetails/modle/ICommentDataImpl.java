package com.qianfeng.maotuananimation.VideoDetails.modle;

import com.qianfeng.maotuananimation.VideoDetails.modle.bean.CommentBean;
import com.qianfeng.maotuananimation.util.OkHttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class ICommentDataImpl implements ICommentData{
    @Override
    public void getCommentData(final OnCommentDataListener listener) {
        Request request=new Request.Builder().url(OkHttpUtil.COMMENTURL).build();
        OkHttpUtil.getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                listener.onResponsed(parseJson1(response.body().string()));
            }
        });
    }
//    String userface;
//    String username;
//    String content;
//    String good_num;
//    String reply_num;
//    String create_time;
    private List<CommentBean> parseJson1(String string) {
        List<CommentBean> list=new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(string);
            JSONArray list1 = jo.getJSONArray("list");
            for (int i = 0; i < list1.length(); i++) {
                JSONObject jsonObject = list1.getJSONObject(i);
                String content = jsonObject.getString("content");
                String create_time = jsonObject.getString("create_time");
                String good_num = jsonObject.getString("good_num");
                String reply_num = jsonObject.getString("reply_num");
                JSONObject from_user = jsonObject.getJSONObject("from_user");
                String userface = from_user.getString("head_pic");
                String username = from_user.getString("nickname");
                String uid = from_user.getString("uid");
                CommentBean commentBean = new CommentBean();
                commentBean.setContent(content);
                commentBean.setUserUid(uid);
                commentBean.setCreate_time(create_time);
                commentBean.setGood_num(good_num);
                commentBean.setReply_num(reply_num);
                commentBean.setUserface(userface);
                commentBean.setUsername(username);
                list.add(commentBean);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
