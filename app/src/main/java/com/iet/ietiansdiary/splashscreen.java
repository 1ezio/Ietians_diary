package com.iet.ietiansdiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;

import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class splashscreen extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        imageView=(ImageView)findViewById(R.id.profile_image);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash);
        imageView.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                startActivity(new Intent(getApplicationContext(), firebase_login.class));
                Toast.makeText(splashscreen.this, "Make sure you are connected to the Internet", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
