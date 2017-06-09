package com.example.farazahmed.kefayat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import static com.example.farazahmed.kefayat.R.styleable.View;

/**
 * Created by FarazAhmed on 4/12/2017.
 */

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyViewHolder> {



    private Context context;
    private List<Product> mdataset;


    public MyAdaptor(Context context, List<Product> mdataset) {
        this.context = context;
        this.mdataset = mdataset;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView company, productname, salary;
        public ImageView thumbnail;

        public MyViewHolder(android.view.View view) {
            super(view);
            company = (TextView) view.findViewById(R.id.company);
            productname = (TextView) view.findViewById(R.id.product_name);
            salary = (TextView) view.findViewById(R.id.price);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ProductsDescription.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_product, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Product product = mdataset.get(position);
        holder.company.setText(product.getCompany());
        holder.productname.setText(product.getProduct_name());
        holder.salary.setText(product.getSalary());


        Glide.with(context).load(product.getThumbnail()).into(holder.thumbnail);


    }

    @Override
    public int getItemCount() {
        return mdataset.size();
    }
}
