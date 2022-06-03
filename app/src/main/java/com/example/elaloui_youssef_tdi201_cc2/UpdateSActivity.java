package com.example.elaloui_youssef_tdi201_cc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UpdateSActivity extends AppCompatActivity {

    EditText nom,sec,nb;
    Button update,delete;
    Spinner cmb;
    MyDatabase db;
    ArrayList<Societe> ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sactivity);
        db=new MyDatabase(this);
        cmb=findViewById(R.id.cmb);
        nom=findViewById(R.id.txt_nomV2);
        sec=findViewById(R.id.txt_secteur2);
        nb=findViewById(R.id.txt_nbEmployeV2);
        update=findViewById(R.id.btn_updateNewS);
        delete=findViewById(R.id.btn_deleteNewS);
        ss=MyDatabase.getAllSociete(db.getReadableDatabase());
        ArrayList<String> lst=new ArrayList<>();
        for (Societe s:ss){
            lst.add(String.valueOf(s.getId()));
        }
        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,lst);
        cmb.setAdapter(ad);

        cmb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Societe s=ss.get(i);
                nom.setText(s.getNom());
                sec.setText(s.getSecteur());
                nb.setText(s.getNbEmploye());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}