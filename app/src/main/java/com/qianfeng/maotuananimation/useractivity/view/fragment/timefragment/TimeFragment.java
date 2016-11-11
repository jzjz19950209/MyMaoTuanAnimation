package com.qianfeng.maotuananimation.useractivity.view.fragment.timefragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.qianfeng.maotuananimation.R;
import com.qianfeng.maotuananimation.useractivity.adapter.LvAdapter;
import com.qianfeng.maotuananimation.useractivity.presenter.TimeFragmentPresenter;
import com.qianfeng.maotuananimation.useractivity.util.TimeLineBean;
import com.qianfeng.maotuananimation.useractivity.util.UserBean;
import com.qianfeng.maotuananimation.view.GroupChatActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Bigname on 2016/11/10.
 */

public class TimeFragment extends Fragment implements IUpdateLv {
    private ListView lv;
    private ImageView iv_head;
    private TextView tv_name;
    private TextView tv_adress;
    private TextView tv_desc;
    private TextView tv_groupchatcount;
    private TextView tv_carecount;
    private TextView tv_fanscount;
    TimeFragmentPresenter presenter;
    private TextView tv_age;
    private FlexboxLayout fblayout;
    private ImageView iv_super;
    List<TimeLineBean> list;
    private LvAdapter adapter;
    private LinearLayout ll_groupchat;
    private LinearLayout ll_care;
    private LinearLayout ll_fans;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public static TimeFragment getTimeFragment(String url) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        TimeFragment timeFragment = new TimeFragment();
        timeFragment.setArguments(bundle);
        return timeFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.time_fragment, container, false);
        View headview = inflater.inflate(R.layout.user_lv_head, null);
        initViews(view,headview);
        initDatas();
        setHeadDatas();
        return view;
    }

    private void setHeadDatas() {

    }

    private void initViews(View view,View headview) {
        lv = (ListView) view.findViewById(R.id.lv);
        list = new ArrayList<>();
        adapter = new LvAdapter(list, getContext());
        lv.setAdapter(adapter);
        setLvListener();
        iv_head = (ImageView) headview.findViewById(R.id.iv_head);
        tv_name = (TextView) headview.findViewById(R.id.tv_name);
        tv_age = ((TextView) headview.findViewById(R.id.tv_age));
        tv_adress = (TextView) headview.findViewById(R.id.tv_adress);
        tv_desc = (TextView) headview.findViewById(R.id.tv_desc);
        tv_groupchatcount = (TextView) headview.findViewById(R.id.tv_groupchatcount);
        tv_carecount = (TextView) headview.findViewById(R.id.tv_carecount);
        tv_fanscount = (TextView) headview.findViewById(R.id.tv_fanscount);
        iv_super = ((ImageView) headview.findViewById(R.id.iv_super));

        ll_groupchat = ((LinearLayout) headview.findViewById(R.id.ll_groupchat));
        ll_care = ((LinearLayout) headview.findViewById(R.id.ll_care));
        ll_fans = ((LinearLayout) headview.findViewById(R.id.ll_fans));
        setllListener();

        fblayout = ((FlexboxLayout) headview.findViewById(R.id.fblayout));

        lv.addHeaderView(headview);
    }
    /*
    * 设置三个的点击事件，
    * */
    private void setllListener() {
        ll_groupchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),GroupChatActivity.class);
            }
        });
    }

    private void setLvListener() {
        adapter.setLvOnClickListener(new LvAdapter.LvOnClickListener() {
            @Override
            public void onItemClick(View view, int position, String id) {
                Log.d("bigname_log", "onClick: "+position+","+id);
                /*
                * 跳转到弹幕界面
                * */
            }
        });
    }

    private void initDatas() {
        String url = getArguments().getString("url");
        Log.d("bigname_log", "initDatas: "+url);
        presenter = new TimeFragmentPresenter(this);
        presenter.start(url);
    }

    @Override
    public void updateLv(UserBean userBean) {
        Log.d("bigname_log", "updateLv: "+userBean.getCity());
        tv_name.setText(userBean.getNickname());
        tv_adress.setText(userBean.getCity());
        tv_desc.setText(userBean.getSign());
        Picasso.with(getContext()).load(userBean.getHead_pic()).into(iv_head);
        tv_groupchatcount.setText(userBean.getGroup_num());
        tv_carecount.setText(userBean.getFocus());
        tv_fanscount.setText(userBean.getFans());
        tv_age.setText(""+userBean.getAge());
        List<String> new_tips = userBean.getNew_tips();
        FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(24, 12, 24, 12);
        for (int i = 0; i < new_tips.size(); i++) {
            TextView tv = new TextView(getContext());
            tv.setText(new_tips.get(i));
            tv.setLayoutParams(lp);
            tv.setPadding(32, 16, 32, 16);

            tv.setBackgroundResource(R.drawable.tips_bg);
            fblayout.addView(tv);
        }
        String superscript = userBean.getSuperscript();
        if (superscript != null && !"".equals(superscript)) {
            Picasso.with(getContext()).load(superscript).into(iv_super);
        }
        list.clear();
        list.addAll(userBean.getTime_lines());
        adapter.notifyDataSetChanged();
    }
}
