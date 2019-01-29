package com.example.duncan.worktodo;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AccountAdapter extends ArrayAdapter<Account> {

    // constructor
    public AccountAdapter(Context context, ArrayList<Account> accountList) {
        super(context, 0, accountList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.account_item, parent, false);
        }

        // grab account
        Account account = getItem(position);

        // set username
        TextView username = convertView.findViewById(R.id.usernameText);
        username.setText(account.getUsername());

        return convertView;
    }
}