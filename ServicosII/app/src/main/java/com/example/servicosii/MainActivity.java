package com.example.servicosii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "XPTO";
    Button bt1, bt2,bt3,bt4,bt5;
    Intent itsrv1, itsrv2;
   public  boolean binded;
    ServicoBind servicoBind;
    ServiceConnection srvcnn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ServicoBind.MyBinder binder =(ServicoBind.MyBinder)iBinder;
            servicoBind=binder.getServico();
            binded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            binded = false;
        }
    };
    ServicoOne servicoOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.bt_startnormalservice_main);
        bt1.setOnClickListener(this);
        bt2 = findViewById(R.id.bt_stopnormalservice_main);
        bt2.setOnClickListener(this);
        bt3 = findViewById(R.id.bt_startbindservice_main);
        bt3.setOnClickListener(this);
        bt4=findViewById(R.id.bt_usatbindservice_main);
        bt4.setOnClickListener(this);

        bt5=findViewById(R.id.bt_unbindservice_main);
        bt5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_startnormalservice_main:
                Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_SHORT).show();
                itsrv1 = new Intent(this, ServicoOne.class);
                startService(itsrv1);
                break;
            case R.id.bt_stopnormalservice_main:
                Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
                stopService(itsrv1);
                break;
            case R.id.bt_startbindservice_main:
                itsrv2= new Intent(view.getContext(),ServicoBind.class);
                bindService(itsrv2,srvcnn, Context.BIND_AUTO_CREATE);

                break;
            case R.id.bt_usatbindservice_main:

                if(binded)Log.i(TAG,String.valueOf(servicoBind.Sorte()));
                else Log.i(TAG,"Unbind");
                break;

            case R.id.bt_unbindservice_main:
               if(binded==true) {
                   unbindService(srvcnn);
                   binded=false;
                   Log.i(TAG,"Unbind Srv");
               }else Log.i(TAG,"Já desligou");

                break;
        }
    }
}