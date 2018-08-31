package com.ironghui.marketdemo.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.bumptech.glide.Glide;
import com.ironghui.marketdemo.R;
import com.ironghui.marketdemo.fragment.CategeryFragment;
import com.ironghui.marketdemo.fragment.MainHomeFragment;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.framlayout)
    FrameLayout framlayout;
    @BindView(R.id.main_home)
    RadioButton mainHome;
    @BindView(R.id.catagory)
    RadioButton catagory;
    @BindView(R.id.market_car)
    RadioButton marketCar;
    @BindView(R.id.main)
    RadioButton main;
    @BindView(R.id.imageview)
    ImageView imageview;
    private MainHomeFragment mainHomeFragment;
    private CategeryFragment categeryFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager = getFragmentManager();
        KLog.d("MainActivity--onCreate");
        initMainHomeFragment();
    }

    @Override
    protected void onPause() {
        super.onPause();
        KLog.d("MainActivity--onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        KLog.d("MainActivity--onStop");
    }

    private void initMainHomeFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFrament(transaction);
        if (mainHomeFragment == null) {
            mainHomeFragment = new MainHomeFragment();
            transaction.add(R.id.framlayout, mainHomeFragment);
        } else {
            transaction.show(mainHomeFragment);
        }
        transaction.commitAllowingStateLoss();
    }

    private void initCatogaryFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFrament(transaction);
        if (categeryFragment == null) {
            categeryFragment = new CategeryFragment();
            transaction.add(R.id.framlayout, categeryFragment);
        } else {
            transaction.show(categeryFragment);
        }
        transaction.commitAllowingStateLoss();
    }

    private void hideFrament(FragmentTransaction transaction) {
        if (mainHomeFragment != null) {
            transaction.hide(mainHomeFragment);
        }
        if (categeryFragment != null) {
            transaction.hide(categeryFragment);
        }
    }

    @OnClick({R.id.main_home, R.id.catagory, R.id.market_car, R.id.main})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_home:
                initMainHomeFragment();
                break;
            case R.id.catagory:
                initCatogaryFragment();
                break;
            case R.id.market_car:
                initMainHomeFragment();
                break;
            case R.id.main:
                initCatogaryFragment();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        KLog.d("MainActivity--onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        KLog.d("MainActivity--onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        KLog.d("MainActivity--onDestroy");
    }
}
