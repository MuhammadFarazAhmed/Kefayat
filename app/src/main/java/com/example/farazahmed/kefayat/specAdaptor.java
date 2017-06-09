package com.example.farazahmed.kefayat;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.Inflater;

/**
 * Created by FarazAhmed on 4/16/2017.
 */

public class specAdaptor extends RecyclerView.Adapter<specAdaptor.MyViewholder> {

    private Context mContext;
    private  ArrayList<ChildDataModel> productsList;




    public specAdaptor(Context context, ArrayList<ChildDataModel> productList) {

        this.mContext = context;
        this.productsList = productList;
    }

    public static class MyViewholder extends RecyclerView.ViewHolder{

        TextView heading;
        public RecyclerView recyclerView;

        public MyViewholder(View itemView) {
            super(itemView);

            heading = (TextView)itemView.findViewById(R.id.spec_heading);
            recyclerView = (RecyclerView)itemView.findViewById(R.id.child_spec_recycler_view);

        }


    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detail_single_item, parent, false);


           return  new MyViewholder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {

          final String sectionname = productsList.get(position).getHeaderTitle();

        ArrayList   singleitem = productsList.get(position).getAllItemsInSection();

        holder.heading.setText(sectionname);

        ChildAdaptor adaptor = new ChildAdaptor(mContext,singleitem);

        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        holder.recyclerView.setNestedScrollingEnabled(false);
        holder.recyclerView.setAdapter(adaptor);

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }
}
