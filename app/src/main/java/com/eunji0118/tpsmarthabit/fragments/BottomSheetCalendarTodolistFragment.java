package com.eunji0118.tpsmarthabit.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.eunji0118.tpsmarthabit.R;
import com.eunji0118.tpsmarthabit.activities.AddTodolistActivity;
import com.eunji0118.tpsmarthabit.databinding.FragmentBottomSheetCalendarTodolistBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;

public class BottomSheetCalendarTodolistFragment extends BottomSheetDialogFragment{

    FragmentBottomSheetCalendarTodolistBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentBottomSheetCalendarTodolistBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                AddTodolistActivity ata=(AddTodolistActivity) getActivity();
                ata.year=i;
                ata.month=i1;
                ata.day=i2;
                ata.binding.tvDate.setText(i+"년 "+(i1+1)+"월 "+i2+"일");

                dismiss();
            }
        });
    }



}
