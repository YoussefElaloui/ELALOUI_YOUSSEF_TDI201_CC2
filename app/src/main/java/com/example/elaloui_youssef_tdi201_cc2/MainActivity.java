package com.example.elaloui_youssef_tdi201_cc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void derecTo(View view) {
        Intent i=null;
        switch(view.getId()){
            case R.id.btn_addS: i=new Intent(MainActivity.this,AddSActivity.class);break;
            case R.id.btn_updateS: i=new Intent(MainActivity.this,UpdateSActivity.class);break;
            case R.id.btn_listS: i=new Intent(MainActivity.this,ListSActivity.class);break;
        }
        startActivity(i);
    }
}