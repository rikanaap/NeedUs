package com.example.needus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainMenu extends AppCompatActivity {
    ImageView btn;
    RecyclerView rv1, rv2;
    String s1[], s2[], s1a[], s2a[];
    int ahli[] = {R.drawable.tobey, R.drawable.johhny, R.drawable.tom, R.drawable.rose, R.drawable.jisoo, R.drawable.karina};
    int food[] = {R.drawable.donat, R.drawable.kebab, R.drawable.burger,R.drawable.housin, R.drawable.ramen, R.drawable.dimsum};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_menu);
        s1 = getResources().getStringArray(R.array.keahlian);
        s2 = getResources().getStringArray(R.array.fooddrink);
        s1a = getResources().getStringArray(R.array.namaJasa);
        s2a = getResources().getStringArray(R.array.kelas);
        btn = findViewById(R.id.buttonProfile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(MainMenu.this, ProfilePage.class);
                startActivity(p);
            }
        });
        rv1 = findViewById(R.id.rvBantuan);
        BantuanAdapter b = new BantuanAdapter(this, s1, ahli, s1a, s2a);
        rv1.setAdapter(b);
        rv1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        rv2 = findViewById(R.id.rvFood);
        int[] menu1 = {R.drawable.pembayaran_food_1,R.drawable.menu1a, R.drawable.menu1b, R.drawable.menu1c, R.drawable.menu1d, R.drawable.menu1e};
        int[] menu2 = {R.drawable.pembayaran_food_2,R.drawable.menu2a, R.drawable.menu2b, R.drawable.menu2c, R.drawable.menu2d, R.drawable.menu2e};
        int[] menu3 = {R.drawable.pembayaran_food_3,R.drawable.menu3a, R.drawable.menu3b, R.drawable.menu3c, R.drawable.menu3d, R.drawable.menu3e};
        FoodAdapter f = new FoodAdapter(this, s2, food, menu1, menu2, menu3);
        rv2.setAdapter(f);
        rv2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}