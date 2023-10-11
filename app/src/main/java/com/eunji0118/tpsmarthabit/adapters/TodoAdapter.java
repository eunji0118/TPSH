package com.eunji0118.tpsmarthabit.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eunji0118.tpsmarthabit.R;
import com.eunji0118.tpsmarthabit.data.Todo;
import com.eunji0118.tpsmarthabit.databinding.RecyclerItemAddTodolistBinding;
import com.eunji0118.tpsmarthabit.fragments.ImportantFragment;
import com.google.gson.Gson;

import java.util.ArrayList;

public class TodoAdapter  extends RecyclerView.Adapter<TodoAdapter.VH> {

    Context context;
    ArrayList<Todo> todos;
    SQLiteDatabase db;



    public TodoAdapter(Context context, ArrayList<Todo> todos) {
        this.context = context;
        this.todos = todos;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.recycler_item_add_todolist,parent,false);
        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Todo todo=todos.get(position);
        holder.binding.tvTitle.setText(todo.title);
        holder.binding.tvDate.setText(todo.date);

        if (todo.isDone==1){
            holder.binding.checkbox.setChecked(true);
            holder.binding.tvTitle.setTextColor(Color.LTGRAY);
            holder.binding.tvTitle.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        }else{
            holder.binding.checkbox.setChecked(false);
            holder.binding.tvTitle.setTextColor(Color.BLACK);
            holder.binding.tvTitle.setPaintFlags(Paint.HINTING_OFF);
        }

        if (todo.important==1)holder.binding.imgBtn.setImageResource(R.drawable.baseline_star_24);
        else holder.binding.imgBtn.setImageResource(R.drawable.baseline_star_outline_24);

        holder.itemView.setOnLongClickListener(view -> {
            db=context.openOrCreateDatabase("mytodo",Context.MODE_PRIVATE,null);
            db.execSQL("DELETE FROM todo WHERE _no=?",new String[]{todo._no+""});
            todos.remove(position);
            notifyDataSetChanged();
            return true;
        });

        holder.binding.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){

                    db=context.openOrCreateDatabase("mytodo",Context.MODE_PRIVATE,null);
                    db.execSQL("UPDATE todo SET isDone=1 WHERE _no=?",new String[]{todo._no+""});
                    todo.isDone=1;

                }else {
                    db=context.openOrCreateDatabase("mytodo",Context.MODE_PRIVATE,null);
                    db.execSQL("UPDATE todo SET isDone=0 WHERE _no=?",new String[]{todo._no+""});
                    todo.isDone=0;
                }

                notifyDataSetChanged();

            }

        });
        holder.binding.imgBtn.setOnClickListener(view -> {
            if (todo.important==1){
                todo.important=0;
                holder.binding.imgBtn.setImageResource(R.drawable.baseline_star_outline_24);
                db=context.openOrCreateDatabase("mytodo",Context.MODE_PRIVATE,null);
                db.execSQL("UPDATE todo SET important=0 WHERE _no=?",new String[]{todo._no+""});

            }else {
                todo.important=1;
                holder.binding.imgBtn.setImageResource(R.drawable.baseline_star_24);
                db=context.openOrCreateDatabase("mytodo",Context.MODE_PRIVATE,null);
                db.execSQL("UPDATE todo SET important=1 WHERE _no=?",new String[]{todo._no+""});

            }
        });


    }

    @Override
    public int getItemCount() {return todos.size();}

    class VH extends RecyclerView.ViewHolder{
        RecyclerItemAddTodolistBinding binding;


        public VH(@NonNull View itemView) {
            super(itemView);
            binding=RecyclerItemAddTodolistBinding.bind(itemView);


        }
    }
}

