package com.example.duncan.worktodo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LoggerAdapter extends ArrayAdapter<Helper> {

    // constructor
    public LoggerAdapter(Context context, ArrayList<Helper> itemList) {
        super(context, 0, itemList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // grab item
        Helper score = getItem(position);

        // set info in imageviews and textviews
        ImageView redflag = convertView.findViewById(R.id.redflag);
        ImageView orangeflag = convertView.findViewById(R.id.orangeflag);
        ImageView greenflag = convertView.findViewById(R.id.greenflag);
        TextView titleText = convertView.findViewById(R.id.titleText);
        TextView priorityText = convertView.findViewById(R.id.priorityText);
        TextView timestampText = convertView.findViewById(R.id.timestampText);

        titleText.setText(score.getTitle());
        priorityText.setText(score.getPriority());
        timestampText.setText(score.getTimestamp());

        if (priorityText.getText().toString().equals("high")){
            redflag.setVisibility(View.VISIBLE);
        }

        else if (priorityText.getText().toString().equals("medium")){
            orangeflag.setVisibility(View.VISIBLE);
        }

        if (priorityText.getText().toString().equals("low")){
            greenflag.setVisibility(View.VISIBLE);
        }

        return convertView;
    }
}