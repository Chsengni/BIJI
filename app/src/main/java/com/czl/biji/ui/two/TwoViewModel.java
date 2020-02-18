package com.czl.biji.ui.two;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TwoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TwoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Two fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}