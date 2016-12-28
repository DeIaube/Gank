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

public class ExcitingPictureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int VIEW_TYPE_NORMAL = 1;
    public static final int VIEW_TYPE_LOAD = 2;

    private Context context;
    private LayoutInflater inflater;
    private List<String> urls;

    public ExcitingPictureAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        urls = new ArrayList<>();
    }


    @Override
    public int getItemViewType(int position) {
        if(position == urls.size()){
            return VIEW_TYPE_LOAD;
        }
        return VIEW_TYPE_NORMAL;
    }

    public void refresh(List<String> urls){
        this.urls = urls;
        notifyDataSetChanged();
    }

    public void loadMore(List<String> urls){
        this.urls.addAll(urls);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_NORMAL){
            return new PictureViewHolder(inflater.inflate(R.layout.recycler_item_girl_imge, parent,false));
        }else{
            return new LoadHolder(inflater.inflate(R.layout.recycler_item_progress, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof PictureViewHolder){
            PictureViewHolder pictureViewHolder = (PictureViewHolder) holder;
            Glide.with(context)
                    .load(urls.get(position))
                    .placeholder(R.color.imageColorPlaceholder)
                    .centerCrop()
                    .into(((PictureViewHolder) holder).iv);
        }
    }

    @Override
    public int getItemCount() {
        return urls.isEmpty() ? 0 : urls.size() + 1;
    }

    static class PictureViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.exciting_pic)
        ImageView iv;
        public PictureViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class LoadHolder extends RecyclerView.ViewHolder{

        public LoadHolder(View itemView) {
            super(itemView);
        }
    }
}
