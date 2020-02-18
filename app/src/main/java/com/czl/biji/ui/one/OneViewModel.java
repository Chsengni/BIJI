package com.czl.biji.ui.one;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OneViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OneViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is one fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}