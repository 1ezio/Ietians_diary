package com.iet.ietiansdiary;

import android.support.v7.app.AppCompatActivity;

public class dupload extends AppCompatActivity {

   /* EditText et1;
    Button bt1;
    StorageReference storageReference;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dupload);
        et1=(EditText)findViewById(R.id.sn);
        bt1=(Button)findViewById(R.id.sbu);
        storageReference= FirebaseStorage.getInstance().getReference();
        databaseReference=FirebaseDatabase.getInstance().getReference("Syllabus");

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getpdffile();
            }
        });

    }

    private void getpdffile() {

        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select PDF"),1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null &&data.getData()!=null){
            uploadpdf(data.getData());
        }


    }

    private void uploadpdf(Uri data) {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("UpLoading");
        progressDialog.show();


        StorageReference reference=storageReference.child("Syllabus/"+System.currentTimeMillis()+".pdf");
        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uri=taskSnapshot.getStorage().getDownloadUrl();
                while(!uri.isComplete());
                Uri url=uri.getResult();
                uploadSyllabi uploads=new uploadSyllabi(et1.getText().toString(),url.toString());
                databaseReference.child(databaseReference.push().getKey()).setValue(uploads);
                Toast.makeText(dupload.this, "File Uploaded", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

             }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                Double progress=(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setMessage("Uploaded: "+(double)progress+"%");
            }
        });
    }

*/
}
