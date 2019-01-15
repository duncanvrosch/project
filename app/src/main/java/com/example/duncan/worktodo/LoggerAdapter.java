package com.example.duncan.worktodo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LoggerAdapter extends ArrayAdapter<Score> {

    public LoggerAdapter(Context context, ArrayList<Score> highscoresList) {
        super(context, 0, highscoresList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.score_item, parent, false);
        }

        Score score = getItem(position);

        TextView titleText = convertView.findViewById(R.id.titleText);
        TextView priorityText = convertView.findViewById(R.id.priorityText);
        TextView timestampText = convertView.findViewById(R.id.timestampText);

        titleText.setText(score.getTitle());
        priorityText.setText(score.getPriority());
        timestampText.setText(score.getTimestamp());

        return convertView;
    }
}