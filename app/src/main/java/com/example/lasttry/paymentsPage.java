package com.example.lasttry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.lasttry.R.id.settings;
import static com.example.lasttry.R.layout.activity_payments_page;

public class paymentsPage extends AppCompatActivity {

    public Button ButtonAll;
    public Button ButtonPayed;
    public Button ButtonNotPayed;
    public Button ButtonPosed;
    public Button ButtonAction;
    public Button ButtonReset;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_payments_page);
        ButtonAll=(Button) findViewById(R.id.button14);
        ButtonPayed=(Button) findViewById(R.id.button15);
        ButtonNotPayed=(Button) findViewById(R.id.button11);
        ButtonPosed=(Button) findViewById(R.id.button16);
        ButtonAction=(Button) findViewById(R.id.button18);
        ButtonReset=(Button) findViewById(R.id.button10);
        ButtonReset.setOnClickListener(new View.OnClickListener() {;
            @Override
            public void onClick(View v) {
                if (MainActivity.UserName.equals("Abdinaewba@gmail.com")) {
                    for (Client client : Client.ClientsAll.values()) {
                        if (client.classPayment == 0) {
                            ClientsClassification.clientAdd(client.Nom, client.ImageId, 1, client.classPosed, client.Matricule, client.Mois, client.Numero);
                        } else {
                            ClientsClassification.clientAdd(client.Nom, client.ImageId, 1, client.classPosed, client.Matricule + 1, client.Mois, client.Numero);
                        }
                    }
                    startActivity(new Intent(paymentsPage.this, Action.class));
                }else{
                    sendEmail();
                    startActivity(new Intent(paymentsPage.this, Action.class));

                }
            }
        });
        ButtonAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(paymentsPage.this, Action.class));
            }
        });
        ButtonPosed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(paymentsPage.this, paymentsPosedPage.class));
            }
        });
        ButtonPayed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(paymentsPage.this, paymentsPayedPage.class));

            }
        });
        ButtonNotPayed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(paymentsPage.this, paymentsUnPayedPage.class));

            }
        });
        ButtonAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(paymentsPage.this, paymentsAllPage.class));
            }
        });

    }
    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"\"Abdinaewba@gmail.com\""};
        String[] CC = {"Abadillayedali06@gmail.com","cheikhmalaininec@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Fin Bilan");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "On a fini le bilan");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(paymentsPage.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}