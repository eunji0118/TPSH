package com.eunji0118.tpsmarthabit.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.eunji0118.tpsmarthabit.activities.AddTodolistActivity;
import com.eunji0118.tpsmarthabit.databinding.FragmentTodolistBinding;

public class TodolistFragment extends Fragment {
    FragmentTodolistBinding binding;


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

}
