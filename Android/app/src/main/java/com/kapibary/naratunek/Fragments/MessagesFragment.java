package com.kapibary.naratunek.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.adapters.MessagesListViewAdapters;
import com.kapibary.naratunek.entity.MessageEntity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessagesFragment extends Fragment {
    private ListView listView;
    public MessagesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_messages, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final ArrayList<MessageEntity> list = new ArrayList<>();
        list.add(new MessageEntity("Mahmud", "wlasnie teraz", "Nowe wyzwanie"));
        list.add(new MessageEntity("Mahmud", "wlasnie teraz", "Nowe wyzwanie"));
        listView = (ListView)view.findViewById(R.id.messagesListView);
        MessagesListViewAdapters adapter = new MessagesListViewAdapters(view.getContext(), list);
        listView.setAdapter(adapter);
    }
}
