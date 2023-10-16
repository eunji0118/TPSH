package com.eunji0118.tpsmarthabit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.eunji0118.tpsmarthabit.databinding.ActivityLoginBinding;
import com.eunji0118.tpsmarthabit.G;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.util.Utility;
import com.kakao.sdk.user.UserApiClient;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

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
        //간편로그인 버튼
        binding.ivKakao.setOnClickListener(view -> clickLoginKakao());
        binding.ivGoogle.setOnClickListener(view -> clickLoginGoogle());

        //카카오 키해시값 얻어오기
        String keyHash= Utility.INSTANCE.getKeyHash(this);
        Log.d("KeyHash",keyHash);
    }
    void clickLoginKakao(){
        Function2<OAuthToken, Throwable, Unit> callback=new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if (throwable !=null){
                    Toast.makeText(LoginActivity.this, "카카오로그인 실패 : "+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "카카오로그인 성공", Toast.LENGTH_SHORT).show();

                    UserApiClient.getInstance().me((user, throwable1) -> {
                        String nickname=user.getKakaoAccount().getProfile().getNickname();
                        String profileImage=user.getKakaoAccount().getProfile().getProfileImageUrl();

                        G.email=user.getKakaoAccount().getEmail();
                        Toast.makeText(LoginActivity.this, ""+G.email, Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                        return null;
                    });
                }
                return null;
            }
        };

        //카톡으로 로그인 권장. 설치되지 않았다면 카카오계정 로그인시도.
        if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(this)){
            UserApiClient.getInstance().loginWithKakaoTalk(this,callback);
        }else {
            UserApiClient.getInstance().loginWithKakaoAccount(this,callback);
        }



    }
    void clickLoginGoogle(){

    }

}