package com.eunji0118.tpsmarthabit;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class GlobalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //카카오 sdk initialize.. [네이티브앱 키 등록]
        KakaoSdk.init(this,"818c9041cf1d6422b1c204156d94220f");



    }
}
