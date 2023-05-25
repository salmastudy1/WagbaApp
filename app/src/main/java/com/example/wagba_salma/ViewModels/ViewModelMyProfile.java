package com.example.wagba_salma.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.wagba_salma.Repositories.myProfileRepo;
import com.example.wagba_salma.Models.ProfileModel;


public class ViewModelMyProfile extends AndroidViewModel {
    private myProfileRepo mRepository;

    private LiveData<ProfileModel> profile;

    public ViewModelMyProfile(@NonNull Application application) {
        super(application);
        mRepository = new myProfileRepo(application);
    }

    public LiveData<ProfileModel> getProfileOfUser( String email){
        profile = mRepository.getProfileOfUser(email);
        return profile;
    }

    public void insert(ProfileModel profile) { mRepository.insert(profile); }

    public void edit(ProfileModel profile) { mRepository.edit(profile); }

}
