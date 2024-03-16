package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyviewHolder> {

    List<ResponseModel> data;

    public AdapterClass(List<ResponseModel> data) {


        this.data = data;
    }


    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false)

        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyviewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView1;
        TextView textview;
        RatingBar ratingbar;
        Button button;
        ImageView imageview1;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textview = itemView.findViewById(R.id.textView3);
            textView1 = itemView.findViewById(R.id.tvlocation);

        }
    }


}
