package com.totoinc.miejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import androidx.annotation.NonNull;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText correoLogin,claveLogin;
    Button BotonLogin,BotonRegistro,recuperar;
    FirebaseAuth mAtuh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent serviceIntent = new Intent(this, ProximityService.class);
        startService(serviceIntent);

        //Iniciar Sesion
        correoLogin = findViewById(R.id.txtLogin);
        claveLogin = findViewById(R.id.txtConfirmContraseña);
        //Botones
        BotonLogin = findViewById(R.id.btnEntrar);
        BotonRegistro = findViewById(R.id.btnRegistro);
        recuperar=(Button)findViewById(R.id.btnRecuperar);
        //Base de datos
        mAtuh = FirebaseAuth.getInstance();

        BotonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }

        });
        BotonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Login.this,Registro.class);
                startActivity(i);
            }
        });
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Login.this, RecuperarCuenta.class);
                startActivity(i);
            }
        });
    }
    private void login() {
        String emailLogin = correoLogin.getText().toString();
        String contrasenaLogin = claveLogin.getText().toString();
        mAtuh.signInWithEmailAndPassword(emailLogin,contrasenaLogin).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent intent = new Intent(Login.this,Screencard.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this, "Credenciales no Validas", Toast.LENGTH_SHORT).show();
                }
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