package com.example.farazahmed.kefayat;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;


public class SpecificationsFragment extends Fragment {



    public ArrayList<ChildDataModel> productList;
    public RecyclerView.Adapter adapter;



    public SpecificationsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_specifications, container, false);

        RecyclerView recyclerView;
        recyclerView = (RecyclerView) rootview.findViewById(R.id.parent_spec_recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        productList = new ArrayList<>();

        adapter = new specAdaptor(getContext(), productList);
        recyclerView.setAdapter(adapter);

        prepareAlbums();
        return rootview;

    }

    private void prepareAlbums() {


        for (int i = 1; i <= 5; i++) {

            ChildDataModel dm = new ChildDataModel();

            dm.setHeaderTitle("Section " + i);


            ArrayList<Product>singleItem = new ArrayList<Product>();

            populate(singleItem);

            dm.setAllItemsInSection(singleItem);

            productList.add(dm);
        }

        adapter.notifyDataSetChanged();
    }

    private  void populate(ArrayList<Product> singleItem)
    {


        singleItem.add(new Product("dummy data", "dummy data"));
        singleItem.add(new Product("dummy data", "dummy data"));
        singleItem.add(new Product("dummy data", "dummy data"));
        singleItem.add(new Product("dummy data", "dummy data"));
        singleItem.add(new Product("dummy data", "dummy data"));
    }


}
