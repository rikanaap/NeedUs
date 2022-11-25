package com.example.needus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private String[] data1;
    private int[] img;
    private Context context;
    public FoodAdapter(Context ct, String[] s1, int[] images){
        context = ct;
        data1 = s1;
        img = images;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vw = inflater.inflate(R.layout.food_post, parent, false);
        return new ViewHolder(vw);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myImage.setImageResource(img[position]);
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ifood = new Intent(context, PembayaranFood.class);
                context.startActivity(ifood);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView myText1;
        ImageView myImage;
        LinearLayout linear;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.textFood);
            myImage = itemView.findViewById(R.id.imageFood);
            linear = itemView.findViewById(R.id.linearFood);
        }
    }
}
