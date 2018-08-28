package com.ironghui.marketdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.ironghui.marketdemo.time.RegisterCodeTimer;

public class RegisterCodeTimerService extends Service {

    private static Handler mHandler;
    private static RegisterCodeTimer mCodeTimer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        mCodeTimer = new RegisterCodeTimer(60000, 1000, mHandler);
        mCodeTimer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public static void setHandler(Handler handler) {
        mHandler = handler;
    }
}
