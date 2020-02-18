package com.czl.biji.ui.four;

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

public class FourFragment extends Fragment {

    private FourViewModel fourViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fourViewModel =
                ViewModelProviders.of(this).get(FourViewModel.class);
        View root = inflater.inflate(R.layout.fragment_four, container, false);
        final TextView textView = root.findViewById(R.id.text_four);
        fourViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}