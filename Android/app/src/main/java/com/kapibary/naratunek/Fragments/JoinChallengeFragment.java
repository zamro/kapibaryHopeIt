package com.kapibary.naratunek.Fragments;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.activity.TempActivity;
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
        ChallengeEntity challenge = (ChallengeEntity) this.getArguments().getSerializable("challenge");
        ProgressBar progressBar = (ProgressBar)view.findViewById(R.id.progressBar4);
        progressBar.setProgress((int)(challenge.getCurrentAmount() / challenge.getAmount() * 100));
        progressBar.setIndeterminate(false);
        ((TextView)view.findViewById(R.id.textView)).setText(challenge.getCurrentAmount().toString());
//        ((EditText)view.findViewById(R.id.editText6)).getText(challenge.getName());
        view.findViewById(R.id.textView5).setVisibility(View.INVISIBLE);
    }
    @Override
    public void onClick(View v) {
        Intent i = new Intent(getView().getContext(), TempActivity.class);
        startActivity(i);
    }
}
