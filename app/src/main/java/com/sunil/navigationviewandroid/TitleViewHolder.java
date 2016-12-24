package com.sunil.navigationviewandroid;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by sunil on 12/23/16.
 */

public class TitleViewHolder extends GroupViewHolder {

    private TextView titleName;
    private ImageView arrow;
    private ImageView icon;

    public TitleViewHolder(View itemView) {
        super(itemView);
        titleName = (TextView) itemView.findViewById(R.id.list_item_name);
        arrow = (ImageView) itemView.findViewById(R.id.list_item_arrow);
        icon = (ImageView) itemView.findViewById(R.id.list_item_icon);
    }

    public void setGenreTitle(Context context, ExpandableGroup title) {
        if (title instanceof TitleMenu) {
            titleName.setText(title.getTitle());
            if (((TitleMenu) title).getImageUrl()!= null && !((TitleMenu) title).getImageUrl().isEmpty()){
                Glide.with(context)
                        .load(((TitleMenu) title).getImageUrl())
                        .into(icon);

            }
        }
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }
}