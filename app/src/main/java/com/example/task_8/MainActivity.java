package com.example.task_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   EditText ed_username , ed_email;
   Button btn_save;
   SharedPreferences sp;
   SharedPreferences.Editor edit;
  public final String USERNAME ="username";
  public final String EMAIL ="email";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_username = findViewById(R.id.ed_username);
        ed_email=findViewById(R.id.ed_email);
        btn_save=findViewById(R.id.btn_save);
          // First a way to shared
        //  sp= PreferenceManager.getDefaultSharedPreferences(this);


        // second a way to shared
        sp=getSharedPreferences("name" ,MODE_PRIVATE);

        // Third a way to shared
       // sp=getPreferences(MODE_PRIVATE);

        edit=sp.edit();


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=ed_username.getText().toString();
                String email=ed_email.getText().toString();
                edit.putString(USERNAME,username);
                edit.putString(EMAIL ,email);
                edit.apply();
                Intent in=new Intent(MainActivity.this,showdata.class);
                startActivity(in);

            }
        });
        Toast.makeText(getApplicationContext(),"***" +sp.getString(USERNAME,"no name"),Toast.LENGTH_LONG).show();

        Toast.makeText(this,"***" +sp.getString(EMAIL,"nothing"),Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String username=ed_username.getText().toString();
        String email=ed_email.getText().toString();

        edit.putString(USERNAME,username);
        edit.putString(EMAIL ,email);
        edit.apply();
    }
}