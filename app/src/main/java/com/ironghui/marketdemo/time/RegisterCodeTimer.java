package com.ironghui.marketdemo.time;

import android.os.CountDownTimer;
import android.os.Handler;

public class RegisterCodeTimer extends CountDownTimer {
    private static Handler mHandler;
    public static final int IN_RUNNING = 1001;
    public static int END_RUNNING = 1002;

    public RegisterCodeTimer(long millisInFuture, long countDownInterval, Handler handler) {
        super(millisInFuture, countDownInterval);
        mHandler = handler;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        if (mHandler != null)
            mHandler.obtainMessage(IN_RUNNING, "重新发送(" + (millisUntilFinished / 1000) + "s)").sendToTarget();
    }

    @Override
    public void onFinish() {
        if (mHandler != null)
            mHandler.obtainMessage(END_RUNNING, "重新发送").sendToTarget();
    }

}
