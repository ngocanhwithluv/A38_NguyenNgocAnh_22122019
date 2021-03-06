package com.example.a38_nguyenngocanh_22122019.Controller;

import android.widget.Toast;

import com.example.a38_nguyenngocanh_22122019.AppManager;
import com.example.a38_nguyenngocanh_22122019.Model.Food;
import com.example.a38_nguyenngocanh_22122019.R;

import java.util.ArrayList;

public class Controller {

    public static ArrayList<Food> foods = new ArrayList<>();
    public static ArrayList<Food> foodsOrdered = new ArrayList<>();
    public static int sumAmount = 0, total = 0;

    public static void setFoods() {
        foods.add(new Food("Soda", 10, 0, R.drawable.soda));
        foods.add(new Food("Chicken", 60, 0, R.drawable.chicken));
        foods.add(new Food("Hot dog", 10, 0, R.drawable.bread));
        foods.add(new Food("Noodle", 10, 0, R.drawable.chinese));
        foods.add(new Food("Fruit", 7, 0, R.drawable.fruit));
        foods.add(new Food("Potato", 20, 0, R.drawable.potato));
        foods.add(new Food("Hamburger", 30, 0, R.drawable.burger));
        foods.add(new Food("Pizza", 30, 0, R.drawable.slice));
        foods.add(new Food("Beer", 15, 0, R.drawable.beer));
        foods.add(new Food("Chocolate", 15, 0, R.drawable.chocolate));
        foods.add(new Food("Coffee cup", 15, 0, R.drawable.coffeecup));
        foods.add(new Food("Ice", 15, 0, R.drawable.jelly));
        foods.add(new Food("Ice cup", 25, 0, R.drawable.dessert));
        foods.add(new Food("Lemon fruit", 15, 0, R.drawable.lemonfruit));
        foods.add(new Food("Orange fruit", 15, 0, R.drawable.orangefruit));
    }

    public static void resetData() {
        foods = new ArrayList<>();
        foodsOrdered = new ArrayList<>();
        setFoods();
        sumAmount = 0;
        total = 0;
    }

    public static void resetDataOrder() {
        foodsOrdered = new ArrayList<>();
    }

    public static void addFoods(Food food) {
        sumAmount++;
        total += food.getPrice();
        int newAmount = food.getAmount() + 1;
        food.setAmount(newAmount);
        Toast.makeText(AppManager.context, "+1", Toast.LENGTH_SHORT).show();
    }

    public static void delFood(Food food) {
        sumAmount--;
        total -= food.getPrice();
        int newAmount = food.getAmount() - 1;
        food.setAmount(newAmount);
        Toast.makeText(AppManager.context, "-1", Toast.LENGTH_SHORT).show();
    }

    public static void reMoveFood(Food food){
        sumAmount-=food.getAmount();
        total -= food.getAmount()*food.getPrice();
//        for (Food i : foods) {
//            if (i.getName().equals(food.getName())) {
//                i.setAmount(0);
//                break;
//            }
//        }
//        food.setAmount(0);

        food.setAmount(0);
        foodsOrdered.remove(food);
    }

    public static void setFoodsOrdered() {
        resetDataOrder();
        for (Food i : foods) {
            if (i.getAmount() > 0) {
                foodsOrdered.add(i);
            }
        }
    }

    public static void editFood() {
        for (Food i : foodsOrdered) {
            for (Food j : foods) {
                if (i.getName().equals(j.getName())) {
                    j.setAmount(i.getAmount());
                    break;
                }
            }
        }
    }
}
