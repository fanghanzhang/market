package com.ironghui.marketdemo.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ironghui.marketdemo.R;
import com.ironghui.marketdemo.bean.GridviewBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestAdapter extends RecyclerView.Adapter implements OnBannerListener{

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
            List list_path = new ArrayList<>();
            //放标题的集合
            List list_title = new ArrayList<>();
            list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
            list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
            list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
            list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");
            list_title.add("偶像练习生");
            list_title.add("天天向上");
            list_title.add("热爱劳动");
            list_title.add("拒绝求偶");
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
            ((BannerViewHolder) holder).banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            //设置图片加载器，图片加载器在下方
            ((BannerViewHolder) holder).banner.setImageLoader(new MyLoader());
            //设置图片网址或地址的集合
            ((BannerViewHolder) holder).banner.setImages(list_path);
            //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
            ((BannerViewHolder) holder).banner.setBannerAnimation(Transformer.Default);
            //设置轮播图的标题集合
            ((BannerViewHolder) holder).banner.setBannerTitles(list_title);
            //设置轮播间隔时间
            ((BannerViewHolder) holder).banner.setDelayTime(2400);
            //设置是否为自动轮播，默认是“是”。
            ((BannerViewHolder) holder).banner.isAutoPlay(true);
            //设置指示器的位置，小点点，左中右。
            ((BannerViewHolder) holder).banner.setIndicatorGravity(BannerConfig.CENTER)
                    //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                    .setOnBannerListener(this)
                    //必须最后调用的方法，启动轮播图。
                    .start();
        }
        if (holder instanceof MidleViewHolder) {
            getData();
            GridViewAdapter adapter = new GridViewAdapter(mContext, beans);
            ((MidleViewHolder) holder).gridView.setAdapter(adapter);
//            ((MidleViewHolder) holder).gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));//去除点击后背景阴影，建议在资源文件中添加，便于解耦
            ((MidleViewHolder) holder).gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("提示").setMessage(mList.get(i).toString()).create().show();
                }
            });
        }
        if (holder instanceof BottomGrideHolder) {
            ((BottomGrideHolder) holder).imageview_left.setImageResource(R.drawable.left_png);
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
        } else if (position >= 2) {
            return GRIDE;
        }
        return super.getItemViewType(position);
    }


    public void getData() {
        int icno[] = {R.drawable.left, R.drawable.left_png, R.drawable.left,
                R.drawable.right_top, R.drawable.bottom, R.drawable.bottom, R.drawable.bottom, R.drawable.right_top};
        //图标下的文字
        String name[] = {"时钟", "信号", "宝箱", "秒钟", "大象", "极光", "记事本", "书签"};
        beans = new ArrayList<>();
        for (int i = 0; i < icno.length; i++) {
            GridviewBean bean = new GridviewBean(icno[i], name[i]);
            beans.add(bean);
        }
    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(mContext, "你点击了" + position, Toast.LENGTH_SHORT).show();
    }

    class MidleViewHolder extends RecyclerView.ViewHolder {
        private final GridView gridView;

        public MidleViewHolder(View itemView) {
            super(itemView);
            gridView = itemView.findViewById(R.id.gridview);
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        Banner banner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
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
    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);//路径path强转与否均可
        }
    }
}
