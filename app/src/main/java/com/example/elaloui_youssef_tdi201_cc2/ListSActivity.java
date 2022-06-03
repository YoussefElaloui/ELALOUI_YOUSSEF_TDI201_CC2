package com.example.elaloui_youssef_tdi201_cc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListSActivity extends AppCompatActivity {

    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sactivity);
        lst=findViewById(R.id.lst);
        MyDatabase db=new MyDatabase(this);
        ArrayList<Societe> ss=MyDatabase.getAllSociete(db.getReadableDatabase());
        ArrayList<HashMap<String,Object>> data=new ArrayList<>();
        for (Societe s:ss){
            HashMap<String,Object> h=new HashMap<>();
            h.put("nom",s.getNom());
            h.put("number",s.getNbEmploye());
            data.add(h);
        }
        String[] from={"nom","number"};
        int[] to={R.id.item_nom,R.id.item_nombre};
        SimpleAdapter ad=new SimpleAdapter(this,data,R.layout.item,from,to);
        lst.setAdapter(ad);
    }
}