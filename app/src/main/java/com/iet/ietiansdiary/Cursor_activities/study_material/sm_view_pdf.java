package com.iet.ietiansdiary.Cursor_activities.study_material;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.iet.ietiansdiary.R;

import java.util.ArrayList;
import java.util.List;

public class sm_view_pdf extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static int vspin1=0, vspin2=0,vspin3=0;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sm_view_pdf);
        MobileAds.initialize(this,"ca-app-pub-6028758234054822~8044560729");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        List<String> vsmbranches = new ArrayList<>();
        vsmbranches.add("None");
        vsmbranches.add("Computer Engineering ");
        vsmbranches.add("Information Technology");
        vsmbranches.add("Electronics & Telecommunication");
        vsmbranches.add("Electronics & Instrumentation");
        vsmbranches.add("Mechanical Engineering");
        vsmbranches.add("Civil Engineering");



        List<String> vsmsemester = new ArrayList<>();
        vsmsemester.add("None");
        vsmsemester.add("SEM-1");
        vsmsemester.add("SEM-2");
        vsmsemester.add("SEM-3");
        vsmsemester.add("SEM-4");
        vsmsemester.add("SEM-5");
        vsmsemester.add("SEM-6");
        vsmsemester.add("SEM-7");
        vsmsemester.add("SEM-8");

        List<String> vsmtype = new ArrayList<>();
        vsmtype.add("None");
        vsmtype.add("Books");
        vsmtype.add("Notes");
        vsmtype.add("Papers");
        vsmtype.add("Practicals");
        vsmtype.add("Assignments");
        vsmtype.add("Others");

        Spinner spinner1=(Spinner) findViewById(R.id.vsmspinner1);
        Spinner spinner2=(Spinner) findViewById(R.id.vsm_spinner2);
        Spinner spinner3=(Spinner) findViewById(R.id.vsm_spinner3);


        ArrayAdapter<String> vsmdataAdapter1 = new ArrayAdapter<String>(sm_view_pdf.this, android.R.layout.simple_spinner_item, vsmbranches);
        vsmdataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner1.setAdapter(vsmdataAdapter1);
        spinner1.setOnItemSelectedListener(this);

        ArrayAdapter<String> vsmdataAdapter2 = new ArrayAdapter<String>(sm_view_pdf.this, android.R.layout.simple_spinner_item, vsmsemester);
        vsmdataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner2.setAdapter(vsmdataAdapter2);
        spinner2.setOnItemSelectedListener(this);

        ArrayAdapter<String> vsmdataAdapter3 = new ArrayAdapter<String>(sm_view_pdf.this, android.R.layout.simple_spinner_item, vsmtype);
        vsmdataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner3.setAdapter(vsmdataAdapter3);
        spinner3.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner vsmspin1 = (Spinner) parent;
        Spinner vsmspin2 = (Spinner) parent;
        Spinner vsmspin3 = (Spinner) parent;

        if (vsmspin1.getId() == R.id.vsmspinner1) {
            if (position == 0) {
                vspin1 = 0;
            }
            if (position == 1) {
                vspin1 = 1;
            }
            if (position == 2) {
                vspin1 = 2;
            }
            if (position == 3) {
                vspin1 = 3;
            }
            if (position == 4) {
                vspin1 = 4;
            }
            if (position == 5) {
                vspin1 = 5;
            }
            if (position == 6) {
                vspin1 = 6;
            }

        }
        if (vsmspin2.getId() == R.id.vsm_spinner2) {
            if (position == 0) {
                vspin2 = 0;
            }
            if (position == 1) {
                vspin2 = 1;
            }
            if (position == 2) {
                vspin2 = 2;
            }
            if (position == 3) {
                vspin2 = 3;
            }
            if (position == 4) {
                vspin2 = 4;
            }
            if (position == 5) {
                vspin2 = 5;
            }
            if (position == 6) {
                vspin2 = 6;
            }
            if (position == 7) {
                vspin2 = 7;
            }
            if (position == 8) {
                vspin2 = 8;
            }
        }
        if (vsmspin3.getId() == R.id.vsm_spinner3) {
            if (position == 0) {
                vspin1 = 0;
            }
            if (position == 1) {
                vspin3 = 1;
            }
            if (position == 2) {
                vspin3 = 2;
            }
            if (position == 3) {
                vspin3 = 3;
            }
            if (position == 4) {
                vspin3 = 4;
            }
            if (position == 5) {
                vspin3 = 5;
            }
            if (position == 6) {
                vspin3 = 6;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void viewmaterial(View view) {

        if(vspin3==1){
            Toast.makeText(this, "Books may take longer to load when you open them... keep patience or download them", Toast.LENGTH_LONG).show();
          //  Snackbar.make(,"Books may take longer to load when you open them... keep patience or download them",Snackbar.LENGTH_LONG).setActionTextColor(getResources().getColor(android.R.color.white)).show();
            Intent intent=new Intent(sm_view_pdf.this,sm_view_activity.class);
            startActivity(intent);
        }

            Intent intent=new Intent(sm_view_pdf.this,sm_view_activity.class);
            startActivity(intent);




    }
}
