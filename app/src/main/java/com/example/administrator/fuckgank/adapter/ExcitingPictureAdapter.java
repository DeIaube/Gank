package com.example.administrator.fuckgank.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.fuckgank.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

public class ExcitingPictureAdapter extends RecyclerView.Adapter<ExcitingPictureAdapter.PictureViewHolder> {


    private Context context;
    private LayoutInflater inflater;
    private List<String> urls;

    public ExcitingPictureAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        urls = new ArrayList<>();
    }


    public void refresh(List<String> urls){
        this.urls = urls;
        notifyDataSetChanged();
    }

    public void loadMore(List<String> data){
        this.urls.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PictureViewHolder(inflater.inflate(R.layout.recycler_item_girl_imge, parent,false));
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        Glide.with(context)
                .load(urls.get(position))
                .placeholder(R.color.imageColorPlaceholder)
                .centerCrop()
                .into(( holder).iv);
    }


    @Override
    public int getItemCount() {
        return urls.size();
    }

    static class PictureViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.exciting_pic)
        ImageView iv;
        public PictureViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
