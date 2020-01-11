package com.example.a38_nguyenngocanh_22122019.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a38_nguyenngocanh_22122019.Model.Food;
import com.example.a38_nguyenngocanh_22122019.MyClick;
import com.example.a38_nguyenngocanh_22122019.R;
import com.example.a38_nguyenngocanh_22122019.databinding.ActivityYourorderBinding;

import java.util.ArrayList;

public class FoodOrderAdapter extends RecyclerView.Adapter<FoodOrderAdapter.ViewHolder> {

    public FoodOrderAdapter(ArrayList<Food> foodArrayList, Context context, MyClick myClick) {
        this.foods = foodArrayList;
        this.context = context;
        this.myClick = myClick;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_yourorder_layout, parent, false);
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_yourorder, parent, false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        food = foods.get(position);
        holder.nameFood.setText(food.getName());
        holder.amountFood.setText("(" + food.getAmount() + ")");
        holder.imageFood.setImageResource(food.getImage());
        holder.nameFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (food.getAmount() > 0) {
                    myClick.OnClickAdd(food);
                    int amount = food.getAmount() - 1;
                    food.setAmount(amount);
                    holder.amountFood.setText("(" + food.getAmount() + ")");
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameFood;
        TextView amountFood;
        ImageView imageFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameFood = itemView.findViewById(R.id.text_view_name);
            amountFood = itemView.findViewById(R.id.text_view_amount);
            imageFood = itemView.findViewById(R.id.image_food);
        }
    }

    private ArrayList<Food> foods;
    private Context context;
    private ActivityYourorderBinding binding;
    private MyClick myClick;
    private Food food;
}
