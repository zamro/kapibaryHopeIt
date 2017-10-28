package com.kapibary.naratunek.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kapibary.naratunek.entity.HistoryEntity;

import java.util.List;

import de.codecrafters.tableview.TableDataAdapter;

/**
 * Created by mariusz on 28.10.17.
 */

public class HistoryTableViewAdapter extends TableDataAdapter<HistoryEntity> {

    public HistoryTableViewAdapter(Context context, List<HistoryEntity> data) {
        super(context, data);

    }

    @Override
    public View getCellView(int rowIndex, int columnIndex, ViewGroup viewGroup) {
        HistoryEntity history = getRowData(rowIndex);
        View renderedView = null;

        switch (columnIndex) {
            case 0:
                renderedView = renderChallenge(history);
                break;
            case 1:
                renderedView = renderDate(history);
                break;
            case 2:
                renderedView = renderSum(history);
                break;
        }

        return renderedView;
    }


    private View renderChallenge(final HistoryEntity history) {

        final TextView textView = new TextView(getContext());
        textView.setText(history.getChallenge());
        //textView.setPadding(20, 10, 20, 10);
        //textView.setTextSize(TEXT_SIZE);


        return textView;
    }

    private View renderDate(final HistoryEntity history) {

        final TextView textView = new TextView(getContext());
        textView.setText(history.getDate());
        //textView.setPadding(20, 10, 20, 10);
        //textView.setTextSize(TEXT_SIZE);


        return textView;
    }

    private View renderSum(final HistoryEntity history) {

        final TextView textView = new TextView(getContext());
        textView.setText(history.getSum());
        //textView.setPadding(20, 10, 20, 10);
        //textView.setTextSize(TEXT_SIZE);


        return textView;
    }
}
