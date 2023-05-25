package com.example.wagba_salma.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.wagba_salma.Models.ProfileModel;

@Dao
public interface myProfileDao {

    @Query("SELECT * from my_profile  WHERE email = :email")
    LiveData<ProfileModel> get_profile(String email);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void edit_profile(ProfileModel profileModel);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert_profile(ProfileModel profile);
}