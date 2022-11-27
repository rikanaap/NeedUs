package com.example.needus;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.needus.FirstSlider;
import com.example.needus.SecondSlider;
import com.example.needus.ThirdSlider;

public class IntroAdapter extends FragmentPagerAdapter{

    public IntroAdapter (FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return new FirstSlider();
            case 1:
                return new SecondSlider();
            case 2:
                    return new ThirdSlider();
            default:
                return null;
        }

    }
    @Override
    public int getCount(){
        return 3;
    }
}