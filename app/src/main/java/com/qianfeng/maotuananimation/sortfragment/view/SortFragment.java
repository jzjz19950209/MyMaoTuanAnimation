package com.qianfeng.maotuananimation.sortfragment.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.qianfeng.maotuananimation.R;
import com.qianfeng.maotuananimation.detailacitivity.view.DetailsActivity;
import com.qianfeng.maotuananimation.sortfragment.adapter.RvAdapter;
import com.qianfeng.maotuananimation.sortfragment.bean.ChannelBean;
import com.qianfeng.maotuananimation.sortfragment.model.ICallBack;
import com.qianfeng.maotuananimation.sortfragment.presenter.ChannelPresenter;
import com.qianfeng.maotuananimation.sortfragment.util.FinalString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bigname on 2016/11/8.
 */
public class SortFragment extends Fragment {
    private RecyclerView recyclerview;
    ChannelPresenter presenter;
    List<ChannelBean> list;
    private RvAdapter adapter;
    private ProgressBar pb;
    private List<String> details_title;
    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        presenter = new ChannelPresenter();
        list = new ArrayList<>();
        adapter = new RvAdapter(context, list);
        adapter.setiOnClickListrener(new RvAdapter.IOnClickListrener() {
            @Override
            public void onClickListener(View view, int position,String id) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("title",details_title.get(position));
                getContext().startActivity(intent);
            }

            @Override
            public void onLongClickListener(View view, int position) {
                Toast.makeText(context, "long"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sort_fragment, container, false);
        initView(view);
        initDatas();
        return view;
    }

    private void initDatas() {
        presenter.start(FinalString.CHANNELURL, new ICallBack() {
            @Override
            public void onFailed(String failStr) {
                Log.d("bigname_log", "onFailed: "+failStr);
            }

            @Override
            public void onSucessed(List<ChannelBean> list) {
                updateRv(list);
            }
        });
    }

    private void initView(View view) {
        recyclerview = ((RecyclerView) view.findViewById(R.id.recyclerview));
        pb = ((ProgressBar) view.findViewById(R.id.pb));
        recyclerview.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerview.setAdapter(adapter);
    }

    public void updateRv(List<ChannelBean> list) {
        details_title=new ArrayList<>();
        pb.setVisibility(View.GONE);
        this.list.clear();
        this.list.addAll(list);
        adapter.notifyDataSetChanged();
        for (int i = 0; i < list.size(); i++) {
            details_title.add(list.get(i).getName());
        }
    }
}
