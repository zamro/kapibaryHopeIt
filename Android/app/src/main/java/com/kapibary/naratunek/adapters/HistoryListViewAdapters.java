package com.kapibary.naratunek.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.kapibary.naratunek.entity.HistoryEntity;

/**
 * Created by slyboots on 10/27/17.
 */

public class HistoryListViewAdapters extends ArrayAdapter<HistoryEntity> {

    public HistoryListViewAdapters(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        
    }


}
