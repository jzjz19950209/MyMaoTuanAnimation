package com.qianfeng.maotuananimation.VideoDetails.modle;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;
import com.qianfeng.maotuananimation.R;
import com.qianfeng.maotuananimation.VideoDetails.modle.bean.WhoAreWatchBean;
import com.qianfeng.maotuananimation.VideoDetails.modle.view.CommentActivity;
import com.qianfeng.maotuananimation.VideoDetails.modle.view.DownloadActivity;
import com.qianfeng.maotuananimation.VideoDetails.modle.view.WebVideoPlayActivity;
import com.qianfeng.maotuananimation.useractivity.view.UserActivity;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VideoDetailsActivity extends AppCompatActivity {

    private FlexboxLayout flexboxLayout;
    private VideoDetailsBean bean = new VideoDetailsBean();
    private List<String> num_list;
    private TextView jianjieTv;
    private Button jianjie_btn;
    private Button juji_btn;
    private List<WhoAreWatchBean> userList;
    private Boolean isCollect = false;
    private String HTTPURL = "http://manhua.haomee.cn/?&pf=1&android_version=19&" +
            "app_version=5717&app_channel=91%E5%B8%82%E5%9C%BA&m=Api&a=getInfo&video_id=32308 ";
    private ImageView animation_face;
    private TextView animation_area, animation_character, animation_update_string, animation_publish_time,
            animation_comment_num, animation_score, animation_intro, animation_name;
    public RecyclerView whoarewatching, from_site;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            initList(Integer.parseInt(bean.getTotal_num()));
            for (String s : num_list) {
                initBtn(s);
            }
            WhoAreWatchAdapter areWatchAdapter = new WhoAreWatchAdapter(userList, VideoDetailsActivity.this);
            LinearLayoutManager manager = new LinearLayoutManager(VideoDetailsActivity.this, LinearLayoutManager.HORIZONTAL, false);
            whoarewatching.setLayoutManager(manager);
            areWatchAdapter.setItemOnClickListener(new WhoAreWatchAdapter.ItemOnClickListener() {
                @Override
                public void onClick(View view, int position, WhoAreWatchBean bean) {
                    Intent intent = new Intent(VideoDetailsActivity.this, UserActivity.class);
                    intent.putExtra("uid", bean.getUid());
                    intent.putExtra("name", bean.getNickname());
                    startActivity(intent);
                }
            });
            whoarewatching.setAdapter(areWatchAdapter);
            FromSiteAdapter fromSiteAdapter = new FromSiteAdapter(bean.getFrom_site(), VideoDetailsActivity.this);
            LinearLayoutManager manager2 = new LinearLayoutManager(VideoDetailsActivity.this, LinearLayoutManager.HORIZONTAL, false);
            from_site.setLayoutManager(manager2);
            from_site.setAdapter(fromSiteAdapter);
        }

    };
    private ImageView collectIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);
        findView();
        initData(HTTPURL);

    }

    //findView
    private void findView() {
        flexboxLayout = ((FlexboxLayout) findViewById(R.id.action_flexbox));
        jianjieTv = ((TextView) findViewById(R.id.animation_intro));
        jianjie_btn = ((Button) findViewById(R.id.jianjie_btn));
        juji_btn = ((Button) findViewById(R.id.juji_btn));
        animation_name = ((TextView) findViewById(R.id.animation_name));
        animation_face = ((ImageView) findViewById(R.id.animation_face));
        animation_area = ((TextView) findViewById(R.id.animation_area));
        animation_character = ((TextView) findViewById(R.id.animation_character));
        animation_update_string = ((TextView) findViewById(R.id.animation_update_string));
        animation_publish_time = ((TextView) findViewById(R.id.animation_publish_time));
        animation_comment_num = ((TextView) findViewById(R.id.animation_comment_num));
        animation_score = ((TextView) findViewById(R.id.animation_score));
        animation_intro = ((TextView) findViewById(R.id.animation_intro));
        whoarewatching = ((RecyclerView) findViewById(R.id.animation_whoarewatching_userface));
        from_site = ((RecyclerView) findViewById(R.id.animation_from_site_icon));
        collectIv = ((ImageView) findViewById(R.id.animation_btn_collect));
    }

    //下载Json
    private void initData(final String url1) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuffer result = new StringBuffer();
                BufferedReader br = null;
                HttpURLConnection con = null;
                try {
                    URL url = new URL(url1);
                    con = (HttpURLConnection) url.openConnection();
                    con.setConnectTimeout(5000);
                    con.connect();
                    if (con.getResponseCode() == 200) {
                        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                        String str;
                        while ((str = br.readLine()) != null) {
                            result.append(str);
                        }
                        parseJson(result.toString());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //    String imgUrl;//图片地址
//    String area;//地区
//    String character;//主演
//    String updataTime;//更新时间
//    String time;//上映时间
//    String comment_num;//评论数
//    String score;//得分
//    String intro;//简介
//    String total_num;//集数
//    List<String> watchUser;//谁在看
//    List<String> from_site;//播放源
    private void parseJson(String s) {
        try {
            final JSONObject jo = new JSONObject(s);
            final String name = jo.getString("name");
            final String cover = jo.getString("cover");
            final String area = jo.getString("area");
            final String character = jo.getString("character");
            final String publish_time = jo.getString("publish_time");
            final String comment_num = jo.getString("comment_num");
            final String score = jo.getString("score");
            final String intro = jo.getString("intro");
            final String total_num = jo.getString("total_num");
            final String update_string = jo.getString("update_string");
            JSONArray episode = jo.getJSONArray("episode");
            List<String> episodeUrl = new ArrayList<>();
            for (int i = 0; i < episode.length(); i++) {
                String videoUrl = episode.getJSONObject(i).getString("mUrl");
                episodeUrl.add(videoUrl);
            }
            JSONArray watchUser = jo.getJSONArray("watchUser");
            List<String> users = new ArrayList<>();
            userList=new ArrayList<>();
            for (int i = 0; i < watchUser.length(); i++) {
                JSONObject jsonObject = watchUser.getJSONObject(i);
                String head_pic = jsonObject.getString("head_pic");
                users.add(head_pic);
                String uid = jsonObject.getString("uid");
                String nickname = jsonObject.getString("nickname");
                WhoAreWatchBean whoAreWatchBean = new WhoAreWatchBean();
                whoAreWatchBean.setUid(uid);
                whoAreWatchBean.setHead_pic(head_pic);
                whoAreWatchBean.setNickname(nickname);
                userList.add(whoAreWatchBean);
            }
            JSONArray from_site = jo.getJSONArray("from_site");
            List<String> froms = new ArrayList<>();
            for (int i = 0; i < from_site.length(); i++) {
                String from = from_site.getJSONObject(i).getString("from");
                froms.add(from);
            }
            bean.setTotal_num(total_num);
            bean.setFrom_site(froms);
            bean.setWatchUser(users);
            bean.setEpisodeUrl(episodeUrl);
            bean.setName(name);
            bean.setTotal_num(total_num);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    animation_name.setText(name);
                    if (cover.equals("") || cover == null) {
                        animation_face.setImageResource(R.drawable.no_content);
                    } else {
                        Picasso.with(VideoDetailsActivity.this).load(cover).into(animation_face);
                    }
                    animation_area.setText("地区：" + area);
                    animation_character.setText("主演：" + character);
                    animation_publish_time.setText("上映时间：" + publish_time);
                    animation_comment_num.setText("评论（" + comment_num + "）");
                    animation_score.setText(score + "分");
                    animation_intro.setText(intro);
                    animation_update_string.setText("更新时间：" + update_string + "(更新至" + total_num + "集)");
                }
            });

            handler.sendEmptyMessage(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void initBtn(final String s) {
        final Button button = new Button(this);
        button.setText(s);
        button.setBackgroundResource(R.drawable.textview_bg);
        FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(14, 8, 14, 8);
        button.setLayoutParams(lp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VideoDetailsActivity.this, WebVideoPlayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("videoUrl", bean.getEpisodeUrl().get(Integer.parseInt(s) - 1));
                intent.putExtras(bundle);
                VideoDetailsActivity.this.startActivity(intent);
            }
        });
        flexboxLayout.addView(button);
        ViewGroup.LayoutParams params = button.getLayoutParams();
        params.width = 150;
        params.height = 120;
        button.setLayoutParams(params);

    }

    private void initList(int i) {
        num_list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            num_list.add(j + 1 + "");
        }
    }

    public void jianjie(View view) {
        jianjieTv.setVisibility(View.VISIBLE);
        flexboxLayout.setVisibility(View.INVISIBLE);
        jianjie_btn.setTextColor(getResources().getColor(R.color.colorUseMore));
        juji_btn.setTextColor(getResources().getColor(R.color.textColor));
    }

    public void juji(View view) {
        flexboxLayout.setVisibility(View.VISIBLE);
        jianjieTv.setVisibility(View.INVISIBLE);
        juji_btn.setTextColor(getResources().getColor(R.color.colorUseMore));
        jianjie_btn.setTextColor(getResources().getColor(R.color.textColor));
    }

    //跳转评论页面
    public void comment_btn(View view) {
        Intent intent = new Intent(this, CommentActivity.class);
        startActivity(intent);
    }

    public void back_btn1(View view) {
        this.finish();
    }

    //收藏按钮
    public void collect_btn(View view) {
        if (isCollect) {
            Toast.makeText(this, "取消收藏：" + bean.getName(), Toast.LENGTH_SHORT).show();
            collectIv.setImageResource(R.drawable.home_icon_collect);
            isCollect = false;
        } else {
            Toast.makeText(this, "添加收藏：" + bean.getName(), Toast.LENGTH_SHORT).show();
            collectIv.setImageResource(R.drawable.list_button_on);
            isCollect = true;
        }
    }

    //立即播放
    public void playNow_btn(View view) {
        Intent intent = new Intent(VideoDetailsActivity.this, WebVideoPlayActivity.class);
        Bundle bundle = new Bundle();
        String value = bean.getEpisodeUrl().get(0);
        bundle.putString("videoUrl", value);
        intent.putExtras(bundle);
        VideoDetailsActivity.this.startActivity(intent);
    }

    //离线下载
    public void download_btn(View view) {
        Intent intent = new Intent(this, DownloadActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("total_num", bean.getTotal_num());
        intent.putExtras(bundle);
        VideoDetailsActivity.this.startActivity(intent);
    }

    //分享
    public void share_btn(View view) {
        View pwView = LayoutInflater.from(this).inflate(R.layout.share_pw, null);
        PopupWindow pw = new PopupWindow(pwView, RelativeLayout.LayoutParams.MATCH_PARENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics()), true);
        pw.setOutsideTouchable(true);
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.showAtLocation(jianjie_btn, Gravity.BOTTOM, 0, 0);
    }
}
