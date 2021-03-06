package com.kapibary.naratunek.Fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.activity.MainActivity;
import com.kapibary.naratunek.adapters.MessagesListViewAdapters;
import com.kapibary.naratunek.entity.MessageEntity;
import com.kapibary.naratunek.service.RestClient;
import com.studioidan.httpagent.JsonArrayCallback;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessagesFragment extends ClickableFragment {
    private ListView listView;
    MessagesListViewAdapters adapter;
    final ArrayList<MessageEntity> list = new ArrayList<>();
    public MessagesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_messages, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        RestClient.getArray("/user/messages", new JsonArrayCallback() {
            @Override
            protected void onDone(boolean b, JSONArray jsonArray) {
                list.clear();
                for(int i = 0; i< jsonArray.length(); i++)
                {
                   list.add(new MessageEntity("Admin", "10:30", jsonArray.optString(i)));
                }
                view.findViewById(R.id.progressBar3).setVisibility(View.INVISIBLE);
                adapter.notifyDataSetChanged();
            }
        });
        listView = (ListView)view.findViewById(R.id.messagesListView);
        adapter = new MessagesListViewAdapters(view.getContext(), list);
        listView.setAdapter(adapter);
        ((MainActivity)getActivity()).setActiveFragment(this);
    }

    @Override
    public void onClick(View v) {
    }
}
