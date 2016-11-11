package com.qianfeng.maotuananimation.Content.view.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qianfeng.maotuananimation.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by qf on 2016/11/10.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<String> imageViews;
    private Context context;

    public GalleryAdapter(List<String> imageViews,Context context) {
        this.imageViews = imageViews;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.recyclerview_item,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        viewHolder.imageView= (ImageView) view.findViewById(R.id.img_item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(context).load(imageViews.get(position)).into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return imageViews.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
        ImageView imageView;
    }
}
