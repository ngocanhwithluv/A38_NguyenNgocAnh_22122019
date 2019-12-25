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

public class OrderFragment extends Fragment implements MyClick {

    ActivityOrderBinding binding;
    MyClick myClick = new MyClick() {
        @Override
        public void OnClickName(Food food) {
            sumAmount++;
            sumTotal += food.getPrice();
            int t = food.getAmount();
            food.setAmount(t++);
            binding.sumTotal.setText("Total: " + sumTotal);
            binding.textViewSumAmount.setText(Integer.toString(sumAmount));
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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_order, container , false);
        binding.sumTotal.setText("Total: " + sumTotal);
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        binding.buttonYourOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle args = new Bundle();
                args.putSerializable("Foods", foods);

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, YourOrderFragment.newInstance()).commit();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false);

        binding.recyclerView.setLayoutManager(linearLayoutManager);

        foods = new ArrayList<>();
        food1 = new Food("Coca", 10, 0);
        food2 = new Food("Chicken", 12, 0);
        food3 = new Food("Rice", 15, 0);
        food4 = new Food("Meat", 20, 0);
        foods.add(food1);
        foods.add(food2);
        foods.add(food3);
        foods.add(food4);


        binding.textViewSumAmount.setText(Integer.toString(sumAmount));

        foodAdapter = new FoodAdapter(foods, getContext(),myClick);
        binding.recyclerView.setAdapter(foodAdapter);
        return binding.getRoot();
    }
    Food food1, food2, food3, food4;
    ArrayList<Food> foods;
    FoodAdapter foodAdapter;
    static int sumAmount = 0, sumTotal = 0;

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }


    @Override
    public void OnClickName(Food food) {
//        sumAmount++;
//        binding.textViewSumAmount.setText(Integer.toString(sumAmount));
    }
}
