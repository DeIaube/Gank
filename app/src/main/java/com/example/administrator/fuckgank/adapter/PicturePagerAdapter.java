package com.example.administrator.fuckgank.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.fuckgank.R;

import java.util.List;

/**
 * Created by Lu on 2016/12/30.
 */

public class PicturePagerAdapter extends PagerAdapter {

    private int index;
    private Context context;
    private List<String> urls;
    private LayoutInflater inflater;

    public PicturePagerAdapter(int index, Context context, List<String> urls) {
        this.index = index;
        this.context = context;
        this.urls = urls;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return urls.size();
    }



    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View root = inflater.inflate(R.layout.pager_item_picture, container, false);
        container.addView(root);
        ImageView iv = (ImageView) root.findViewById(R.id.pic);
        Glide.with(context)
                .load(urls.get(position))
                .placeholder(R.color.imageColorPlaceholder)
                .centerCrop()
                .into(iv);
        return root;
    }
}
