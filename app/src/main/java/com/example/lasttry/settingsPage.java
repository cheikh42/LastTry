package com.example.lasttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


public class settingsPage extends AppCompatActivity implements View.OnClickListener {

    private Button btnSearch;
    public static EditText SearchMatricule;
    Client client2=new Client("dataSynchronizer",0,0,0,0,0,0);
    private Button BackAction;
    public Button CreateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        btnSearch = (Button) findViewById(R.id.btnLog2);
        BackAction= (Button) findViewById(R.id.button2);
        CreateButton= (Button) findViewById(R.id.button3);
        BackAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(settingsPage.this, Action.class));
            }
        });


        btnSearch.setOnClickListener(this);
        SearchMatricule = (EditText) findViewById(R.id.emailLog2);
        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(settingsPage.this, CreateClient.class));
            }
        });

    }
    public void onClick(View view){
        onClick2();
        for(Client client:Client.ClientsAll.values()) {
            System.out.println(client.Nom);
        }
    }

    public  void onClick2(){

         String WantedMatricule = SearchMatricule.getText().toString().trim();
         if(WantedMatricule.equals(""+0)){
             SearchMatricule.setError("Pas de Matricule.");
             SearchMatricule.setText("");
         }else {
             if (Client.ClientsAll.containsKey("" + WantedMatricule)) {
                 startActivity(new Intent(settingsPage.this, settingClientPage.class));
             } else {
                 SearchMatricule.setError("Pas de Matricule.");
                 SearchMatricule.setText("");

                 startActivity(new Intent(settingsPage.this, settingsPage.class));
             }
         }
    }
}