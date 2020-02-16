package com.iet.ietiansdiary.Cursor_activities.study_material;

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

import com.iet.ietiansdiary.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.iet.ietiansdiary.Cursor_activities.study_material.sm_view_pdf.vspin1;
import static com.iet.ietiansdiary.Cursor_activities.study_material.sm_view_pdf.vspin2;
import static com.iet.ietiansdiary.Cursor_activities.study_material.sm_view_pdf.vspin3;

public class sm_view_activity extends AppCompatActivity {

    ListView smlistView;
    private DatabaseReference smdatabaseReference;
    List<sm_upload_model> upload_model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sm_view_activity);
       // FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        smlistView=(ListView)findViewById(R.id.smlistview);
        upload_model=new ArrayList<>();
        if(vspin1==0 || vspin2==0 || vspin3==0){
            Toast.makeText(sm_view_activity.this, "Please Select Appropriate Choices..", Toast.LENGTH_SHORT).show();
        }
        else{smviewpdf();}

        smlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                sm_upload_model sm_model=upload_model.get(position);
                    Intent intent=new Intent();

                    intent.setDataAndType(Uri.parse(sm_model.getSmurl()),"application/pdf");
                    startActivity(intent);



            }
        });

    }

    public DatabaseReference smreference(){
        if(vspin1==1 && (vspin2==1) &&(vspin3==1)){
         smdatabaseReference   = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem1").child("books");
        } if(vspin1==1&&(vspin2==2)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-2").child("books");
        }if(vspin1==1&&(vspin2==3)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-3").child("books");
        }if(vspin1==1&&(vspin2==4)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-4").child("books");
        }if(vspin1==1&&(vspin2==5)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-5").child("books");
        }if(vspin1==1&&(vspin2==6)&&(vspin3==1)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-6").child("books");
        }if(vspin1==1&&(vspin2==7)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-7").child("books");
        }if(vspin1==1&&(vspin2==8)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-8").child("books");
        }//

        if(vspin1==1&&(vspin2==1)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-1").child("notes");
        }if(vspin1==1&&(vspin2==2)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-2").child("notes");
        }if(vspin1==1&&(vspin2==3)&&(vspin3==2)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-3").child("notes");
        }if(vspin1==1&&(vspin2==4)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-4").child("notes");
        }if(vspin1==1&&(vspin2==5)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-5").child("notes");
        }if(vspin1==1&&(vspin2==6)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-6").child("notes");
        }if(vspin1==1&&(vspin2==7)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-7").child("notes");
        }if(vspin1==1&&(vspin2==8)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-8").child("notes");
        }//
        if(vspin1==1&&(vspin2==1)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-1").child("papers");
        }if(vspin1==1&&(vspin2==2)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-2").child("papers");
        }if(vspin1==1&&(vspin2==3)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-3").child("papers");
        }if(vspin1==1&&(vspin2==4)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-4").child("papers");
        }if(vspin1==1&&(vspin2==5)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-5").child("papers");
        }if(vspin1==1&&(vspin2==6)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-6").child("papers");
        }if(vspin1==1&&(vspin2==7)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-7").child("papers");
        }if(vspin1==1&&(vspin2==8)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-8").child("papers");
        }//
        if(vspin1==1&&(vspin2==1)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-1").child("practicals");
        }if(vspin1==1&&(vspin2==2)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-2").child("practicals");
        }if(vspin1==1&&(vspin2==3)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-3").child("practicals");
        }if(vspin1==1&&(vspin2==4)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-4").child("practicals");
        }if(vspin1==1&&(vspin2==5)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-5").child("practicals");
        }if(vspin1==1&&(vspin2==6)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-6").child("practicals");
        }if(vspin1==1&&(vspin2==7)&&(vspin3==4)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-7").child("practicals");
        }if(vspin1==1&&(vspin2==8)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-8").child("practicals");
        }//
        if(vspin1==1&&(vspin2==1)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-1").child("assignment");
        }if(vspin1==1&&(vspin2==2)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-2").child("assignment");
        }if(vspin1==1&&(vspin2==3)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-3").child("assignment");
        }if(vspin1==1&&(vspin2==4)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-4").child("assignment");
        }if(vspin1==1&&(vspin2==5)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-5").child("assignment");
        }if(vspin1==1&&(vspin2==6)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-6").child("assignment");
        }if(vspin1==1&&(vspin2==7)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-7").child("assignment");
        }if(vspin1==1&&(vspin2==8)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-8").child("assignment");
        }//
        if(vspin1==1&&(vspin2==1)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-1").child("others");
        }if(vspin1==1&&(vspin2==2)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-2").child("others");
        }if(vspin1==1&&(vspin2==3)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-3").child("others");
        }if(vspin1==1&&(vspin2==4)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-4").child("others");
        }if(vspin1==1&&(vspin2==5)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-5").child("others");
        }if(vspin1==1&&(vspin2==6)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-6").child("others");
        }if(vspin1==1&&(vspin2==7)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-7").child("others");
        }if(vspin1==1&&(vspin2==8)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("cs").child("sem-8").child("others");
        }//
        //
        //
        if(vspin1==2 && (vspin2==1) &&(vspin3==1)){
            smdatabaseReference   = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem1").child("books");
        } if(vspin1==2&&(vspin2==2)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-2").child("books");
        }if(vspin1==2&&(vspin2==3)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-3").child("books");
        }if(vspin1==2&&(vspin2==4)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-4").child("books");
        }if(vspin1==2&&(vspin2==5)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-5").child("books");
        }if(vspin1==2&&(vspin2==6)&&(vspin3==1)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-6").child("books");
        }if(vspin1==2&&(vspin2==7)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-7").child("books");
        }if(vspin1==2&&(vspin2==8)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-8").child("books");
        }//

        if(vspin1==2&&(vspin2==1)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-1").child("notes");
        }if(vspin1==2&&(vspin2==2)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-2").child("notes");
        }if(vspin1==2&&(vspin2==3)&&(vspin3==2)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-3").child("notes");
        }if(vspin1==2&&(vspin2==4)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-4").child("notes");
        }if(vspin1==2&&(vspin2==5)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-5").child("notes");
        }if(vspin1==2&&(vspin2==6)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-6").child("notes");
        }if(vspin1==2&&(vspin2==7)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-7").child("notes");
        }if(vspin1==2&&(vspin2==8)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-8").child("notes");
        }//
        if(vspin1==2&&(vspin2==1)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-1").child("papers");
        }if(vspin1==2&&(vspin2==2)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-2").child("papers");
        }if(vspin1==2&&(vspin2==3)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-3").child("papers");
        }if(vspin1==2&&(vspin2==4)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-4").child("papers");
        }if(vspin1==2&&(vspin2==5)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-5").child("papers");
        }if(vspin1==2&&(vspin2==6)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-6").child("papers");
        }if(vspin1==2&&(vspin2==7)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-7").child("papers");
        }if(vspin1==2&&(vspin2==8)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-8").child("papers");
        }//
        if(vspin1==2&&(vspin2==1)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-1").child("practicals");
        }if(vspin1==2&&(vspin2==2)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-2").child("practicals");
        }if(vspin1==2&&(vspin2==3)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-3").child("practicals");
        }if(vspin1==2&&(vspin2==4)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-4").child("practicals");
        }if(vspin1==2&&(vspin2==5)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-5").child("practicals");
        }if(vspin1==2&&(vspin2==6)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-6").child("practicals");
        }if(vspin1==2&&(vspin2==7)&&(vspin3==4)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-7").child("practicals");
        }if(vspin1==2&&(vspin2==8)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-8").child("practicals");
        }//
        if(vspin1==2&&(vspin2==1)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-1").child("assignment");
        }if(vspin1==2&&(vspin2==2)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-2").child("assignment");
        }if(vspin1==2&&(vspin2==3)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-3").child("assignment");
        }if(vspin1==2&&(vspin2==4)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-4").child("assignment");
        }if(vspin1==2&&(vspin2==5)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-5").child("assignment");
        }if(vspin1==2&&(vspin2==6)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-6").child("assignment");
        }if(vspin1==2&&(vspin2==7)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-7").child("assignment");
        }if(vspin1==2&&(vspin2==8)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-8").child("assignment");
        }//
        if(vspin1==2&&(vspin2==1)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-1").child("others");
        }if(vspin1==2&&(vspin2==2)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-2").child("others");
        }if(vspin1==2&&(vspin2==3)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-3").child("others");
        }if(vspin1==2&&(vspin2==4)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-4").child("others");
        }if(vspin1==2&&(vspin2==5)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-5").child("others");
        }if(vspin1==2&&(vspin2==6)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-6").child("others");
        }if(vspin1==2&&(vspin2==7)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-7").child("others");
        }if(vspin1==2&&(vspin2==8)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("IT").child("sem-8").child("others");
        }//
        //
        //
        if(vspin1==3 && (vspin2==1) &&(vspin3==1)){
            smdatabaseReference   = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem1").child("books");
        } if(vspin1==3&&(vspin2==2)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-2").child("books");
        }if(vspin1==3&&(vspin2==3)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-3").child("books");
        }if(vspin1==3&&(vspin2==4)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-4").child("books");
        }if(vspin1==3&&(vspin2==5)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-5").child("books");
        }if(vspin1==3&&(vspin2==6)&&(vspin3==1)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-6").child("books");
        }if(vspin1==3&&(vspin2==7)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-7").child("books");
        }if(vspin1==3&&(vspin2==8)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-8").child("books");
        }//

        if(vspin1==3&&(vspin2==1)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-1").child("notes");
        }if(vspin1==3&&(vspin2==2)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-2").child("notes");
        }if(vspin1==3&&(vspin2==3)&&(vspin3==2)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-3").child("notes");
        }if(vspin1==3&&(vspin2==4)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-4").child("notes");
        }if(vspin1==3&&(vspin2==5)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-5").child("notes");
        }if(vspin1==3&&(vspin2==6)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-6").child("notes");
        }if(vspin1==3&&(vspin2==7)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-7").child("notes");
        }if(vspin1==3&&(vspin2==8)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-8").child("notes");
        }//
        if(vspin1==3&&(vspin2==1)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-1").child("papers");
        }if(vspin1==3&&(vspin2==2)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-2").child("papers");
        }if(vspin1==3&&(vspin2==3)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-3").child("papers");
        }if(vspin1==3&&(vspin2==4)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-4").child("papers");
        }if(vspin1==3&&(vspin2==5)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-5").child("papers");
        }if(vspin1==3&&(vspin2==6)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-6").child("papers");
        }if(vspin1==3&&(vspin2==7)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-7").child("papers");
        }if(vspin1==3&&(vspin2==8)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-8").child("papers");
        }//
        if(vspin1==3&&(vspin2==1)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-1").child("practicals");
        }if(vspin1==3&&(vspin2==2)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-2").child("practicals");
        }if(vspin1==3&&(vspin2==3)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-3").child("practicals");
        }if(vspin1==3&&(vspin2==4)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-4").child("practicals");
        }if(vspin1==3&&(vspin2==5)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-5").child("practicals");
        }if(vspin1==3&&(vspin2==6)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-6").child("practicals");
        }if(vspin1==3&&(vspin2==7)&&(vspin3==4)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-7").child("practicals");
        }if(vspin1==3&&(vspin2==8)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-8").child("practicals");
        }//
        if(vspin1==3&&(vspin2==1)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-1").child("assignment");
        }if(vspin1==3&&(vspin2==2)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-2").child("assignment");
        }if(vspin1==3&&(vspin2==3)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-3").child("assignment");
        }if(vspin1==3&&(vspin2==4)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-4").child("assignment");
        }if(vspin1==3&&(vspin2==5)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-5").child("assignment");
        }if(vspin1==3&&(vspin2==6)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-6").child("assignment");
        }if(vspin1==3&&(vspin2==7)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-7").child("assignment");
        }if(vspin1==3&&(vspin2==8)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-8").child("assignment");
        }//
        if(vspin1==3&&(vspin2==1)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-1").child("others");
        }if(vspin1==3&&(vspin2==2)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-2").child("others");
        }if(vspin1==3&&(vspin2==3)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-3").child("others");
        }if(vspin1==3&&(vspin2==4)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-4").child("others");
        }if(vspin1==3&&(vspin2==5)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-5").child("others");
        }if(vspin1==3&&(vspin2==6)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-6").child("others");
        }if(vspin1==3&&(vspin2==7)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-7").child("others");
        }if(vspin1==3&&(vspin2==8)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("etc").child("sem-8").child("others");
        }//
        //
        //
        if(vspin1==4 && (vspin2==1) &&(vspin3==1)){
            smdatabaseReference   = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem1").child("books");
        } if(vspin1==4&&(vspin2==2)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-2").child("books");
        }if(vspin1==4&&(vspin2==3)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-3").child("books");
        }if(vspin1==4&&(vspin2==4)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-4").child("books");
        }if(vspin1==4&&(vspin2==5)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-5").child("books");
        }if(vspin1==4&&(vspin2==6)&&(vspin3==1)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-6").child("books");
        }if(vspin1==4&&(vspin2==7)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-7").child("books");
        }if(vspin1==4&&(vspin2==8)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-8").child("books");
        }//

        if(vspin1==4&&(vspin2==1)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-1").child("notes");
        }if(vspin1==4&&(vspin2==2)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-2").child("notes");
        }if(vspin1==4&&(vspin2==3)&&(vspin3==2)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-3").child("notes");
        }if(vspin1==4&&(vspin2==4)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-4").child("notes");
        }if(vspin1==4&&(vspin2==5)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-5").child("notes");
        }if(vspin1==4&&(vspin2==6)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-6").child("notes");
        }if(vspin1==4&&(vspin2==7)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-7").child("notes");
        }if(vspin1==4&&(vspin2==8)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-8").child("notes");
        }//
        if(vspin1==4&&(vspin2==1)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-1").child("papers");
        }if(vspin1==4&&(vspin2==2)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-2").child("papers");
        }if(vspin1==4&&(vspin2==3)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-3").child("papers");
        }if(vspin1==4&&(vspin2==4)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-4").child("papers");
        }if(vspin1==4&&(vspin2==5)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-5").child("papers");
        }if(vspin1==4&&(vspin2==6)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-6").child("papers");
        }if(vspin1==4&&(vspin2==7)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-7").child("papers");
        }if(vspin1==4&&(vspin2==8)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-8").child("papers");
        }//
        if(vspin1==4&&(vspin2==1)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-1").child("practicals");
        }if(vspin1==4&&(vspin2==2)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-2").child("practicals");
        }if(vspin1==4&&(vspin2==3)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-3").child("practicals");
        }if(vspin1==4&&(vspin2==4)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-4").child("practicals");
        }if(vspin1==4&&(vspin2==5)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-5").child("practicals");
        }if(vspin1==4&&(vspin2==6)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-6").child("practicals");
        }if(vspin1==4&&(vspin2==7)&&(vspin3==4)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-7").child("practicals");
        }if(vspin1==4&&(vspin2==8)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-8").child("practicals");
        }//
        if(vspin1==4&&(vspin2==1)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-1").child("assignment");
        }if(vspin1==4&&(vspin2==2)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-2").child("assignment");
        }if(vspin1==4&&(vspin2==3)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-3").child("assignment");
        }if(vspin1==4&&(vspin2==4)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-4").child("assignment");
        }if(vspin1==4&&(vspin2==5)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-5").child("assignment");
        }if(vspin1==4&&(vspin2==6)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-6").child("assignment");
        }if(vspin1==4&&(vspin2==7)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-7").child("assignment");
        }if(vspin1==4&&(vspin2==8)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-8").child("assignment");
        }//
        if(vspin1==4&&(vspin2==1)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-1").child("others");
        }if(vspin1==4&&(vspin2==2)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-2").child("others");
        }if(vspin1==4&&(vspin2==3)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-3").child("others");
        }if(vspin1==4&&(vspin2==4)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-4").child("others");
        }if(vspin1==4&&(vspin2==5)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-5").child("others");
        }if(vspin1==4&&(vspin2==6)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-6").child("others");
        }if(vspin1==4&&(vspin2==7)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-7").child("others");
        }if(vspin1==4&&(vspin2==8)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("ei").child("sem-8").child("others");
        }//
        //
        //

        if(vspin1==5 && (vspin2==1) &&(vspin3==1)){
            smdatabaseReference   = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem1").child("books");
        } if(vspin1==5&&(vspin2==2)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-2").child("books");
        }if(vspin1==5&&(vspin2==3)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-3").child("books");
        }if(vspin1==5&&(vspin2==4)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-4").child("books");
        }if(vspin1==5&&(vspin2==5)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-5").child("books");
        }if(vspin1==5&&(vspin2==6)&&(vspin3==1)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-6").child("books");
        }if(vspin1==5&&(vspin2==7)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-7").child("books");
        }if(vspin1==5&&(vspin2==8)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-8").child("books");
        }//

        if(vspin1==5&&(vspin2==1)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-1").child("notes");
        }if(vspin1==5&&(vspin2==2)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-2").child("notes");
        }if(vspin1==5&&(vspin2==3)&&(vspin3==2)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-3").child("notes");
        }if(vspin1==5&&(vspin2==4)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-4").child("notes");
        }if(vspin1==5&&(vspin2==5)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-5").child("notes");
        }if(vspin1==5&&(vspin2==6)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-6").child("notes");
        }if(vspin1==5&&(vspin2==7)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-7").child("notes");
        }if(vspin1==5&&(vspin2==8)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-8").child("notes");
        }//
        if(vspin1==5&&(vspin2==1)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-1").child("papers");
        }if(vspin1==5&&(vspin2==2)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-2").child("papers");
        }if(vspin1==5&&(vspin2==3)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-3").child("papers");
        }if(vspin1==5&&(vspin2==4)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-4").child("papers");
        }if(vspin1==5&&(vspin2==5)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-5").child("papers");
        }if(vspin1==5&&(vspin2==6)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-6").child("papers");
        }if(vspin1==5&&(vspin2==7)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-7").child("papers");
        }if(vspin1==5&&(vspin2==8)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-8").child("papers");
        }//
        if(vspin1==5&&(vspin2==1)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-1").child("practicals");
        }if(vspin1==5&&(vspin2==2)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-2").child("practicals");
        }if(vspin1==5&&(vspin2==3)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-3").child("practicals");
        }if(vspin1==5&&(vspin2==4)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-4").child("practicals");
        }if(vspin1==5&&(vspin2==5)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-5").child("practicals");
        }if(vspin1==5&&(vspin2==6)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-6").child("practicals");
        }if(vspin1==5&&(vspin2==7)&&(vspin3==4)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-7").child("practicals");
        }if(vspin1==5&&(vspin2==8)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-8").child("practicals");
        }//
        if(vspin1==5&&(vspin2==1)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-1").child("assignment");
        }if(vspin1==5&&(vspin2==2)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-2").child("assignment");
        }if(vspin1==5&&(vspin2==3)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-3").child("assignment");
        }if(vspin1==5&&(vspin2==4)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-4").child("assignment");
        }if(vspin1==5&&(vspin2==5)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-5").child("assignment");
        }if(vspin1==5&&(vspin2==6)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-6").child("assignment");
        }if(vspin1==5&&(vspin2==7)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-7").child("assignment");
        }if(vspin1==5&&(vspin2==8)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-8").child("assignment");
        }//
        if(vspin1==5&&(vspin2==1)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-1").child("others");
        }if(vspin1==5&&(vspin2==2)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-2").child("others");
        }if(vspin1==5&&(vspin2==3)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-3").child("others");
        }if(vspin1==5&&(vspin2==4)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-4").child("others");
        }if(vspin1==5&&(vspin2==5)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-5").child("others");
        }if(vspin1==5&&(vspin2==6)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-6").child("others");
        }if(vspin1==5&&(vspin2==7)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-7").child("others");
        }if(vspin1==5&&(vspin2==8)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("mech").child("sem-8").child("others");
        }//
        //
        //
        if(vspin1==6 && (vspin2==1) &&(vspin3==1)){
            smdatabaseReference   = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem1").child("books");
        } if(vspin1==6&&(vspin2==2)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-2").child("books");
        }if(vspin1==6&&(vspin2==3)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-3").child("books");
        }if(vspin1==6&&(vspin2==4)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-4").child("books");
        }if(vspin1==6&&(vspin2==5)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-5").child("books");
        }if(vspin1==6&&(vspin2==6)&&(vspin3==1)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-6").child("books");
        }if(vspin1==6&&(vspin2==7)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-7").child("books");
        }if(vspin1==6&&(vspin2==8)&&(vspin3==1)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-8").child("books");
        }//

        if(vspin1==6&&(vspin2==1)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-1").child("notes");
        }if(vspin1==6&&(vspin2==2)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-2").child("notes");
        }if(vspin1==6&&(vspin2==3)&&(vspin3==2)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-3").child("notes");
        }if(vspin1==6&&(vspin2==4)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-4").child("notes");
        }if(vspin1==6&&(vspin2==5)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-5").child("notes");
        }if(vspin1==6&&(vspin2==6)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-6").child("notes");
        }if(vspin1==6&&(vspin2==7)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-7").child("notes");
        }if(vspin1==6&&(vspin2==8)&&(vspin3==2)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-8").child("notes");
        }//
        if(vspin1==6&&(vspin2==1)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-1").child("papers");
        }if(vspin1==6&&(vspin2==2)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-2").child("papers");
        }if(vspin1==6&&(vspin2==3)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-3").child("papers");
        }if(vspin1==6&&(vspin2==4)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-4").child("papers");
        }if(vspin1==6&&(vspin2==5)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-5").child("papers");
        }if(vspin1==6&&(vspin2==6)&&(vspin3==3)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-6").child("papers");
        }if(vspin1==6&&(vspin2==7)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-7").child("papers");
        }if(vspin1==6&&(vspin2==8)&&(vspin3==3)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-8").child("papers");
        }//
        if(vspin1==6&&(vspin2==1)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-1").child("practicals");
        }if(vspin1==6&&(vspin2==2)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-2").child("practicals");
        }if(vspin1==6&&(vspin2==3)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-3").child("practicals");
        }if(vspin1==6&&(vspin2==4)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-4").child("practicals");
        }if(vspin1==6&&(vspin2==5)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-5").child("practicals");
        }if(vspin1==6&&(vspin2==6)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-6").child("practicals");
        }if(vspin1==6&&(vspin2==7)&&(vspin3==4)) {
            smdatabaseReference = FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-7").child("practicals");
        }if(vspin1==6&&(vspin2==8)&&(vspin3==4)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-8").child("practicals");
        }//
        if(vspin1==6&&(vspin2==1)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-1").child("assignment");
        }if(vspin1==6&&(vspin2==2)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-2").child("assignment");
        }if(vspin1==6&&(vspin2==3)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-3").child("assignment");
        }if(vspin1==6&&(vspin2==4)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-4").child("assignment");
        }if(vspin1==6&&(vspin2==5)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-5").child("assignment");
        }if(vspin1==6&&(vspin2==6)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-6").child("assignment");
        }if(vspin1==6&&(vspin2==7)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-7").child("assignment");
        }if(vspin1==6&&(vspin2==8)&&(vspin3==5)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-8").child("assignment");
        }//
        if(vspin1==6&&(vspin2==1)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-1").child("others");
        }if(vspin1==6&&(vspin2==2)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-2").child("others");
        }if(vspin1==6&&(vspin2==3)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-3").child("others");
        }if(vspin1==6&&(vspin2==4)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-4").child("others");
        }if(vspin1==6&&(vspin2==5)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-5").child("others");
        }if(vspin1==6&&(vspin2==6)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-6").child("others");
        }if(vspin1==6&&(vspin2==7)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-7").child("others");
        }if(vspin1==6&&(vspin2==8)&&(vspin3==6)) {
            smdatabaseReference= FirebaseDatabase.getInstance().getReference("study_material").child("civil").child("sem-8").child("others");
        }//
        //
        //



        return smdatabaseReference;
    }


    private void smviewpdf() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Loading");

        progressDialog.show();


        smreference();
        smdatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              if(dataSnapshot.exists()){
                for(DataSnapshot postsnapshot :dataSnapshot.getChildren()) {
                    sm_upload_model model = postsnapshot.getValue(sm_upload_model.class);
                    upload_model.add(model);
                    String[] smuploads = new String[upload_model.size()];

                    for (int i = 0; i < smuploads.length; i++) {
                        smuploads[i] = upload_model.get(i).getSmname();

                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, smuploads) {

                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {

                            View view = super.getView(position, convertView, parent);
                            TextView mytext = (TextView) view.findViewById(android.R.id.text1);
                            mytext.setTextColor(Color.WHITE);


                            progressDialog.dismiss();
                            return view;
                        }
                    };
                    smlistView.setAdapter(adapter);
                }
              }else{progressDialog.dismiss();
                  Toast.makeText(sm_view_activity.this, "Nothing to show", Toast.LENGTH_LONG).show();}

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
