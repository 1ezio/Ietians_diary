package com.iet.ietiansdiary.Cursor_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.iet.ietiansdiary.R;
import com.iet.ietiansdiary.view_pdf;

import java.util.ArrayList;
import java.util.List;

public class Syllabus extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
   public static int vitem1=0,vitem2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

            List<String> Branch=new ArrayList<>();
            Branch.add("None");
        Branch.add("Computer Engineering ");
        Branch.add("Information Technology");
        Branch.add("Electronics & Telecommunication");
        Branch.add("Electronics & Instrumentation");
        Branch.add("Mechanical Engineering");
        Branch.add("Civil Engineering");

        List<String>sem=new ArrayList<>();
        sem.add("None");
        sem.add("SEM-1");
        sem.add("SEM-2");
        sem.add("SEM-3");
        sem.add("SEM-4");
        sem.add("SEM-5");
        sem.add("SEM-6");
        sem.add("SEM-7");
        sem.add("SEM-8");

        //spinner 1
        Spinner vspinner=(Spinner)findViewById(R.id.view_spinner1);
        ArrayAdapter<String> vdataAdapter = new ArrayAdapter<String>(Syllabus.this, android.R.layout.simple_spinner_item, Branch);
        vdataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        vspinner.setAdapter(vdataAdapter);
        vspinner.setOnItemSelectedListener(this);

        //spinner 2

        Spinner vspinner2=(Spinner) findViewById(R.id.view_spinner2);
        ArrayAdapter<String> vdataAdapter2=new ArrayAdapter<>(Syllabus.this,android.R.layout.simple_spinner_item,sem);
        vdataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vspinner2.setAdapter(vdataAdapter2);
        vspinner2.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner vspin=(Spinner)parent;
        Spinner vspin2=(Spinner)parent;
        if(vspin.getId()==R.id.view_spinner1){

            if (position == 1) {
                vitem1 = 1;
            }
            if (position == 2) {
                vitem1 = 2;
            }
            if (position == 3) {
                vitem1 = 3;
            }
            if (position == 4) {
                vitem1 = 4;
            }
            if (position == 5) {
                vitem1 = 5;
            }
            if (position == 6) {
                vitem1 = 6;
            }
        }
        if(vspin2.getId()==R.id.view_spinner2){

            if (position == 1) {
                vitem2 = 1;
            }
            if (position == 2) {
                vitem2 = 2;
            }
            if (position == 3) {
                vitem2 = 3;
            }
            if (position == 4) {
                vitem2 = 4;
            }
            if (position == 5) {
                vitem2 = 5;
            }
            if (position == 6) {
                vitem2 = 6;
            }
            if (position == 7) {
                vitem2 = 7;
            }
            if (position == 8) {
                vitem2 = 8;
            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
 public void view_file(View view){
        if(vitem1==0 || vitem2==0){
            Toast.makeText(this, "Select Appropriate Choice..", Toast.LENGTH_SHORT).show();
        }else{ Intent intent=new Intent(Syllabus.this, view_pdf.class);
           // Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
            startActivity(intent);}

 }


}

