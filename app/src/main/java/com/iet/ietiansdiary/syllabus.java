package com.iet.ietiansdiary;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.iet.ietiansdiary.log.logout;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class syllabus extends Fragment implements AdapterView.OnItemSelectedListener {



    public syllabus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_syllabus, container, false);
        Button btnview =(Button)view.findViewById(R.id.VIEW);
        Button btn=(Button) view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), logout.class));
            }
        });
        List<String> categories = new ArrayList<String>();
        categories.add("None");
        categories.add("Computer Engineering ");
        categories.add("Information Technology");
        categories.add("Electronics & Telecommunication");
        categories.add("Electronics & Instrumentation");
        categories.add("Mechanical Engineering");
        categories.add("Civil Engineering");

        Spinner spin = (Spinner) view.findViewById(R.id.view_spinner1);
        spin.setOnItemSelectedListener(this);
        // Inflate the layout for this fragment
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(dataAdapter);
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),view_pdf.class);
                startActivity(intent);
            }
        });


        return view;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
            if(position==1){
                Intent intent=new Intent(getContext(),cs.class);
                startActivity(intent);

            }
        // Showing selected spinner item
       // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }


}

