package com.example.wagba_salma.Adapters;

import android.content.Context;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.wagba_salma.Models.RestaurantsModel;


import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wagba_salma.R;

import java.util.ArrayList;

public class recyclerviewadapter extends RecyclerView.Adapter<recyclerviewadapter.MyViewHolder> {
    Context context;
    ArrayList<RestaurantsModel> resturantsModels;

    public recyclerviewadapter(Context context, ArrayList<RestaurantsModel> resturantsModels) {
        this.context = context;
        this.resturantsModels = resturantsModels;
    }
    @NonNull
    @Override
    public recyclerviewadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerviewrow, parent, false);
        return new recyclerviewadapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerviewadapter.MyViewHolder holder, int position) {
        holder.textView.setText(resturantsModels.get(position).getResturantName());
        holder.imageView.setImageResource(resturantsModels.get(position).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                String restaurnat_name = holder.textView.getText().toString();
                bundle.putString("restaurant_name",restaurnat_name);
                Navigation.findNavController(view).navigate(R.id.action_myRestaurants_to_myDishes,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resturantsModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}


