package com.example.farazahmed.kefayat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by FarazAhmed on 4/14/2017.
 */

public class OverviewAdaptor extends RecyclerView.Adapter<OverviewAdaptor.OverviewHolder> {

    private Context context;
    private List<Product> mdataset;

    public OverviewAdaptor(Context context, List<Product> mdataset) {

        this.context = context;
        this.mdataset = mdataset;
    }


    public class OverviewHolder extends RecyclerView.ViewHolder {
        public ImageView Thumbnail;

        public OverviewHolder(View view) {
            super(view);

            Thumbnail = (ImageView) view.findViewById(R.id.overview_thumbnail);
        }
    }

    @Override
    public OverviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.overview_sing_product, parent, false);

        return new OverviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final OverviewHolder holder, int position) {

        Product product = mdataset.get(position);

        Glide.with(context).load(product.getThumbnail()).into(holder.Thumbnail);


    }

    @Override
    public int getItemCount() {
        return mdataset.size();
    }
}
