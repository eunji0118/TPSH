package com.eunji0118.tpsmarthabit.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.eunji0118.tpsmarthabit.R;
import com.eunji0118.tpsmarthabit.databinding.ActivitySignupBinding;
import com.eunji0118.tpsmarthabit.network.RetrofitHelper;
import com.eunji0118.tpsmarthabit.network.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
        String email=binding.inputLayoutEmail.getEditText().getText().toString();
        String password=binding.inputLayoutPw.getEditText().getText().toString();
        String passwordConfirm=binding.inputLayoutPwConfirm.getEditText().getText().toString();

        if (!password.equals(passwordConfirm)){
            new AlertDialog.Builder(this).setMessage("비밀번호 확인에 문제가 있습니다. \n다시 확인하여 입력해주시기 바랍니다.").create().show();
            binding.inputLayoutPwConfirm.getEditText().requestFocus();
            binding.inputLayoutPwConfirm.getEditText().selectAll();
            return;
        }

        Retrofit retrofit= RetrofitHelper.getRetrofitInstence("http://smarthabit.dothome.co.kr");

        RetrofitService retrofitService=retrofit.create(RetrofitService.class);
        Call<String> call=retrofitService.signup(email,password);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String s=response.body();
                Toast.makeText(SignupActivity.this, ""+s, Toast.LENGTH_SHORT).show();
                Log.d("TPSmartHabit",s);

                finish();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(SignupActivity.this, "회원가입에 문제가 발생했습니다.\n다시 시도해 주세요.", Toast.LENGTH_SHORT).show();

            }
        });

    }
}