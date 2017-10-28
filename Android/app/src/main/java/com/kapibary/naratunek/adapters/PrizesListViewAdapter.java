package com.kapibary.naratunek.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.entity.MessageEntity;
import com.kapibary.naratunek.entity.PrizeEntity;

import java.util.ArrayList;

/**
 * Created by mariusz on 27.10.17.
 */

public class PrizesListViewAdapter extends ArrayAdapter <PrizeEntity> {

        public PrizesListViewAdapter(@NonNull Context context, ArrayList<PrizeEntity> prizes) {
            super(context,-1, prizes);

        }

        TextView name, points;

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            PrizeEntity prize = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.prize_list_item, parent, false);
            }

            initializeComponents(convertView);

            // Populate the data into the template view using the data object
            setComponents(prize);

            // Return the completed view to render on screen
            return convertView;
        }

        private void initializeComponents(View view) {
            points = (TextView) view.findViewById(R.id.points);
            name = (TextView) view.findViewById(R.id.prize_name);

            //pendingLayout = (LinearLayout) view.findViewById(R.id.pending_layout);
            //inProgressLayout = (LinearLayout) view.findViewById(R.id.in_progress_layout);
        }

        private void setComponents(PrizeEntity prizeEntity) {
            points.setText(prizeEntity.getPoints()+" pkt.");
            name.setText(prizeEntity.getName());
        }



    }
