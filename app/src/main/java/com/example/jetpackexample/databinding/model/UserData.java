package com.example.jetpackexample.databinding.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.jetpackexample.BR;

public class UserData  extends BaseObservable {
    private String firstName;
    private String lastName;
    public UserData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Bindable
    public String getFirstName() {
        return this.firstName;
    }
    @Bindable
    public String getLastName() {
        return this.lastName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
