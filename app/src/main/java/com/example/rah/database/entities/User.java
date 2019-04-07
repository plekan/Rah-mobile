package com.example.rah.database.entities;

import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "access_token")
    public String access_token;

    @ColumnInfo(name = "refresh_token")
    public String refresh_token;

    @NonNull
    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }
}
