package com.example.a38_nguyenngocanh_22122019.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a38_nguyenngocanh_22122019.AppManager;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        food = foods.get(position);

        holder.nameFood.setText(food.getName());
        holder.amountFood.setText("" + food.getAmount() + "");
        holder.imageFood.setImageResource(food.getImage());
        holder.priceFood.setText(food.getPrice() + "$");
        holder.deleteFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food = foods.get(position);
                if (food.getAmount() > 1) {
                    myClick.OnClickDelete(food);
                    holder.amountFood.setText(food.getAmount() + "");
                } else {
                    if (food.getAmount() == 1) {
                        Toast.makeText(AppManager.context, "Số lượng tối thiểu là 1", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        holder.addFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food = foods.get(position);
                myClick.OnClickAdd(food);
                holder.amountFood.setText(food.getAmount() + "");
            }
        });
        holder.removeFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food = foods.get(position);
                myClick.OnClickRemove(food);
                notifyDataSetChanged();
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
        TextView priceFood;
        TextView removeFood;
        ImageView imageFood;
        RelativeLayout relativeLayout;
        Button addFoodButton, deleteFoodButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameFood = itemView.findViewById(R.id.text_view_name);
            amountFood = itemView.findViewById(R.id.amount_text_view);
            imageFood = itemView.findViewById(R.id.image_food);
            relativeLayout = itemView.findViewById(R.id.relative_layout_1);
            priceFood = itemView.findViewById(R.id.price_text_view);
            addFoodButton = itemView.findViewById(R.id.add_food_button);
            deleteFoodButton = itemView.findViewById(R.id.delete_food_button);
            removeFood = itemView.findViewById(R.id.remove_food_ordered);
        }
    }

    private ArrayList<Food> foods;
    private Context context;
    private ActivityYourorderBinding binding;
    private MyClick myClick;
    private Food food;
}
