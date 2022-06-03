package com.example.elaloui_youssef_tdi201_cc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddSActivity extends AppCompatActivity {

    EditText nom,secteur,nb;
    Button btn_save,btn_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sactivity);
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
    }
}