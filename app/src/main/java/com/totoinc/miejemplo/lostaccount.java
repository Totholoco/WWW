package com.totoinc.miejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lostaccount extends AppCompatActivity {
    Button Atras;
    Button Recuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lostaccount);

        Atras= findViewById(R.id.btnDevolverInicio);
        Recuperar= findViewById(R.id.btnEnviarcorreo);
        Atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (lostaccount.this, Login.class);
                startActivity(i);
            }
        });
        Recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (lostaccount.this, Login.class);
                startActivity(i);
            }
        });
    }

}