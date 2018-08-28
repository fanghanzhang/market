package com.ironghui.marketdemo.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ironghui.marketdemo.R;
import com.ironghui.marketdemo.service.RegisterCodeTimerService;
import com.ironghui.marketdemo.time.RegisterCodeTimer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginTwoActivity extends AppCompatActivity {


    @BindView(R.id.tv_code1)
    TextView tvCode1;
    @BindView(R.id.v1)
    View v1;
    @BindView(R.id.tv_code2)
    TextView tvCode2;
    @BindView(R.id.v2)
    View v2;
    @BindView(R.id.tv_code3)
    TextView tvCode3;
    @BindView(R.id.v3)
    View v3;
    @BindView(R.id.tv_code4)
    TextView tvCode4;
    @BindView(R.id.v4)
    View v4;
    @BindView(R.id.tv_code5)
    TextView tvCode5;
    @BindView(R.id.v5)
    View v5;
    @BindView(R.id.tv_code6)
    TextView tvCode6;
    @BindView(R.id.v6)
    View v6;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.ll_code)
    RelativeLayout llCode;
    @BindView(R.id.timer)
    TextView timer;
    private List<String> codes = new ArrayList<>();
    private Intent mIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logintwo);
        ButterKnife.bind(this);
        initEvent();
        initClick();
    }

    private void initClick() {
        RegisterCodeTimerService.setHandler(mCodeHandler);
        mIntent = new Intent(LoginTwoActivity.this, RegisterCodeTimerService.class);
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.setEnabled(false);
                startService(mIntent);
            }
        });
    }

    Handler mCodeHandler = new Handler() {
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == RegisterCodeTimer.IN_RUNNING) {// 正在倒计时
                timer.setText(msg.obj.toString());
                timer.setBackground(getResources().getDrawable(R.drawable.sendmsg));
                timer.setTextColor(getResources().getColor(R.color.fasongduanxziti));
            } else if (msg.what == RegisterCodeTimer.END_RUNNING) {// 完成倒计时
                timer.setEnabled(true);
                timer.setText(msg.obj.toString());
                timer.setBackground(getResources().getDrawable(R.drawable.sendretry));
                timer.setTextColor(getResources().getColor(R.color.white));
                Toast.makeText(LoginTwoActivity.this, "链接java接口发送短信", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void initEvent() {
        //验证码输入
        etCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() > 0) {
                    etCode.setText("");
                    if (codes.size() < 6) {
                        codes.add(editable.toString());
                        showCode();
                    }
                }
                if (codes.size() == 6) {
                    StringBuilder sb = new StringBuilder();
                    for (String code : codes) {
                        sb.append(code);
                    }
                    String code = sb.toString();
                    if (code.equals("111111")){
                        Intent intent = new Intent(LoginTwoActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
        // 监听验证码删除按键
        etCode.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_DEL && keyEvent.getAction() == KeyEvent.ACTION_DOWN && codes.size() > 0) {
                    codes.remove(codes.size() - 1);
                    showCode();
                    return true;
                }
                return false;
            }
        });
    }

    private void showCode() {
        String code1 = "";
        String code2 = "";
        String code3 = "";
        String code4 = "";
        String code5 = "";
        String code6 = "";
        if (codes.size() >= 1) {
            code1 = codes.get(0);
        }
        if (codes.size() >= 2) {
            code2 = codes.get(1);
        }
        if (codes.size() >= 3) {
            code3 = codes.get(2);
        }
        if (codes.size() >= 4) {
            code4 = codes.get(3);
        }
        if (codes.size() >= 5) {
            code5 = codes.get(4);
        }
        if (codes.size() >= 6) {
            code6 = codes.get(5);
        }
        tvCode1.setText(code1);
        tvCode2.setText(code2);
        tvCode3.setText(code3);
        tvCode4.setText(code4);
        tvCode5.setText(code5);
        tvCode6.setText(code6);

    }

    //注销服务
    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(mIntent);
    }

}
