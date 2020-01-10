package com.example.a38_nguyenngocanh_22122019.View;

import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.a38_nguyenngocanh_22122019.AppManager;
import com.example.a38_nguyenngocanh_22122019.Controller.LogInController;
import com.example.a38_nguyenngocanh_22122019.Controller.MainActivity;
import com.example.a38_nguyenngocanh_22122019.R;
import com.example.a38_nguyenngocanh_22122019.databinding.ActivityLoginBinding;

public class LoginFragment extends Fragment {

    public ActivityLoginBinding binding;
    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_login, container, false);

        binding.buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(LogInController.checkPass(binding.editTextUserName.getText().toString(), binding.editTextPassword.getText().toString())){
                    AppManager.handler.sendEmptyMessageDelayed(1, 0);
                }
                else {
                    Toast.makeText(getContext(), "Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return binding.getRoot();
    }

}
