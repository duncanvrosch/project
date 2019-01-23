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

    public void onClickMAKENEWACCOUNT(View v) {

        EditText usernameEdit = findViewById(R.id.etUsername);
        String username = usernameEdit.getText().toString();
        EditText passwordEdit = findViewById(R.id.etPassword);
        String password = passwordEdit.getText().toString();
        EditText confirmPasswordEdit = findViewById(R.id.etConfirmpassword);
        String confirmpassword = confirmPasswordEdit.getText().toString();

        if(password.equals(confirmpassword) && !username.equals("")){
            AccountPost post = new AccountPost(NewAccountWGActivity.this);
            post.postLogger(NewAccountWGActivity.this, username, password);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(NewAccountWGActivity.this, MenuWGActivity.class);
            startActivity(intent);
        }

        else if(!password.equals(confirmpassword)){
            Toast.makeText(getApplicationContext(), "You entered different passwords!", Toast.LENGTH_LONG).show();
        }

        else if(password.equals("") || username.equals("") || confirmpassword.equals("")){
            Toast.makeText(getApplicationContext(), "You left a line empty!", Toast.LENGTH_LONG).show();
        }
    }
}

