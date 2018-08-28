package com.ironghui.marketdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ironghui.marketdemo.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.et_phonenum)
    EditText etPhonenum;
    @BindView(R.id.loginbutton)
    Button loginbutton;
    @BindView(R.id.tv_deal)
    TextView tvDeal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.loginbutton)
    public void onViewClicked() {
        if (etPhonenum.getText().toString().trim().length() == 0 || etPhonenum.equals("")) {
            return;
        } else {
            Pattern regExp = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
            Matcher m = regExp.matcher(etPhonenum.getText().toString().trim());
            if (!m.matches()) {
                Toast.makeText(this, "电话号码输入有误", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, LoginTwoActivity.class);
                startActivity(intent);
            }
        }
    }
}
