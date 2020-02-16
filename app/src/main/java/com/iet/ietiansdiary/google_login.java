package com.iet.ietiansdiary;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


import static com.google.firebase.auth.FirebaseAuth.getInstance;

public class google_login extends AppCompatActivity {

    SignInButton signInButton;
    FirebaseAuth mauth;
    private static int RC_SIGN_IN=1;
    GoogleApiClient mGoogleApiClient;
    private FirebaseAuth.AuthStateListener mAuthStateListner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_login2);
        signInButton=(SignInButton)findViewById(R.id.google_btn);
        mauth= FirebaseAuth.getInstance();
       // FirebaseAuth.getInstance().addAuthStateListener(mAuthStateListner);


        mAuthStateListner=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                 FirebaseUser user=firebaseAuth.getCurrentUser();
                    if(user!=null) {
                        Intent intent = new Intent(google_login.this, navigation_drawer.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(google_login.this, "error", Toast.LENGTH_SHORT).show();
                    }
            }
        };
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("272639447829-set69me9upbld0v19m6l1327143a5lsr.apps.googleusercontent.com").requestEmail().build();
        mGoogleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
            @Override
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                Toast.makeText(google_login.this,"Network Error",Toast.LENGTH_SHORT).show();
            }
        }).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();
    }
    @Override
    protected void onStart() {
        super.onStart();
        mauth.addAuthStateListener(mAuthStateListner);
    }

    @Override
    protected void onStop() {

        super.onStop();
        if(mAuthStateListner!=null){
            mauth.removeAuthStateListener(mAuthStateListner);
        }

    }

    private void signIn(){
        Intent signInIntent= Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }
    @Override
    public void  onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==RC_SIGN_IN){
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess()){
                GoogleSignInAccount account=result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            }else{
                Toast.makeText(google_login.this,result.getStatus().getStatusMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential= GoogleAuthProvider.getCredential(account.getIdToken(),null);
        mauth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.d("TAG","SigninwithCredentials:success");
                    FirebaseUser user=mauth.getCurrentUser();
                }else{
                    Log.w("TAG","Failed",task.getException());
                    Toast.makeText(google_login.this,"Authentication Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
