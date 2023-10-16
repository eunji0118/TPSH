package com.eunji0118.tpsmarthabit.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitHelper {

    public static Retrofit getRetrofitInstence(String baseUrl){
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(baseUrl);
        builder.addConverterFactory(ScalarsConverterFactory.create()); //단순일차원값 글자
        Retrofit retrofit=builder.build();

        return retrofit;

    }
}
