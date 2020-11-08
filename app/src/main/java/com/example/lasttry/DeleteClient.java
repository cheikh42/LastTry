package com.example.lasttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DeleteClient extends AppCompatActivity {
    public Button DeleteClientForGood;
    public Button BackClientForGood;
    Client client23=new Client("dataSynchronizer",0,0,0,0,0,0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_client);
        DeleteClientForGood=(Button) findViewById(R.id.button5);
        DeleteClientForGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(MainActivity.UserName.equals("cheikhmalaininec@gmail.com")) {

                    ClientsClassification.clientDelete(Integer.parseInt(String.valueOf(settingsPage.SearchMatricule.getText())));
                    //Sychronize data
                    Client client32=new Client("dataSynchronizer",0,0,0,0,0,0);
                    //End Sychninization
                    startActivity(new Intent(DeleteClient.this, Action.class));
                }
                else{
                    sendEmail();
                }
            }
        });
        BackClientForGood=(Button) findViewById(R.id.button6);
        BackClientForGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteClient.this, Action.class));
            }
        });
    }protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"cheikhmalaininec@gmail.com"};
        String[] CC = {"Abadillayedali06@gmail.com","mixikady@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Supprimer Client");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Matricule : "+settingClientPage.MatriculeDelete+", Nom: "+settingClientPage.NomDelete);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(DeleteClient.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}