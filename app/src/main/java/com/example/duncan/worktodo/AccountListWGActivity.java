package com.example.duncan.worktodo;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class AccountListWGActivity extends AppCompatActivity implements AccountListHelper.Callback {

    ArrayList<Account> accountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_list_wg);

        AccountListHelper helper = new AccountListHelper(this);
        helper.getAccount(this);

        ListView lv = findViewById(R.id.scores);
        lv.setOnItemClickListener(new SelectItemClickListener());
    }

    @Override
    public void gotAccount(ArrayList<Account> accountList) {
        this.accountList = accountList;
        ListView account = findViewById(R.id.scores);
        AccountAdapter adapter = new AccountAdapter(this, accountList);
        account.setAdapter(adapter);
    }

    @Override
    public void gotAccountError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private class SelectItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Account item = (Account) parent.getItemAtPosition(position);

            Intent intent = new Intent(AccountListWGActivity.this, AccountDetailWGActivity.class);
            intent.putExtra("selected_item", item);
            startActivity(intent);
        }
    }

    public void onClickMAKENEWACCOUNT(View v) {

        Intent intent = new Intent(AccountListWGActivity.this, NewAccountWGActivity.class);
        startActivity(intent);
    }

    public void onClickBACKTOMENU(View v) {

        Intent intent = new Intent(AccountListWGActivity.this, MenuWGActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AccountListWGActivity.this, MenuWGActivity.class);
        startActivity(intent);
    }
}
