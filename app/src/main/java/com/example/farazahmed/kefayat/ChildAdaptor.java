package com.example.farazahmed.kefayat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by FarazAhmed on 4/17/2017.
 */

public class ChildAdaptor extends RecyclerView.Adapter<ChildAdaptor.MyViewHolder> {

    public Context context;
    public List<Product> productList;

    public ChildAdaptor(Context context , List<Product> productList) {

        this.context = context;
        this.productList = productList;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView spec_content ;
        public MyViewHolder(View itemView) {
            super(itemView);

            spec_content =(TextView)itemView.findViewById(R.id.spec_content);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_card,parent,false);

        return  new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.spec_content.setText(product.getContent());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
