package com.eunji0118.tpsmarthabit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.eunji0118.tpsmarthabit.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //게스트
        binding.tvGeustGo.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        //회원가입 클릭
        binding.tvSingup.setOnClickListener(view -> startActivity(new Intent(this, SignupActivity.class)));
        //이메일 로그인버튼
        binding.tvEmail.setOnClickListener(view -> startActivity(new Intent(this, EmailSigninActivity.class)));
    }
}