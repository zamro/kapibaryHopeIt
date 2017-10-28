package com.kapibary.naratunek.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kapibary.naratunek.entity.HistoryEntity;
import com.kapibary.naratunek.entity.ServiceEntity;

import java.util.List;

import de.codecrafters.tableview.TableDataAdapter;

/**
 * Created by mariusz on 28.10.17.
 */

public class ServiceTableViewAdapter extends TableDataAdapter<ServiceEntity> {

    public ServiceTableViewAdapter(Context context, List<ServiceEntity> data) {
        super(context, data);

    }

    @Override
    public View getCellView(int rowIndex, int columnIndex, ViewGroup viewGroup) {
        ServiceEntity service = getRowData(rowIndex);
        View renderedView = null;

        switch (columnIndex) {
            case 0:
                renderedView = renderServiceSubject(service);
                break;
            case 1:
                renderedView = renderPrice(service);
                break;
            case 2:
                renderedView = renderDeadline(service);
                break;
        }

        return renderedView;
    }


    private View renderServiceSubject(final ServiceEntity service) {

        final TextView textView = new TextView(getContext());
        textView.setText(service.getServiceSubject());
        //textView.setPadding(20, 10, 20, 10);
        //textView.setTextSize(TEXT_SIZE);


        return textView;
    }

    private View renderPrice(final ServiceEntity service) {

        final TextView textView = new TextView(getContext());
        textView.setText(service.getPrice());
        //textView.setPadding(20, 10, 20, 10);
        //textView.setTextSize(TEXT_SIZE);


        return textView;
    }

    private View renderDeadline(final ServiceEntity service) {

        final TextView textView = new TextView(getContext());
        textView.setText(service.getDeadline());
        //textView.setPadding(20, 10, 20, 10);
        //textView.setTextSize(TEXT_SIZE);


        return textView;
    }
}
