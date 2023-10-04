package com.eunji0118.tpsmarthabit.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;

import com.eunji0118.tpsmarthabit.R;
import com.eunji0118.tpsmarthabit.databinding.ActivityAddTodolistBinding;
import com.eunji0118.tpsmarthabit.databinding.FragmentBottomSheetCalendarTodolistBinding;
import com.eunji0118.tpsmarthabit.fragments.BottomSheetCalendarTodolistFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTodolistActivity extends AppCompatActivity {
    public ActivityAddTodolistBinding binding;
    public int year,month,day;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddTodolistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment=new BottomSheetCalendarTodolistFragment();
                dialogFragment.show(getSupportFragmentManager(),"datePicker");
            }
        });





        binding.toolbar.setNavigationOnClickListener(view -> finish());

        //저장버튼
        binding.tvSave.setOnClickListener(view -> {


        });



    }


}