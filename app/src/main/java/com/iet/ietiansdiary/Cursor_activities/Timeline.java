package com.iet.ietiansdiary.Cursor_activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iet.ietiansdiary.R;

import org.qap.ctimelineview.TimelineRow;
import org.qap.ctimelineview.TimelineViewAdapter;

import java.util.ArrayList;

public class Timeline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ArrayList<TimelineRow> timelineRowslist= new ArrayList<>();
        TimelineRow myrow1=new TimelineRow(0);

        myrow1.setTitle("Class Test-1");
        myrow1.setTitleColor(Color.rgb(255,255,255));
        myrow1.setBellowLineColor(Color.rgb(0,128,255));
        myrow1.setBellowLineSize(6);

        myrow1.setDescription("20-22 January");
        myrow1.setDescriptionColor(Color.rgb(255,255,255));



        TimelineRow myrow2=new TimelineRow(1);
        myrow2.setTitle("Lab Test-1");
        myrow2.setTitleColor(Color.rgb(255,255,255));
        myrow2.setBellowLineColor(Color.rgb(0,128,255));
        myrow2.setBellowLineSize(6);
        myrow2.setDescription("23- 29 January");
        myrow2.setDescriptionColor(Color.rgb(255,255,255));


        TimelineRow myrow3=new TimelineRow(2);
        myrow3.setTitle("Cultural Fest");
        myrow3.setTitleColor(Color.rgb(255,255,255));
        myrow3.setBellowLineColor(Color.rgb(0,128,255));
        myrow3.setDescriptionColor(Color.rgb(255,255,255));
        myrow3.setBellowLineSize(6);
        myrow3.setDescription("27-29 February");

        TimelineRow myrow4=new TimelineRow(3);
        myrow4.setTitle("Class Test-2");
        myrow4.setTitleColor(Color.rgb(255,255,255));
        myrow4.setBellowLineColor(Color.rgb(0,128,255));
        myrow4.setBellowLineSize(6);
        myrow4.setDescription("19-22 February");
        myrow4.setDescriptionColor(Color.rgb(255,255,255));


        TimelineRow myrow5=new TimelineRow(4);
        myrow5.setTitle("Lab Test-2");
        myrow5.setTitleColor(Color.rgb(255,255,255));
        myrow5.setBellowLineColor(Color.rgb(0,128,255));
        myrow5.setBellowLineSize(6);
        myrow5.setDescription("2-7 March");
        myrow5.setDescriptionColor(Color.rgb(255,255,255));

        TimelineRow myrow6=new TimelineRow(5);
        myrow6.setTitle("Feedback");
        myrow6.setTitleColor(Color.rgb(255,255,255));
        myrow6.setBellowLineColor(Color.rgb(0,128,255));
        myrow6.setBellowLineSize(6);
        myrow6.setDescription("17-18 March");
        myrow6.setDescriptionColor(Color.rgb(255,255,255));

        TimelineRow myrow7=new TimelineRow(6);
        myrow7.setTitle("Class Test-3");
        myrow7.setTitleColor(Color.rgb(255,255,255));
        myrow7.setBellowLineColor(Color.rgb(0,128,255));
        myrow7.setBellowLineSize(6);
        myrow7.setDescription("19-21 March");
        myrow7.setDescriptionColor(Color.rgb(255,255,255));

        TimelineRow myrow8=new TimelineRow(7);
        myrow8.setTitle("Lab Test-3");
        myrow8.setTitleColor(Color.rgb(255,255,255));
        myrow8.setBellowLineColor(Color.rgb(0,128,255));
        myrow8.setBellowLineSize(6);
        myrow8.setDescription("23,24,26 March");
        myrow8.setDescriptionColor(Color.rgb(255,255,255));

        TimelineRow myrow9=new TimelineRow(8);
        myrow9.setTitle("Teaching Ends");
        myrow9.setTitleColor(Color.rgb(255,255,255));
        myrow9.setBellowLineColor(Color.rgb(0,128,255));
        myrow9.setBellowLineSize(6);
        myrow9.setDescription("21 March");
        myrow9.setDescriptionColor(Color.rgb(255,255,255));


        TimelineRow myrow10=new TimelineRow(9);
        myrow10.setTitle("Examinations");
        myrow10.setTitleColor(Color.rgb(255,255,255));
        myrow10.setBellowLineColor(Color.rgb(0,128,255));
        myrow10.setBellowLineSize(6);
        myrow10.setDescription("30 March-18 April");
        myrow10.setDescriptionColor(Color.rgb(255,255,255));

        TimelineRow myrow11=new TimelineRow(10);
        myrow11.setTitle("Vacations");
        myrow11.setTitleColor(Color.rgb(255,255,255));
        myrow11.setBellowLineColor(Color.rgb(0,128,255));
        myrow11.setBellowLineSize(6);
        myrow11.setDescription("19 April - 22 June");
        myrow11.setDescriptionColor(Color.rgb(255,255,255));


        timelineRowslist.add(myrow1);
        timelineRowslist.add(myrow2);
        timelineRowslist.add(myrow3);
        timelineRowslist.add(myrow4);
        timelineRowslist.add(myrow5);
        timelineRowslist.add(myrow6);
        timelineRowslist.add(myrow7);
        timelineRowslist.add(myrow8);
        timelineRowslist.add(myrow9);
        timelineRowslist.add(myrow10);
        timelineRowslist.add(myrow11);
        ArrayAdapter<TimelineRow>myadapter=new TimelineViewAdapter(this,0,timelineRowslist,false);
        ListView mylistview=(ListView)findViewById(R.id.timeline_list);
        mylistview.setAdapter(myadapter);

    }
}
