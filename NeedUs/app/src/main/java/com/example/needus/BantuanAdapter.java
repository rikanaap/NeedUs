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

public class BantuanAdapter extends RecyclerView.Adapter<BantuanAdapter.ViewHolder> {
    private String[] data1, data2, data3;
    private int[] img;
    private Context context;
    public BantuanAdapter(Context ct, String[] s1, int[] images, String[] nama, String[] kelas){
        context = ct;
        data1 = s1;
        img = images;
        data2 = nama;
        data3 = kelas;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vw = inflater.inflate(R.layout.bantuan_post, parent, false);
        return new ViewHolder(vw);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myImage.setImageResource(img[position]);
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ijasa = new Intent(context, PembayaranJasa.class);
                ijasa.putExtra("gambarKeahli",img[position]);
                ijasa.putExtra("textKeahli",data1[position]);
                ijasa.putExtra("namaAhli", data2[position]);
                ijasa.putExtra("Kelas", data3[position]);
                context.startActivity(ijasa);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myText1;
        ImageView myImage;
        LinearLayout ll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.textAhli);
            myImage = itemView.findViewById(R.id.imageAhli);
            ll = itemView.findViewById(R.id.linearJasa);
        }
    }
}
