package com.qianfeng.maotuananimation.useractivity.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.qianfeng.maotuananimation.R;
import com.qianfeng.maotuananimation.useractivity.adapter.VpAdapter;
import com.qianfeng.maotuananimation.useractivity.view.fragment.commentfragment.CommentFragment;
import com.qianfeng.maotuananimation.useractivity.view.fragment.timefragment.TimeFragment;

import java.util.ArrayList;
import java.util.List;


public class UserActivity extends AppCompatActivity {

    private TabLayout tb;
    private ViewPager vp;
    private TextView tv_title;
    private TextView tv_care;
    List<String> titles ;
    List<Fragment> fragments;
    String URL="http://manhua.haomee.cn/?&pf=1&android_version=23&app_version=5717&app_channel=91%E5%B8%82%E5%9C%BA&m=NewUser&a=userPage&Luid=1581567&";
    String arg = "uid=%s&login_uid=1581567";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initViews();
        initDatas();
        setDatas();
    }



    private void setDatas() {
        vp.setAdapter(new VpAdapter(getSupportFragmentManager(),titles,fragments));
        tb.setupWithViewPager(vp);
    }

    private void initDatas() {
        titles = new ArrayList<>();
        titles.add("时间线");
        titles.add("评论");
        Intent intent = getIntent();
        String uid = intent.getStringExtra("uid");
        String args = String.format(arg, uid);
        uid = URL + args;
        String name = intent.getStringExtra("name");
        fragments = new ArrayList<>();
        fragments.add(TimeFragment.getTimeFragment(uid));
        fragments.add(new CommentFragment());

    }

    private void initViews() {
        tb = ((TabLayout) findViewById(R.id.tb));
        vp = ((ViewPager) findViewById(R.id.vp));
        tv_title = ((TextView) findViewById(R.id.tv_title));
        tv_care = ((TextView) findViewById(R.id.tv_care));
    }

    public void back_btn5(View view) {
        this.finish();
    }
}
