package com.example.lasttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Action extends AppCompatActivity {

    private ImageView userProfile;
    private LinearLayout settings, map, clients, help, logOut, payments;
    Client client1=new Client("dataSynchronizer",0,0,0,0,0,0);
    private TextView nombreClient;
    public int countPayed=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        userProfile = (ImageView) findViewById(R.id.userProfile);
        userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Action.this, userProfilePage.class));

            }
        });

        settings =(LinearLayout) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Action.this, settingsPage.class));

            }
       });
        nombreClient=(TextView) findViewById(R.id.textviewC);
        int nombreClientAll=Client.ClientsAll.size()-1;

        for(Client client:Client.ClientsAll.values()){
            if(client.classPayment==0&&client.Matricule!=0){

                countPayed+=1;
            }
        }
        nombreClient.setText(""+countPayed+" / "+nombreClientAll+"");

        map =(LinearLayout) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Action.this, mapPage.class));

            }
        });

        clients =(LinearLayout) findViewById(R.id.clients);
        clients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(Action.this, clientsPage.class));

            }
        });

        payments =(LinearLayout) findViewById(R.id.payments);
        payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Action.this, paymentsPage.class));

            }
        });

        help = (LinearLayout) findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Action.this, notePage.class));

            }
        });

        logOut =(LinearLayout) findViewById(R.id.logOut);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Action.this, MainActivity.class));

            }
        });
    }
}