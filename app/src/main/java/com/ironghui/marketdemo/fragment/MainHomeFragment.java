package com.ironghui.marketdemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ironghui.marketdemo.R;
import com.ironghui.marketdemo.adapter.TestAdapter;
import com.socks.library.KLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainHomeFragment extends Fragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;
    private ArrayList<String> mDataList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        KLog.d("MainHomeFragment-onCreate");
    }

    private void initData() {
        mDataList = new ArrayList<String>();
        for (int i=0;i<50;i++){
            mDataList.add("内容 - "+i);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mainhome, container, false);
        unbinder = ButterKnife.bind(this, view);
        KLog.d("MainHomeFragment-onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        TestAdapter adapter = new TestAdapter(getActivity(),mDataList);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        KLog.d("MainHomeFragment-onViewCreated");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        KLog.d("MainHomeFragment-onDestroyView");
    }

    @Override
    public void onResume() {
        super.onResume();
        KLog.d("MainHomeFragment-onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        KLog.d("MainHomeFragment-onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        KLog.d("MainHomeFragment-onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        KLog.d("MainHomeFragment-onDestroy");
    }


}
