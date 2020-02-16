package com.iet.ietiansdiary.navigation_activities.developers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iet.ietiansdiary.R;
import com.iet.ietiansdiary.upld;

public class developer extends AppCompatActivity {
    private EditText editTextpass;
    private Button btndevlogin;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        editTextpass=(EditText)findViewById(R.id.dev_password);
        btndevlogin=(Button)findViewById(R.id.dev_login);

        btndevlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password= editTextpass.getText().toString();
                if(password.equals("18tc3031")||password.equals("18tc3052")||password.equals("18tc3022")||password.equals("18tc3013")||password.equals("18tc3001")){
                    Intent intent=new Intent(developer.this, upld.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(developer.this,"You are not a DEVELOPER",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
