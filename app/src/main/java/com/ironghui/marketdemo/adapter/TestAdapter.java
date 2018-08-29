package com.ironghui.marketdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ironghui.marketdemo.R;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter {

    private static final int BANNER = 0;
    private static final int COLUMN = 1;
    private static final int GRIDE = 2;
    private List<String> mList;
    private Context mContext;
    private final LayoutInflater inflater;

    public TestAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case BANNER:
                View view = inflater.inflate(R.layout.fragment_banner, parent, false);
                BannerViewHolder bannerViewHolder = new BannerViewHolder(view);
                return bannerViewHolder;
            case COLUMN:
            case GRIDE:
                View view1 = inflater.inflate(R.layout.testadapter_item, parent, false);
                ViewHolder viewHolder = new ViewHolder(view1);
                return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       if (holder instanceof BannerViewHolder){

       }
       if (holder instanceof ViewHolder){
           ((ViewHolder) holder).text_item.setText(mList.get(position).toString());
       }
    }


    @Override
    public int getItemCount() {
        return 13;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER;
        } else if (position >= 1 && position <= 10) {
            return COLUMN;
        } else if (position > 10) {
            return GRIDE;
        }
        return super.getItemViewType(position);
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView text_item;

        public ViewHolder(View itemView) {
            super(itemView);
            text_item = itemView.findViewById(R.id.text_item);
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {

        public BannerViewHolder(View itemView) {
            super(itemView);

        }
    }
}
