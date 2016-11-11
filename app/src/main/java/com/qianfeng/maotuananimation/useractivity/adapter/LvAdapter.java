package com.qianfeng.maotuananimation.useractivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qianfeng.maotuananimation.R;
import com.qianfeng.maotuananimation.useractivity.util.TimeLineBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Bigname on 2016/11/11.
 */

public class LvAdapter extends BaseAdapter {
    List<TimeLineBean> list;
    Context context;
    LayoutInflater inflater;

    public LvAdapter(List<TimeLineBean> list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }
    public interface LvOnClickListener{
        void onItemClick(View view, int position, String id);
    }
    LvOnClickListener lvOnClickListener;

    public void setLvOnClickListener(LvOnClickListener lvOnClickListener) {
        this.lvOnClickListener = lvOnClickListener;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyHolder holder;
        if (convertView == null) {
            holder = new MyHolder();
            convertView = inflater.inflate(R.layout.user_lv_item, parent, false);
            holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_name = (TextView) convertView.findViewById(R.id.user_item_name);
            holder.tv_adress = (TextView) convertView.findViewById(R.id.user_item_adress);
            holder.tv_desc = (TextView) convertView.findViewById(R.id.user_item_groupdesc);
            holder.iv_head = ((ImageView) convertView.findViewById(R.id.user_item_head));
            holder.item_layout = ((RelativeLayout) convertView.findViewById(R.id.item_layout));
            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
        }
        final TimeLineBean timeLineBean = list.get(position);
        holder.tv_time.setText(timeLineBean.getTime());
        holder.tv_title.setText(timeLineBean.getTitle());
        holder.tv_name.setText(timeLineBean.getDesc1());
        holder.tv_adress.setText(timeLineBean.getDesc2());
        holder.tv_desc.setText(timeLineBean.getDesc3());
        Picasso.with(context).load(timeLineBean.getPic()).into(holder.iv_head);
        holder.item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lvOnClickListener != null) {
                    lvOnClickListener.onItemClick(v,position,timeLineBean.getId());
                }
            }
        });
        return convertView;
    }

    private class MyHolder {
        private RelativeLayout item_layout;
        private TextView tv_time;
        private TextView tv_title;
        private TextView tv_name;
        private TextView tv_adress;
        private TextView tv_desc;
        private ImageView iv_head;
    }
}
