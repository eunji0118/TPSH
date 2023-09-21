package com.eunji0118.tpsmarthabit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.eunji0118.tpsmarthabit.R;
import com.eunji0118.tpsmarthabit.databinding.ActivityEmailSigninBinding;

public class EmailSigninActivity extends AppCompatActivity {
    ActivityEmailSigninBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEmailSigninBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //툴바의 업버튼 클릭 반응
        binding.toolbar.setNavigationOnClickListener(view -> finish());
        binding.tvSingin.setOnClickListener(view -> clickSignin());
    }
    void clickSignin(){

    }
}