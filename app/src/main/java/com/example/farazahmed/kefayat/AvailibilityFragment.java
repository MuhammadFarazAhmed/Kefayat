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

import com.example.farazahmed.kefayat.R;

import java.util.ArrayList;
import java.util.List;


public class AvailibilityFragment extends Fragment {

    public List<availibiltydatamodel> List;
    public RecyclerView.Adapter adapter;


    public AvailibilityFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_availibility, container, false);


        RecyclerView recyclerView;
        recyclerView = (RecyclerView)rootview.findViewById(R.id.avail_recyclerview);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List = new ArrayList<availibiltydatamodel>();

        adapter = new AvailSimpleAdaptor(getContext(),List);
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        return rootview;

    }

    private void prepareAlbums() {

        availibiltydatamodel availibiltydatamodel = new availibiltydatamodel("dubai","+923201490787","Shop No 71 dragon city dubai");
        List.add(availibiltydatamodel);
        availibiltydatamodel availibiltydatamodel1 = new availibiltydatamodel("dubai","+923201490787","Shop No 71 dragon city dubai");
        List.add(availibiltydatamodel1);
        availibiltydatamodel availibiltydatamodel2 = new availibiltydatamodel("dubai","+923201490787","Shop No 71 dragon city dubai");
        List.add(availibiltydatamodel2);
        availibiltydatamodel availibiltydatamodel3 = new availibiltydatamodel("dubai","+923201490787","Shop No 71 dragon city dubai");
        List.add(availibiltydatamodel3);
        availibiltydatamodel availibiltydatamodel4 = new availibiltydatamodel("dubai","+923201490787","Shop No 71 dragon city dubai");
        List.add(availibiltydatamodel4);




        adapter.notifyDataSetChanged();
    }

}
