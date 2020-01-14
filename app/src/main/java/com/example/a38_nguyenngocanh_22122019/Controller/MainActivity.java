package com.example.a38_nguyenngocanh_22122019.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.example.a38_nguyenngocanh_22122019.AppManager;
import com.example.a38_nguyenngocanh_22122019.R;


public class MainActivity extends AppCompatActivity {

    public void moveFragment(int message) {
        switch (message) {
            case 1: {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, AppManager.orderFragment).commit();

                break;
            }
            case 2: {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, AppManager.yourOrderFragment).commit();

                break;
            }
            case 0: {
                Controller.resetData();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, AppManager.loginFragment).commit();
                break;
            }
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
        AppManager.context = getApplicationContext();
        moveFragment(0);
        AppManager.handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                moveFragment(msg.what);
            }
        };


    }

}
