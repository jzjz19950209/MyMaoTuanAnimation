package com.qianfeng.maotuananimation.BaseInterface.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.maotuananimation.BaseInterface.model.bean.ZuBean;
import com.qianfeng.maotuananimation.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public class ZuLvAdapter extends BaseAdapter{
    private List<ZuBean.MemberBean> list;
    private Context context;
    private LayoutInflater inflater;

    public ZuLvAdapter(List<ZuBean.MemberBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder;
        if(view==null)
        {
            view=inflater.inflate(R.layout.zu_item,viewGroup,false);
            holder=new MyViewHolder();
            holder.iv= (ImageView) view.findViewById(R.id.zu_item_iv);
            holder.tv1= (TextView) view.findViewById(R.id.zu_item_tv1);
            holder.tv2= (TextView) view.findViewById(R.id.zu_item_tv2);
            holder.tv3= (TextView) view.findViewById(R.id.zu_item_tv3);
            view.setTag(holder);
        }else {
            holder= (MyViewHolder) view.getTag();
        }
        ZuBean.MemberBean memberBean=list.get(i);
        Picasso.with(context).load(memberBean.getHead_pic()).into(holder.iv);
        holder.tv1.setText(memberBean.getUser_level_group_tip());
        holder.tv2.setText(memberBean.getNickname());
        holder.tv3.setText(memberBean.getSign());
        return view;
    }

    class MyViewHolder
    {
        private ImageView iv;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
    }
}
