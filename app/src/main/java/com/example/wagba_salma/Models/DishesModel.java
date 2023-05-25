package com.example.wagba_salma.Models;

public class DishesModel {

    String resturantName;
    String dishName;
    String image;
    String price;


    public DishesModel(String resturantName, String dishName, String image, String price) {
        this.resturantName = resturantName;
        this.dishName = dishName;
        this.image = image;
        this.price = price;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setResturantName(String resturantName) {
        this.resturantName = resturantName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getResturantName() {
        return resturantName;
    }

    public String getImage() {
        return image;
    }
}
