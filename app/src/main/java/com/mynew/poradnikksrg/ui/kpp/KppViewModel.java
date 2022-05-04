package com.mynew.poradnikksrg.ui.kpp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KppViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public KppViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is KPP fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}