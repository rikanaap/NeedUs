package com.example.needus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class RegisterPage extends AppCompatActivity {
    Button btn;
    EditText nama, nis, kelas, tlp, alamat, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.register_page);
        btn = findViewById(R.id.registerButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = findViewById(R.id.namaEdit);
                nis = findViewById(R.id.nisEdit);
                kelas = findViewById(R.id.kelasEdit);
                tlp = findViewById(R.id.tlpEdit);
                alamat = findViewById(R.id.alamatEdit);
                email = findViewById(R.id.emailEdit);
                if (nama.getText().toString().isEmpty()){
                    nama.setError("Required!");
                }
                if (nis.getText().toString().isEmpty()){
                    nis.setError("Required!");
                }
                if (kelas.getText().toString().isEmpty()){
                    kelas.setError("Required!");
                }
                if (tlp.getText().toString().isEmpty()){
                    tlp.setError("Required!");
                }
                if (alamat.getText().toString().isEmpty()){
                    alamat.setError("Required!");
                }
                if (email.getText().toString().isEmpty()){
                    email.setError("Required!");
                } else{
                    Intent i = new Intent(RegisterPage.this, MainMenu.class);
                    startActivity(i);
                }
            }
        });
    }
}