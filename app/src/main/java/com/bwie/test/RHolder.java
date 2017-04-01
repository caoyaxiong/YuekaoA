package com.bwie.test;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/30 20:38
 */

public class RHolder extends RecyclerView.ViewHolder {

    public final ImageView imageView;

    public RHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }
}
