package com.ironghui.marketdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.ironghui.marketdemo.R;
import com.ironghui.marketdemo.fragment.MainHomeFragment;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initMainHomeFragment();
    }

    private void initMainHomeFragment() {
        MainHomeFragment fragment = new MainHomeFragment();
    }

    @OnClick({R.id.main_home, R.id.catagory, R.id.market_car, R.id.main})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_home:
                break;
            case R.id.catagory:
                break;
            case R.id.market_car:
                break;
            case R.id.main:
                break;
        }
    }
}
