package com.example.lasttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class notePage extends AppCompatActivity {
    EditText Note;
    Button SendNote;
    Button BackToAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_page);
        Note= (EditText) findViewById(R.id.editTextTextMultiLine2);
        Note.setFocusable(true);
        Note.setEnabled(true);
        Note.setClickable(true);
        Note.setFocusableInTouchMode(true);
        Note.setText(Client.ClientsAll.get(""+0).Nom);
        SendNote=(Button) findViewById(R.id.button9);
        BackToAction=(Button) findViewById(R.id.button21);
        SendNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message= String.valueOf(Note.getText());
                ClientsClassification.clientAdd(message,0,0,0,0,0,0);
                startActivity(new Intent(notePage.this, Action.class));

            }
        });
        BackToAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(notePage.this, Action.class));
            }
        });

    }
}