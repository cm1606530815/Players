package com.example.players.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.players.Bean.MyBean;
import com.example.players.R;

import java.util.List;

/**
 * Created by samsung on 2017/12/20.
 */

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.MyHolder> {
    Context context;
    List<MyBean.DataBean> list;

    public RecAdapter(Context context, List<MyBean.DataBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.imageView.setImageURI(Uri.parse(list.get(position).getImages()));
        holder.textView1.setText(list.get(position).getTitle());
        holder.textView2.setText(list.get(position).getSubhead());
        holder.textView3.setText(list.get(position).getPrice() + "");
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView1;
        private final TextView textView2;
        private final TextView textView3;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.sdv);
            textView1 = (TextView) itemView.findViewById(R.id.tv1);
            textView2 = (TextView) itemView.findViewById(R.id.tv2);
            textView3 = (TextView) itemView.findViewById(R.id.tv3);

        }
    }
}
