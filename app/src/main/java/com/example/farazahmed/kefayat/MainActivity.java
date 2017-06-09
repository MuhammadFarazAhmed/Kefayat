package com.example.farazahmed.kefayat;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<Product> productList;
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView.Adapter adapter;

    public ImageButton listbutton;
    public ImageButton gridbutton;

    public ImageButton explore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listbutton = (ImageButton)findViewById(R.id.listview_item);
        gridbutton = (ImageButton)findViewById(R.id.gridview_item);
        explore = (ImageButton)findViewById(R.id.image_button_explore);




        listbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    listbutton.setImageResource(R.drawable.list_icon);
                    gridbutton.setImageResource(R.drawable.grid_icon_gray);
                    layoutManager = new GridLayoutManager(MainActivity.this, 1);
                    recyclerView.setLayoutManager(layoutManager);
                    adapter.notifyDataSetChanged();
                }

        });
        gridbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                listbutton.setImageResource(R.drawable.list_icon_gray);
                gridbutton.setImageResource(R.drawable.grid_icon);

                layoutManager = new GridLayoutManager(MainActivity.this, 2);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                adapter.notifyDataSetChanged();
            }
        });

        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Explore.class);
                startActivity(intent);
            }
        });


        //attacting recyclerview to xml product
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        //configuring layoutmanager
        layoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
       // recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //conecting to Adaptor
        productList = new ArrayList<>();
        adapter = new MyAdaptor(this, productList);
        recyclerView.setAdapter(adapter);

        prepareAlbums();
    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.nophoto,
                R.drawable.nophoto,
                R.drawable.nophoto,
                R.drawable.nophoto,
                R.drawable.nophoto,
                R.drawable.nophoto,
                R.drawable.nophoto,
                R.drawable.nophoto,
                R.drawable.nophoto,
                R.drawable.nophoto,
                R.drawable.nophoto};

        Product product = new Product(covers[0], "Samsung", "Camcoder", "10000/-");
        productList.add(product);
        product = new Product(covers[0], "Samsung", "Camcoder", "10000/-");
        productList.add(product);
        product = new Product(covers[0], "Samsung", "Camcoder", "10000/-");
        productList.add(product);
        product = new Product(covers[0], "Samsung", "Camcoder", "10000/-");
        productList.add(product);
        product = new Product(covers[0], "Samsung", "Camcoder", "10000/-");
        productList.add(product);
        product = new Product(covers[0], "Samsung", "Camcoder", "10000/-");
        productList.add(product);
        product = new Product(covers[0], "Samsung", "Camcoder", "10000/-");
        productList.add(product);
        product = new Product(covers[0], "Samsung", "Camcoder", "10000/-");
        productList.add(product);
        product = new Product(covers[0], "Samsung", "Camcoder", "10000/-");
        productList.add(product);

        adapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
