package com.qianfeng.maotuananimation.VideoDetails.modle.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.maotuananimation.R;
import com.qianfeng.maotuananimation.VideoDetails.modle.bean.CommentBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class CommentAdapter extends BaseAdapter{
    private List<CommentBean> list;
    private Context context;
    private LayoutInflater inflater;

    public CommentAdapter(List<CommentBean> list, Context context) {
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
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view==null){
            view=inflater.inflate(R.layout.comment_lv_item,viewGroup,false);
            holder=new Holder();
            holder.username= (TextView) view.findViewById(R.id.comment_item_username);
            holder.content= (TextView) view.findViewById(R.id.comment_item_text);
            holder.good_num= (TextView) view.findViewById(R.id.comment_item_pro_num);
            holder.reply_num= (TextView) view.findViewById(R.id.comment_item_comment_num);
            holder.create_time= (TextView) view.findViewById(R.id.comment_item_time);
            holder.userface= (ImageView) view.findViewById(R.id.comment_item_userface);
            view.setTag(holder);
        }else {
            holder= (Holder) view.getTag();
        }
        CommentBean commentBean = list.get(i);
        holder.username.setText(commentBean.getUsername());
        holder.content.setText(commentBean.getContent());
        holder.good_num.setText(commentBean.getGood_num());
        holder.reply_num.setText(commentBean.getReply_num());
        holder.create_time.setText(commentBean.getCreate_time());
        Picasso.with(context).load(commentBean.getUserface()).into(holder.userface);
        return view;
    }
    //    String userface;
//    String username;
//    String content;
//    String good_num;
//    String reply_num;
//    String create_time;
    class Holder{
        TextView username,content,good_num,reply_num,create_time;
        ImageView userface;
    }
}
