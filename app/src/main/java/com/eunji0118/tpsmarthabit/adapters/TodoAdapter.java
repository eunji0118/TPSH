package com.eunji0118.tpsmarthabit.adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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

import java.util.ArrayList;

public class TodoAdapter  extends RecyclerView.Adapter<TodoAdapter.VH> {

    Context context;
    ArrayList<Todo> todos;


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

        holder.binding.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    Toast.makeText(context, "on", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "off", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    @Override
    public int getItemCount() {return todos.size();}

    class VH extends RecyclerView.ViewHolder{
        RecyclerItemAddTodolistBinding binding;
        CheckBox cb;
        TextView title;
        TextView date;
        ImageButton imgbnt;

        public VH(@NonNull View itemView) {
            super(itemView);
            binding=RecyclerItemAddTodolistBinding.bind(itemView);
            cb=binding.checkbox;
            title=binding.tvTitle;
            date=binding.tvDate;
            imgbnt=binding.imgBtn;

        }
    }
}

