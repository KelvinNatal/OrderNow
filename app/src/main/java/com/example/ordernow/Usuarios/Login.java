package com.example.ordernow.Usuarios;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ordernow.Activitys.MainActivity;
import com.example.ordernow.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button userLogin;
    ProgressBar progressBar;
    EditText userEmail;
    EditText userPass;
    TextView Regtxt;
    TextView EsquePass;
    Typeface tf1, tf2;


    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progressBar);
        userEmail = findViewById(R.id.etUserEmail);
        Regtxt = findViewById(R.id.Regtxt);
        userPass = findViewById(R.id.etUserPass);
        userLogin = findViewById(R.id.userLogin);
        EsquePass = findViewById(R.id.EsquePass);


        tf1 = Typeface.createFromAsset(getAssets(), "Lena.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "Scaramella-Regular.otf");


        EsquePass.setTypeface(tf1);
        Regtxt.setTypeface(tf1);



        firebaseAuth = firebaseAuth.getInstance();


        userLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                firebaseAuth.signInWithEmailAndPassword(userEmail.getText().toString(), userPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            startActivity(new Intent(Login.this, MainActivity.class));
                        }else{
                            Toast.makeText(Login.this, "Senha incorreta",     Toast.LENGTH_LONG).show();
                        }

                    }
                });

            }
        });

    }

    public void text_action(View view){
        startActivity(new Intent(getApplicationContext(), Registro.class));
    }
}