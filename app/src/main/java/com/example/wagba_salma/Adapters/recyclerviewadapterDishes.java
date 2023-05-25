package com.example.wagba_salma.Adapters;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wagba_salma.Models.DishesModel;
import com.example.wagba_salma.R;

import java.util.ArrayList;
import java.util.HashMap;

public class recyclerviewadapterDishes extends RecyclerView.Adapter<recyclerviewadapterDishes.MyViewHolder> {
    Context context;
    ArrayList<DishesModel> dishesModels;

    public recyclerviewadapterDishes(Context context, ArrayList<DishesModel> arr) {
        this.context = context;
        this.dishesModels = arr;
    }
    @NonNull
    @Override
    public recyclerviewadapterDishes.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dishesrow, parent, false);
        return new recyclerviewadapterDishes.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerviewadapterDishes.MyViewHolder holder, int position) {
        holder.textView.setText(dishesModels.get(position).getDishName());
        holder.priceTextView.setText(dishesModels.get(position).getPrice());
        String  imageName = dishesModels.get(position).getImage();
        int id = holder.itemView.getResources().getIdentifier(imageName, "drawable",  "com.example.wagba_salma");
        Drawable drawable = holder.itemView.getResources().getDrawable(id);
        holder.imageView.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return dishesModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        TextView priceTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
            textView = itemView.findViewById(R.id.textView);
            priceTextView = itemView.findViewById(R.id.price);
        }
    }
}
