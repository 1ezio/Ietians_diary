package com.iet.ietiansdiary.Cursor_activities.notice;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
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

public class Notices extends AppCompatActivity {
    private EditText editText,etd;
    private NotificationManagerCompat notificationManager;
    private Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notices);

        editText=(EditText)findViewById(R.id.et);
        etd=(EditText)findViewById(R.id.etd);
        button=(Button)findViewById(R.id.upld_notices);
        notificationManager=NotificationManagerCompat.from(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Notices").push();
                Map<String,Object>map=new HashMap<>();
                map.put("ID",databaseReference.getKey());
                map.put("Title",editText.getText().toString());
                map.put("desc",etd.getText().toString().toString());
                databaseReference.setValue(map);

                Toast.makeText(Notices.this,"Notice Uploaded",Toast.LENGTH_SHORT).show();
               //notification();

            }
        });


    }



    public void  notification(){
        Intent intent=new Intent(Notices.this,Recycler_view__.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent ci= PendingIntent.getActivity(Notices.this,0,intent,0);

        Notification notifications=new NotificationCompat.Builder(this,notice_notifications.Channel_1_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(editText.getText().toString()).setContentText(etd.getText().toString()).setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

        notificationManager.notify(1,notifications);
        editText.setText(" ");
        etd.setText(" ");



    }
}
