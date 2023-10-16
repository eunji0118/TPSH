package com.eunji0118.tpsmarthabit.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitService {
    //이메일, 비밀번호 정보를 서버에 전송하는 기능 명세
    //@FormUrlEncoded : 키=벨류&
    @FormUrlEncoded
    @POST("TPSmartHabit/signup.php")
    Call<String> signup(@Field("email") String email, @Field("pw") String password);


    //이메일, 비밀번호를 전송하여 로그인 여부를 확인하는 기능 명세
    @FormUrlEncoded
    @POST("TPSmartHabit/signin.php")
    Call<String> signin(@Field("email") String email, @Field("pw") String password);


}
