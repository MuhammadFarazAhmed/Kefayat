package com.example.farazahmed.kefayat;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by FarazAhmed on 4/14/2017.
 */

public class FeaturesAdaptor extends RecyclerView.Adapter<FeaturesAdaptor.FeaturesViewHolder>{

    public Context context;
    public List<Product> productList;

    public FeaturesAdaptor(Context context,List<Product> productlist) {
        this.context = context;
        this.productList = productlist;
    }

    public  class FeaturesViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textView;
        public ImageView imageView;
        public FeaturesViewHolder(View itemView) {
            super(itemView);
           textView = (TextView)itemView.findViewById(R.id.feature_text);
            imageView = (ImageView)itemView.findViewById(R.id.feature_image);
        }
    }

    @Override
    public FeaturesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.features_single_product,parent,false);


        return  new FeaturesViewHolder(rootview);


    }

    @Override
    public void onBindViewHolder(final FeaturesViewHolder holder, int position) {

        Product product = productList.get(position);

        holder.textView.setText(product.getProduct_name());

        Glide.with(context).load(product.getThumbnail()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
