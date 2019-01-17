package com.example.duncan.worktodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Werkgever")) && (userPassword.equals("Werkgever"))){
            Intent intent = new Intent(LogInActivity.this, MenuWGActivity.class);
            startActivity(intent);
            return;
        }

        else if((userName.equals("Werknemer")) && (userPassword.equals("Werknemer"))) {
            Intent intent = new Intent(LogInActivity.this, MenuWNActivity.class);
            startActivity(intent);
            return;
        }

        else{
            counter--;

            Info.setText("Remaining attempts: " + String.valueOf(counter));

            Toast.makeText(getApplicationContext(), "Wrong username or password! Please try again.", Toast.LENGTH_LONG).show();

            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}
