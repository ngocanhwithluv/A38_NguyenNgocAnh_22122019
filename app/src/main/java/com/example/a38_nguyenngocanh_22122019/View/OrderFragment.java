package com.example.a38_nguyenngocanh_22122019.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.a38_nguyenngocanh_22122019.Adapter.FoodAdapter;
import com.example.a38_nguyenngocanh_22122019.Controller.MainActivity;
import com.example.a38_nguyenngocanh_22122019.Model.Food;
import com.example.a38_nguyenngocanh_22122019.MyClick;
import com.example.a38_nguyenngocanh_22122019.R;
import com.example.a38_nguyenngocanh_22122019.databinding.ActivityOrderBinding;

public class OrderFragment extends Fragment {

    public ActivityOrderBinding binding;
    public FoodAdapter foodAdapter;
    public static int sumAmount = 0, sumTotal = 0;
    public static OrderFragment newInstance() {
        Bundle args = new Bundle();
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    MyClick myClick = new MyClick() {
        @Override
        public void OnClickAdd(Food food) {
            sumAmount++;
            sumTotal += food.getPrice();
            int newAmount = food.getAmount();
            food.setAmount(newAmount++);
            binding.sumTotal.setText("Total: " + sumTotal);
            binding.textViewSumAmount.setText(Integer.toString(sumAmount));
            Toast.makeText(getContext(), "+1", Toast.LENGTH_SHORT).show();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_order, container, false);

        binding.sumTotal.setText("Total: " + sumTotal);

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.sendMessage(0);
            }
        });

        binding.buttonYourOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.sendMessage(2);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,RecyclerView.HORIZONTAL );

        binding.recyclerView.setLayoutManager(linearLayoutManager);
        foodAdapter = new FoodAdapter(MainActivity.foods, getContext(), myClick);
        foodAdapter.notifyDataSetChanged();
        binding.textViewSumAmount.setText(Integer.toString(sumAmount));
        binding.recyclerView.setAdapter(foodAdapter);
        return binding.getRoot();
    }
}
