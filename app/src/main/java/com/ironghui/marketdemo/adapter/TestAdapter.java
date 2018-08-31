package com.ironghui.marketdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ironghui.marketdemo.R;
import com.ironghui.marketdemo.bean.GridviewBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestAdapter extends RecyclerView.Adapter {

    private static final int BANNER = 0;
    private static final int COLUMN = 1;
    private static final int GRIDE = 2;
    private List<String> mList;
    private Context mContext;
    private final LayoutInflater inflater;
    private List<GridviewBean> beans;

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
                View clolumnView = inflater.inflate(R.layout.item_gridview, parent, false);
                MidleViewHolder midleHolder = new MidleViewHolder(clolumnView);
                return midleHolder;
            case GRIDE:
                View gridleView = inflater.inflate(R.layout.item_gride, parent, false);
                BottomGrideHolder bottomHolder = new BottomGrideHolder(gridleView);
                return bottomHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerViewHolder) {

        }
        if (holder instanceof MidleViewHolder) {
            getData();
            GridViewAdapter adapter = new GridViewAdapter(mContext, beans);
            ((MidleViewHolder) holder).gridView.setAdapter(adapter);
        }
        if (holder instanceof BottomGrideHolder) {
            ((BottomGrideHolder) holder).imageview_left.setImageResource(R.drawable.left_png);
//            Glide.with(mContext).load(R.drawable.right_top).into(((GrideHolder) holder).imageview_right_top);
            Glide.with(mContext).load("http://ojyz0c8un.bkt.clouddn.com/home_two_01.png").into(((BottomGrideHolder) holder).imageview_right_bottom);
            Glide.with(mContext).load("http://ojyz0c8un.bkt.clouddn.com/b_7.jpg").into(((BottomGrideHolder) holder).imageview_right_top);
        }
    }


    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER;
        } else if (position >= 1 && position <= 1) {
            return COLUMN;
        } else if (position >=2 ) {
            return GRIDE;
        }
        return super.getItemViewType(position);
    }

    private List<Map<String, Object>> dataList;

    public void getData() {
        int icno[] = {R.drawable.left, R.drawable.left_png, R.drawable.left,
                R.drawable.right_top, R.drawable.bottom, R.drawable.bottom, R.drawable.bottom,R.drawable.right_top};
        //图标下的文字
        String name[] = {"时钟", "信号", "宝箱", "秒钟", "大象", "极光", "记事本", "书签"};
        beans = new ArrayList<>();
        for (int i = 0; i < icno.length; i++) {
            GridviewBean bean = new GridviewBean(icno[i], name[i]);
            beans.add(bean);
        }

    }

    class MidleViewHolder extends RecyclerView.ViewHolder {

        private final GridView gridView;

        public MidleViewHolder(View itemView) {
            super(itemView);
            gridView = itemView.findViewById(R.id.gridview);
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {

        public BannerViewHolder(View itemView) {
            super(itemView);

        }
    }

    class BottomGrideHolder extends RecyclerView.ViewHolder {

        private ImageView imageview_left;
        private ImageView imageview_right_bottom;
        private ImageView imageview_right_top;

        public BottomGrideHolder(View itemView) {
            super(itemView);
            imageview_left = itemView.findViewById(R.id.imageview_left);
            imageview_right_top = itemView.findViewById(R.id.imageview_right_top);
            imageview_right_bottom = itemView.findViewById(R.id.imageview_right_bottom);
        }
    }
}
