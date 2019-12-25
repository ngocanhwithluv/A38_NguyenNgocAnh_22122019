package com.example.a38_nguyenngocanh_22122019;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a38_nguyenngocanh_22122019.databinding.ActivityYourorderBinding;

import java.util.ArrayList;

public class YourOrderFragment extends Fragment {
    OrderFragment orderFragment = new OrderFragment();
    FoodOrderAdapter foodOrderAdapter;

    ActivityYourorderBinding binding;
    ArrayList<Food> foodss = new ArrayList<>();

    public static YourOrderFragment newInstance() {

        Bundle args = new Bundle();

        YourOrderFragment fragment = new YourOrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_yourorder, container, false);

        foodss = orderFragment.foods;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false);

        binding.recyclerView.setLayoutManager(linearLayoutManager);

        foodOrderAdapter = new FoodOrderAdapter(foodss, getContext());
        binding.recyclerView.setAdapter(foodOrderAdapter);

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        return binding.getRoot();
    }
}
