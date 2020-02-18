package com.czl.biji.ui.two;

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

public class TwoFragment extends Fragment {

    private TwoViewModel twoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        twoViewModel =
                ViewModelProviders.of(this).get(TwoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_two, container, false);
        final TextView textView = root.findViewById(R.id.text_two);
        twoViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}