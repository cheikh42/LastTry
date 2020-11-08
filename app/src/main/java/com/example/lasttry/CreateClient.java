package com.example.lasttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class CreateClient extends AppCompatActivity {
    public EditText MatriculeClientCreated;
    public  EditText NomOfClientCreated;
    public  EditText NumeroOfClientCreated;
    public  EditText MoisClientCreated;
    public Switch SwitchPaymentCreated;
    public Switch SwitchPosedCreated;
    public Button LeaveCreated;
    public Button CreateCreated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_client);

        MatriculeClientCreated= (EditText) findViewById(R.id.emailLog7);
        MatriculeClientCreated.requestFocus();
        NomOfClientCreated= (EditText) findViewById(R.id.emailLog8);
        NomOfClientCreated.requestFocus();
        NumeroOfClientCreated= (EditText) findViewById(R.id.emailLog9);
        NumeroOfClientCreated.requestFocus();
        MoisClientCreated= (EditText) findViewById(R.id.emailLog10);
        MoisClientCreated.requestFocus();
        SwitchPosedCreated=(Switch) findViewById(R.id.switch4);
        SwitchPaymentCreated=(Switch) findViewById(R.id.switch5);

        LeaveCreated=(Button) findViewById(R.id.button8);
        CreateCreated=(Button) findViewById(R.id.button7);
        LeaveCreated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateClient.this, Action.class));
            }
        });
        CreateCreated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int matriculeUpdate = Integer.parseInt(String.valueOf(MatriculeClientCreated.getText()));
                final String nomUpdate = "" + NomOfClientCreated.getText();
                final int numeroUpdate = Integer.parseInt(String.valueOf(NumeroOfClientCreated.getText()))+0;
                final int moisUpdate = Integer.parseInt(String.valueOf(MoisClientCreated.getText()))+0;
                int PaymentCreated;
                int PoseCreated;
                if (SwitchPaymentCreated.isChecked()) {
                    PaymentCreated = 0;
                } else {
                    PaymentCreated = 1;
                }
                if (SwitchPosedCreated.isChecked()) {
                    PoseCreated = 0;
                } else {
                    PoseCreated = 1;
                }
                if (Client.ClientsAll.containsKey(""+matriculeUpdate)) {
                    MatriculeClientCreated.setError("Existe déjà");
                    MatriculeClientCreated.setText("");

                } else {

                    ClientsClassification.clientAdd(nomUpdate, 0, PaymentCreated, PoseCreated, matriculeUpdate, moisUpdate, numeroUpdate);
                    startActivity(new Intent(CreateClient.this, settingsPage.class));

                }
            }
        });


    }
}