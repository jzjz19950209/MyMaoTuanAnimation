package com.qianfeng.maotuananimation.detailacitivity.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.maotuananimation.R;
import com.qianfeng.maotuananimation.detailacitivity.adapter.RvDtAdapter;
import com.qianfeng.maotuananimation.detailacitivity.model.ICallBackDetail;
import com.qianfeng.maotuananimation.detailacitivity.presenter.RvPresenter;
import com.qianfeng.maotuananimation.sortfragment.bean.DetailsBean;
import com.qianfeng.maotuananimation.sortfragment.util.FinalString;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private String id;
    private RvPresenter presenter;
    private List<DetailsBean> list;
    private RvDtAdapter rvDtAdapter;
    private RecyclerView recyclerview;
    private TextView tv;
    private ImageButton ib;
    private ImageView iv;
    private ImageView details_back;
    private TextView details_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getIntents();
        initViews();
        initPresent(id);
        details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        details_text.setText(getIntent().getStringExtra("title"));
    }

    private void initViews() {
        list = new ArrayList<>();
        rvDtAdapter = new RvDtAdapter(this, list);
        recyclerview = ((RecyclerView) findViewById(R.id.rv));
        details_back= (ImageView) findViewById(R.id.details_back);
        details_text= (TextView) findViewById(R.id.details_text);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerview.setAdapter(rvDtAdapter);

        tv = ((TextView) findViewById(R.id.tv));
        ib = ((ImageButton) findViewById(R.id.ib));
        iv = ((ImageView) findViewById(R.id.iv));
    }

    private void initPresent(String id) {
        String url = String.format(FinalString.DETAILURL, id);
        presenter = new RvPresenter();
        presenter.start(url, new ICallBackDetail() {
            @Override
            public void onFailed(String failStr) {
//                Toast.makeText(DetailsActivity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
                setVisiable(false);
            }

            @Override
            public void onSucessed(List<DetailsBean> list) {
                setVisiable(true);
                updateRv(list);
            }
        });
    }

    public void getIntents() {
        id = getIntent().getStringExtra("id");
    }

    private void updateRv(List<DetailsBean> list) {
        Log.d("bigname_log", "updateRv: "+list.size());
        this.list.clear();
        this.list.addAll(list);
        rvDtAdapter.notifyDataSetChanged();
    }

    private void setVisiable(boolean isGone) {
        if (isGone) {
            iv.setVisibility(View.GONE);
            ib.setVisibility(View.GONE);
            tv.setVisibility(View.GONE);
        } else {
            iv.setVisibility(View.VISIBLE);
            ib.setVisibility(View.VISIBLE);
            tv.setVisibility(View.VISIBLE);
        }

    }

    public void btnRefresh(View view) {
        initPresent(id);
    }
}
