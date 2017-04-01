package com.bwie.test;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/30 20:37
 */

public class MyAdapter extends RecyclerView.Adapter<RHolder> {
    private final Context context;
    private final RequsetBean requsetBean;

   

    public MyAdapter(Context context, RequsetBean requsetBean) {
        this.context=context;
        this.requsetBean=requsetBean;
    }


    @Override
    public RHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
       RHolder rHolder=new RHolder(view);
        return rHolder;
    }

    @Override
    public void onBindViewHolder(RHolder holder, int position) {
        Glide.with(context)
                .load(requsetBean.getResult().getRows().get(position).getInfo().getDefault_image())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return requsetBean.getResult().getRows().size();
    }
}
