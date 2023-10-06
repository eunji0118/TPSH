package com.eunji0118.tpsmarthabit.fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.eunji0118.tpsmarthabit.activities.AddTodolistActivity;
import com.eunji0118.tpsmarthabit.activities.MainActivity;
import com.eunji0118.tpsmarthabit.adapters.TodoAdapter;
import com.eunji0118.tpsmarthabit.data.Todo;
import com.eunji0118.tpsmarthabit.databinding.FragmentTodolistBinding;

import java.util.ArrayList;

public class TodolistFragment extends Fragment {
    FragmentTodolistBinding binding;
    ArrayList<Todo> todos=new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentTodolistBinding.inflate(inflater,container,false);
        binding.fab.setOnClickListener(view -> {
            Intent i =new Intent(getActivity(), AddTodolistActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(i);
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        loadData();
    }

    void loadData(){

        SQLiteDatabase db=getActivity().openOrCreateDatabase("mytodo", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS todo(_no INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT NOT NULL,date TEXT NOT NULL,id TEXT,isDone INTEGER(1) NOT NULL,important INTEGER(1) NOT NULL)");

        Cursor cursor=db.rawQuery("SELECT title,date,isDone,important FROM todo",null);

        if (cursor !=null){

            todos.clear();

            while (cursor.moveToNext()){

                Todo todo=new Todo();
                todo.title=cursor.getString(0);
                todo.date=cursor.getString(1);
                todo.isDone=cursor.getInt(2);
                todo.important=cursor.getInt(3);

                todos.add(todo);
            }

            Toast.makeText(getActivity(), todos.size()+"", Toast.LENGTH_SHORT).show();

        }

    }

}
