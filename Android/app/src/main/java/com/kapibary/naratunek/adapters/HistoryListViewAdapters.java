package com.kapibary.naratunek.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.entity.HistoryEntity;

import java.util.ArrayList;

/**
 * Created by slyboots on 10/27/17.
 */

public class HistoryListViewAdapters extends ArrayAdapter<HistoryEntity> {
    private final Context context;

    public HistoryListViewAdapters(@NonNull Context context, ArrayList<HistoryEntity> history) {
        super(context,-1, history);
        this.context = context;
        
    }

    TextView challenge, date, sum;
    //LinearLayout pendingLayout, inProgressLayout;
    // Create global configuration and initialize ImageLoader with this config

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.history_list_item, parent, false);
        // Get the data item for this position
        HistoryEntity history = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            //convertView = LayoutInflater.from(getContext()).inflate(R.layout.calling_list_item, parent, false);
        }

        initializeComponents(rowView);

        // Populate the data into the template view using the data object
        setComponents(history);

        // Return the completed view to render on screen
        return convertView;
    }

    private void initializeComponents(View view) {
        challenge = (TextView) view.findViewById(R.id.challengeTextView);
        date = (TextView) view.findViewById(R.id.dateTextView);
        sum = (TextView) view.findViewById(R.id.sumTextView);

        //pendingLayout = (LinearLayout) view.findViewById(R.id.pending_layout);
        //inProgressLayout = (LinearLayout) view.findViewById(R.id.in_progress_layout);
    }

    private void setComponents(HistoryEntity historyEntity) {
        challenge.setText(historyEntity.getChallenge());
        date.setText(historyEntity.getDate());
        sum.setText(historyEntity.getSum());
    }



}
