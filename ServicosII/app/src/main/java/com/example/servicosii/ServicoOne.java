package com.example.servicosii;

import android.app.Service;
import android.content.Intent;
import android.os.Debug;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class ServicoOne extends Service {
    private static final String TAG = "XPTO";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Destroy");

    }




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            faz();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public  void faz() throws InterruptedException {
        for(int i =0 ; i< 10; i++){
            Log.i(TAG,String.valueOf(i));
            Thread.sleep(1000);
        }
    }//faz
}
