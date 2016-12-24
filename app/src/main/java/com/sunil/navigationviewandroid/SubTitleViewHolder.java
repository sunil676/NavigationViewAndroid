package com.sunil.navigationviewandroid;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by kuliza-195 on 12/23/16.
 */

public class SubTitleViewHolder extends ChildViewHolder {

    private TextView subTitleTextView;

    public SubTitleViewHolder(View itemView) {
        super(itemView);
        subTitleTextView = (TextView) itemView.findViewById(R.id.subtitle);
    }

    public void setSubTitletName(String name) {
        subTitleTextView.setText(name);
    }
}
