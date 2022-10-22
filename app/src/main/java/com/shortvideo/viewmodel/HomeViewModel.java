package com.shortvideo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.adapters.AdapterViewBindingAdapter;

import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * @Author: xu xiao wei
 * @Date: 2022/10/13 22:58
 * @Version 1.0
 * Created by IntelliJ IDEA.
 */
public class HomeViewModel extends BaseViewModel<BaseModel> {
    private ObservableField<AdapterViewBindingAdapter.OnItemSelected> mNavigationView = new ObservableField<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }
}
