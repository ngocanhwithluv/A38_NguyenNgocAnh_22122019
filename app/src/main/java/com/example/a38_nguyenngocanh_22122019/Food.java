package com.example.a38_nguyenngocanh_22122019;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Food implements Serializable {
    private String name;
    private int price, amount;

    public Food(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
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
