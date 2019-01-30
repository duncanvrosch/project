package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class NewAccountWGActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account_wg);
    }

    public void onClickMakeNewAccount(View v) {

        // grab info
        EditText usernameEdit = findViewById(R.id.etUsername);
        String username = usernameEdit.getText().toString();
        EditText passwordEdit = findViewById(R.id.etPassword);
        String password = passwordEdit.getText().toString();
        EditText confirmPasswordEdit = findViewById(R.id.etConfirmpassword);
        String confirmpassword = confirmPasswordEdit.getText().toString();

        // if input in password and confirm password is the same, then post new account
        if(password.equals(confirmpassword) && !username.equals("")){
            AccountPost post = new AccountPost(NewAccountWGActivity.this);
            post.postLogger(NewAccountWGActivity.this, username, password);

            // delay of 1 second
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(NewAccountWGActivity.this, AccountListWGActivity.class);
            startActivity(intent);
        }

        // inserted different passwords
        else if(!password.equals(confirmpassword)){
            Toast.makeText(getApplicationContext(), "You entered different passwords!", Toast.LENGTH_LONG).show();
        }

        // line is empty
        else if(password.equals("") || username.equals("") || confirmpassword.equals("")){
            Toast.makeText(getApplicationContext(), "You left a line empty!", Toast.LENGTH_LONG).show();
        }
    }
}

