package com.example.euromilhoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "XPTO";
    TextView txtnumeros, txtestrelas;

    Button btbind,btsorte;
    MeuServico meuServico;
    boolean binded=false;
    ServiceConnection srvcnn= new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MeuServico.MyBinder binder = (MeuServico.MyBinder)iBinder;
            meuServico = binder.getServico();
            binded=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            binded=false;
        }
    };
    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtestrelas =findViewById(R.id.txt_estrelas_main);
        txtnumeros=findViewById(R.id.txt_numeros_main);
        btbind = findViewById(R.id.bt_bind_main);
        btbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it= new Intent(view.getContext(),MeuServico.class);
                bindService(it,srvcnn,BIND_AUTO_CREATE);
            }
        });
        btsorte=findViewById(R.id.bt_sorte_main);
        btsorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] numeros = meuServico.numeros(5,50);
                int[] estrelas = meuServico.numeros(2,11);
                StringBuilder sbnumeros = new StringBuilder();
                sbnumeros.append("números:  ");
                for(int i : numeros){
                    sbnumeros.append(String.valueOf(i) +  "; ");

                }
                txtnumeros.setText(sbnumeros.toString());

                StringBuilder sbestrelas = new StringBuilder();
                sbestrelas.append("estrelas:  ");
                for(int i : estrelas){
                    sbestrelas.append(String.valueOf(i) +  "; ");

                }
                txtestrelas.setText(sbestrelas.toString());
            }
        });

    }
}