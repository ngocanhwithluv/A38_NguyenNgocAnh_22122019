package com.example.a38_nguyenngocanh_22122019.View;

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

import com.example.a38_nguyenngocanh_22122019.Adapter.FoodOrderAdapter;
import com.example.a38_nguyenngocanh_22122019.AppManager;
import com.example.a38_nguyenngocanh_22122019.Controller.Controller;
import com.example.a38_nguyenngocanh_22122019.Model.Food;
import com.example.a38_nguyenngocanh_22122019.MyClick;
import com.example.a38_nguyenngocanh_22122019.R;
import com.example.a38_nguyenngocanh_22122019.databinding.ActivityYourorderBinding;

public class YourOrderFragment extends Fragment {

    public FoodOrderAdapter foodOrderAdapter;
    public ActivityYourorderBinding binding;

    public static YourOrderFragment newInstance() {
        Bundle args = new Bundle();
        YourOrderFragment fragment = new YourOrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    MyClick myClick = new MyClick() {
        @Override
        public void OnClickAdd(Food food) {
            Controller.addFoods(food);
            binding.sumTotal.setText("Total: " + Controller.sumTotal + "$");
        }
        @Override
        public void OnClickDelete(Food food) {
            Controller.delFood(food);
            binding.sumTotal.setText("Total: " + Controller.sumTotal + "$");
        }

        @Override
        public void OnClickRemove(Food food) {
            Controller.reMoveFood(food);
            binding.sumTotal.setText("Total: " + Controller.sumTotal + "$");
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_yourorder, container, false);
        binding.sumTotal.setText("Total: " + Controller.sumTotal + "$");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        binding.recyclerView.setLayoutManager(linearLayoutManager);
        foodOrderAdapter = new FoodOrderAdapter(Controller.foodsOrdered, getContext(), myClick);
        foodOrderAdapter.notifyDataSetChanged();
        binding.recyclerView.setAdapter(foodOrderAdapter);
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller.editFood();
                AppManager.handler.sendEmptyMessageDelayed(1, 0);
            }
        });
        return binding.getRoot();
    }
}
