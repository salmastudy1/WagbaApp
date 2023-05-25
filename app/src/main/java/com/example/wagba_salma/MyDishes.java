package com.example.wagba_salma;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wagba_salma.Adapters.recyclerviewadapter;
import com.example.wagba_salma.Adapters.recyclerviewadapterDishes;
import com.example.wagba_salma.Models.DishesModel;

import java.util.ArrayList;
import java.util.HashMap;

public class MyDishes extends Fragment {

    String[] karam_DishesNames = new String[]{"combo","hotdog",
            "fries", "housezalad"};
    String[] FoodCorner_DishesNames = new String[]{"fries", "cola", "nuggets", "cheesefinger"};
    String[] TaybatDishesNames = new String[]{"housezalad","combo",
            "brownie", "cola"};
    String[] HeartAttack_DishesNames = new String[]{"brownie","burger",
            "fries", "nuggets"};
    String[] KfcDishesNames = new String[]{"combo","hotdog",
            "cheesefinger", "brownie"};
    String[] ElshabrawyDishesNames= new String[]{"fries","foul",
            "cola", "housezalad"};
    String[] BazookaDishesNames= new String[]{"housezalad","burger",
            "nuggets", "hotdog"};
    String[] NagafDishesNames= new String[]{"brownie","cola",
            "cheesefinger", "combo"};
    String[] karam_DishesPrices= new String[]{"35.00","26.00",
            "40.00", "30.00"};
    String[] FoodCorner_DishesPrices= new String[]{"26.00", "10.00", "22.00", "8.00"};
    String[] TaybatDishesPrices = new String[]{"30.00","10.00",
            "22.00", "10"};
    String[] HeartAttack_DishesPrices = new String[]{"60.00","65.00",
            "55.00", "46.00"};
    String[] KfcDishesPrices = new String[]{"68.50","60.00",
            "34.00", "10.00"};
    String[] ElshabrawyDishesPrices=new String[]{"8.00","4.75",
            "16.00", "10"};
    String[] BazookaDishesPrices= new String[]{"42.75","35.00",
            "65.00", "55.00"};
    String[] NagafDishesPrices= new String[]{"9.00","6.50",
            "32.50", "8.00"};
    HashMap<String,String[]> Prices_hm = new HashMap<>();
    HashMap<String,String[]> names_hm = new HashMap<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Prices_hm.put("Arabiata Alshabrawy", ElshabrawyDishesPrices);
        Prices_hm.put("Food Corner", FoodCorner_DishesPrices);
        Prices_hm.put("Bazooka", BazookaDishesPrices);
        Prices_hm.put("Heart Attack", HeartAttack_DishesPrices);
        Prices_hm.put("Karam ElSham", karam_DishesPrices);
        Prices_hm.put("KFC", KfcDishesPrices);
        Prices_hm.put("Nagaf", NagafDishesPrices);
        Prices_hm.put("Taybat Elsham", TaybatDishesPrices);
        names_hm.put("Arabiata Alshabrawy", ElshabrawyDishesNames);
        names_hm.put("Food Corner", FoodCorner_DishesNames);
        names_hm.put("Bazooka", BazookaDishesNames);
        names_hm.put("Heart Attack", HeartAttack_DishesNames);
        names_hm.put("Karam ElSham", karam_DishesNames);
        names_hm.put("KFC", KfcDishesNames);
        names_hm.put("Nagaf", NagafDishesNames);
        names_hm.put("Taybat Elsham", TaybatDishesNames);

        String restaurantName = requireArguments().getString("restaurant_name");
        View view = inflater.inflate(R.layout.fragment_my_dishes, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.mRecyclerViewDishes);
        ArrayList<DishesModel> dishesModels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            DishesModel dish = new DishesModel(restaurantName,
                    names_hm.get(restaurantName)[i],
                    names_hm.get(restaurantName)[i], Prices_hm.get(restaurantName)[i]);
            dishesModels.add(dish);
        }
        recyclerviewadapterDishes adapter= new recyclerviewadapterDishes(getActivity(), dishesModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
}