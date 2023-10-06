package com.eunji0118.tpsmarthabit.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import com.eunji0118.tpsmarthabit.R;
import com.eunji0118.tpsmarthabit.adapters.TodoAdapter;
import com.eunji0118.tpsmarthabit.data.Todo;
import com.eunji0118.tpsmarthabit.databinding.ActivityAddTodolistBinding;
import com.eunji0118.tpsmarthabit.databinding.FragmentBottomSheetCalendarTodolistBinding;
import com.eunji0118.tpsmarthabit.fragments.BottomSheetCalendarTodolistFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddTodolistActivity extends AppCompatActivity {
    public ActivityAddTodolistBinding binding;
    public int year,month,day;
    public String title;
    SQLiteDatabase db;



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
            title=binding.etTitle.getText().toString();

            db= openOrCreateDatabase("mytodo",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS todo(_no INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT NOT NULL,date TEXT NOT NULL,id TEXT,isDone INTEGER(1) NOT NULL,important INTEGER(1) NOT NULL)");

            String date=year+"년"+(month+1)+"월"+day+"일";
            String[] datas=new String[]{title,date,"0","0"};
            db.execSQL("INSERT INTO todo(title, date, isDone, important) VALUES(?,?,?,?)", datas);
            Toast.makeText(this, "저장이 되었습니다.", Toast.LENGTH_SHORT).show();
            finish();

        });
    }


}