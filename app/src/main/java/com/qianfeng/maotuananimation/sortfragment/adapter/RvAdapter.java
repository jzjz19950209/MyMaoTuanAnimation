package com.qianfeng.maotuananimation.sortfragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.maotuananimation.R;
import com.qianfeng.maotuananimation.sortfragment.bean.ChannelBean;
import com.squareup.picasso.Picasso;

import java.util.List;



/**
 * Created by Bigname on 2016/11/8.
 */
public class RvAdapter extends RecyclerView.Adapter {
    List<ChannelBean> list;
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
    public RvAdapter(Context context,List<ChannelBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_item, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyHolder myHolder = (MyHolder) holder;
        Picasso.with(context).load(list.get(position).getPic()).into(myHolder.iv);
        myHolder.tv.setText(list.get(position).getName());
        myHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iOnClickListrener != null) {
                    iOnClickListrener.onClickListener(v,position,list.get(position).getId());
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
        ImageView iv;
        TextView tv;
        public MyHolder(View itemView) {
            super(itemView);
            iv = ((ImageView) itemView.findViewById(R.id.iv));
            tv = (TextView) itemView.findViewById(R.id.tv);
            view = itemView;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
