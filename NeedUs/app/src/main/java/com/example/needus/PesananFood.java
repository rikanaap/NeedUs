package com.example.needus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class PesananFood extends AppCompatActivity {
    ImageView imgBut, firstMenu, secondMenu;
    Button btn;
    int menus1, menus2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.detailpesanan_food);
        imgBut = findViewById(R.id.buttonBack);
        firstMenu = findViewById(R.id.imageFood1);
        secondMenu = findViewById(R.id.imageFood2);
        getData();
        setData();
        imgBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn = findViewById(R.id.buttonKirim);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PesananFood.this, OutputPembayaran.class);
                startActivity(i);
            }
        });
    }
    private void getData(){
        if (getIntent().hasExtra("Gmenu1")&&getIntent().hasExtra("Gmenu2")){
            menus1 = getIntent().getIntExtra("Gmenu1", 1);
            menus2 = getIntent().getIntExtra("Gmenu2", 1);
        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        firstMenu.setImageResource(menus1);
        secondMenu.setImageResource(menus2);
    }
}