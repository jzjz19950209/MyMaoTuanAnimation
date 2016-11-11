package com.qianfeng.maotuananimation.VideoDetails.modle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qianfeng.maotuananimation.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public class FromSiteAdapter extends RecyclerView.Adapter{
    private List<String> list;
    private LayoutInflater inflater;
    private Context context;

    public FromSiteAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.from_site_item, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder myHolder = (Holder) holder;
        String imgname = list.get(position);
        if (imgname.equals("56")){
            myHolder.iv.setImageResource(R.drawable.from_56);
        }else if (imgname.equals("cntv")){
            myHolder.iv.setImageResource(R.drawable.from_cntv);
        }else if (imgname.equals("iqiyi")){
            myHolder.iv.setImageResource(R.drawable.from_iqiyi);
        }else if (imgname.equals("letv")){
            myHolder.iv.setImageResource(R.drawable.from_letv);
        }else if (imgname.equals("other")){
            myHolder.iv.setImageResource(R.drawable.from_other);
        }else if (imgname.equals("pps")){
            myHolder.iv.setImageResource(R.drawable.from_pps);
        }else if (imgname.equals("pptv")){
            myHolder.iv.setImageResource(R.drawable.from_pptv);
        }else if (imgname.equals("qq")){
            myHolder.iv.setImageResource(R.drawable.from_qq);
        }else if (imgname.equals("sohu")){
            myHolder.iv.setImageResource(R.drawable.from_sohu);
        }else if (imgname.equals("tudou")){
            myHolder.iv.setImageResource(R.drawable.from_tudou);
        }else if (imgname.equals("xunlei")){
            myHolder.iv.setImageResource(R.drawable.from_xunlei);
        }else if (imgname.equals("youku")){
            myHolder.iv.setImageResource(R.drawable.from_youku);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView iv;

        public Holder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.from_site_item_icon);
        }
    }
}
