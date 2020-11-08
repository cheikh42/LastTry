package com.example.lasttry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InfiniteSroller extends RecyclerView.Adapter<InfiniteSroller.VHolder> {
        ArrayList<String> listGauche;
        ArrayList<String>   listDroit;
        ArrayList<String>  listNumber;
        ArrayList<String>   listPose;
        ArrayList<String>   listPayement;
        ArrayList<String>   listMois;

        Context context;

public InfiniteSroller(ArrayList<String> listGauche, ArrayList<String> listDroite, ArrayList<String> listPayement, ArrayList<String> listPose, ArrayList<String> listNumber, ArrayList<String> listMois, Context context){
        this.listDroit=listDroite;
        this.listGauche=listGauche;
        this.listNumber=listNumber;
        this.listPayement=listPayement;
        this.listPose=listPose;
        this.listMois=listMois;
        this.context=context;

        }

    @NonNull
    @Override
    public VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item,parent,false);
        return new VHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHolder holder, int position) {
        holder.MatriculeClient.setText(listGauche.get(position));
        holder.Nom.setText(listDroit.get(position));
        holder.NumeroClient.setText(listNumber.get(position));
        holder.PoseOrNot.setText(listPose.get(position));
        holder.PayementClient.setText(listPayement.get(position));
        holder.MoisClient.setText(listMois.get(position));
    }

    @Override
    public int getItemCount() {
        return listDroit.size();
    }
    public class VHolder extends RecyclerView.ViewHolder{
        TextView MatriculeClient;
        TextView Nom;
        TextView PayementClient;
        TextView PoseOrNot;
        TextView NumeroClient;
        TextView MoisClient;



        public VHolder(View itemView) {

            super(itemView);
            MatriculeClient = (TextView) itemView.findViewById(R.id.textView8);
            Nom = (TextView) itemView.findViewById(R.id.textView5);
            PayementClient= (TextView) itemView.findViewById(R.id.textView7);
            PoseOrNot= (TextView) itemView.findViewById(R.id.textView9);
            NumeroClient= (TextView) itemView.findViewById(R.id.textView6);
            MoisClient= (TextView) itemView.findViewById(R.id.textView11);

        }
    }
}

