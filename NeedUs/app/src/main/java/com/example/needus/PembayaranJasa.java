package com.example.needus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PembayaranJasa extends AppCompatActivity {
    ImageView imgback;
    ConstraintLayout cl;
    TextView textAhli, namaAhli, kls;
    ImageView gambarAhli;
    String txtAhli, namaAhlis, kelas;
    int images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.pembayaran_jasa);
        imgback = findViewById(R.id.imageBack);
        textAhli = findViewById(R.id.textKeahlian);
        gambarAhli = findViewById(R.id.imageAhli);
        namaAhli = findViewById(R.id.namaPenjasa);
        kls = findViewById(R.id.namaKelas);
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
                Intent i = new Intent(PembayaranJasa.this, PesananJasa.class);
                i.putExtra("gamAhli", images);
                i.putExtra("namAhli", namaAhlis);
                startActivity(i);
            }
        });
    }
    private void getData(){
        if (getIntent().hasExtra("gambarKeahli")&&getIntent().hasExtra("textKeahli")&&getIntent().hasExtra("namaAhli") && getIntent().hasExtra("Kelas")){
            txtAhli = getIntent().getStringExtra("textKeahli");
            images = getIntent().getIntExtra("gambarKeahli", 1);
            namaAhlis = getIntent().getStringExtra("namaAhli");
            kelas = getIntent().getStringExtra("Kelas");
        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        textAhli.setText(txtAhli);
        gambarAhli.setImageResource(images);
        namaAhli.setText(namaAhlis);
        kls.setText(kelas);
    }
}