package com.iet.ietiansdiary.Cursor_activities.notice;

import com.firebase.ui.database.FirebaseRecyclerOptions;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iet.ietiansdiary.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Recycler_view__ extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private FirebaseRecyclerAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view__);
        recyclerView=(RecyclerView)findViewById(R.id.list);
        linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
      //  FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        fetch();
    }

    private void fetch() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Loading");

        progressDialog.show();

        Query query= FirebaseDatabase.getInstance().getReference().child("Notices");

        FirebaseRecyclerOptions<model> options=new FirebaseRecyclerOptions.Builder<model>().setQuery(query, new SnapshotParser<model>() {
            @NonNull
            @Override
            public model parseSnapshot(@NonNull DataSnapshot snapshot) {
                progressDialog.dismiss();
                return new model(snapshot.child("ID").getValue().toString(),snapshot.child("Title").getValue().toString(),snapshot.child("desc").getValue().toString());
            }
        }).build();
        adapter= new FirebaseRecyclerAdapter<model, ViewHolder>(options) {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup,false);
                return new ViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, final int position, @NonNull model model) {
                holder.setTxttiltle(model.getmTitle());
                holder.setTxtdesc(model.getmDesc());
                holder.root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Recycler_view__.this,String.valueOf(position),Toast.LENGTH_SHORT).show();

                    }
                });


            }
        };
        recyclerView.setAdapter(adapter);



    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout root;
        public TextView txttiltle,txtdesc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            root=itemView.findViewById(R.id.list_root);
            txttiltle=itemView.findViewById(R.id.list_title);

            Linkify.addLinks(txttiltle, Linkify.WEB_URLS);

            txtdesc=itemView.findViewById(R.id.list_desc);
            Linkify.addLinks(txtdesc, Linkify.WEB_URLS);

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
        adapter.startListening();

        super.onStart();
    }
    @Override
    protected void onStop() {
        adapter.stopListening();

        super.onStop();
    }
}

