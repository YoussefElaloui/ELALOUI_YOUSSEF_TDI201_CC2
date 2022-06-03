package com.example.elaloui_youssef_tdi201_cc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sactivity);
        db=new MyDatabase(this);
        cmb=findViewById(R.id.cmb);
        ArrayList<Societe> ss=MyDatabase.getAllSociete(db.getReadableDatabase());
        ArrayList<String> lst=new ArrayList<>();
        for (Societe s:ss){
            lst.add(String.valueOf(s.getId()));
        }
        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,lst);
        cmb.setAdapter(ad);
    }
}