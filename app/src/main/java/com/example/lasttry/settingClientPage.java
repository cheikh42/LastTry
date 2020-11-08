package com.example.lasttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class settingClientPage extends AppCompatActivity {
    public  EditText MatriculeClient;
    public  EditText NomOfClient;
    public  EditText NumeroOfClient;
    public  EditText MoisClient;
    public Switch SwitchPayment;
    public Switch SwitchPosed;
    public Button ButtonUpdate;
    public Button DeleteButton;
    public static String MatriculeDelete;
    public static String NomDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_client_page);
        final String ClientMatricule = String.valueOf(settingsPage.SearchMatricule.getText());
        MatriculeDelete=String.valueOf(settingsPage.SearchMatricule.getText());
        final String NomClient=Client.ClientsAll.get(""+ClientMatricule).Nom;
        NomDelete=Client.ClientsAll.get(""+ClientMatricule).Nom;
        int NumeroClient=Client.ClientsAll.get(""+ClientMatricule).Numero;
        int Mois=Client.ClientsAll.get(""+ClientMatricule).Mois;
        int Pause=Client.ClientsAll.get(""+ClientMatricule).classPosed;
        int Payment=Client.ClientsAll.get(""+ClientMatricule).classPayment;
        MatriculeClient= (EditText) findViewById(R.id.emailLog4);
        MatriculeClient.requestFocus();
        NomOfClient= (EditText) findViewById(R.id.emailLog3);
        NomOfClient.requestFocus();
        NumeroOfClient= (EditText) findViewById(R.id.emailLog5);
        NumeroOfClient.requestFocus();
        MoisClient= (EditText) findViewById(R.id.emailLog6);
        MoisClient.requestFocus();
        SwitchPosed=(Switch) findViewById(R.id.switch1);
        SwitchPayment=(Switch) findViewById(R.id.switch2);
        SwitchPayment.setChecked(Payment==0);
        SwitchPosed.setChecked(Pause==0);
        ButtonUpdate=(Button) findViewById(R.id.button4);
        DeleteButton=(Button) findViewById(R.id.button);




        MatriculeClient.setText(ClientMatricule);
        NomOfClient.setText(NomClient);
        NumeroOfClient.setText(""+NumeroClient);
        MoisClient.setText(""+Mois);

        //***********Update the client information********//

         ButtonUpdate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

             int matriculeUpdate= Integer.parseInt(""+MatriculeClient.getText());
             String nomUpdate=""+NomOfClient.getText();
             int numeroUpdate=Integer.parseInt(""+NumeroOfClient.getText());
             int moisUpdate=Integer.parseInt(""+MoisClient.getText());
             int PosedClientClient=Client.ClientsAll.get(""+ClientMatricule).classPosed=0;
             int PaymentClient=Client.ClientsAll.get(""+ClientMatricule).classPayment;

            if(SwitchPayment.isChecked()){
                PaymentClient=0;
            }
            else{
                PaymentClient=1;
            };

            if(SwitchPosed.isChecked()){
                PosedClientClient=0;
            }
            else{
                PosedClientClient=1;
            };
            ClientsClassification.clientAdd(nomUpdate,Client.ClientsAll.get(""+ClientMatricule).ImageId,PaymentClient,PosedClientClient,matriculeUpdate,moisUpdate,numeroUpdate);
            //Sychronize data
            Client client32=new Client("dataSynchronizer",0,0,0,0,0,0);
            //End Sychninization


            startActivity(new Intent(settingClientPage.this, settingsPage.class));
        }
    });
    DeleteButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startActivity(new Intent(settingClientPage.this, DeleteClient.class));
        }
    });

    }
}