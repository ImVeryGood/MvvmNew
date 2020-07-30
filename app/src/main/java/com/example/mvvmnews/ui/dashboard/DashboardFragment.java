package com.example.mvvmnews.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmnews.R;
import com.example.mvvmnews.bean.NewBean;
import com.example.mvvmnews.ui.home.HomeViewModel;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private HomeViewModel homeViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        homeViewModel= new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        homeViewModel.newsBean.observe(getViewLifecycleOwner(), new Observer<NewBean>() {
            @Override
            public void onChanged(NewBean newBean) {
                Log.d("SSSSSSSSSSSSSSSS", "onChanged: 666");
            }
        });
        return root;
    }
}
