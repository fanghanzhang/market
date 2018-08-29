package com.ironghui.marketdemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ironghui.marketdemo.R;
import com.socks.library.KLog;

public class CategeryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_catagory,container,false);
        KLog.d("CategeryFragment-onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        KLog.d("CategeryFragment-onViewCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        KLog.d("CategeryFragment-onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        KLog.d("CategeryFragment-onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        KLog.d("CategeryFragment-onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        KLog.d("CategeryFragment-onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        KLog.d("CategeryFragment-onDestroyView");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        KLog.d("MainHomeFragment-setUserVisibleHint");
    }
}
