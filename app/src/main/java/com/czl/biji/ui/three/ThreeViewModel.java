package com.czl.biji.ui.three;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ThreeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ThreeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Three fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}