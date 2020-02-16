package com.iet.ietiansdiary.navigation_activities.developers.clubs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iet.ietiansdiary.R;
import com.iet.ietiansdiary.navigation_drawer;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Clubs extends AppCompatActivity {
    private LinearLayoutManager clinearLayoutManager;
    private FirebaseRecyclerAdapter cadapter;
    private RecyclerView crecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);
        crecyclerView=(RecyclerView)findViewById(R.id.clubs_list);
        clinearLayoutManager=new LinearLayoutManager(this);
       // clinearLayoutManager.setReverseLayout(true);
     //   clinearLayoutManager.setStackFromEnd(true);

        crecyclerView.setLayoutManager(clinearLayoutManager);
        crecyclerView.setHasFixedSize(true);
        cfetch();

    }

    private void cfetch() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Loading");

        progressDialog.show();

        Query query= FirebaseDatabase.getInstance().getReference().child("Clubs");
        FirebaseRecyclerOptions<cmodel> options=new FirebaseRecyclerOptions.Builder<cmodel>().setQuery(query, new SnapshotParser<cmodel>() {
            @NonNull
            @Override
            public cmodel parseSnapshot(@NonNull DataSnapshot snapshot) {
                progressDialog.dismiss();
                return new cmodel(snapshot.child("ID").getValue().toString(),snapshot.child("Title").getValue().toString(),snapshot.child("desc").getValue().toString());
            }
        }).build();
        cadapter= new FirebaseRecyclerAdapter<cmodel, Clubs.ViewHolder>(options) {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.club_list, viewGroup,false);
                return new ViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, final int position, @NonNull cmodel model) {
                holder.setTxttiltle(model.getmTitle());
                holder.setTxtdesc(model.getmDesc());
                holder.root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Clubs.this,String.valueOf(position),Toast.LENGTH_SHORT).show();
                    }
                });
            }


        };
        crecyclerView.setAdapter(cadapter);



    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout root;
        public TextView txttiltle,txtdesc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            root=itemView.findViewById(R.id.list_root);
            txttiltle=itemView.findViewById(R.id.list_title);
            txtdesc=itemView.findViewById(R.id.list_desc);


        }
        public void setTxttiltle(String string){
            txttiltle.setText(string);
        }
        public void setTxtdesc(String string){
            txtdesc.setText(string);
        }
    }
    @Override
    protected void onStart() {
        cadapter.startListening();

        super.onStart();
    }
    @Override
    protected void onStop() {
        cadapter.stopListening();

        super.onStop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Clubs.this, navigation_drawer.class);
        startActivity(intent);


    }
}

