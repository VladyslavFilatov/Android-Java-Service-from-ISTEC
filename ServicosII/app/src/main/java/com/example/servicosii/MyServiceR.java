package com.example.servicosii;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Random;

public class MyServiceR extends Service {
    public final String TAG = "XPTO";
    Boolean flag;




    public IBinder onBind(Intent intent) {

        return mymessenger.getBinder();

    }

    public  boolean stop=false;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!stop){
                    Sorteia();
                }
            }
        }).start();
        stopSelf();

        return super.onStartCommand(intent, flags, startId);
    }

    public static final int getCount = 0;


    private class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case getCount:
                    Message mensagem = Message.obtain(null, getCount);
                    mensagem.arg1 = Sorte();
                    try {
                        msg.replyTo.send(mensagem);
                    } catch (RemoteException e) {
                        Log.i(TAG, e.getMessage());
                    }

            }
            super.handleMessage(msg);
        }
    }


    private Messenger mymessenger = new Messenger(new MyHandler());



    @Override
    public void onDestroy() {

    Log.i(TAG,"Fim");
        super.onDestroy();
    }

    public  int  Sorte(){
        Random r = new Random();
        return r.nextInt(200);

    }

    public  void Sorteia(){
    Log.i(TAG,String.valueOf(Sorte()));
    }




    public  void stopRandom(){
        flag=false;
    }
}
