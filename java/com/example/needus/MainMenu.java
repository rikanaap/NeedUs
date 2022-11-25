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
import android.widget.LinearLayout;


public class MainMenu extends AppCompatActivity {
    Button btn;
    RecyclerView rv1, rv2;
    String s1[], s2[];
    int ahli[] = {R.drawable.tobey, R.drawable.johhny, R.drawable.tom, R.drawable.jisoo, R.drawable.rose,R.drawable.karina};
    int food[] = {R.drawable.donat, R.drawable.kebab, R.drawable.burger,R.drawable.housin, R.drawable.ramen, R.drawable.dimsum};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_menu);
        s1 = getResources().getStringArray(R.array.keahlian);
        s2 = getResources().getStringArray(R.array.fooddrink);
        btn = findViewById(R.id.buttonProfile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(MainMenu.this, ProfilePage.class);
                startActivity(p);
            }
        });
        rv1 = findViewById(R.id.rvBantuan);
        BantuanAdapter b = new BantuanAdapter(this, s1, ahli);
        rv1.setAdapter(b);
        rv1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv2 = findViewById(R.id.rvFood);
        FoodAdapter f = new FoodAdapter(this, s2, food);
        rv2.setAdapter(f);
        rv2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}