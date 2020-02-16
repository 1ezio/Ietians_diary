package com.iet.ietiansdiary.navigation_activities.developers;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.iet.ietiansdiary.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class developers_activity extends AppCompatActivity {
    TextView selectbtn;
    private List<list_data> list_data;
    private RecyclerView recyclerView;
    private DatabaseReference db;
    private dev_adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers_activity);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);


       recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(linearLayoutManager);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list_data=new ArrayList<>();
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Loading");

        progressDialog.show();

        db= FirebaseDatabase.getInstance().getReference("Uploads");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
              if(dataSnapshot.exists()){
                for (DataSnapshot post : dataSnapshot.getChildren()){
                    list_data listData=post.getValue(list_data.class);
                    list_data.add(listData);
                    progressDialog.dismiss();
                }
                adapter=new dev_adapter(list_data, developers_activity.this);
                recyclerView.setAdapter(adapter);

            }else {
                  Toast.makeText(developers_activity.this, "Nothing to show", Toast.LENGTH_SHORT).show();
              }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }


}