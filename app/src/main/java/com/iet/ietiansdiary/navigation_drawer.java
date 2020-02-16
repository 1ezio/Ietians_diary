package com.iet.ietiansdiary;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.webkit.HttpAuthHandler;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.iet.ietiansdiary.Cursor_activities.Timeline;
import com.iet.ietiansdiary.Cursor_activities.study_material.Study_Material;
import com.iet.ietiansdiary.Cursor_activities.Syllabus;
import com.iet.ietiansdiary.Cursor_activities.notice.Recycler_view__;
import com.iet.ietiansdiary.Cursor_activities.study_material.sm_view_pdf;
import com.iet.ietiansdiary.crsr.MenuItemData;
import com.iet.ietiansdiary.crsr.wheeltextadapter;
import com.iet.ietiansdiary.navigation_activities.developers.clubs.Clubs;
import com.iet.ietiansdiary.navigation_activities.developers.contributors.contributors_activity;
import com.iet.ietiansdiary.navigation_activities.developers.developer;
import com.iet.ietiansdiary.navigation_activities.developers.developers_activity;

import java.util.ArrayList;
import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;

public class navigation_drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CursorWheelLayout.OnMenuSelectedListener {
    CursorWheelLayout wheel_text;
    private List<MenuItemData> listtext=new ArrayList<>();
    private TextView textView;
    Boolean connected =false;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        initViews();
        MobileAds.initialize(this,"ca-app-pub-6028758234054822~8044560729");
            mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()== NetworkInfo.State.CONNECTED ||connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()== NetworkInfo.State.CONNECTED){
            connected=true;
        }else{connected=false;
            Intent i=new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            Toast.makeText(this, "Make sure you are connected to Internet", Toast.LENGTH_SHORT).show();

        }
        loaddata();

        wheel_text.setOnMenuSelectedListener(this);
        textView=(TextView)findViewById(R.id.id_wheel_menu_center_item);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(navigation_drawer.this,Study_Material.class);
                startActivity(intent);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.project_id, R.string.project_id);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_developers) {

            Intent intent=new Intent(navigation_drawer.this, developers_activity.class);
            startActivity(intent);
         //   Toast.makeText(this, "Wait.. till the images are loading are loading", Toast.LENGTH_LONG).show();
            return true;
        }if (id == R.id.action_contibutors) {

            Intent intent=new Intent(navigation_drawer.this, contributors_activity.class);
            startActivity(intent);
           // Toast.makeText(this, "Wait.. till the images are loading are loading", Toast.LENGTH_LONG).show();
            return true;
        }if (id == R.id.action_logour) {


            Intent intent=new Intent(navigation_drawer.this, log_out.class);
            startActivity(intent);
            //Toast.makeText(this, "Wait.. till the images are loading are loading", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id==R.id.nav_clubs){
            startActivity(new Intent(navigation_drawer.this, Clubs.class));
            finish();

        }else if(id==R.id.contacts){

            startActivity(new Intent(navigation_drawer.this, Contacts.class));
        }else if(id==R.id.about){
            startActivity(new Intent(navigation_drawer.this, about_college.class));
        }

        else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(navigation_drawer.this, developer.class);
            startActivity(intent);

        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void loaddata() {
        listtext.add(new MenuItemData("None"));
        listtext.add(new MenuItemData("syllabus"));
        listtext.add(new MenuItemData("Study Material"));
        listtext.add(new MenuItemData("Timeline"));
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
            Intent i=new Intent(navigation_drawer.this, Syllabus.class);
            startActivity(i);
            textView.setText(R.string.Syllabus);
            textView.setTextColor(getResources().getColor(R.color.colorPrimary));
            pos=0;

            // Toast.makeText(getApplicationContext(),"SELECTED"+listtext.get(pos),Toast.LENGTH_SHORT).show();
        }
        if(pos==2) {
            Intent i=new Intent(navigation_drawer.this, sm_view_pdf.class);
            startActivity(i);
            textView.setText(R.string.Study_Material);
            textView.setTextColor(getResources().getColor(R.color.colorPrimary));
            pos=0;
            // Toast.makeText(getApplicationContext(),"SELECTED"+listtext.get(pos),Toast.LENGTH_SHORT).show();
        }
        if(pos==3) {
            pos=0;
            Intent i=new Intent(navigation_drawer.this, Timeline.class);
            startActivity(i);
            textView.setText(R.string.Timeline);
            textView.setTextColor(getResources().getColor(R.color.colorPrimary));


            // Toast.makeText(getApplicationContext(),"SELECTED"+listtext.get(pos),Toast.LENGTH_SHORT).show();
        }
        if(pos==4) {
            pos=0;
            Intent i=new Intent(navigation_drawer.this, Recycler_view__.class);
            startActivity(i);
            textView.setText(R.string.Notices);
           // Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
            textView.setTextColor(getResources().getColor(R.color.colorPrimary));

            // Toast.makeText(getApplicationContext(),"SELECTED"+listtext.get(pos),Toast.LENGTH_SHORT).show();
        }

    }




}

