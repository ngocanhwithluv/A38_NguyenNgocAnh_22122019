package com.example.a38_nguyenngocanh_22122019;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a38_nguyenngocanh_22122019.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class FoodOrderAdapter extends RecyclerView.Adapter<FoodOrderAdapter.ViewHolder> {

    ArrayList<Food> foods;
    Context context;
    ActivityOrderBinding binding;


    public FoodOrderAdapter(ArrayList<Food> foodArrayList, Context context) {
        this.foods = foodArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_yourorder_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Food food = foods.get(position);
        holder.nameFood.setText(food.getName());
        holder.amountFood.setText(Integer.toString(food.getAmount()));
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameFood;
        TextView amountFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameFood = itemView.findViewById(R.id.tex_view_name);
            amountFood = itemView.findViewById(R.id.tex_view_amount);

        }
    }
}
