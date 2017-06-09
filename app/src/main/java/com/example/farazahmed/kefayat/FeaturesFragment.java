package com.example.farazahmed.kefayat;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FeaturesFragment extends Fragment {

    public List<Product> productList;
    public RecyclerView.Adapter adapter;
    public FeaturesFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_features, container, false);

        RecyclerView recyclerView;
        recyclerView = (RecyclerView)rootview.findViewById(R.id.recycler_view_features);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        productList = new ArrayList<>();

        adapter = new FeaturesAdaptor(getContext(),productList);
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

        Product product = new Product("Descovered the moments with high quality LED .",covers[0]);
        productList.add(product);
        product = new Product("Descovered the moments with high quality",covers[0]);
        productList.add(product);
        product = new Product("Descovered the moments with high quality",covers[0]);
        productList.add(product);

        adapter.notifyDataSetChanged();
    }
}
