package com.example.a38_nguyenngocanh_22122019;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.a38_nguyenngocanh_22122019.databinding.ActivityLoginBinding;

public class LoginFragment extends Fragment {

    ActivityLoginBinding binding;

    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_login, container, false);

        binding.buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.editTextUserName.getText().toString().equals(user) &&
                        binding.editTextPassword.getText().toString().equals(password)){
                    getActivity().getSupportFragmentManager().beginTransaction
                            ().addToBackStack(null).replace(R.id.frame_layout, new OrderFragment()).commit();
                }
                else{
                    Toast.makeText(getContext() , "Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return binding.getRoot();
    }
    private String user = "";
    private String password = "";
}
