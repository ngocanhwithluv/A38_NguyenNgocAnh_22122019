package com.example.a38_nguyenngocanh_22122019.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.example.a38_nguyenngocanh_22122019.Model.Food;
import com.example.a38_nguyenngocanh_22122019.R;
import com.example.a38_nguyenngocanh_22122019.View.LoginFragment;
import com.example.a38_nguyenngocanh_22122019.View.OrderFragment;
import com.example.a38_nguyenngocanh_22122019.View.YourOrderFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static Handler handler;
    public static LoginFragment loginFragment = LoginFragment.newInstance();
    public static OrderFragment orderFragment = OrderFragment.newInstance();
    public static YourOrderFragment yourOrderFragment = YourOrderFragment.newInstance();
    public static ArrayList<Food> foods = new ArrayList<>();

    public void moveFragment(int message){
        switch (message) {
            case 1: {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, orderFragment).commit();

                break;
            }
            case 2: {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, yourOrderFragment).commit();

                break;
            }
            case 0: {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, loginFragment).commit();

                break;
            }
        }

    }
    public static void sendMessage(int message){
        Message msg = new Message();
        msg.what = message;
        MainActivity.handler.sendMessage(msg);
    }
    public static void addFood() {
        foods.add(new Food("Coca", 10, 0, R.drawable.soda));
        foods.add(new Food("Chicken", 12, 0, R.drawable.chicken));
        foods.add(new Food("Rice", 15, 0, R.drawable.bread));
        foods.add(new Food("Meat", 20, 0,R.drawable.chinese));
        foods.add(new Food("Durex", 60, 0, R.drawable.fruit));
        foods.add(new Food("BimBim", 5, 0, R.drawable.potato));
        foods.add(new Food("Snack", 6, 0, R.drawable.slice));
        foods.add(new Food("Vegetable", 5, 0, R.drawable.burger));
    }
    public static boolean checkPass(String user, String pass ){
        if(MainActivity.user.equals(user) &&
                MainActivity.password.equals(pass)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
        setContentView(R.layout.activity_main);
        moveFragment(0);
        addFood();
        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                moveFragment(msg.what);
            }
        };
    }
    private static String user = "";
    private static String password = "";
}
