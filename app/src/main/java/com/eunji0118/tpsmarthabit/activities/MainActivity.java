package com.eunji0118.tpsmarthabit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.eunji0118.tpsmarthabit.R;
import com.eunji0118.tpsmarthabit.databinding.ActivityMainBinding;
import com.eunji0118.tpsmarthabit.fragments.CalendarFragment;
import com.eunji0118.tpsmarthabit.fragments.DdayFragment;
import com.eunji0118.tpsmarthabit.fragments.ImportantFragment;
import com.eunji0118.tpsmarthabit.fragments.SettingFragment;
import com.eunji0118.tpsmarthabit.fragments.TodolistFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    int year,month,day;


    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy년  MM월  dd일");
    String dateData=new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Date date=new Date();
        dateData= simpleDateFormat.format(date);
        binding.tvTodayDate.setText(String.valueOf(dateData));




        getSupportFragmentManager().beginTransaction().add(R.id.container_fragment,new CalendarFragment()).commit();

        binding.bnv.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id==R.id.bnv_calendar)
                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,new CalendarFragment()).commit();
            else if (id==R.id.bnv_todo)
                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,new TodolistFragment()).commit();
            else if (id==R.id.bnv_dday)
                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,new DdayFragment()).commit();
            else if (id==R.id.bnv_important)
                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,new ImportantFragment()).commit();
            else if (id==R.id.bnv_setting)
                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,new SettingFragment()).commit();

            return true;
        });

    }



}