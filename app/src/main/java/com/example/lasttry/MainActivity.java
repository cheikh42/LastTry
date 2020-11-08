package com.example.lasttry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText emailLog, passwordLog;
    private Button btnLog;
    private ProgressBar progressBartwo;
    private FirebaseAuth TrashOut;
    Client client3=new Client("dataSynchronizer",0,0,0,0,0,0);

    public static String UserName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLog = (Button) findViewById(R.id.btnLog);
        btnLog.setOnClickListener(this);

        emailLog = (EditText) findViewById(R.id.emailLog);
        passwordLog = (EditText) findViewById(R.id.passwordLog);

        progressBartwo = (ProgressBar) findViewById(R.id.progressBartwo);

        TrashOut = FirebaseAuth.getInstance();
        System.out.println("hello");
    }
    public void onClick(View view) {

                userlogIn();



    }

    private void userlogIn() {


        String email = emailLog.getText().toString().trim();
        String password = passwordLog.getText().toString().trim();
        if (email.isEmpty()){
            emailLog.setError("Saisissez votre addresse e-mail.");
            emailLog.requestFocus();
            return;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailLog.setError("Veuillez saisir une addresse valide.");
            emailLog.requestFocus();
            return;

        }

        if(password.isEmpty()){
            passwordLog.setError("Saisissez votre mot de passe.");
            emailLog.requestFocus();
            return;
        }
        if (password.length() <6) {
            passwordLog.setError("Mot de passe trop court.");
            passwordLog.requestFocus();
            return;
        }
        progressBartwo.setVisibility(View.VISIBLE);

        TrashOut.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {

                if (task.isSuccessful()){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if ( user.isEmailVerified()) {
                        //redirect to user Profile
                        UserName= String.valueOf(emailLog.getText());
                        startActivity(new Intent(MainActivity.this, Action.class));
                    }

                }else{
                    Toast.makeText(MainActivity.this,"Échec de l'opération. L'e-mail ou le mot de passe entré ne correspond à aucun compte.", Toast.LENGTH_LONG).show();
                    progressBartwo.setVisibility(View.GONE);
                }
            }
        });


    }

}