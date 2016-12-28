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
import android.widget.TextView;

import com.example.administrator.fuckgank.R;
import com.example.administrator.fuckgank.bean.BaseBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class GankCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<BaseBean> data;

    private OnItemClickListener onItemClickListener;

    public static final int VIEW_TYPE_NORMAL = 1;
    public static final int VIEW_TYPE_LOAD = 2;

    @Override
    public int getItemViewType(int position) {
        if(position == data.size()){
            return VIEW_TYPE_LOAD;
        }
        return VIEW_TYPE_NORMAL;
    }

    public GankCategoryAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_NORMAL){
            return new NormalHolder(inflater.inflate(R.layout.recycler_item_gank, parent,false));
        }else{
            return new LoadHolder(inflater.inflate(R.layout.recycler_item_progress, parent, false));
        }
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClickNormalItem(View view, BaseBean item);
    }

    public void refresh(List<BaseBean> data){
        this.data = data;
        notifyDataSetChanged();
    }

    public void loadMore(List<BaseBean> data){
        this.data.addAll(data);
        notifyDataSetChanged();
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
        return data.isEmpty() ? 0 : data.size() + 1;
    }

    static class NormalHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.hehe)
        TextView textView;

        public NormalHolder(View itemView) {
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
