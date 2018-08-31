package com.ironghui.marketdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ironghui.marketdemo.R;
import com.ironghui.marketdemo.bean.GridviewBean;

import java.util.List;
import java.util.Map;

class GridViewAdapter extends BaseAdapter {
    private List<GridviewBean> mDataList;
    private Context mContext;
    private ViewHolder holder;

    public GridViewAdapter(Context context, List<GridviewBean> dataList) {
        mDataList = dataList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {

        if (convertview == null) {
            convertview = LayoutInflater.from(mContext).inflate(R.layout.item, viewGroup, false);
            holder = new ViewHolder();
            holder.imageView = convertview.findViewById(R.id.img);
            holder.textView = convertview.findViewById(R.id.text);
            convertview.setTag(holder);
        } else {
            holder = (ViewHolder) convertview.getTag();
        }
        holder.textView.setText(mDataList.get(i).getName());
        holder.imageView.setImageResource(mDataList.get(i).getBitmapId());
        return convertview;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
