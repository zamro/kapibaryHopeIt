package com.kapibary.naratunek.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.entity.NavigationItem;

import java.util.ArrayList;

/**
 * Created by mariusz on 27.10.17.
 */


public class MainDrawerListAdapter extends BaseAdapter {

    private ArrayList<NavigationItem> navigationItems;
    private Context context;

    public MainDrawerListAdapter(@NonNull Context context, ArrayList<NavigationItem> items) {
        this.context = context;
        this.navigationItems = items;

    }

    Button messages, user, settings, history;

    @Override
    public int getCount() {
        return navigationItems.size();
    }

    @Override
    public Object getItem(int i) {
        return navigationItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.drawer_item, null);
        }
        else {
            view = convertView;
        }

        TextView titleView = (TextView) view.findViewById(R.id.title);
        TextView subtitleView = (TextView) view.findViewById(R.id.subTitle);
        ImageView iconView = (ImageView) view.findViewById(R.id.icon);

        titleView.setText( navigationItems.get(position).getmTitle() );
        subtitleView.setText( navigationItems.get(position).getmSubtitle() );
        iconView.setImageResource(navigationItems.get(position).getmIcon());


        // Populate the data into the template view using the data object
        //setComponents(message);

        // Return the completed view to render on screen
        return view;
    }

    private void initializeComponents(View view) {
       // message = (TextView) view.findViewById(R.id.message);
        //receiveTime = (TextView) view.findViewById(R.id.receiveTime);
        //name = (TextView) view.findViewById(R.id.name);

        //pendingLayout = (LinearLayout) view.findViewById(R.id.pending_layout);
        //inProgressLayout = (LinearLayout) view.findViewById(R.id.in_progress_layout);
    }

    private void setComponents(NavigationItem messageEntity) {
        //message.setText(messageEntity.getMessage());
        //receiveTime.setText(messageEntity.getReceiveTime());
        //name.setText(messageEntity.getName());
    }
}
