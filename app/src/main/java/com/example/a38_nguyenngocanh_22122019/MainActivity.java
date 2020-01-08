package com.example.a38_nguyenngocanh_22122019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static Handler handler;
    public static LoginFragment loginFragment = LoginFragment.newInstance();
    public static OrderFragment orderFragment = OrderFragment.newInstance();
    public static YourOrderFragment yourOrderFragment = YourOrderFragment.newInstance();

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

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, loginFragment).commit();
        OrderFragment.FoodList();

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 1: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, orderFragment).commit();

                        break;
                    }
                    case 2: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, yourOrderFragment).commit();

                        break;
                    }
                    case 0: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, LoginFragment.newInstance()).commit();

                        break;
                    }
                }
            }
        };
    }
}
