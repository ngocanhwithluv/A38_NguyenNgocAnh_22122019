package com.example.a38_nguyenngocanh_22122019;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a38_nguyenngocanh_22122019.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    public ArrayList<Food> foods;
    public Context context;
    public ActivityOrderBinding binding;
    MyClick myClick;

    public FoodAdapter(ArrayList<Food> foodArrayList, Context context, MyClick myClick) {
        this.foods = foodArrayList;
        this.context = context;
        this.myClick = myClick;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_layout, parent, false);
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_order, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Food food = foods.get(position);
        holder.nameFood.setText(food.getName());
        holder.totalFood.setText(food.getPrice()+ "$");

        holder.nameFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClick.OnClickAdd(food);
                int amount = food.getAmount() + 1;
                food.setAmount(amount);
            }
        });

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView nameFood;
        TextView totalFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameFood = itemView.findViewById(R.id.tex_view_name);
            totalFood = itemView.findViewById(R.id.total);

        }
    }
}
