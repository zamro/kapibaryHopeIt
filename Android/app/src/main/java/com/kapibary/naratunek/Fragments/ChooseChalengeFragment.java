package com.kapibary.naratunek.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.activity.MainActivity;

public class ChooseChalengeFragment extends ClickableFragment{
    public ChooseChalengeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("MainMenuFragment", "onCreateView");
        return inflater.inflate(R.layout.challenge_choose, container, false);
    }
    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Log.d("MainMenuFragment", "onViewCreated");
        ((MainActivity)getActivity()).setActiveFragment(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.joinChallenge:
                ClickableFragment fragment = new ChallengesFragment();
                Log.d("ChooseChalengeFragment", "joinChallenge");
                ((MainActivity)getActivity()).setActiveFragment(fragment, "Aktywne wyzwania");
                break;
            case R.id.myChallenges:
                Log.d("ChooseChalengeFragment", "myChallenges");
                break;
        }
    }
}
