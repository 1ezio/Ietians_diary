package com.iet.ietiansdiary.navigation_activities.developers.contributors;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.iet.ietiansdiary.R;
import com.iet.ietiansdiary.navigation_activities.developers.list_data;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class cont_image_activity extends AppCompatActivity {
    private Button cselectimg,cbtnUpload;
    private ImageView csimg;
    private EditText cetName;
    private static final int cPICK_IMAGE_REQUEST=1;
    private DatabaseReference cmdataref;
    private StorageReference cmstorageref;
    final int cIMAGE_REQUEST_CODE = 999;
    private ProgressBar cprogressBar;
    private Uri cmimguri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_image_activity);
        cselectimg = (Button) findViewById(R.id.cbtn_select);
        csimg = (ImageView) findViewById(R.id.cselekedimg);
        cbtnUpload = (Button) findViewById(R.id.cbtn_upload);
        cetName = (EditText) findViewById(R.id.cimg_name);
        cprogressBar = (ProgressBar) findViewById(R.id.cprogressbar);
        cmstorageref = FirebaseStorage.getInstance().getReference("cUploads");
        cmdataref = FirebaseDatabase.getInstance().getReference("cUploads");
        cbtnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cuploadImage();
                Toast.makeText(cont_image_activity.this, "Please wait..uploading..", Toast.LENGTH_SHORT).show();
            }
        });
        cselectimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ActivityCompat.requestPermissions(cont_image_activity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, cIMAGE_REQUEST_CODE);
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==cIMAGE_REQUEST_CODE){
            if (grantResults.length>0&& grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Intent intent=new Intent(new Intent(Intent.ACTION_PICK));
                intent.setType("image/*");

                startActivityForResult(Intent.createChooser(intent,"select image"),cIMAGE_REQUEST_CODE);

            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == cIMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            cmimguri = data.getData();
            Picasso.with(this).load(cmimguri).into(csimg);
        }
    }
    private String getFileExtensoin (Uri uri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap map = MimeTypeMap.getSingleton();
        return map.getExtensionFromMimeType(contentResolver.getType(uri));

    }

    private void cuploadImage() {
        if (cmimguri!=null){
            StorageReference storageReference=cmstorageref.child(System.currentTimeMillis()+"."+ getFileExtensoin(cmimguri));
            storageReference.putFile(cmimguri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    cprogressBar.setProgress(0);
                                }
                            },5000);
                            Toast.makeText(cont_image_activity.this,"Upload SuccsessFul",Toast.LENGTH_SHORT).show();
                            Task<Uri> uri=taskSnapshot.getStorage().getDownloadUrl();
                            while(!uri.isComplete());
                            Uri url=uri.getResult();
                            list_data list_data=new list_data(cetName.getText().toString().trim(),url.toString());
                            String uploadid=cmdataref.push().getKey();
                            cmdataref.child(uploadid).setValue(list_data);
                            startActivity(new Intent(cont_image_activity.this, contributors_activity.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double pr=(100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                    cprogressBar.setProgress((int) pr);

                }
            });
        }else {
            Toast.makeText(cont_image_activity.this,"File Not Selected", Toast.LENGTH_SHORT).show();
        }

    }
}
