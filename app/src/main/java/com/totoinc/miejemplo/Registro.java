package com.totoinc.miejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import androidx.annotation.NonNull;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {
    Button atras;
    Button registrarse;
    EditText UsuarioReg;
    EditText ClaveReg;
    EditText ConfirmClaveReg;
    EditText Correo;
    FirebaseAuth mAuth;
    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        UsuarioReg = findViewById(R.id.txtNombre);
        ClaveReg = findViewById(R.id.txtContraseña);
        ConfirmClaveReg = findViewById(R.id.txtConfirmContraseña);
        Correo = findViewById(R.id.txtCorreo);

        atras = (Button) findViewById(R.id.btnDevolverInicio);
        registrarse = (Button) findViewById(R.id.btnSeguirRegistro);

        mAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
                Intent i = new Intent (Registro.this, Login.class);
                startActivity(i);
            }
        });
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Registro.this, Login.class);
                startActivity(i);
            }
        });
    }

    private void register() {
        String Usuario = UsuarioReg.getText().toString();
        String Contrasena = ClaveReg.getText().toString();
        String ConfirmarContrasena = ConfirmClaveReg.getText().toString();
        String Mail = Correo.getText().toString();

        if (!Usuario.isEmpty() && !Contrasena.isEmpty() && !Mail.isEmpty()) {

            if (Contrasena.equals(ConfirmarContrasena)) {
                if (Contrasena.length() > 6) {
                    createUser(Usuario, Mail, Contrasena);
                } else {
                    Toast.makeText(this, "Contraseña debe tener mas de 6 caracteres", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void createUser(String UsuarioReg, String Correo, String ClaveReg) {
        mAuth.createUserWithEmailAndPassword(Correo, ClaveReg).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String id = mAuth.getCurrentUser().getUid();
                    Map<String, Object> map = new HashMap<>();
                    map.put("Nombre", UsuarioReg);
                    map.put("Correo", Correo);
                    map.put("Contraseña", ClaveReg);

                    mFirestore.collection("Users").document(id).set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Intent i = new Intent(Registro.this, MainActivity.class);
                            Toast.makeText(Registro.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(Registro.this, "No se pudo registrar Usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean isEmailValid(String Mail) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+)[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(Mail);
        return matcher.matches();
    }

}


