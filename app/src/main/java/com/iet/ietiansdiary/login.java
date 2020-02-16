package com.iet.ietiansdiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText editText;
    String ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText=findViewById(R.id.pass);


    }

























































    public void DLOGIN(View view) {
        ch=editText.getText().toString();
        if(ch.equals("ptanhi")){
            Intent intent=new Intent(this,dupload.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"You are not a developer",Toast.LENGTH_SHORT).show();
        }

    }

    public void ULOGIN(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
