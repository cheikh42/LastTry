package com.example.lasttry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class paymentsPayedPage extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    InfiniteSroller adapter;
    Button ReturntoAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_payed_page);
        ReturntoAction=(Button) findViewById(R.id.button13);
        ReturntoAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(paymentsPayedPage.this, Action.class));
            }
        });
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview2);
        manager =new LinearLayoutManager(this);
//Filling Information
        ArrayList<String> listGauche =new ArrayList<String>();
        ArrayList<String>   listDroite=new ArrayList<String>();
        ArrayList<String>   listNumero=new ArrayList<String>();
        ArrayList<String>   listMois=new ArrayList<String>();
        ArrayList<String>   listPose=new ArrayList<String>();
        ArrayList<String>   listPayment=new ArrayList<String>();
        for(Client client: Client.ClientsAll.values()){
            if(client.classPayment==0 && client.Matricule!=0) {
                listGauche.add("" + client.Matricule);
                listDroite.add("" + client.Nom);
                listMois.add("Mois " + client.Mois);
                if (client.classPosed == 0) {
                    listPose.add("Posé");
                } else {
                    listPose.add("Continue");
                }
                    listPayment.add("Payé");


                listNumero.add("Numéro: " + client.Numero);
            }
        }
//End Filling information
        adapter = new InfiniteSroller(listGauche,listDroite,listPayment,listPose,listNumero,listMois,this);

        recyclerView.setAdapter((RecyclerView.Adapter) adapter);
        recyclerView.setLayoutManager(manager);

    }

}