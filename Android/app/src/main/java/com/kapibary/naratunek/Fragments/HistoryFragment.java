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

import java.util.ArrayList;
import java.util.Comparator;

import de.codecrafters.tableview.SortableTableView;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;


public class HistoryFragment extends ClickableFragment {
    private static final String[] TABLE_HEADERS = { "Wyzwanie", "Data", "Kwota" };

    public HistoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final ArrayList<HistoryEntity> list = new ArrayList<>();

        SortableTableView tableView = (SortableTableView)view.findViewById(R.id.tableViewHistory);
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(view.getContext(), TABLE_HEADERS));
        tableView.setColumnComparator(0, new HistoryChallengeComparator());
        tableView.setColumnComparator(2, new HistorySumComparator());

        list.add(new HistoryEntity("Martyna 1k", "10.11.2017", "5"));
        list.add(new HistoryEntity("Abecadlo", "12.11.2017", "50"));

        HistoryTableViewAdapter adapter = new HistoryTableViewAdapter(view.getContext(), list);

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
            return Integer.parseInt(lh.getSum())-Integer.parseInt(rh.getSum());
        }
    }

}
