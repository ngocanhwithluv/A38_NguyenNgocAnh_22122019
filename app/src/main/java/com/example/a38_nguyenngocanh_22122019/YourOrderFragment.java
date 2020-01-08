package com.example.a38_nguyenngocanh_22122019;

import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a38_nguyenngocanh_22122019.databinding.ActivityYourorderBinding;

import java.util.ArrayList;

public class YourOrderFragment extends Fragment {
    FoodOrderAdapter foodOrderAdapter;
    ActivityYourorderBinding binding;
    public static Message msg;
    public static YourOrderFragment newInstance() {
        Bundle args = new Bundle();
        YourOrderFragment fragment = new YourOrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    MyClick myClick = new MyClick() {
        @Override
        public void OnClickAdd(Food food) {
                OrderFragment.sumAmount--;
                OrderFragment.sumTotal -= food.getPrice();
                int t = food.getAmount();
                food.setAmount(t--);
                Toast.makeText(getContext(), "-1", Toast.LENGTH_SHORT).show();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_yourorder, container, false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false);

        binding.recyclerView.setLayoutManager(linearLayoutManager);
        foodOrderAdapter = new FoodOrderAdapter(OrderFragment.foods, getContext(), myClick);
        foodOrderAdapter.notifyDataSetChanged();
        binding.recyclerView.setAdapter(foodOrderAdapter);

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = new Message();
                msg.what = 1;
                MainActivity.handler.sendMessage(msg);
            }
        });

        return binding.getRoot();
    }
}
