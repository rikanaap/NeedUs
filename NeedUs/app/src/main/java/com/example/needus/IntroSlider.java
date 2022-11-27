package com.example.needus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;

public class IntroSlider extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.intro_slider);
        SharedPreferences pre = getSharedPreferences("REFERENCE", MODE_PRIVATE);
        String FirstTime = pre.getString("FirstTimeInstal", "");
        if(FirstTime.equals("Yes")){
            Intent intent = new Intent(IntroSlider.this, MainMenu.class);
            startActivity(intent);
            finish();
        }else{
            SharedPreferences.Editor editor = pre.edit();
            editor.putString("FirstTimeInstal", "Yes");
            editor.apply();
        }
        viewPager = findViewById(R.id.viewPager);
        IntroAdapter adapter = new IntroAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}