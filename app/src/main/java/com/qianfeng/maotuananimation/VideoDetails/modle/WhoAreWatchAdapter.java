package com.qianfeng.maotuananimation.VideoDetails.modle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qianfeng.maotuananimation.R;
import com.qianfeng.maotuananimation.VideoDetails.modle.bean.WhoAreWatchBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public class WhoAreWatchAdapter extends RecyclerView.Adapter{
    private List<WhoAreWatchBean> list;
    private LayoutInflater inflater;
    private Context context;
    public interface ItemOnClickListener{
        void onClick(View view, int position, WhoAreWatchBean bean);
    }

    ItemOnClickListener itemOnClickListener;

    public void setItemOnClickListener(ItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    public WhoAreWatchAdapter(List<WhoAreWatchBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.whoarewatch_item, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Holder myHolder = (Holder) holder;
        final WhoAreWatchBean whoAreWatchBean = list.get(position);
        myHolder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemOnClickListener != null) {
                    itemOnClickListener.onClick(view,position,whoAreWatchBean);
                }
            }
        });
        Picasso.with(context).load(whoAreWatchBean.getHead_pic()).into(myHolder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView iv;

        public Holder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.whoarewatching_userface);
        }
    }
}
