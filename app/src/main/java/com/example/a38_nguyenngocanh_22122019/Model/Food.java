package com.example.a38_nguyenngocanh_22122019.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Food implements Serializable {
    private String name;
    private int price, amount;
    private int image;

//    public Food(String name, int price, int amount) {
//        this.name = name;
//        this.price = price;
//        this.amount = amount;
//    }

    public Food(String name, int price, int amount, int image) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
