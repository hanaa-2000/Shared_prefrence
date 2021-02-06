package com.example.task_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showdata extends AppCompatActivity {
    TextView txt_username , txt_email;
    SharedPreferences sp;
    SharedPreferences.Editor edit;
    Button  btn_cancel;
    public final String USERNAME ="username";
    public final String EMAIL ="email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);
        txt_email=findViewById(R.id.txtemail);
        txt_username=findViewById(R.id.txtusername);
        btn_cancel=findViewById(R.id.btn_cancel);


        sp=getSharedPreferences("name",MODE_PRIVATE);


        edit=sp.edit();

        txt_username.setText(sp.getString(USERNAME,"No name"));
        txt_email.setText(sp.getString(EMAIL,"Nothing"));


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(showdata.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}