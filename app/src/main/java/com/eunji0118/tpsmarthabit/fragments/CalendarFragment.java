package com.eunji0118.tpsmarthabit.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.eunji0118.tpsmarthabit.R;
import com.eunji0118.tpsmarthabit.activities.AddTodolistActivity;
import com.eunji0118.tpsmarthabit.activities.MainActivity;
import com.eunji0118.tpsmarthabit.databinding.FragmentCalendarBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CalendarFragment extends Fragment {
    FragmentCalendarBinding binding;
    EditText dialogTitle;
    TextView dialogBtn;

    SQLiteDatabase db;

    int year,month,day;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentCalendarBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        db=getActivity().openOrCreateDatabase("mytodo",Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS schedule (_no INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, date TEXT NOT NULL, id TEXT)");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        MainActivity ma=(MainActivity) getActivity();
//        adapter=new ArrayAdapter(getActivity(),R.layout.listview_item,datas);
//        binding.listItem.setAdapter(adapter);

        Calendar calendar= Calendar.getInstance(); //현재 날짜..
        year= calendar.get(Calendar.YEAR);
        month= calendar.get(Calendar.MONTH);
        day= calendar.get(Calendar.DAY_OF_MONTH);

        binding.calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                year= i;
                month= i1;
                day= i2;
            }
        });

        binding.fab.setOnClickListener(v -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            builder.setTitle("");
            builder.setView(R.layout.dialog);
            builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog=builder.create();
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();

            dialogTitle=dialog.findViewById(R.id.et_title);
            dialogBtn=dialog.findViewById(R.id.tv_save);
            dialogBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String title=dialogTitle.getText().toString();
                    String date=year+"년"+(month+1)+"월"+day+"일";

//                    datas.add(s);
//                    adapter.notifyDataSetChanged();

                    //일정데이터(title, date) 디비에 저장 scadule
                    db.execSQL("INSERT INTO schedule(title,date) VALUES (?,?)", new String[]{title, date});

                    dialog.dismiss();
                }
            });




        });

    }


}


