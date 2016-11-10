package com.qianfeng.maotuananimation.BaseInterface.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.maotuananimation.BaseInterface.model.bean.FaceBean;
import com.qianfeng.maotuananimation.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class TuiLvAdapter extends BaseAdapter{
    private List<FaceBean.ListBean> list;
    private Context context;
    private LayoutInflater inflater;

    public TuiLvAdapter(List<FaceBean.ListBean> list, Context context) {
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
            view=inflater.inflate(R.layout.tuanliaolv_item,viewGroup,false);
            holder=new MyViewHolder();
            holder.iv= (ImageView) view.findViewById(R.id.tuanliao_item_iv);
            holder.tv1= (TextView) view.findViewById(R.id.tuanliao_item_tv_tv1);
            holder.tv2= (TextView) view.findViewById(R.id.tuanliao_item_tv_tv2);
            holder.tv3= (TextView) view.findViewById(R.id.tuanliao_item_tv_tv3);
            holder.tv4= (TextView) view.findViewById(R.id.tuanliao_item_tv_tv4);
            holder.tv5= (TextView) view.findViewById(R.id.tuanliao_item_tv_tv5);
            holder.tv6= (TextView) view.findViewById(R.id.tuanliao_item_tv_tv6);
            holder.tv7= (TextView) view.findViewById(R.id.tuanliao_item_tv_tv7);
            view.setTag(holder);
        }else {
            holder= (MyViewHolder) view.getTag();
        }

        FaceBean.ListBean bean=list.get(i);
        Picasso.with(context).load(bean.getIcon()).into(holder.iv);
        holder.tv1.setText(bean.getName());
        holder.tv2.setText(bean.getLevel());
        holder.tv3.setText(bean.getCur_num());
        holder.tv4.setText(bean.getTotal());
        holder.tv5.setText(bean.getDistance());
        holder.tv6.setText(bean.getCity());
        holder.tv7.setText(bean.getDesc());
        return view;
    }

    class MyViewHolder {
        private ImageView iv;
        private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    }
}
