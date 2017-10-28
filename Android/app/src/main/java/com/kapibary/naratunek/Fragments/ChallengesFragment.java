package com.kapibary.naratunek.Fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kapibary.naratunek.Fragments.ClickableFragment;
import com.kapibary.naratunek.Fragments.HistoryFragment;
import com.kapibary.naratunek.R;
import com.kapibary.naratunek.activity.MainActivity;
import com.kapibary.naratunek.adapters.ChallengesViewAdapter;
import com.kapibary.naratunek.adapters.HistoryTableViewAdapter;
import com.kapibary.naratunek.entity.ChallengeEntity;
import com.kapibary.naratunek.entity.ChallengeEntity;
import com.kapibary.naratunek.service.RestClient;
import com.studioidan.httpagent.JsonArrayCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;

import de.codecrafters.tableview.SortableTableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChallengesFragment extends ClickableFragment {
    private static final String[] TABLE_HEADERS = { "Wyzwanie", "Kwota", "Data", "Status" };
    final ArrayList<ChallengeEntity> list = new ArrayList<>();
    ChallengesViewAdapter adapter;
    public ChallengesFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("MainMenuFragment", "onCreateView");
        return inflater.inflate(R.layout.challenges, container, false);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        RestClient.getArray("/user/challenges", new JsonArrayCallback() {
            @Override
            protected void onDone(boolean b, JSONArray jsonArray) {
                list.clear();
                if(b) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.optJSONObject(i);
                        list.add(new ChallengeEntity("name", 2000., "31.12.2017", true, 123.));
                    }
                }
                view.findViewById(R.id.progressBar3).setVisibility(View.INVISIBLE);
                list.add(new ChallengeEntity("name", 2000., "31.12.2016", false, 1750.));
                list.add(new ChallengeEntity("name", 2000., "31.12.2017", true, 500.));
                list.add(new ChallengeEntity("name", 2000., "31.12.2018", true, 0.));
                list.add(new ChallengeEntity("name", 2000., "31.12.2019", true, 0.));
                adapter.notifyDataSetChanged();
            }
        });

        SortableTableView tableView = (SortableTableView)view.findViewById(R.id.tableView);
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(view.getContext(), TABLE_HEADERS));
        tableView.setColumnComparator(0, new NameComparator());
        tableView.setColumnComparator(1, new AmountComparator());
        tableView.setColumnComparator(2, new DateComparator());
        tableView.setColumnComparator(3, new StatusComparator());
        adapter = new ChallengesViewAdapter(view.getContext(), list);
        tableView.setDataAdapter(adapter);
        ((MainActivity)getActivity()).setActiveFragment(this);
        ((MainActivity)getActivity()).setActiveFragment(this);
        tableView.addDataClickListener(new TableDataClickListener<ChallengeEntity>() {
            @Override
            public void onDataClicked(int i, ChallengeEntity challengeEntity) {
                ClickableFragment fragment = new JoinChallengeFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("challenge", challengeEntity);
                fragment.setArguments(bundle);
                ((MainActivity)getActivity()).setActiveFragment(fragment, "Dołącz do wyzwania");
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.challengeButton:
                Log.d("ChooseChalengeFragment", "myChallenges");
                break;
            case R.id.serviceButton:
                Log.d("ChooseChalengeFragment", "joinChallenge");
                break;
            default:
                Log.d("ChooseChalengeFragment", "any clicked" + v.getId());
                break;
        }
    }

    private static class NameComparator implements Comparator<ChallengeEntity> {
        @Override
        public int compare(ChallengeEntity lh, ChallengeEntity rh) {
            return lh.getName().compareTo(rh.getName());
        }
    }
    private static class AmountComparator implements Comparator<ChallengeEntity> {
        @Override
        public int compare(ChallengeEntity lh, ChallengeEntity rh) {
            return lh.getAmount().compareTo(rh.getAmount());
        }
    }
    private static class DateComparator implements Comparator<ChallengeEntity> {
        @Override
        public int compare(ChallengeEntity lh, ChallengeEntity rh) {
            return lh.getDate().compareTo(rh.getDate());
        }
    }
    private static class StatusComparator implements Comparator<ChallengeEntity> {
        @Override
        public int compare(ChallengeEntity lh, ChallengeEntity rh) {
            return lh.getStatus() ? -1:1;
        }
    }

}
