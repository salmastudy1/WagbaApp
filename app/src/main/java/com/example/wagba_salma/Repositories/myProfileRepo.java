package com.example.wagba_salma.Repositories;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.wagba_salma.Models.ProfileModel;
import com.example.wagba_salma.database.myDatabase;
import com.example.wagba_salma.database.myProfileDao;


public class myProfileRepo {
    private myProfileDao myProfileDao;
    private LiveData<ProfileModel> profileModel;

    public myProfileRepo(Application application){
        myDatabase db = myDatabase.getDatabase(application);
        myProfileDao = db.myProfileDao();
    }

    public LiveData<ProfileModel> getProfileOfUser(String email) {
        profileModel = myProfileDao.get_profile(email);
        return profileModel;
    }

    public void edit (ProfileModel profile){
        new myProfileRepo.insertAsyncTask(myProfileDao).execute(profile);
    }

    private static class insertAsyncTask extends AsyncTask<ProfileModel, Void, Void> {

        private myProfileDao mAsyncTaskDao;

        insertAsyncTask(myProfileDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ProfileModel... params) {
            mAsyncTaskDao.edit_profile(params[0]);
            return null;
        }
    }

    public void insert (ProfileModel profile){
        new myProfileRepo.insertFirstTimeAsyncTask(myProfileDao).execute(profile);
    }

    private static class insertFirstTimeAsyncTask extends AsyncTask<ProfileModel, Void, Void> {

        private myProfileDao mAsyncTaskDao;

        insertFirstTimeAsyncTask(myProfileDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ProfileModel... params) {
            mAsyncTaskDao.insert_profile(params[0]);
            Log.d("TAG", "onClick2: ");

            return null;
        }
    }
}