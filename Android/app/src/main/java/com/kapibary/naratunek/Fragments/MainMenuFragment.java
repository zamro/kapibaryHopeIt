package com.kapibary.naratunek.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.activity.MainActivity;

public class MainMenuFragment extends ClickableFragment{
    public MainMenuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("MainMenuFragment", "onCreateView");
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }
    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Log.d("MainMenuFragment", "onViewCreated");
        ((MainActivity)getActivity()).setActiveFragment(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.challengeButton:
                ChooseChalengeFragment fragment = new ChooseChalengeFragment();
                ((MainActivity)getActivity()).setActiveFragment(fragment, "Wyzwania");
                break;
            case R.id.serviceButton:
                Log.d("MainMenuFragment", "serviceButton");
                break;
            case R.id.rankButton:
                Log.d("MainMenuFragment", "rankButton");
                break;
            case R.id.prizesButton:
                Log.d("MainMenuFragment", "prizesButton");
                break;
        }
    }
}
