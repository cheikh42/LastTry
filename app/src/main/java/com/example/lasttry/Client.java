package com.example.lasttry;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Client {

    public String Nom;
    public int ImageId;
    public int Matricule;
    public int Numero;
    public int Mois = 0;
    public int classPayment=0;  //0 if payed
    public int classPosed=0;    //0 if not posed
    public Map<String, String> informations = new HashMap<String, String>();
    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference myRef = database.getReference("All clients");
    //Database registration part
    public static Map<String, Client> ClientsAll= new HashMap<String, Client>() ;
    public Client() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Client(String Nom, int ImageId, int Matricule, int Numero, int classPayment, int classPosed, int Mois) {
        this.Nom = Nom;
        this.ImageId = ImageId;
        this.Matricule = Matricule;
        this.Numero = Numero;
        this.classPayment=classPayment;
        this.classPosed=classPosed;
        this.Mois=Mois;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("All clients");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    ///ClientsAll.clear();
                for(DataSnapshot data :dataSnapshot.getChildren()) {
                    Client client = data.getValue(Client.class);
                    ClientsAll.put("" +client.Matricule, client);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

    }

}


