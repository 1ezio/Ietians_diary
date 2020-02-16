package com.iet.ietiansdiary.crsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.iet.ietiansdiary.Cursor_activities.Syllabus;
import com.iet.ietiansdiary.Cursor_activities.notice.Recycler_view__;
import com.iet.ietiansdiary.R;

import java.util.ArrayList;
import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;

public class cursor_activity extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener {

    CursorWheelLayout wheel_text;
    private List<MenuItemData> listtext=new ArrayList<>();
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fadein,R.anim.fadein);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursor_activity);
        initViews();
        loaddata();
        wheel_text.setOnMenuSelectedListener(this);
        textView=(TextView)findViewById(R.id.id_wheel_menu_center_item);
    }
    private void loaddata() {
        listtext.add(new MenuItemData("None"));
        listtext.add(new MenuItemData("syllabus"));

        listtext.add(new MenuItemData("Study Material"));
        listtext.add(new MenuItemData("Chat"));
        listtext.add(new MenuItemData("Notices"));


        wheeltextadapter WHeeltextadapter= new wheeltextadapter(getBaseContext(),listtext);
        wheel_text.setAdapter(WHeeltextadapter);

    }

    private void initViews() {
        wheel_text=(CursorWheelLayout)findViewById(R.id.Wheel_text);

    }

    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {

        if(pos==0) {

            textView.setText(R.string.None);
            textView.setTextColor(getResources().getColor(R.color.colorPrimary));

            // Toast.makeText(getApplicationContext(),"SELECTED"+listtext.get(pos),Toast.LENGTH_SHORT).show();
        }
        if(pos==1) {
            Intent i=new Intent(cursor_activity.this, Syllabus.class);
            startActivity(i);
            textView.setText(R.string.Syllabus);
            textView.setTextColor(getResources().getColor(R.color.colorPrimary));


            // Toast.makeText(getApplicationContext(),"SELECTED"+listtext.get(pos),Toast.LENGTH_SHORT).show();
        }
        if(pos==2) {
            Intent i=new Intent(cursor_activity.this, Syllabus.class);
            startActivity(i);
            textView.setText(R.string.Study_Material);
            textView.setTextColor(getResources().getColor(R.color.colorPrimary));
            // Toast.makeText(getApplicationContext(),"SELECTED"+listtext.get(pos),Toast.LENGTH_SHORT).show();
        }
        if(pos==3) {
            Intent i=new Intent(cursor_activity.this, Syllabus.class);
            startActivity(i);
            textView.setText(R.string.Chats);
            textView.setTextColor(getResources().getColor(R.color.colorPrimary));


            // Toast.makeText(getApplicationContext(),"SELECTED"+listtext.get(pos),Toast.LENGTH_SHORT).show();
        }
        if(pos==4) {
            Intent i=new Intent(cursor_activity.this, Recycler_view__.class);
            startActivity(i);
            textView.setText(R.string.Notices);
            textView.setTextColor(getResources().getColor(R.color.colorPrimary));

            // Toast.makeText(getApplicationContext(),"SELECTED"+listtext.get(pos),Toast.LENGTH_SHORT).show();
        }

    }
}
