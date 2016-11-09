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
import android.widget.Toast;

import com.example.administrator.maotuandongman10.R;
import com.example.administrator.maotuandongman10.detailacitivity.adapter.RvDtAdapter;
import com.example.administrator.maotuandongman10.detailacitivity.model.ICallBackDetail;
import com.example.administrator.maotuandongman10.detailacitivity.presenter.RvPresenter;
import com.example.administrator.maotuandongman10.sortfragment.bean.DetailsBean;
import com.example.administrator.maotuandongman10.sortfragment.util.FinalString;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getIntents();
        initViews();
        initPresent(id);
    }

    private void initViews() {
        list = new ArrayList<>();
        rvDtAdapter = new RvDtAdapter(this, list);
        recyclerview = ((RecyclerView) findViewById(R.id.rv));
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
                Toast.makeText(DetailsActivity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
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
