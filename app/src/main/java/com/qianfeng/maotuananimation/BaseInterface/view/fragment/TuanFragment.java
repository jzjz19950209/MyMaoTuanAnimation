package com.qianfeng.maotuananimation.BaseInterface.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qianfeng.maotuananimation.BaseInterface.model.bean.TuanBean;
import com.qianfeng.maotuananimation.BaseInterface.presenter.TuanPresenter;
import com.qianfeng.maotuananimation.BaseInterface.view.FaceActivity;
import com.qianfeng.maotuananimation.BaseInterface.view.MengActivity;
import com.qianfeng.maotuananimation.BaseInterface.view.TuiActivity;
import com.qianfeng.maotuananimation.BaseInterface.view.ZuActivity;
import com.qianfeng.maotuananimation.BaseInterface.view.adapter.TuanLvAdapter;
import com.qianfeng.maotuananimation.BaseInterface.view.adapter.TuanReAdapter;
import com.qianfeng.maotuananimation.R;
import com.qianfeng.mylibrary.MyFlexBox;
import com.qianfeng.mylibrary.MyListView;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class TuanFragment extends Fragment implements ITuanView{
    private View view;
    private RecyclerView recycler;
    private ListView lv;
    private MyFlexBox line;
    private TuanPresenter presenter;
    private ImageView feiji;
    private int startX;
    private int startY;
    private RelativeLayout layout;
    private View rLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null)
        {
            view=inflater.inflate(R.layout.tuanliao_fragment,container,false);
            init();
            presenter=new TuanPresenter(this);
            presenter.start("113.340762","23.176336");
        }
        return view;
    }

    private void init() {
        recycler = ((RecyclerView) view.findViewById(R.id.tuanliao_recycler));
        lv = ((MyListView) view.findViewById(R.id.tuanliao_lv));
         line = (MyFlexBox) view.findViewById(R.id.tuanliao_line);
        feiji = ((ImageView) view.findViewById(R.id.tuanliao_feiji));
        layout = ((RelativeLayout) view.findViewById(R.id.tuanliao_feijichang));
        rLayout = view.findViewById(R.id.tuanliao_layout);
        final int totalWidth=layout.getHeight();
        final int height = feiji.getHeight();
        feiji.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().getParent().getParent().getParent()
                        .requestDisallowInterceptTouchEvent(true);
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        startX= (int) motionEvent.getX();
                        startY = ((int) motionEvent.getY());
                        break;
                    case  MotionEvent.ACTION_MOVE:
                        ((ViewGroup) view.getParent()).scrollBy(-(int) motionEvent.getX()+startX,height);
                        break;
                    case MotionEvent.ACTION_UP:
                        Intent intent=new Intent(getActivity(), FaceActivity.class);
                        intent.putExtra("x","123");
                        intent.putExtra("y","123");
                       startActivity(intent);

                        break;
                }
                return true;
            }
        });

    }

    @Override
    public void updateView(final TuanBean bean) {

        TuanReAdapter reAdapter=new TuanReAdapter(bean.getRec(),getActivity());
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(reAdapter);
        reAdapter.setOnItemListener(new TuanReAdapter.OnItemListener() {
            @Override
            public void onItemClickListener(int position) {
                Intent intent=new Intent(getActivity(), TuiActivity.class);
                intent.putExtra("id",bean.getRec().get(position).getId());
                intent.putExtra("title",bean.getRec().get(position).getTitle());
                startActivity(intent);
            }

            @Override
            public void onItemLongClickListener(int position) {

            }
        });
        TuanLvAdapter lvAdapter=new TuanLvAdapter(bean.getNearby(),getActivity());
        lv.setFocusable(false);
        lv.setAdapter(lvAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), ZuActivity.class);
                intent.putExtra("id",bean.getNearby().get(i).getId());
                startActivity(intent);
            }
        });
        for (int i = 0; i < line.getChildCount(); i++) {
            TextView textView = (TextView) line.getChildAt(i);
            textView.setText(bean.getTips().get(i));
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getActivity(), MengActivity.class);
                    intent.putExtra("word",bean.getTips().get(finalI));
                    intent.putExtra("order","new");
                    startActivity(intent);
                }
            });
        }
    }
}
