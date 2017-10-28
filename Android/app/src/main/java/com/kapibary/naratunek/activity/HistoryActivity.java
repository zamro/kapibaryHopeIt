package com.kapibary.naratunek.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.adapters.HistoryListViewAdapters;
import com.kapibary.naratunek.adapters.HistoryTableViewAdapter;
import com.kapibary.naratunek.entity.HistoryEntity;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

import static java.security.AccessController.getContext;

public class HistoryActivity extends AppCompatActivity {

    private ListView listView;
    private static final String[] TABLE_HEADERS = { "Wyzwanie", "Data", "Kwota" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        final ArrayList<HistoryEntity> list = new ArrayList<>();

        TableView tableView = (TableView)findViewById(R.id.tableViewHistory);
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this, TABLE_HEADERS));
        list.add(new HistoryEntity("Martyna 1k", "10.11.2017", "5zl"));
        HistoryTableViewAdapter adapter = new HistoryTableViewAdapter(this, list);
        tableView.setDataAdapter(adapter);
        /*listView = (ListView)findViewById(R.id.historyListView);
        HistoryListViewAdapters adapter = new HistoryListViewAdapters(this, list);
        listView.setAdapter(adapter); */


    }

}
