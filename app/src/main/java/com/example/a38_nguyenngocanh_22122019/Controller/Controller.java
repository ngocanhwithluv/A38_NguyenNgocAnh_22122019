package com.example.a38_nguyenngocanh_22122019.Controller;

import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.a38_nguyenngocanh_22122019.AppManager;
import com.example.a38_nguyenngocanh_22122019.Model.Food;
import com.example.a38_nguyenngocanh_22122019.R;
import com.example.a38_nguyenngocanh_22122019.View.LoginFragment;
import com.example.a38_nguyenngocanh_22122019.View.OrderFragment;
import com.example.a38_nguyenngocanh_22122019.View.YourOrderFragment;
import com.example.a38_nguyenngocanh_22122019.databinding.ActivityOrderBinding;
import com.example.a38_nguyenngocanh_22122019.databinding.ActivityYourorderBinding;

import java.util.ArrayList;


public class Controller {

    public static LoginFragment loginFragment = LoginFragment.newInstance();
    public static OrderFragment orderFragment = OrderFragment.newInstance();
    public static YourOrderFragment yourOrderFragment = YourOrderFragment.newInstance();
    public static ArrayList<Food> foods = new ArrayList<>();
    public static ArrayList<Food> foodsOrdered = new ArrayList<>();
    public static int sumAmount = 0, sumTotal = 0;

    public static void setFoods() {
        foods.add(new Food("Coca", 10, 0, R.drawable.soda));
        foods.add(new Food("Chicken", 12, 0, R.drawable.chicken));
        foods.add(new Food("Rice", 15, 0, R.drawable.bread));
        foods.add(new Food("Meat", 20, 0,R.drawable.chinese));
        foods.add(new Food("Durex", 60, 0, R.drawable.fruit));
        foods.add(new Food("BimBim", 5, 0, R.drawable.potato));
        foods.add(new Food("Snack", 6, 0, R.drawable.slice));
        foods.add(new Food("Vegetable", 5, 0, R.drawable.burger));
    }
    public static void resetData(){
        foods = new ArrayList<>();
        foodsOrdered = new ArrayList<>();
        setFoods();
        sumAmount = 0;
        sumTotal = 0;
    }
    public static void resetDataOrder(){
        foodsOrdered = new ArrayList<>();
    }
    public static void addFoods(Food food){
        sumAmount ++ ;
        sumTotal += food.getPrice();
        int newAmount = food.getAmount();
        food.setAmount(newAmount++);
        foodsOrdered.add(food);
        Toast.makeText(AppManager.context, "+1", Toast.LENGTH_SHORT).show();
    }

    public static void delFood(Food food){
        sumAmount --;
        sumTotal -= food.getPrice();
        int newAmount = food.getAmount() - 1;
        food.setAmount(newAmount);
        for(Food i : foods){
            if(i.getName().equals(food.getName())){
                int j = foods.indexOf(i);
                i.setAmount(newAmount);
                foods.set(j, i);
            }
        }
        Toast.makeText(AppManager.context, "-1", Toast.LENGTH_SHORT).show();
    }

    public static void setFoodsOrdered(){
        resetDataOrder();
        for (Food i : foods){
            if(i.getAmount() > 0){
                foodsOrdered.add(i);
            }
        }
    }
}
