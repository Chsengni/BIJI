package com.czl.biji.ui.four;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FourViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FourViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is four fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}