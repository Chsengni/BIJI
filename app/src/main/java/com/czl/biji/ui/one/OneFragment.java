package com.czl.biji.ui.one;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.czl.biji.R;
import com.czl.biji.ui.main.SectionsPagerAdapter;
import com.czl.biji.ui.viewpage.NoScrollViewPager;
import com.google.android.material.tabs.TabLayout;

public class OneFragment extends Fragment {

    private OneViewModel oneViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        oneViewModel =
                ViewModelProviders.of(this).get(OneViewModel.class);
        View root = inflater.inflate(R.layout.fragment_one, container, false);
        final TextView textView = root.findViewById(R.id.text_one);
        oneViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getContext(), getActivity().getSupportFragmentManager());
        NoScrollViewPager viewPager = root.findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = root.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        return root;
    }
}