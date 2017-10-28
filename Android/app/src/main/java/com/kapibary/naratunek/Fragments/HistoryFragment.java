package com.kapibary.naratunek.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.adapters.HistoryTableViewAdapter;
import com.kapibary.naratunek.entity.HistoryEntity;
import com.kapibary.naratunek.entity.MessageEntity;
import com.kapibary.naratunek.service.RestClient;
import com.studioidan.httpagent.JsonArrayCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;

import de.codecrafters.tableview.SortableTableView;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;


public class HistoryFragment extends ClickableFragment {
    private static final String[] TABLE_HEADERS = { "Wyzwanie", "Data", "Kwota" };
    final ArrayList<HistoryEntity> list = new ArrayList<>();
    HistoryTableViewAdapter adapter;

    public HistoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history, container, false);
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        RestClient.getArray("/user/donations", new JsonArrayCallback() {
            @Override
            protected void onDone(boolean b, JSONArray jsonArray) {
                list.clear();
                for(int i = 0; i< jsonArray.length(); i++)
                {
                    JSONObject obj = jsonArray.optJSONObject(i);
                    list.add(new HistoryEntity(obj.optString("id"), obj.optString("date"), obj.optInt("amount")/100.0));
                }
                view.findViewById(R.id.progressBar3).setVisibility(View.INVISIBLE);
                adapter.notifyDataSetChanged();
            }
        });

        SortableTableView tableView = (SortableTableView)view.findViewById(R.id.tableViewHistory);
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(view.getContext(), TABLE_HEADERS));
        tableView.setColumnComparator(0, new HistoryChallengeComparator());
        tableView.setColumnComparator(2, new HistorySumComparator());
        adapter = new HistoryTableViewAdapter(view.getContext(), list);
        tableView.setDataAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
    }

    private static class HistoryChallengeComparator implements Comparator<HistoryEntity> {

        @Override
        public int compare(HistoryEntity lh, HistoryEntity rh) {
            return lh.getChallenge().compareTo(rh.getChallenge());
        }
    }

    private static class HistorySumComparator implements Comparator<HistoryEntity> {

        @Override
        public int compare(HistoryEntity lh, HistoryEntity rh) {
            return (int)(lh.getSum()-rh.getSum());
        }
    }

}
