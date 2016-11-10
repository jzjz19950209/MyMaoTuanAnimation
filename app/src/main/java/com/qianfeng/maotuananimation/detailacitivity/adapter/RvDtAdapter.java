package com.qianfeng.maotuananimation.detailacitivity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.qianfeng.maotuananimation.R;
import com.qianfeng.maotuananimation.sortfragment.bean.DetailsBean;
import com.qianfeng.maotuananimation.sortfragment.util.RectangleImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Bigname on 2016/11/8.
 */
public class RvDtAdapter extends RecyclerView.Adapter {
    List<DetailsBean> list;
    LayoutInflater inflater;
    Context context;
    public interface IOnClickListrener{
        void onClickListener(View view, int position, String id);

        void onLongClickListener(View view, int position);
    }

    IOnClickListrener iOnClickListrener;

    public void setiOnClickListrener(IOnClickListrener iOnClickListrener) {
        this.iOnClickListrener = iOnClickListrener;
    }
    public RvDtAdapter(Context context, List<DetailsBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_dt_item, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyHolder myHolder = (MyHolder) holder;
        Picasso.with(context).load(list.get(position).getCover()).into(myHolder.iv);
        myHolder.tv_name.setText(list.get(position).getName());
        myHolder.tv_desc.setText(list.get(position).getIntro());

        String score = list.get(position).getScore();
        if (Float.valueOf(score) > 9.0f || Float.valueOf(score) == 9.0f) {
            myHolder.tv_score.setTextColor(Color.RED);
        }else{
            myHolder.tv_score.setTextColor(Color.BLACK);
        }
        myHolder.tv_score.setText(score);
        myHolder.tv_name.setText(list.get(position).getName());
        myHolder.tv_desc.setText(list.get(position).getIntro());
        myHolder.tv_time.setText(list.get(position).getCur_num());
        myHolder.scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        myHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iOnClickListrener != null) {
//                    iOnClickListrener.onClickListener(v,position,list.get(position).getId());
                }
            }
        });
        myHolder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (iOnClickListrener != null) {
                    iOnClickListrener.onLongClickListener(v, position);
                }
                return true;
            }
        });
    }

    private class MyHolder extends RecyclerView.ViewHolder {
        View view;
        RectangleImageView iv;
        ScrollView scrollView;
        TextView tv_name;
        TextView tv_time;
        TextView tv_score;
        TextView tv_desc;
        public MyHolder(View itemView) {
            super(itemView);
            iv = ((RectangleImageView) itemView.findViewById(R.id.iv));
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_score = (TextView) itemView.findViewById(R.id.tv_score);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);
            scrollView = (ScrollView) itemView.findViewById(R.id.scrollview);
            view = itemView;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
