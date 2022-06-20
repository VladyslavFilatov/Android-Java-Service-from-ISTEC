package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class Servico1 extends Service {

    private static final String TAG = "XPTO";
    public boolean para = false;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i< 10; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (para)break;
                    Log.i(TAG,String.valueOf(i));
                }
                stopSelf();
            }
        });
        t1.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        para=true;
        Log.i(TAG,"Destroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
