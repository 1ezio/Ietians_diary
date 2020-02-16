package com.iet.ietiansdiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.ArrayList;
import java.util.List;

public class firebase_login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private int RC_SIGN_IN = 123;
    FirebaseUser user;
    public static String Logged_in_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_login);
        mAuth = FirebaseAuth.getInstance();

        user=mAuth.getCurrentUser();
      //  Logged_in_user=user.getEmail();
       // OneSignal.sendTag("user_id",Logged_in_user);
    }
        @Override
        public void onStart() {
            super.onStart();
            // Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser != null) {
                startActivity(new Intent(this, navigation_drawer.class));
                firebase_login.this.finish();
            } else {
                findViewById(R.id.signinButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Choose authentication providers
                        List<AuthUI.IdpConfig> providers =new ArrayList<>();
                        AuthUI.IdpConfig.Builder cinfig1=new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER);
                        providers.add(cinfig1.build());

                        // Create and launch sign-in intent
                        startActivityForResult(
                                AuthUI.getInstance()
                                        .createSignInIntentBuilder()
                                        .setProviders(providers)
                                        .build(),
                                RC_SIGN_IN);
                    }
                });
            }
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == RC_SIGN_IN) {

                if (resultCode == RESULT_OK) {
                    // Successfully signed in
                    if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                        startActivity(new Intent(firebase_login.this, navigation_drawer.class));
                        firebase_login.this.finish();
                    }
                 } else {
                    // Sign in failed. If response is null the user canceled the
                    // sign-in flow using the back button. Otherwise check
                    // response.getError().getErrorCode() and handle the error.
                    // ...
                    Toast.makeText(this, "Something Went Wrong...", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
