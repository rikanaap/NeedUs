package com.example.needus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PesananJasa extends AppCompatActivity {
    ImageView imgBut, imgAhli;
    TextView nama;
    Button btn;
    String namas;
    int images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.detailpesanan_jasa);
        imgBut = findViewById(R.id.buttonBack);
        imgAhli = findViewById(R.id.imageAhli);
        nama = findViewById(R.id.textNama);
        getData();
        setData();
        imgBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn = findViewById(R.id.buttonK);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PesananJasa.this, OutputPembayaran.class);
                startActivity(i);
            }
        });
    }
    private void getData(){
        if (getIntent().hasExtra("gamAhli")&&getIntent().hasExtra("namAhli")){
            images = getIntent().getIntExtra("gamAhli", 1);
            namas = getIntent().getStringExtra("namAhli");
        } else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        imgAhli.setImageResource(images);
        nama.setText(namas);
    }
}