package com.qianfeng.maotuananimation.BaseInterface.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.maotuananimation.BaseInterface.model.bean.TuanBean;
import com.qianfeng.maotuananimation.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class TuanReAdapter extends RecyclerView.Adapter{
    private List<TuanBean.RecBean> list;
    private Context context;
    private LayoutInflater inflater;

    public TuanReAdapter(List<TuanBean.RecBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tuanliaore_item, parent, false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder viewHolder= (MyViewHolder) holder;
        TuanBean.RecBean recBean=list.get(position);
        viewHolder.tv.setText(recBean.getTitle());
        Picasso.with(context).load(recBean.getPic()).into(viewHolder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv=((ImageView) itemView.findViewById(R.id.tuanliaore_item_iv));
            tv=((TextView) itemView.findViewById(R.id.tuanliaore_item_tv));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemListener.onItemClickListener(getLayoutPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onItemListener.onItemLongClickListener(getLayoutPosition());
                    return false;
                }
            });
        }
    }

    private OnItemListener onItemListener;

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }

    public interface OnItemListener{
        public void onItemClickListener(int position);
        public void onItemLongClickListener(int position);
    }
}
