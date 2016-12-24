package com.sunil.navigationviewandroid;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by sunil on 12/23/16.
 */

public class TitleMenu extends ExpandableGroup<SubTitle> {

    private String imageUrl;

    public TitleMenu(String title, List<SubTitle> items, String imageUrl) {
        super(title, items);
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

