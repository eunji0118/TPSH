package com.eunji0118.tpsmarthabit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.eunji0118.tpsmarthabit.databinding.FragmentSettingBinding;

public class SettingFragment extends Fragment {
    FragmentSettingBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentSettingBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}
