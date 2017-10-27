package com.kapibary.naratunek.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.adapters.MessagesListViewAdapters;
import com.kapibary.naratunek.entity.MessageEntity;

import java.util.ArrayList;

public class MessagesActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        final ArrayList<MessageEntity> list = new ArrayList<>();
        list.add(new MessageEntity("Mahmud", "wlasnie teraz", "Nowe wyzwanie"));
        list.add(new MessageEntity("Mahmud", "wlasnie teraz", "Nowe wyzwanie"));
        listView = (ListView)findViewById(R.id.messagesListView);
        MessagesListViewAdapters adapter = new MessagesListViewAdapters(this, list);
        listView.setAdapter(adapter);
    }
}
