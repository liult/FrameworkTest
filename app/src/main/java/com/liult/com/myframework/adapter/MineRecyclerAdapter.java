package com.liult.com.myframework.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liult.com.myframework.R;

/**
 * Created by zhilian-2 on 2016/1/15.
 */
public class MineRecyclerAdapter extends RecyclerView.Adapter<MineRecyclerAdapter.Holder>{

    Context context;
    public MineRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.test_recyclerview_item, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tv.setText("position:" + position);
    }


    @Override
    public int getItemCount() {
        return 20;
    }


    public class Holder extends RecyclerView.ViewHolder{

        public TextView tv;
        public Holder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);


        }
    }



}
