package com.iet.ietiansdiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class about_college extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_college);
        TextView t2 = (TextView) findViewById(R.id.textView20);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
