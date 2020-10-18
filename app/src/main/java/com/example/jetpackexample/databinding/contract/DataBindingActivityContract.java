package com.example.jetpackexample.databinding.contract;

import com.example.jetpackexample.databinding.model.UserDataObserver;

public interface DataBindingActivityContract {
    interface Presenter {
        void onShowData(UserDataObserver userData);
        void showList();
    }

    interface View {
        void showData(UserDataObserver userData);
    }

}