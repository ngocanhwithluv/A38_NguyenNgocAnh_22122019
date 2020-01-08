package com.example.a38_nguyenngocanh_22122019;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a38_nguyenngocanh_22122019.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderFragment extends Fragment {

    public static Message msg;
    public ActivityOrderBinding binding;
    public static ArrayList<Food> foods = new ArrayList<>();
    public FoodAdapter foodAdapter;
    public static int sumAmount = 0, sumTotal = 0;

    MyClick myClick = new MyClick() {
        @Override
        public void OnClickAdd(Food food) {
            sumAmount++;
            sumTotal += food.getPrice();
            int t = food.getAmount();
            food.setAmount(t++);
            binding.sumTotal.setText("Total: " + sumTotal);
            binding.textViewSumAmount.setText(Integer.toString(sumAmount));
            Toast.makeText(getContext(), "+1", Toast.LENGTH_SHORT).show();
        }
    };
    public static OrderFragment newInstance() {
        Bundle args = new Bundle();
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_order, container, false);

        binding.sumTotal.setText("Total: " + sumTotal);

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = new Message();
                msg.what = 0;
                MainActivity.handler.sendMessage(msg);

            }
        });

        binding.buttonYourOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = new Message();
                msg.what = 2;
                MainActivity.handler.sendMessage(msg);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false);
        binding.recyclerView.setLayoutManager(linearLayoutManager);

        foodAdapter = new FoodAdapter(foods, getContext(), myClick);
        foodAdapter.notifyDataSetChanged();
        binding.textViewSumAmount.setText(Integer.toString(sumAmount));
        binding.recyclerView.setAdapter(foodAdapter);
        return binding.getRoot();
    }

    public static void FoodList(){
        OrderFragment.foods.add(new Food("Coca", 10, 0));
        OrderFragment.foods.add(new Food("Chicken", 12, 0));
        OrderFragment.foods.add(new Food("Rice", 15, 0));
        OrderFragment.foods.add(new Food("Meat", 20, 0));
        OrderFragment.foods.add(new Food("Durex", 60, 0));
        OrderFragment.foods.add(new Food("BimBim", 5, 0));
        OrderFragment.foods.add(new Food("Snack", 6, 0));
        OrderFragment.foods.add(new Food("Vegetable", 5, 0));
    }

}
