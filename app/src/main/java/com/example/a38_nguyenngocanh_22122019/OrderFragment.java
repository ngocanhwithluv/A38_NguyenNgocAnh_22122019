package com.example.a38_nguyenngocanh_22122019;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a38_nguyenngocanh_22122019.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderFragment extends Fragment {

    ActivityOrderBinding binding;

    public static OrderFragment newInstance() {
        Bundle args = new Bundle();
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_order, container , false);

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        binding.buttonYourOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, YourOrderFragment.newInstance()).commit();

            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false);

        binding.recyclerView.setLayoutManager(linearLayoutManager);
        foods = new ArrayList<>();
        addFood();
        binding.textViewSumAmount.setText(Integer.toString(sumAmount));

        foodAdapter = new FoodAdapter(foods, getContext());
        binding.recyclerView.setAdapter(foodAdapter);
        return binding.getRoot();
    }
    Food food1, food2, food3, food4;
    private ArrayList<Food> foods;
    private FoodAdapter foodAdapter;
    private static int sumAmount;

    private void addFood(){
        food1 = new Food("nna", 10, 1);
        food2 = new Food("nnb", 12, 1);
        food3 = new Food("nnc", 15, 1);
        food4 = new Food("nnd", 20, 1);

        foods.add(food1);
        foods.add(food2);
        foods.add(food3);
        foods.add(food4);
        sumAmount = foods.size();

    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }
}
