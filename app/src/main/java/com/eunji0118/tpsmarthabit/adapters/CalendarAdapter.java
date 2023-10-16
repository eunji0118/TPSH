package com.eunji0118.tpsmarthabit.adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eunji0118.tpsmarthabit.R;
import com.eunji0118.tpsmarthabit.data.CalendarItem;
import com.eunji0118.tpsmarthabit.databinding.RecyclerItemBinding;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.VH> {

    Context context;
    ArrayList<CalendarItem> calendars;

    SQLiteDatabase db;

    public CalendarAdapter(Context context, ArrayList<CalendarItem> calendars) {
        this.context = context;
        this.calendars = calendars;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        CalendarItem calendar=calendars.get(position);
        holder.binding.tvTitle.setText(calendar.title);



    }

    @Override
    public int getItemCount() {return calendars.size();}

    class VH extends RecyclerView.ViewHolder {
        RecyclerItemBinding binding;
        public VH(@NonNull View itemView) {
            super(itemView);
            binding=RecyclerItemBinding.bind(itemView);
        }
    }
}
