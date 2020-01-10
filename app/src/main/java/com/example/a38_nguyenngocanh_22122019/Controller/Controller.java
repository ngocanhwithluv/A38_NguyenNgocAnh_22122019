package com.example.a38_nguyenngocanh_22122019.Controller;

import android.widget.Toast;

import com.example.a38_nguyenngocanh_22122019.AppManager;
import com.example.a38_nguyenngocanh_22122019.Model.Food;
import com.example.a38_nguyenngocanh_22122019.View.OrderFragment;
import com.example.a38_nguyenngocanh_22122019.databinding.ActivityOrderBinding;

import static com.example.a38_nguyenngocanh_22122019.View.OrderFragment.sumTotal;

public class Controller {
    public static ActivityOrderBinding binding;


    public void addFoods(Food food){
        OrderFragment.sumAmount ++ ;
        sumTotal += food.getPrice();
        int newAmount = food.getAmount();
        food.setAmount(newAmount++);
        binding.sumTotal.setText("Total: " + sumTotal);
        binding.textViewSumAmount.setText(Integer.toString(OrderFragment.sumAmount));
        Toast.makeText(AppManager.context, "+1", Toast.LENGTH_SHORT).show();
    }

}
