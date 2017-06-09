package com.example.farazahmed.kefayat;

import java.util.ArrayList;

/**
 * Created by FarazAhmed on 4/17/2017.
 */

public class ChildDataModel {

    private String headerTitle;
    private ArrayList<Product> allItemsInSection;


    public ChildDataModel() {

    }
    public ChildDataModel(String headerTitle, ArrayList<Product> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }


    public ArrayList<Product> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<Product> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }
    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }


}
