package com.example.lasttry;

import android.content.Intent;
import android.util.Log;
import android.widget.Switch;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ClientsClassification {
    public Map<String, Object> ClientsPosed= new HashMap<String, Object>() ;
    public Map<String, Object> ClientsPayed= new HashMap<String, Object>() ;
    public Map<String, Object> ClientsUnPayed= new HashMap<String, Object>() ;
    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference myRef = database.getReference("All clients");
    // Add a client
    public static void clientAdd(String Nom, int ImageId, int classPayment, int classPosed, int Matricule, int Mois, int Numero) {
        Client client= new Client(Nom, ImageId, Matricule, Numero, classPayment, classPosed, Mois);

        myRef.child(""+client.Matricule).setValue(client);
    }
    //Delete a client
    public static void clientDelete(int Matricule){
        myRef.child(""+Matricule).removeValue();
    }
    public static void clientUpdate(String Nom, int ImageId, int classPayment, int classPosed, int Matricule, int Mois, int Numero){
        Client client= new Client(Nom, ImageId, Matricule, Numero, classPayment, classPosed, Mois);
        Client.ClientsAll.get(Matricule).classPayment=classPayment;
        Client.ClientsAll.get(Matricule).classPosed=classPosed;
        Client.ClientsAll.get(Matricule).Mois=Mois;
        Client.ClientsAll.get(Matricule).Numero=Numero;
        Client.ClientsAll.get(Matricule).ImageId=ImageId;
        Client.ClientsAll.get(Matricule).Nom=Nom;
        Map<String, Client> TheClient= new HashMap<>();
        TheClient=Client.ClientsAll;
        final Task<Void> p = myRef.updateChildren(Collections.<String, Object>unmodifiableMap(TheClient));

    }





}
