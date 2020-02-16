package com.iet.ietiansdiary;

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

import com.iet.ietiansdiary.Cursor_activities.Syllabus;
import com.iet.ietiansdiary.Cursor_activities.notice.Notices;
import com.iet.ietiansdiary.navigation_activities.developers.clubs.clubs_input;
import com.iet.ietiansdiary.navigation_activities.developers.dev_image_upload;
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

public class upld extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText uet;
    Button ubtn;
    private DatabaseReference firebaseDatabase;
    private StorageReference firebaseStorage;
    public  int item=0,item2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upld);
        uet=(EditText) findViewById(R.id.uploadtitle);
        ubtn=(Button)findViewById(R.id.upl);
        ubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(item==0 || item2==0){
                    Toast.makeText(upld.this, "Please Select Appropriate Choice..", Toast.LENGTH_SHORT).show();
                }else{
                    getpdffile();
                }

            }
        });
        firebaseStorage= FirebaseStorage.getInstance().getReference();
        firebaseDatabase=FirebaseDatabase.getInstance().getReference("Syllabi");


        List<String> branches=new ArrayList<>();
        branches.add("None");
        branches.add("Computer Engineering ");
        branches.add("Information Technology");
        branches.add("Electronics & Telecommunication");
        branches.add("Electronics & Instrumentation");
        branches.add("Mechanical Engineering");
        branches.add("Civil Engineering");

        List<String>semester=new ArrayList<>();
        semester.add("None");
        semester.add("SEM-1");
        semester.add("SEM-2");
        semester.add("SEM-3");
        semester.add("SEM-4");
        semester.add("SEM-5");
        semester.add("SEM-6");
        semester.add("SEM-7");
        semester.add("SEM-8");

        //spinner 1
        Spinner upspinner=(Spinner)findViewById(R.id.uspinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(upld.this, android.R.layout.simple_spinner_item, branches);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        upspinner.setAdapter(dataAdapter);
        upspinner.setOnItemSelectedListener(this);

        //spinner 2

        Spinner upspinner2=(Spinner) findViewById(R.id.uspinner2);
        ArrayAdapter<String> dataAdapter2=new ArrayAdapter<>(upld.this,android.R.layout.simple_spinner_item,semester);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        upspinner2.setAdapter(dataAdapter2);
        upspinner2.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spin=(Spinner)parent;
        Spinner spin2=(Spinner)parent;
        if(spin.getId()==R.id.uspinner) {

            if (position == 1) {
                item = 1;
            }
            if (position == 2) {
                item = 2;
            }
            if (position == 3) {
                item = 3;
            }
            if (position == 4) {
                item = 4;
            }
            if (position == 5) {
                item = 5;
            }
            if (position == 6) {
                item = 6;
            }
        }
        if(spin2.getId()==R.id.uspinner2){

            if (position == 1) {
                item2 = 1;
            }
            if (position == 2) {
                item2 = 2;
            }
            if (position == 3) {
                item2 = 3;
            }
            if (position == 4) {
                item2 = 4;
            }
            if (position == 5) {
                item2 = 5;
            }
            if (position == 6) {
                item2 = 6;
            }
            if (position == 7) {
                item2 = 7;
            }
            if (position == 8) {
                item2 = 8;
            }



        }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null &&data.getData()!=null){
            uploadfile(data.getData());
        }


    }

    private void uploadfile(Uri data) {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Uploading");
        progressDialog.show();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


        StorageReference reference=firebaseStorage.child("Syllabus/"+uet.getText()+System.currentTimeMillis()+".pdf");
        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uri=taskSnapshot.getStorage().getDownloadUrl();
                while(!uri.isComplete());
                Uri url=uri.getResult();
                uploadSyllabi uploads=new uploadSyllabi(uet.getText().toString(),url.toString());
                if(item==1&&(item2==1)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("cs").child("sem-1");
                }else if(item==1&&(item2==2)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("cs").child("sem-2");
                }else if(item==1&&(item2==3)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("cs").child("sem-3");
                }else if(item==1&&(item2==4)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("cs").child("sem-4");
                }else if(item==1&&(item2==5)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("cs").child("sem-5");
                }else if(item==1&&(item2==6)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("cs").child("sem-6");
                }else if(item==1&&(item2==7)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("cs").child("sem-7");
                }else if(item==1&&(item2==8)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("cs").child("sem-8");
                }

                else if(item==2&&(item2==1)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("IT").child("sem-1");
                }else if(item==2&&(item2==2)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("IT").child("sem-2");
                }else if(item==2&&(item2==3)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("IT").child("sem-3");
                }else if(item==2&&(item2==4)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("IT").child("sem-4");
                }else if(item==2&&(item2==5)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("IT").child("sem-5");
                }else if(item==2&&(item2==6)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("IT").child("sem-6");
                }else if(item==2&&(item2==7)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("IT").child("sem-7");
                }else if(item==2&&(item2==8)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("IT").child("sem-8");
                }

                else if(item==3&&(item2==1)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("etc").child("sem-1");
                }else if(item==3&&(item2==2)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("etc").child("sem-2");
                }else if(item==3&&(item2==3)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("etc").child("sem-3");
                }else if(item==3&&(item2==4)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("etc").child("sem-4");
                }else if(item==3&&(item2==5)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("etc").child("sem-5");
                }else if(item==3&&(item2==6)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("etc").child("sem-6");
                }else if(item==3&&(item2==7)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("etc").child("sem-7");
                }else if(item==3&&(item2==8)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("etc").child("sem-8");
                }

                else if(item==4&&(item2==1)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("ei").child("sem-1");
                }else if(item==4&&(item2==2)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("ei").child("sem-2");
                }else if(item==4&&(item2==3)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("ei").child("sem-3");
                }else if(item==4&&(item2==4)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("ei").child("sem-4");
                }else if(item==4&&(item2==5)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("ei").child("sem-5");
                }else if(item==4&&(item2==6)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("ei").child("sem-6");
                }else if(item==4&&(item2==7)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("ei").child("sem-7");
                }else if(item==4&&(item2==8)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("ei").child("sem-8");
                }

                else if(item==5&&(item2==1)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("mech").child("sem-1");
                }else if(item==5&&(item2==2)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("mech").child("sem-2");
                }else if(item==5&&(item2==3)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("mech").child("sem-3");
                }else if(item==5&&(item2==4)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("mech").child("sem-4");
                }else if(item==5&&(item2==5)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("mech").child("sem-5");
                }else if(item==5&&(item2==6)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("mech").child("sem-6");
                }else if(item==5&&(item2==7)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("mech").child("sem-7");
                }else if(item==5&&(item2==8)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("mech").child("sem-8");
                }

                else if(item==6&&(item2==1)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("civil").child("sem-1");
                }else if(item==6&&(item2==2)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("civil").child("sem-2");
                }else if(item==6&&(item2==3)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("civil").child("sem-3");
                }else if(item==6&&(item2==4)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("civil").child("sem-4");
                }else if(item==6&&(item2==5)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("civil").child("sem-5");
                }else if(item==6&&(item2==6)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("civil").child("sem-6");
                }else if(item==6&&(item2==7)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("civil").child("sem-7");
                }else if(item==6&&(item2==8)) {
                    firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Syllabi").child("civil").child("sem-8");
                }



                firebaseDatabase.child(firebaseDatabase.push().getKey()).setValue(uploads);
                Toast.makeText(upld.this, "File Uploaded", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress=(100* taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setMessage("Uploaded: "+(int)progress+"%");
            }
        });



    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void getpdffile() {

        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select PDF"),1);
    }


    public void view(View view) {
        Intent intent=new Intent(upld.this, Syllabus.class);
        startActivity(intent);
    }


    public void developers_profile(View view) {
        startActivity(new Intent(upld.this, dev_image_upload.class));
        finish();
    }

    public void club(View view) {
        startActivity(new Intent(upld.this, clubs_input.class));
        finish();
    }

    public void notice(View view) {
        startActivity(new Intent(upld.this, Notices.class));
        finish();
    }
}
