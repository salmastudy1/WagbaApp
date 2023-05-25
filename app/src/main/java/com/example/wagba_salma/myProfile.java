package com.example.wagba_salma;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.wagba_salma.Models.ProfileModel;
import com.example.wagba_salma.ViewModels.ViewModelMyProfile;

public class myProfile extends Fragment {

    TextView name;
    TextView address;
    TextView email;
    TextView phonenumber;
    private ViewModelMyProfile mProfileViewModel;
    Button saveBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        name= view.findViewById(R.id.name);
        address= view.findViewById(R.id.address);
        email= view.findViewById(R.id.email);
        phonenumber= view.findViewById(R.id.phonenumber);
        saveBtn = view.findViewById(R.id.button1);
        mProfileViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ViewModelMyProfile.class);
        mProfileViewModel.getProfileOfUser("test@test.com").observe(getActivity(), new Observer<ProfileModel>() {
            @Override
            public void onChanged(@Nullable final ProfileModel profile) {
                if(profile!=null){
                    email.setText(profile.getEmail());
                    phonenumber.setText(profile.getMobile());
                    name.setText(profile.getName());
                    address.setText(profile.getLocation());

                }
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mphone = phonenumber.getText().toString();
                String maddress = address.getText().toString();
                String mname = name.getText().toString();
                ProfileModel profile = new ProfileModel(mname,maddress,"test@test.com", mphone );
                mProfileViewModel.insert(profile);
            }
        });
        return view;
    }
}