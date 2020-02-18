package com.czl.biji.ui.three;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.czl.biji.R;

public class ThreeFragment extends Fragment {

    private ThreeViewModel threeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        threeViewModel =
                ViewModelProviders.of(this).get(ThreeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_three, container, false);
        final TextView textView = root.findViewById(R.id.text_three);
        threeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}