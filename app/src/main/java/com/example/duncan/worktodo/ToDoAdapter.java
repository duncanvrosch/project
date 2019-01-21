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

public class ToDoAdapter extends ArrayAdapter<Score> {

    public ToDoAdapter(Context context, ArrayList<Score> highscoresList) {
        super(context, 0, highscoresList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.score_item, parent, false);
        }

        Score score = getItem(position);

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