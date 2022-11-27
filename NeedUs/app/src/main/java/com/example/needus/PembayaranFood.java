package com.example.needus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class PembayaranFood extends AppCompatActivity {
    ImageView imgback, gmMenu1, gmMenu2, gmMenu3;
    TextView tmenu1, tmenu2, tmenu3;
    ConstraintLayout cl;
    String text1, text2, text3;
    int menu1, menu2, menu3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.pembayaran_food);
        imgback = findViewById(R.id.imgBack);
        gmMenu1 = findViewById(R.id.gambarMenu1);
        gmMenu2 = findViewById(R.id.gambarMenu2);
        gmMenu3 = findViewById(R.id.gambarMenu3);
        tmenu1 = findViewById(R.id.textMenu1);
        tmenu2 = findViewById(R.id.textMenu2);
        tmenu3 = findViewById(R.id.textMenu3);
        getData();
        setData();
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        cl = findViewById(R.id.button);
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PembayaranFood.this, PesananFood.class);
                i.putExtra("Gmenu1", menu1);
                i.putExtra("Gmenu2", menu2);
                i.putExtra("Tmenu1", text1);
                i.putExtra("Tmenu2", text2);
                startActivity(i);
            }
        });
    }
    private void getData(){
        if (getIntent().hasExtra("Menu1")&&getIntent().hasExtra("Menu2")&&getIntent().hasExtra("Menu3")&&getIntent().hasExtra("TextMenu1")&&getIntent().hasExtra("TextMenu2")&&getIntent().hasExtra("TextMenu3")){
            menu1 = getIntent().getIntExtra("Menu1", 1);
            menu2 = getIntent().getIntExtra("Menu2", 1);
            menu3 = getIntent().getIntExtra("Menu3", 1);
            text1 = getIntent().getStringExtra("TextMenu1");
            text2 = getIntent().getStringExtra("TextMenu2");
            text3 = getIntent().getStringExtra("TextMenu3");
        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        gmMenu1.setImageResource(menu1);
        gmMenu2.setImageResource(menu2);
        gmMenu3.setImageResource(menu3);
        tmenu1.setText(text1);
        tmenu2.setText(text2);
        tmenu3.setText(text3);
    }
}