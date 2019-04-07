package com.example.rah.database;

import android.app.Application;
import android.os.AsyncTask;

import com.example.rah.database.dao.UserDao;
import com.example.rah.database.entities.User;

import java.util.List;

import androidx.lifecycle.LiveData;

public class UserRepository {
    private UserDao mWordDao;
    private LiveData<List<User>> mAllUsers;

    UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mWordDao = db.userDao();
        mAllUsers = mWordDao.getAll();
    }

    LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }


    public void insert (User user) {
        new insertAsyncTask(mWordDao).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insertAll(params[0]);
            return null;
        }
    }
}
