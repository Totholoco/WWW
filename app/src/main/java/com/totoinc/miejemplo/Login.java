package com.totoinc.miejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class Login extends AppCompatActivity {
    Button logearse;
    Button register;
    Button recuperar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent serviceIntent = new Intent(this, ProximityService.class);
        startService(serviceIntent);

        recuperar=(Button)findViewById(R.id.btnRecuperar);
        logearse=(Button)findViewById(R.id.btnIniciarSesion);
        register=(Button)findViewById(R.id.btnRegistrarse);
        logearse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Login.this, Screencard.class);
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Login.this, Register.class);
                startActivity(i);
            }
        });
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Login.this, lostaccount.class);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Detener el servicio
        Intent serviceIntent = new Intent(this, ProximityService.class);
        stopService(serviceIntent);
    }
}