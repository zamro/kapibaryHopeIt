package com.kapibary.naratunek.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kapibary.naratunek.entity.ChallengeEntity;

import java.util.List;

import de.codecrafters.tableview.TableDataAdapter;

/**
 * Created by mariusz on 28.10.17.
 */

public class ChallengesViewAdapter extends TableDataAdapter<ChallengeEntity> {

    public ChallengesViewAdapter(Context context, List<ChallengeEntity> data) {
        super(context, data);

    }

    @Override
    public View getCellView(int rowIndex, int columnIndex, ViewGroup viewGroup) {
        ChallengeEntity challenge = getRowData(rowIndex);
        View renderedView = null;

        switch (columnIndex) {
            case 0:
                renderedView = renderName(challenge);
                break;
            case 1:
                renderedView = renderSum(challenge);
                break;
            case 2:
                renderedView = renderDate(challenge);
                break;
            case 3:
                renderedView = renderStatus(challenge);
                break;
        }

        return renderedView;
    }


    private View renderName(final ChallengeEntity challenge) {

        final TextView textView = new TextView(getContext());
        textView.setText(challenge.getName());
        textView.setPadding(20, 10, 20, 10);
        //textView.setTextSize(TEXT_SIZE);
        return textView;
    }

    private View renderDate(final ChallengeEntity challenge) {

        final TextView textView = new TextView(getContext());
        textView.setText(challenge.getDate());
        textView.setPadding(20, 10, 20, 10);
        //textView.setTextSize(TEXT_SIZE);
        return textView;
    }

    private View renderSum(final ChallengeEntity challenge) {

        final TextView textView = new TextView(getContext());
        textView.setText(challenge.getAmount()+" zł");
        textView.setPadding(20, 10, 20, 10);
        //textView.setTextSize(TEXT_SIZE);
        return textView;
    }

    private View renderStatus(final ChallengeEntity challenge) {

        final TextView textView = new TextView(getContext());
        textView.setText(challenge.getStatus()?"Aktywne":"Nieaktywne");
        textView.setPadding(20, 10, 20, 10);
        //textView.setTextSize(TEXT_SIZE);
        return textView;
    }
}
