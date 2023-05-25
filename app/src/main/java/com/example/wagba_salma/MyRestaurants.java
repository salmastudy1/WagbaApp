package com.example.wagba_salma;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wagba_salma.Adapters.recyclerviewadapter;
import com.example.wagba_salma.Adapters.recyclerviewadapter;
import com.example.wagba_salma.Models.RestaurantsModel;

import java.util.ArrayList;


public class MyRestaurants extends Fragment {
    ArrayList<RestaurantsModel> resturantsModels = new ArrayList<>();
    int[] resturantsImages = new int[]{R.drawable.arabiata_al_shabrawy, R.drawable.food_corner,
            R.drawable.bazooka, R.drawable.heart_attack,
             R.drawable.karamelsham, R.drawable.kfc, R.drawable.nagaf,
            R.drawable.taybat_el_sham};
    String[] resturantsNames = new String[]{"Arabiata Alshabrawy","Food Corner",
            "Bazooka", "Heart Attack", "Karam ElSham", "KFC", "Nagaf",  "Taybat Elsham"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_restaurants, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.mRecyclerView);
        setUpResturantsModels();
        recyclerviewadapter adapter= new recyclerviewadapter(getActivity(), resturantsModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
    private void setUpResturantsModels(){
        for(int i=0; i < resturantsNames.length; i++){
            resturantsModels.add(new RestaurantsModel(resturantsNames[i],resturantsImages[i]));
        }
    }
}

