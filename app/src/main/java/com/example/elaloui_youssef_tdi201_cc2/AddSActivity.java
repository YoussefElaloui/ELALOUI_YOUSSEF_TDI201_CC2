package com.example.elaloui_youssef_tdi201_cc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddSActivity extends AppCompatActivity {

    EditText nom,secteur,nb;
    Button btn_save,btn_cancel;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sactivity);
        db=new MyDatabase(this);
        btn_save=findViewById(R.id.btn_addNewS);
        btn_cancel=findViewById(R.id.btn_cancelNewS);
        nom=findViewById(R.id.txt_nom);
        secteur=findViewById(R.id.txt_secteur);
        nb=findViewById(R.id.txt_nbEmploye);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Societe s=new Societe(nom.getText().toString(),secteur.getText().toString(),Integer.valueOf(nb.getText().toString()));
                if(MyDatabase.AddSociete(db.getWritableDatabase(),s)==-1)
                    Toast.makeText(AddSActivity.this, "Cannot add to database", Toast.LENGTH_SHORT).show();
                else Toast.makeText(AddSActivity.this, "Added successfuly", Toast.LENGTH_SHORT).show();
            }
        });
    }
}