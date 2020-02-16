package com.iet.ietiansdiary.Cursor_activities.study_material;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.iet.ietiansdiary.R;
import com.iet.ietiansdiary.navigation_activities.developers.contributors.cont_image_activity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.List;

public class Study_Material extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText smtitle;
    private Button smbutton;
    private DatabaseReference smdtabasereference;
    private StorageReference smstoragerefernce;
    int smitem1 = 0, smitem2 = 0, smitem3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study__material);
        smtitle = (EditText) findViewById(R.id.sm_upload);
        smbutton = (Button) findViewById(R.id.sm_up);
        smdtabasereference = FirebaseDatabase.getInstance().getReference("study_material");
        smstoragerefernce = FirebaseStorage.getInstance().getReference();


        List<String> smbranches = new ArrayList<>();
        smbranches.add("None");
        smbranches.add("Computer Engineering ");
        smbranches.add("Information Technology");
        smbranches.add("Electronics & Telecommunication");
        smbranches.add("Electronics & Instrumentation");
        smbranches.add("Mechanical Engineering");
        smbranches.add("Civil Engineering");



        List<String> smsemester = new ArrayList<>();
        smsemester.add("None");
        smsemester.add("SEM-1");
        smsemester.add("SEM-2");
        smsemester.add("SEM-3");
        smsemester.add("SEM-4");
        smsemester.add("SEM-5");
        smsemester.add("SEM-6");
        smsemester.add("SEM-7");
        smsemester.add("SEM-8");

        List<String> smtype = new ArrayList<>();
        smtype.add("None");
        smtype.add("Books");
        smtype.add("Notes");
        smtype.add("Papers");
        smtype.add("Practicals");
        smtype.add("Assignments");
        smtype.add("Others");

        Spinner smbranchspinner = (Spinner) findViewById(R.id.smspinner);
        Spinner smsemspinner = (Spinner) findViewById(R.id.sm_spinner2);
        Spinner smtypespinner = (Spinner) findViewById(R.id.sm_spinner3);


        ArrayAdapter<String> smdataAdapter1 = new ArrayAdapter<String>(Study_Material.this, android.R.layout.simple_spinner_item, smbranches);
        smdataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        smbranchspinner.setAdapter(smdataAdapter1);
        smbranchspinner.setOnItemSelectedListener(this);

        //spinner 2


        ArrayAdapter<String> smdataAdapter2 = new ArrayAdapter<>(Study_Material.this, android.R.layout.simple_spinner_item, smsemester);
        smdataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        smsemspinner.setAdapter(smdataAdapter2);
        smsemspinner.setOnItemSelectedListener(this);

        //spinner 3
        ArrayAdapter<String> smdataAdapter3 = new ArrayAdapter<>(Study_Material.this, android.R.layout.simple_spinner_item, smtype);
        smdataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        smtypespinner.setAdapter(smdataAdapter3);
        smtypespinner.setOnItemSelectedListener(this);

        smbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(smitem1==0 || smitem2==0 || smitem3==0){
                    Toast.makeText(Study_Material.this, "Please Select Appropriate Choices..", Toast.LENGTH_SHORT).show();
                }else{
                    smgetpdffile();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner smspin1 = (Spinner) parent;
        Spinner smspin2 = (Spinner) parent;
        Spinner smspin3 = (Spinner) parent;
        if (smspin1.getId() == R.id.smspinner) {

            if (position ==0 ) {
                smitem1 = 0;
            }  if (position == 1) {
                smitem1 = 1;
            }  if (position == 2) {
                smitem1 = 2;
            } if (position == 3) {
                smitem1 = 3;
            }  if (position == 4) {
                smitem1 = 4;
            }  if (position == 5) {
                smitem1 = 5;
            }  if (position == 6) {
                smitem1 = 6;
            }
        }
        if ((smspin2.getId() == R.id.sm_spinner2)) {
            if (position == 0) {
                smitem2 = 0;
            }
            if (position == 1) {
                smitem2 = 1;
            }
            if (position == 2) {
                smitem2 = 2;
            }
            if (position == 3) {
                smitem2 = 3;
            } else if (position == 4) {
                smitem2 = 4;
            } else if (position == 5) {
                smitem2 = 5;
            } else if (position == 6) {
                smitem2 = 6;
            } else if (position == 7) {
                smitem2 = 7;
            } else if (position == 8) {
                smitem2 = 8;
            }
        }
            if (smspin3.getId() == R.id.sm_spinner3) {
                if (position == 0) {
                    smitem3 = 0;
                }   if (position == 1) {
                    smitem3 = 1;
                }  if (position == 2) {
                    smitem3 = 2;
                }  if (position == 3) {
                    smitem3 = 3;
                } else if (position == 4) {
                    smitem3 = 4;
                } else if (position == 5) {
                    smitem3 = 5;
                } else if (position == 6) {
                    smitem3 = 6;
                }
            }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null &&data.getData()!=null){
            smuploadfile(data.getData());
        }


    }

    private void smuploadfile(Uri data) {

        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Uploading");
        progressDialog.show();
      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


        StorageReference smreference=smstoragerefernce.child("Study_Material/"+smtitle.getText()+System.currentTimeMillis()+".pdf");
        smreference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Task<Uri> uri=taskSnapshot.getStorage().getDownloadUrl();
                while(!uri.isComplete());
                Uri url=uri.getResult();
                sm_upload_model smuploads=new sm_upload_model(smtitle.getText().toString(),url.toString());
                if(smitem1==1 && (smitem2==1) &&(smitem3==1)){
                    smdtabasereference=FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem1").child("books");
                } if(smitem1==1&&(smitem2==2)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-2").child("books");
                }if(smitem1==1&&(smitem2==3)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-3").child("books");
                }if(smitem1==1&&(smitem2==4)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-4").child("books");
                }if(smitem1==1&&(smitem2==5)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-5").child("books");
                }if(smitem1==1&&(smitem2==6)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-6").child("books");
                }if(smitem1==1&&(smitem2==7)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-7").child("books");
                }if(smitem1==1&&(smitem2==8)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-8").child("books");
                }//
                 if(smitem1==1&&(smitem2==1)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-1").child("notes");
                }if(smitem1==1&&(smitem2==2)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-2").child("notes");
                }if(smitem1==1&&(smitem2==3)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-3").child("notes");
                }if(smitem1==1&&(smitem2==4)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-4").child("notes");
                }if(smitem1==1&&(smitem2==5)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-5").child("notes");
                }if(smitem1==1&&(smitem2==6)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-6").child("notes");
                }if(smitem1==1&&(smitem2==7)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-7").child("notes");
                }if(smitem1==1&&(smitem2==8)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-8").child("notes");
                }//
                if(smitem1==1&&(smitem2==1)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-1").child("papers");
                }if(smitem1==1&&(smitem2==2)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-2").child("papers");
                }if(smitem1==1&&(smitem2==3)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-3").child("papers");
                }if(smitem1==1&&(smitem2==4)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-4").child("papers");
                }if(smitem1==1&&(smitem2==5)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-5").child("papers");
                }if(smitem1==1&&(smitem2==6)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-6").child("papers");
                }if(smitem1==1&&(smitem2==7)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-7").child("papers");
                }if(smitem1==1&&(smitem2==8)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-8").child("papers");
                }//
                if(smitem1==1&&(smitem2==1)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-1").child("practicals");
                }if(smitem1==1&&(smitem2==2)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-2").child("practicals");
                }if(smitem1==1&&(smitem2==3)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-3").child("practicals");
                }if(smitem1==1&&(smitem2==4)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-4").child("practicals");
                }if(smitem1==1&&(smitem2==5)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-5").child("practicals");
                }if(smitem1==1&&(smitem2==6)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-6").child("practicals");
                }if(smitem1==1&&(smitem2==7)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-7").child("practicals");
                }if(smitem1==1&&(smitem2==8)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-8").child("practicals");
                }//
                if(smitem1==1&&(smitem2==1)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-1").child("assignment");
                }if(smitem1==1&&(smitem2==2)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-2").child("assignment");
                }if(smitem1==1&&(smitem2==3)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-3").child("assignment");
                }if(smitem1==1&&(smitem2==4)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-4").child("assignment");
                }if(smitem1==1&&(smitem2==5)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-5").child("assignment");
                }if(smitem1==1&&(smitem2==6)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-6").child("assignment");
                }if(smitem1==1&&(smitem2==7)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-7").child("assignment");
                }if(smitem1==1&&(smitem2==8)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-8").child("assignment");
                }//
                if(smitem1==1&&(smitem2==1)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-1").child("others");
                }if(smitem1==1&&(smitem2==2)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-2").child("others");
                }if(smitem1==1&&(smitem2==3)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-3").child("others");
                }if(smitem1==1&&(smitem2==4)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-4").child("others");
                }if(smitem1==1&&(smitem2==5)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-5").child("others");
                }if(smitem1==1&&(smitem2==6)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-6").child("others");
                }if(smitem1==1&&(smitem2==7)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-7").child("others");
                }if(smitem1==1&&(smitem2==8)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("cs").child("sem-8").child("others");
                }//
                //
                //
                if(smitem1==2 && (smitem2==1) &&(smitem3==1)){
                    smdtabasereference=FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem1").child("books");
                } if(smitem1==2&&(smitem2==2)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-2").child("books");
                }if(smitem1==2&&(smitem2==3)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-3").child("books");
                }if(smitem1==2&&(smitem2==4)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-4").child("books");
                }if(smitem1==2&&(smitem2==5)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-5").child("books");
                }if(smitem1==2&&(smitem2==6)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-6").child("books");
                }if(smitem1==2&&(smitem2==7)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-7").child("books");
                }if(smitem1==2&&(smitem2==8)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-8").child("books");
                }//
                if(smitem1==2&&(smitem2==1)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-1").child("notes");
                }if(smitem1==2&&(smitem2==2)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-2").child("notes");
                }if(smitem1==2&&(smitem2==3)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-3").child("notes");
                }if(smitem1==2&&(smitem2==4)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-4").child("notes");
                }if(smitem1==2&&(smitem2==5)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-5").child("notes");
                }if(smitem1==2&&(smitem2==6)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-6").child("notes");
                }if(smitem1==2&&(smitem2==7)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-7").child("notes");
                }if(smitem1==2&&(smitem2==8)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-8").child("notes");
                }//
                if(smitem1==2&&(smitem2==1)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-1").child("papers");
                }if(smitem1==2&&(smitem2==2)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-2").child("papers");
                }if(smitem1==2&&(smitem2==3)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-3").child("papers");
                }if(smitem1==2&&(smitem2==4)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-4").child("papers");
                }if(smitem1==2&&(smitem2==5)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-5").child("papers");
                }if(smitem1==2&&(smitem2==6)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-6").child("papers");
                }if(smitem1==2&&(smitem2==7)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-7").child("papers");
                }if(smitem1==2&&(smitem2==8)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-8").child("papers");
                }//
                if(smitem1==2&&(smitem2==1)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-1").child("practicals");
                }if(smitem1==2&&(smitem2==2)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-2").child("practicals");
                }if(smitem1==2&&(smitem2==3)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-3").child("practicals");
                }if(smitem1==2&&(smitem2==4)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-4").child("practicals");
                }if(smitem1==2&&(smitem2==5)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-5").child("practicals");
                }if(smitem1==2&&(smitem2==6)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-6").child("practicals");
                }if(smitem1==2&&(smitem2==7)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-7").child("practicals");
                }if(smitem1==2&&(smitem2==8)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-8").child("practicals");
                }//
                if(smitem1==2&&(smitem2==1)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-1").child("assignment");
                }if(smitem1==2&&(smitem2==2)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-2").child("assignment");
                }if(smitem1==2&&(smitem2==3)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-3").child("assignment");
                }if(smitem1==2&&(smitem2==4)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-4").child("assignment");
                }if(smitem1==2&&(smitem2==5)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-5").child("assignment");
                }if(smitem1==2&&(smitem2==6)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-6").child("assignment");
                }if(smitem1==2&&(smitem2==7)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-7").child("assignment");
                }if(smitem1==2&&(smitem2==8)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-8").child("assignment");
                }//
                if(smitem1==2&&(smitem2==1)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-1").child("others");
                }if(smitem1==2&&(smitem2==2)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-2").child("others");
                }if(smitem1==2&&(smitem2==3)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-3").child("others");
                }if(smitem1==2&&(smitem2==4)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-4").child("others");
                }if(smitem1==2&&(smitem2==5)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-5").child("others");
                }if(smitem1==2&&(smitem2==6)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-6").child("others");
                }if(smitem1==2&&(smitem2==7)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-7").child("others");
                }if(smitem1==2&&(smitem2==8)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("IT").child("sem-8").child("others");
                }//
                //
                //
                if(smitem1==3 && (smitem2==1) &&(smitem3==1)){
                    smdtabasereference=FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem1").child("books");
                } if(smitem1==3&&(smitem2==2)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-2").child("books");
                }if(smitem1==3&&(smitem2==3)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-3").child("books");
                }if(smitem1==3&&(smitem2==4)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-4").child("books");
                }if(smitem1==3&&(smitem2==5)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-5").child("books");
                }if(smitem1==3&&(smitem2==6)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-6").child("books");
                }if(smitem1==3&&(smitem2==7)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-7").child("books");
                }if(smitem1==3&&(smitem2==8)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-8").child("books");
                }//
                if(smitem1==3&&(smitem2==1)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-1").child("notes");
                }if(smitem1==3&&(smitem2==2)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-2").child("notes");
                }if(smitem1==3&&(smitem2==3)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-3").child("notes");
                }if(smitem1==3&&(smitem2==4)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-4").child("notes");
                }if(smitem1==3&&(smitem2==5)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-5").child("notes");
                }if(smitem1==3&&(smitem2==6)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-6").child("notes");
                }if(smitem1==3&&(smitem2==7)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-7").child("notes");
                }if(smitem1==3&&(smitem2==8)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-8").child("notes");
                }//
                if(smitem1==3&&(smitem2==1)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-1").child("papers");
                }if(smitem1==3&&(smitem2==2)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-2").child("papers");
                }if(smitem1==3&&(smitem2==3)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-3").child("papers");
                }if(smitem1==3&&(smitem2==4)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-4").child("papers");
                }if(smitem1==3&&(smitem2==5)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-5").child("papers");
                }if(smitem1==3&&(smitem2==6)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-6").child("papers");
                }if(smitem1==3&&(smitem2==7)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-7").child("papers");
                }if(smitem1==3&&(smitem2==8)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-8").child("papers");
                }//
                if(smitem1==3&&(smitem2==1)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-1").child("practicals");
                }if(smitem1==3&&(smitem2==2)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-2").child("practicals");
                }if(smitem1==3&&(smitem2==3)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-3").child("practicals");
                }if(smitem1==3&&(smitem2==4)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-4").child("practicals");
                }if(smitem1==3&&(smitem2==5)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-5").child("practicals");
                }if(smitem1==3&&(smitem2==6)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-6").child("practicals");
                }if(smitem1==3&&(smitem2==7)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-7").child("practicals");
                }if(smitem1==3&&(smitem2==8)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-8").child("practicals");
                }//
                if(smitem1==3&&(smitem2==1)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-1").child("assignment");
                }if(smitem1==3&&(smitem2==2)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-2").child("assignment");
                }if(smitem1==3&&(smitem2==3)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-3").child("assignment");
                }if(smitem1==3&&(smitem2==4)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-4").child("assignment");
                }if(smitem1==3&&(smitem2==5)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-5").child("assignment");
                }if(smitem1==3&&(smitem2==6)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-6").child("assignment");
                }if(smitem1==3&&(smitem2==7)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-7").child("assignment");
                }if(smitem1==3&&(smitem2==8)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-8").child("assignment");
                }//
                if(smitem1==3&&(smitem2==1)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-1").child("others");
                }if(smitem1==3&&(smitem2==2)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-2").child("others");
                }if(smitem1==3&&(smitem2==3)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-3").child("others");
                }if(smitem1==3&&(smitem2==4)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-4").child("others");
                }if(smitem1==3&&(smitem2==5)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-5").child("others");
                }if(smitem1==3&&(smitem2==6)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-6").child("others");
                }if(smitem1==3&&(smitem2==7)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-7").child("others");
                }if(smitem1==3&&(smitem2==8)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("etc").child("sem-8").child("others");
                }//
                //
                //
                if(smitem1==4 && (smitem2==1) &&(smitem3==1)){
                    smdtabasereference=FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem1").child("books");
                } if(smitem1==4&&(smitem2==2)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-2").child("books");
                }if(smitem1==4&&(smitem2==3)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-3").child("books");
                }if(smitem1==4&&(smitem2==4)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-4").child("books");
                }if(smitem1==4&&(smitem2==5)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-5").child("books");
                }if(smitem1==4&&(smitem2==6)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-6").child("books");
                }if(smitem1==4&&(smitem2==7)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-7").child("books");
                }if(smitem1==4&&(smitem2==8)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-8").child("books");
                }//
                if(smitem1==4&&(smitem2==1)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-1").child("notes");
                }if(smitem1==4&&(smitem2==2)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-2").child("notes");
                }if(smitem1==4&&(smitem2==3)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-3").child("notes");
                }if(smitem1==4&&(smitem2==4)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-4").child("notes");
                }if(smitem1==4&&(smitem2==5)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-5").child("notes");
                }if(smitem1==4&&(smitem2==6)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-6").child("notes");
                }if(smitem1==4&&(smitem2==7)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-7").child("notes");
                }if(smitem1==4&&(smitem2==8)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-8").child("notes");
                }//
                if(smitem1==4&&(smitem2==1)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-1").child("papers");
                }if(smitem1==4&&(smitem2==2)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-2").child("papers");
                }if(smitem1==4&&(smitem2==3)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-3").child("papers");
                }if(smitem1==4&&(smitem2==4)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-4").child("papers");
                }if(smitem1==4&&(smitem2==5)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-5").child("papers");
                }if(smitem1==4&&(smitem2==6)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-6").child("papers");
                }if(smitem1==4&&(smitem2==7)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-7").child("papers");
                }if(smitem1==4&&(smitem2==8)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-8").child("papers");
                }//
                if(smitem1==4&&(smitem2==1)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-1").child("practicals");
                }if(smitem1==4&&(smitem2==2)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-2").child("practicals");
                }if(smitem1==4&&(smitem2==3)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-3").child("practicals");
                }if(smitem1==4&&(smitem2==4)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-4").child("practicals");
                }if(smitem1==4&&(smitem2==5)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-5").child("practicals");
                }if(smitem1==4&&(smitem2==6)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-6").child("practicals");
                }if(smitem1==4&&(smitem2==7)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-7").child("practicals");
                }if(smitem1==4&&(smitem2==8)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-8").child("practicals");
                }//
                if(smitem1==4&&(smitem2==1)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-1").child("assignment");
                }if(smitem1==4&&(smitem2==2)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-2").child("assignment");
                }if(smitem1==4&&(smitem2==3)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-3").child("assignment");
                }if(smitem1==4&&(smitem2==4)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-4").child("assignment");
                }if(smitem1==4&&(smitem2==5)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-5").child("assignment");
                }if(smitem1==4&&(smitem2==6)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-6").child("assignment");
                }if(smitem1==4&&(smitem2==7)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-7").child("assignment");
                }if(smitem1==4&&(smitem2==8)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-8").child("assignment");
                }//
                if(smitem1==4&&(smitem2==1)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-1").child("others");
                }if(smitem1==4&&(smitem2==2)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-2").child("others");
                }if(smitem1==4&&(smitem2==3)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-3").child("others");
                }if(smitem1==4&&(smitem2==4)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-4").child("others");
                }if(smitem1==4&&(smitem2==5)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-5").child("others");
                }if(smitem1==4&&(smitem2==6)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-6").child("others");
                }if(smitem1==4&&(smitem2==7)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-7").child("others");
                }if(smitem1==4&&(smitem2==8)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("ei").child("sem-8").child("others");
                }//
                //
                //
                if(smitem1==5 && (smitem2==1) &&(smitem3==1)){
                    smdtabasereference=FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem1").child("books");
                } if(smitem1==5&&(smitem2==2)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-2").child("books");
                }if(smitem1==5&&(smitem2==3)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-3").child("books");
                }if(smitem1==5&&(smitem2==4)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-4").child("books");
                }if(smitem1==5&&(smitem2==5)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-5").child("books");
                }if(smitem1==5&&(smitem2==6)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-6").child("books");
                }if(smitem1==5&&(smitem2==7)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-7").child("books");
                }if(smitem1==5&&(smitem2==8)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-8").child("books");
                }//
                if(smitem1==5&&(smitem2==1)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-1").child("notes");
                }if(smitem1==5&&(smitem2==2)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-2").child("notes");
                }if(smitem1==5&&(smitem2==3)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-3").child("notes");
                }if(smitem1==5&&(smitem2==4)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-4").child("notes");
                }if(smitem1==5&&(smitem2==5)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-5").child("notes");
                }if(smitem1==5&&(smitem2==6)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-6").child("notes");
                }if(smitem1==5&&(smitem2==7)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-7").child("notes");
                }if(smitem1==5&&(smitem2==8)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-8").child("notes");
                }//
                if(smitem1==5&&(smitem2==1)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-1").child("papers");
                }if(smitem1==5&&(smitem2==2)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-2").child("papers");
                }if(smitem1==5&&(smitem2==3)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-3").child("papers");
                }if(smitem1==5&&(smitem2==4)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-4").child("papers");
                }if(smitem1==5&&(smitem2==5)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-5").child("papers");
                }if(smitem1==5&&(smitem2==6)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-6").child("papers");
                }if(smitem1==5&&(smitem2==7)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-7").child("papers");
                }if(smitem1==5&&(smitem2==8)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-8").child("papers");
                }//
                if(smitem1==5&&(smitem2==1)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-1").child("practicals");
                }if(smitem1==5&&(smitem2==2)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-2").child("practicals");
                }if(smitem1==5&&(smitem2==3)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-3").child("practicals");
                }if(smitem1==5&&(smitem2==4)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-4").child("practicals");
                }if(smitem1==5&&(smitem2==5)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-5").child("practicals");
                }if(smitem1==5&&(smitem2==6)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-6").child("practicals");
                }if(smitem1==5&&(smitem2==7)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-7").child("practicals");
                }if(smitem1==5&&(smitem2==8)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-8").child("practicals");
                }//
                if(smitem1==5&&(smitem2==1)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-1").child("assignment");
                }if(smitem1==5&&(smitem2==2)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-2").child("assignment");
                }if(smitem1==5&&(smitem2==3)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-3").child("assignment");
                }if(smitem1==5&&(smitem2==4)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-4").child("assignment");
                }if(smitem1==5&&(smitem2==5)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-5").child("assignment");
                }if(smitem1==5&&(smitem2==6)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-6").child("assignment");
                }if(smitem1==5&&(smitem2==7)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-7").child("assignment");
                }if(smitem1==5&&(smitem2==8)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-8").child("assignment");
                }//
                if(smitem1==5&&(smitem2==1)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-1").child("others");
                }if(smitem1==5&&(smitem2==2)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-2").child("others");
                }if(smitem1==5&&(smitem2==3)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-3").child("others");
                }if(smitem1==5&&(smitem2==4)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-4").child("others");
                }if(smitem1==5&&(smitem2==5)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-5").child("others");
                }if(smitem1==5&&(smitem2==6)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-6").child("others");
                }if(smitem1==5&&(smitem2==7)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-7").child("others");
                }if(smitem1==5&&(smitem2==8)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("mech").child("sem-8").child("others");
                }//
                //
                //
                if(smitem1==6 && (smitem2==1) &&(smitem3==1)){
                    smdtabasereference=FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem1").child("books");
                } if(smitem1==6&(smitem2==2)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-2").child("books");
                }if(smitem1==6&&(smitem2==3)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-3").child("books");
                }if(smitem1==6&&(smitem2==4)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-4").child("books");
                }if(smitem1==6&&(smitem2==5)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-5").child("books");
                }if(smitem1==6&&(smitem2==6)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-6").child("books");
                }if(smitem1==6&&(smitem2==7)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-7").child("books");
                }if(smitem1==6&&(smitem2==8)&&(smitem3==1)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-8").child("books");
                }//
                if(smitem1==6&&(smitem2==1)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-1").child("notes");
                }if(smitem1==6&&(smitem2==2)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-2").child("notes");
                }if(smitem1==6&&(smitem2==3)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-3").child("notes");
                }if(smitem1==6&&(smitem2==4)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-4").child("notes");
                }if(smitem1==6&&(smitem2==5)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-5").child("notes");
                }if(smitem1==6&&(smitem2==6)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-6").child("notes");
                }if(smitem1==6&&(smitem2==7)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-7").child("notes");
                }if(smitem1==6&&(smitem2==8)&&(smitem3==2)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-8").child("notes");
                }//
                if(smitem1==6&&(smitem2==1)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-1").child("papers");
                }if(smitem1==6&&(smitem2==2)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-2").child("papers");
                }if(smitem1==6&&(smitem2==3)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-3").child("papers");
                }if(smitem1==6&&(smitem2==4)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-4").child("papers");
                }if(smitem1==6&&(smitem2==5)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-5").child("papers");
                }if(smitem1==6&&(smitem2==6)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-6").child("papers");
                }if(smitem1==6&&(smitem2==7)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-7").child("papers");
                }if(smitem1==6&&(smitem2==8)&&(smitem3==3)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-8").child("papers");
                }//
                if(smitem1==6&&(smitem2==1)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-1").child("practicals");
                }if(smitem1==6&&(smitem2==2)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-2").child("practicals");
                }if(smitem1==6&&(smitem2==3)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-3").child("practicals");
                }if(smitem1==6&&(smitem2==4)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-4").child("practicals");
                }if(smitem1==6&&(smitem2==5)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-5").child("practicals");
                }if(smitem1==6&&(smitem2==6)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-6").child("practicals");
                }if(smitem1==6&&(smitem2==7)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-7").child("practicals");
                }if(smitem1==6&&(smitem2==8)&&(smitem3==4)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-8").child("practicals");
                }//
                if(smitem1==6&&(smitem2==1)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-1").child("assignment");
                }if(smitem1==6&&(smitem2==2)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-2").child("assignment");
                }if(smitem1==6&&(smitem2==3)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-3").child("assignment");
                }if(smitem1==6&&(smitem2==4)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-4").child("assignment");
                }if(smitem1==6&&(smitem2==5)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-5").child("assignment");
                }if(smitem1==6&&(smitem2==6)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-6").child("assignment");
                }if(smitem1==6&&(smitem2==7)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-7").child("assignment");
                }if(smitem1==6&&(smitem2==8)&&(smitem3==5)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-8").child("assignment");
                }//
                if(smitem1==6&&(smitem2==1)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-1").child("others");
                }if(smitem1==6&&(smitem2==2)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-2").child("others");
                }if(smitem1==6&&(smitem2==3)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-3").child("others");
                }if(smitem1==6&&(smitem2==4)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-4").child("others");
                }if(smitem1==6&&(smitem2==5)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-5").child("others");
                }if(smitem1==6&&(smitem2==6)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-6").child("others");
                }if(smitem1==6&&(smitem2==7)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-7").child("others");
                }if(smitem1==6&&(smitem2==8)&&(smitem3==6)) {
                    smdtabasereference = FirebaseDatabase.getInstance().getReference().child("study_material").child("civil").child("sem-8").child("others");
                }//
                //
                //

                smdtabasereference.child(smdtabasereference.push().getKey()).setValue(smuploads);
                Toast.makeText(Study_Material.this, "File Uploaded", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress=(100* taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                progressDialog.setMessage("Uploaded: "+(int)progress+"%");


            }
        });

    }
    private void smgetpdffile() {

        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select PDF"),1);
    }

    public void umploadmage(View view) {
        Intent i=new Intent (Study_Material.this, cont_image_activity.class);
        startActivity(i);
    }
}
