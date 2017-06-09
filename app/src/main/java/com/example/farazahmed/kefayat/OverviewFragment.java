package com.example.farazahmed.kefayat;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OverviewFragment extends Fragment {
    public List<Product> productList;
    public RecyclerView.Adapter adapter;
    public OverviewFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_overview, container, false);

        RecyclerView recyclerView;
        recyclerView = (RecyclerView)rootview.findViewById(R.id.recycler_view_overview);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        productList = new ArrayList<>();

        adapter = new OverviewAdaptor(getContext(),productList);
        recyclerView.setAdapter(adapter);


        prepareAlbums();





        return rootview;

    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.nophoto,
                R.drawable.nophoto,
                R.drawable.nophoto,
                };

        Product product = new Product(covers[0]);
        productList.add(product);
        product = new Product(covers[0]);
        productList.add(product);
        product = new Product(covers[0]);
        productList.add(product);

        adapter.notifyDataSetChanged();
    }
}