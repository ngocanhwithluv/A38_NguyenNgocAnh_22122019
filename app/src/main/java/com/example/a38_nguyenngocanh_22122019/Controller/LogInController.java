package com.example.a38_nguyenngocanh_22122019.Controller;

import android.widget.Toast;

import com.example.a38_nguyenngocanh_22122019.AppManager;
import com.example.a38_nguyenngocanh_22122019.View.LoginFragment;

public class LogInController {

    public static String user = "";
    public static String password = "";

    public static boolean checkPass(String user, String pass ){
        if(LogInController.user.equals(user) && LogInController.password.equals(pass)){
            return true;
        }
        else{
            return false;
        }
    }
}
