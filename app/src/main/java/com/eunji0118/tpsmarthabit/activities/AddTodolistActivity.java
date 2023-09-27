package com.eunji0118.tpsmarthabit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

import com.eunji0118.tpsmarthabit.R;
import com.eunji0118.tpsmarthabit.databinding.ActivityAddTodolistBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTodolistActivity extends AppCompatActivity {
    ActivityAddTodolistBinding binding;

    BottomSheetBehavior bottomSheetBehavior;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        binding=ActivityAddTodolistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.toolbar.setNavigationOnClickListener(view -> finish());

        //저장버튼
        binding.tvSave.setOnClickListener(view -> {

        });



    }

}