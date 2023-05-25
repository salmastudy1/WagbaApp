package com.example.wagba_salma.Models;

public class RestaurantsModel {
    String resturantName;
    int image;

    public RestaurantsModel(String resturantName, int image) {
        this.resturantName = resturantName;
        this.image = image;
    }

    public String getResturantName() {
        return resturantName;
    }

    public int getImage() {
        return image;
    }
}

