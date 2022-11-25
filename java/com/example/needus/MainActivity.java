package com.example.needus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button lgnBtn, rgstrBtn;
    EditText username, nis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_page);
        SharedPreferences pre = getSharedPreferences("REFERENCE", MODE_PRIVATE);
       String FirstTime = pre.getString("FirstTimeInstal", "");
        if(FirstTime.equals("Yes")){
            Intent intent = new Intent(MainActivity.this, MainMenu.class);
            startActivity(intent);
            finish();
        }else{
            SharedPreferences.Editor editor = pre.edit();
            editor.putString("FirstTimeInstal", "Yes");
            editor.apply();
        }
        lgnBtn = findViewById(R.id.loginButton);
        lgnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = findViewById(R.id.usernameEdit);
                nis = findViewById(R.id.nisEdit);
                if (username.getText().toString().isEmpty()){
                    username.setError("Required!");
                }
                if (nis.getText().toString().isEmpty()){
                    nis.setError("Required!");
                } else {
                    Intent i = new Intent(MainActivity.this, MainMenu.class);
                    startActivity(i);
                }
            }
        });
        rgstrBtn = findViewById(R.id.register_btn);
        rgstrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterPage.class);
                startActivity(i);
            }
        });
    }
}