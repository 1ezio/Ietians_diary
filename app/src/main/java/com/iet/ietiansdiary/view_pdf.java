package com.iet.ietiansdiary;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.iet.ietiansdiary.Cursor_activities.Syllabus.vitem1;
import static com.iet.ietiansdiary.Cursor_activities.Syllabus.vitem2;

public class view_pdf extends AppCompatActivity {
    ListView listView;

    private DatabaseReference databaseReference;
    List<uploadSyllabi> uploadsyllabi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);
        listView=(ListView)findViewById(R.id.listview);
      //  FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        uploadsyllabi=new ArrayList<>();

        viewallfiles();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if(vitem1==0 || vitem2==0){
                   Toast.makeText(view_pdf.this, "Please Select Appropriate Choice..", Toast.LENGTH_SHORT).show();
               }else{uploadSyllabi uploadSyllabi=uploadsyllabi.get(position);

                   Intent intent=new Intent();
                   intent.setDataAndType(Uri.parse(uploadSyllabi.getSurl()),"application/pdf");
                   //
                   // intent.setType(Intent.ACTION_VIEW);

                   startActivity(intent);
               }




            }
        });
     /*   final SwipeRefreshLayout pullToRefresh = findViewById(R.id.pullToRefresh);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               viewallfiles(); // your code
                pullToRefresh.setRefreshing(false);
            }
        }); */


    }

    public DatabaseReference database() {

        if(vitem1==1&&(vitem2==1)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("cs").child("sem-1");
        }else if(vitem1==1&&(vitem2==2)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("cs").child("sem-2");
        }else if(vitem1==1&&(vitem2==3)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("cs").child("sem-3");
        }else if(vitem1==1&&(vitem2==4)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("cs").child("sem-4");
        }else if(vitem1==1&&(vitem2==5)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("cs").child("sem-5");
        }else if(vitem1==1&&(vitem2==6)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("cs").child("sem-6");
        }else if(vitem1==1&&(vitem2==7)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("cs").child("sem-7");
        }else if(vitem1==1&&(vitem2==8)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("cs").child("sem-8");
        }

        else if(vitem1==2&&(vitem2==1)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("IT").child("sem-1");
        }else if(vitem1==2&&(vitem2==2)) {
            databaseReference= FirebaseDatabase.getInstance().getReference("Syllabi").child("IT").child("sem-2");
        }else if(vitem1==2&&(vitem2==3)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("IT").child("sem-3");
        }else if(vitem1==2&&(vitem2==4)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("IT").child("sem-4");
        }else if(vitem1==2&&(vitem2==5)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("IT").child("sem-5");
        }else if(vitem1==2&&(vitem2==6)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("IT").child("sem-6");
        }else if(vitem1==2&&(vitem2==7)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("IT").child("sem-7");
        }else if(vitem1==2&&(vitem2==8)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("IT").child("sem-8");
        }

        else if(vitem1==3&&(vitem2==1)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("etc").child("sem-1");
        }else if(vitem1==3&&(vitem2==2)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("etc").child("sem-2");
        }else if(vitem1==3&&(vitem2==3)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("etc").child("sem-3");
        }else if(vitem1==3&&(vitem2==4)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("etc").child("sem-4");
        }else if(vitem1==3&&(vitem2==5)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("etc").child("sem-5");
        }else if(vitem1==3&&(vitem2==6)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("etc").child("sem-6");
        }else if(vitem1==3&&(vitem2==7)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("etc").child("sem-7");
        }else if(vitem1==3&&(vitem2==8)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("etc").child("sem-8");
        }

        else if(vitem1==4&&(vitem2==1)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("ei").child("sem-1");
        }else if(vitem1==4&&(vitem2==2)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("ei").child("sem-2");
        }else if(vitem1==4&&(vitem2==3)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("ei").child("sem-3");
        }else if(vitem1==4&&(vitem2==4)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("ei").child("sem-4");
        }else if(vitem1==4&&(vitem2==5)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("ei").child("sem-5");
        }else if(vitem1==4&&(vitem2==6)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("ei").child("sem-6");
        }else if(vitem1==4&&(vitem2==7)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("ei").child("sem-7");
        }else if(vitem1==4&&(vitem2==8)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("ei").child("sem-8");
        }

        else if(vitem1==5&&(vitem2==1)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("mech").child("sem-1");
        }else if(vitem1==5&&(vitem2==2)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("mech").child("sem-2");
        }else if(vitem1==5&&(vitem2==3)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("mech").child("sem-3");
        }else if(vitem1==5&&(vitem2==4)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("mech").child("sem-4");
        }else if(vitem1==5&&(vitem2==5)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("mech").child("sem-5");
        }else if(vitem1==5&&(vitem2==6)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("mech").child("sem-6");
        }else if(vitem1==5&&(vitem2==7)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("mech").child("sem-7");
        }else if(vitem1==5&&(vitem2==8)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("mech").child("sem-8");
        }

        else if(vitem1==6&&(vitem2==1)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("civil").child("sem-1");
        }else if(vitem1==6&&(vitem2==2)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("civil").child("sem-2");
        }else if(vitem1==6&&(vitem2==3)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("civil").child("sem-3");
        }else if(vitem1==6&&(vitem2==4)) {
             databaseReference= FirebaseDatabase.getInstance().getReference("Syllabi").child("civil").child("sem-4");
        }else if(vitem1==6&&(vitem2==5)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("civil").child("sem-5");
        }else if(vitem1==6&&(vitem2==6)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("civil").child("sem-6");
        }else if(vitem1==6&&(vitem2==7)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("civil").child("sem-7");
        }else if(vitem1==6&&(vitem2==8)) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Syllabi").child("civil").child("sem-8");
        }

        return databaseReference;
    }

    private void viewallfiles() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Loading");

        progressDialog.show();



        database();
        if(databaseReference==null){
            progressDialog.dismiss();
            Toast.makeText(view_pdf.this, "Nothing to show", Toast.LENGTH_LONG).show();

        }

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot postsnapshot : dataSnapshot.getChildren()) {
                        uploadSyllabi uploadSyllab = postsnapshot.getValue(uploadSyllabi.class);
                        uploadsyllabi.add(uploadSyllab);

                        String[] uploads = new String[uploadsyllabi.size()];


                        for (int i = 0; i < uploads.length; i++) {
                            uploads[i] = uploadsyllabi.get(i).getSname();

                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads) {

                            @Override
                            public View getView(int position, View convertView, ViewGroup parent) {

                                View view = super.getView(position, convertView, parent);
                                TextView mytext = (TextView) view.findViewById(android.R.id.text1);
                                mytext.setTextColor(Color.WHITE);
                                progressDialog.dismiss();


                                return view;
                            }
                        };
                        listView.setAdapter(adapter);

                    }
                } else{progressDialog.dismiss();
                    Toast.makeText(view_pdf.this, "Nothing to show", Toast.LENGTH_LONG).show();}


            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
