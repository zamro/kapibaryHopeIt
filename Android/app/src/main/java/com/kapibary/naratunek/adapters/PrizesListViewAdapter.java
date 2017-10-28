package com.kapibary.naratunek.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.entity.HistoryEntity;
import com.kapibary.naratunek.entity.MessageEntity;

import java.util.ArrayList;

/**
 * Created by mariusz on 27.10.17.
 */

public class MessagesListViewAdapters extends ArrayAdapter <MessageEntity> {

        public MessagesListViewAdapters(@NonNull Context context, ArrayList<MessageEntity> messages) {
            super(context,-1, messages);

        }

        TextView message, receiveTime, name;

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            MessageEntity message = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.message_list_item, parent, false);
            }

            initializeComponents(convertView);

            // Populate the data into the template view using the data object
            setComponents(message);

            // Return the completed view to render on screen
            return convertView;
        }

        private void initializeComponents(View view) {
            message = (TextView) view.findViewById(R.id.message);
            receiveTime = (TextView) view.findViewById(R.id.receiveTime);
            name = (TextView) view.findViewById(R.id.name);

            //pendingLayout = (LinearLayout) view.findViewById(R.id.pending_layout);
            //inProgressLayout = (LinearLayout) view.findViewById(R.id.in_progress_layout);
        }

        private void setComponents(MessageEntity messageEntity) {
            message.setText(messageEntity.getMessage());
            receiveTime.setText(messageEntity.getReceiveTime());
            name.setText(messageEntity.getName());
        }



    }
