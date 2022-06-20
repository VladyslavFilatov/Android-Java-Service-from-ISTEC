package com.example.servicosii;

import static android.content.ContentValues.TAG;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Random;

public class ServicoBind extends Service {
    public class MyBinder extends Binder{
        public   ServicoBind getServico(){
            return  ServicoBind.this;
        }
    }
    public  IBinder mybinder = new MyBinder();

    Random r = new Random();


   
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mybinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG,"OnUnbind");

        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"Start Service");
        return super.onStartCommand(intent, flags, startId);
    }

    public  int  Sorte(){
        return  r.nextInt(100);
    }


}
