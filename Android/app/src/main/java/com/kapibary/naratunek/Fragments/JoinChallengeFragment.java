package com.kapibary.naratunek.Fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.entity.ChallengeEntity;

public class JoinChallengeFragment extends ClickableFragment {
    ChallengeEntity challenge;
    public JoinChallengeFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("MainMenuFragment", "onCreateView");
        return inflater.inflate(R.layout.join_challenge, container, false);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
    }
    @Override
    public void onClick(View v) {
    }
}
