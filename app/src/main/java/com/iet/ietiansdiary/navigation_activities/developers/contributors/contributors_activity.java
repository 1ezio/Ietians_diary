package com.iet.ietiansdiary.navigation_activities.developers.contributors;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.iet.ietiansdiary.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class contributors_activity extends AppCompatActivity {

    private List<clist_data> list_data;
    private RecyclerView crecyclerView;
    private DatabaseReference cdb;
    private cont_adapter cadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contributors_activity);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);

        crecyclerView=(RecyclerView)findViewById(R.id.crecyclerview);
        crecyclerView.setHasFixedSize(true);
        crecyclerView.setLayoutManager(linearLayoutManager);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list_data=new ArrayList<>();
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Loading");

        progressDialog.show();

        cdb= FirebaseDatabase.getInstance().getReference("cUploads");
        cdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               if(dataSnapshot.exists()) {
                   for (DataSnapshot post : dataSnapshot.getChildren()) {
                       clist_data listData = post.getValue(clist_data.class);
                       list_data.add(listData);
                   }
                   cadapter = new cont_adapter(list_data, contributors_activity.this);
                   crecyclerView.setAdapter(cadapter);
                   progressDialog.dismiss();
               }else{progressDialog.dismiss();
                   Toast.makeText(contributors_activity.this, "Nothing to show", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
