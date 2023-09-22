package com.eunji0118.tpsmarthabit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.eunji0118.tpsmarthabit.databinding.FragmentImportantBinding;

public class ImportantFragment extends Fragment {
    FragmentImportantBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentImportantBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}
