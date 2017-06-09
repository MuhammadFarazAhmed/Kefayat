package com.example.farazahmed.kefayat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by FarazAhmed on 4/18/2017.
 */

public class AvailSimpleAdaptor extends RecyclerView.Adapter<AvailSimpleAdaptor.MyViewHolder> {

    private List<availibiltydatamodel> data;
    public Context context;

    public AvailSimpleAdaptor(Context context, List<availibiltydatamodel> data) {

        this.context = context;
        this.data = data;


    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView header;
        TextView contactno;
        TextView address;
        TextView leftfooter;
        ImageButton rightfooter;

        public MyViewHolder(View itemView) {
            super(itemView);

            header = (TextView) itemView.findViewById(R.id.header);
            leftfooter = (TextView) itemView.findViewById(R.id.left_footer);
            rightfooter = (ImageButton) itemView.findViewById(R.id.right_footer);
            contactno = (TextView) itemView.findViewById(R.id.contact);
            address = (TextView) itemView.findViewById(R.id.Address);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.avail_single_item,parent,false);

        return  new MyViewHolder(rootview);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        availibiltydatamodel model = data.get(position);
        holder.header.setText(model.getCountryname());
        holder.contactno.setText(model.getContact_no());
        holder.address.setText(model.getAddress());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

