package com.example.a38_nguyenngocanh_22122019;

import android.content.Context;
import android.os.Handler;

import com.example.a38_nguyenngocanh_22122019.Controller.Controller;
import com.example.a38_nguyenngocanh_22122019.View.LoginFragment;
import com.example.a38_nguyenngocanh_22122019.View.OrderFragment;
import com.example.a38_nguyenngocanh_22122019.View.YourOrderFragment;

public class AppManager {
    public static Context context;
    public static Controller controller;
    public static Handler handler;

    public static LoginFragment loginFragment = LoginFragment.newInstance();
    public static OrderFragment orderFragment = OrderFragment.newInstance();
    public static YourOrderFragment yourOrderFragment = YourOrderFragment.newInstance();


}
