package com.example.farazahmed.kefayat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by FarazAhmed on 4/18/2017.
 */

public class AvailAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private boolean isHeader;
    private boolean isFooter;
    private List<availibiltydatamodel> data;
    public Context context;

    public static final int VIEW_HEADER = 0;
    public static final int VIEW_FOOTER = 2;
    public static final int ITEM_LIST = 1;

    public AvailAdaptor(Context context, List<availibiltydatamodel> data, boolean isHeader, boolean isFooter) {

        this.context = context;
        this.data = data;
        this.isHeader = isHeader;
        this.isFooter = isFooter;

    }

    public class headView extends RecyclerView.ViewHolder {

        TextView header;

        public headView(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.header);
        }
    }

    public class footView extends RecyclerView.ViewHolder {

        TextView leftfooter;
        ImageButton rightfooter;

        public footView(View itemView) {
            super(itemView);
            leftfooter = (TextView) itemView.findViewById(R.id.left_footer);
            rightfooter = (ImageButton) itemView.findViewById(R.id.right_footer);
        }
    }

    public class ItemView extends RecyclerView.ViewHolder {

        TextView contactno;
        TextView address;

        public ItemView(View itemView) {
            super(itemView);
            contactno = (TextView)itemView.findViewById(R.id.contact);
            address = (TextView)itemView.findViewById(R.id.Address);

        }
    }

    @Override
    public int getItemViewType(int position) {
        if(isHeader && isHeader(position))
        {
            return VIEW_HEADER;
        }
        else if (isFooter && isFooter(position))
        {
            return VIEW_FOOTER;
        }
        else
            return ITEM_LIST;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_HEADER)
        {
            return new headView(LayoutInflater.from(context).inflate(R.layout.avail_header, parent, false));

        }if(viewType == VIEW_FOOTER)
        {
            return new footView(LayoutInflater.from(context).inflate(R.layout.avail_footer, parent, false));
        }
        else
        {
            return new ItemView(LayoutInflater.from(context).inflate(R.layout.avail_list_item, parent, false));
        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        availibiltydatamodel model = data.get(position);
        if(holder instanceof headView)
        {
            ((headView) holder).header.setText(model.getCountryname());
        }
        else if(holder instanceof footView)
        {
            ((footView) holder).leftfooter.setText("Get Directions on Map");
            ((footView) holder).rightfooter.setImageResource(R.drawable.right_icon);
        }
        else
        {
            ((ItemView)holder).contactno.setText(model.getContact_no());
            ((ItemView)holder).address.setText(model.getAddress());

        }
    }

    @Override
    public int getItemCount() {
        int getitemcount =  data.size();

        if(isHeader)
        {
            getitemcount += 1;
        }
        if(isFooter)
        {
            getitemcount -= 1;
        }
        return getitemcount;

    }
    private boolean isFooter(int position) {
        return position == getItemCount() - 1;
    }

    private boolean isHeader(int position) {
        return position == 0;
    }

}
