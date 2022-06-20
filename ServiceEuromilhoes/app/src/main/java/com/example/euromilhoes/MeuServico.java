package com.example.euromilhoes;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.Random;

public class MeuServico extends Service {
    private static final String TAG = "XPTO";

    public class MyBinder extends Binder {
        public MeuServico getServico() {
            return MeuServico.this;
        }
    }

    public MyBinder myBinder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Destroy");
        this.stopSelf();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Destroy");

        return super.onStartCommand(intent, flags, startId);
    }


    public int[] numeros(int limite, int max) {
        Random r = new Random();
        int[] rslt = new int[limite];
        for (int i = 0; i < limite; i++) {
            rslt[i] = r.nextInt(max)+1;
            for (int j = 0; j < i; j++) {
                if (rslt[j] == rslt[i]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(rslt);
        return rslt;
    }

    public int Sorte() {
        Random r = new Random();
        return r.nextInt(50);

    }

}
