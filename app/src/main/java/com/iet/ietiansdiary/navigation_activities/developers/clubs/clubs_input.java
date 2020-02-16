package com.iet.ietiansdiary.navigation_activities.developers.clubs;

import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iet.ietiansdiary.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class clubs_input extends AppCompatActivity {
    private EditText ceditText,cetd;
    private NotificationManagerCompat notificationManager;
    private Button cbutton,cbutton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs_input);
        ceditText=(EditText)findViewById(R.id.cet);
        cetd=(EditText)findViewById(R.id.cetd);
        cbutton=(Button)findViewById(R.id.upld_club);
        //notificationManager=NotificationManagerCompat.from(this);


        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Clubs").push();
                Map<String,Object> map=new HashMap<>();
                map.put("ID",databaseReference.getKey());
                map.put("Title",ceditText.getText().toString());
                map.put("desc",cetd.getText().toString().toString());
                databaseReference.setValue(map);

                Toast.makeText(clubs_input.this,"Notice Uploaded",Toast.LENGTH_SHORT).show();
                //notification();

            }
        });

    }
}
