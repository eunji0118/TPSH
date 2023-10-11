package com.eunji0118.tpsmarthabit.fragments;

import android.content.Context;
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

import com.eunji0118.tpsmarthabit.adapters.TodoAdapter;
import com.eunji0118.tpsmarthabit.data.Todo;
import com.eunji0118.tpsmarthabit.databinding.FragmentImportantBinding;

import java.util.ArrayList;

public class ImportantFragment extends Fragment {
    FragmentImportantBinding binding;

    ArrayList<Todo> todos=new ArrayList<>();
    SQLiteDatabase db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentImportantBinding.inflate(inflater,container,false);
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
        db=getActivity().openOrCreateDatabase("mytodo", Context.MODE_PRIVATE,null);
        Cursor cursor=db.rawQuery("SELECT _no,title,date,isDone,important FROM todo WHERE important=1",null);


        if (cursor !=null){
            todos.clear();

            while (cursor.moveToNext()){
                Todo todo=new Todo();

                todo._no=cursor.getInt(0);
                todo.title=cursor.getString(1);
                todo.date=cursor.getString(2);
                todo.isDone=cursor.getInt(3);
                todo.important=cursor.getInt(4);

                todos.add(todo);
            }
            Toast.makeText(getActivity(), todos.size()+"", Toast.LENGTH_SHORT).show();

            TodoAdapter adapter=new TodoAdapter(getActivity(),todos);
            binding.recyclerView.setAdapter(adapter);

            if (todos.size()>0){
                binding.tvText.setVisibility(View.GONE);
            }else {
                binding.tvText.setVisibility(View.VISIBLE);
            }

        }

    }

}
