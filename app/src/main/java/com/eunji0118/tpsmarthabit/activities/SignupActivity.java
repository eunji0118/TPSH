package com.eunji0118.tpsmarthabit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.eunji0118.tpsmarthabit.R;
import com.eunji0118.tpsmarthabit.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //툴바 업버튼 클릭반응
        binding.toolbar.setNavigationOnClickListener(view -> finish());
        binding.tvSingup.setOnClickListener(view -> clickSignup());
    }
    void clickSignup(){

    }
}