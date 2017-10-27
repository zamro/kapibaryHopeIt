package com.kapibary.naratunek.entity;

/**
 * Created by mariusz on 27.10.17.
 */

public class NavigationItem {

    String mTitle;
    String mSubtitle;
    int mIcon;

    public NavigationItem(String title, String subtitle, int icon) {
        mTitle = title;
        mSubtitle = subtitle;
        mIcon = icon;
    }

    public int getmIcon() {
        return mIcon;
    }

    public String getmSubtitle() {
        return mSubtitle;
    }

    public String getmTitle() {
        return mTitle;
    }
}
