package com.iet.ietiansdiary;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        final TextView tv1=(TextView)findViewById(R.id.textView25);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phno1= tv1.getText().toString().trim();
                Intent callIntent=new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse(phno1));
               // callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
            }
        });
        final TextView tv2=(TextView)findViewById(R.id.textView30);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phno2= tv2.getText().toString().trim();
                Intent callIntent=new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse(phno2));
                // callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
            }


        });
    }
}
