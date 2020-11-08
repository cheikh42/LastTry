package com.example.lasttry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class paymentsPosedPage extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    InfiniteSroller adapter;
    Button ReturntoAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_posed_page);
        ReturntoAction=(Button) findViewById(R.id.button12);
        ReturntoAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(paymentsPosedPage.this, Action.class));
            }
        });
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview4);
        manager =new LinearLayoutManager(this);
//Filling Information
        ArrayList<String> listGauche =new ArrayList<String>();
        ArrayList<String>   listDroite=new ArrayList<String>();
        ArrayList<String>   listNumero=new ArrayList<String>();
        ArrayList<String>   listMois=new ArrayList<String>();
        ArrayList<String>   listPose=new ArrayList<String>();
        ArrayList<String>   listPayment=new ArrayList<String>();
        for(Client client: Client.ClientsAll.values()){
            if(client.classPosed==0 && client.Matricule!=0){
            listGauche.add(""+client.Matricule);
            listDroite.add(""+client.Nom);
            listMois.add("Mois "+client.Mois);
                listPose.add("Posé");
            if(client.classPayment==0) {
                listPayment.add("Payé");
            }else {
                listPayment.add("Pas payé");
            }
            listNumero.add("Numéro: "+client.Numero);

        }
//End Filling information
        adapter = new InfiniteSroller(listGauche,listDroite,listPayment,listPose,listNumero,listMois,this);

        recyclerView.setAdapter((RecyclerView.Adapter) adapter);
        recyclerView.setLayoutManager(manager);



    }

}
}