package com.eunji0118.tpsmarthabit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.eunji0118.tpsmarthabit.G;
import com.eunji0118.tpsmarthabit.R;
import com.eunji0118.tpsmarthabit.databinding.ActivityEmailSigninBinding;
import com.eunji0118.tpsmarthabit.network.RetrofitHelper;
import com.eunji0118.tpsmarthabit.network.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
        String email=binding.inputLayoutEmail.getEditText().getText().toString();
        String password=binding.inputLayoutPw.getEditText().getText().toString();

        //서버에 로그인 여부를 요청
        Retrofit retrofit= RetrofitHelper.getRetrofitInstence("http://smarthabit.dothome.co.kr");
        RetrofitService retrofitService=retrofit.create(RetrofitService.class);
        retrofitService.signin(email,password).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String s=response.body();

                if (s.equals("true")){
                    Toast.makeText(EmailSigninActivity.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                    G.email=email;

                    Intent intent=new Intent(EmailSigninActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }else {
                    Toast.makeText(EmailSigninActivity.this, "이메일과 비밀번호를 다시 확인하세요.", Toast.LENGTH_SHORT).show();
                    binding.inputLayoutEmail.getEditText().requestFocus();
                    binding.inputLayoutEmail.getEditText().selectAll();

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(EmailSigninActivity.this, "서버에 문제가 있습니다. \n다시 시도하세요.", Toast.LENGTH_SHORT).show();

            }
        });

    }
}