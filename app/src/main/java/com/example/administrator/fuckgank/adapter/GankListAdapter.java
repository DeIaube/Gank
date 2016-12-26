package com.example.administrator.fuckgank.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.fuckgank.R;
import com.example.administrator.fuckgank.bean.BaseBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class GankListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<BaseBean> data;

    private OnItemClickListener onItemClickListener;

    public static final int VIEW_TYPE_NORMAL = 1;
    public static final int VIEW_TYPE_TITLE = 2;
    public static final int VIEW_TYPE_EXCITING = 3;

    @Override
    public int getItemViewType(int position) {
        BaseBean baseBean = data.get(position);
        if(baseBean.get_id() != null){
            return VIEW_TYPE_NORMAL;
        }else if(baseBean.getDesc() != null){
            return VIEW_TYPE_TITLE;
        }else if(baseBean.getUrl() != null){
            return VIEW_TYPE_EXCITING;
        }
        return VIEW_TYPE_NORMAL;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public GankListAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        data = new ArrayList<>();
    }

    public void refresh(List<BaseBean> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEW_TYPE_NORMAL:
                return new NormalHolder(inflater.inflate(R.layout.recycler_item_gank, parent, false));
            case VIEW_TYPE_TITLE:
                return new TitleHolder(inflater.inflate(R.layout.recycler_item_category_title, parent, false));
            case VIEW_TYPE_EXCITING:
                return new ExcitingHolder(inflater.inflate(R.layout.recycler_item_girl_imge, parent, false));
        }
        return new NormalHolder(inflater.inflate(R.layout.recycler_item_gank, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if(holder instanceof NormalHolder){
            NormalHolder normalHolder = (NormalHolder) holder;
            normalHolder.textView.setText(getGankTitleStr(data.get(position).getDesc(), data.get(position).getWho()));
            normalHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemClickListener != null){
                        onItemClickListener.onClickNormalItem(v, data.get(position));
                    }
                }
            });
        }else if(holder instanceof TitleHolder){
            TitleHolder titleHolder = (TitleHolder) holder;
            titleHolder.titleView.setText(data.get(position).getDesc());
        }else if(holder instanceof ExcitingHolder){
            ExcitingHolder excitingHolder = (ExcitingHolder) holder;
            String url = data.get(position).getUrl();
            Glide.with(context)
                    .load(url)
                    .placeholder(R.color.imageColorPlaceholder)
                    .centerCrop()
                    .into(excitingHolder.excitingView);
        }
    }

    private CharSequence getGankTitleStr(String desc, String who) {
        if(TextUtils.isEmpty(who)) {
            return desc;
        }
        SpannableStringBuilder builder = new SpannableStringBuilder(desc);
        SpannableString spannableString = new SpannableString(" (" + who + ")");
        spannableString.setSpan(new TextAppearanceSpan(context, R.style.SummaryTextAppearance), 0, spannableString.length(), 0);
        builder.append(spannableString);
        return builder;
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener{
        void onClickNormalItem(View view, BaseBean item);
    }

    static class NormalHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.hehe)
        TextView textView;

         public NormalHolder(View itemView) {
             super(itemView);
             ButterKnife.bind(this, itemView);
        }
    }

    static class TitleHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.category_title)
        TextView titleView;

        public TitleHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ExcitingHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.girl_image)
        ImageView excitingView;

        public ExcitingHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
