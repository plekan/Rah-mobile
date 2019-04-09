package com.example.rah;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.rah.database.AppDatabase;
import com.example.rah.database.UserViewModel;
import com.example.rah.database.entities.User;

import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

public class RegisterActivity extends AppCompatActivity {
    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mUserViewModel = new UserViewModel(this.getApplication());
        mUserViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable final List<User> users) {
                // Update the cached copy of the words in the adapter.
                if (users.size() > 0) {
                    ((TextView) findViewById(R.id.textView)).setText(users.get(users.size() - 1).toString());
                }
            }
        });


        findViewById(R.id.buttonRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.firstName = ((TextView)findViewById(R.id.plName)).getText().toString();
                user.lastName = ((TextView)findViewById(R.id.plLastName)).getText().toString();
                user.email = ((TextView)findViewById(R.id.plEmail)).getText().toString();
                mUserViewModel.insert(user);
                Intent intent = new Intent(v.getContext(), Dashboard.class);
                startActivity(intent);

            }
        });
    }


}
