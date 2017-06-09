package com.example.farazahmed.kefayat;

import java.util.List;

/**
 * Created by FarazAhmed on 4/12/2017.
 */

public class Product {

    private int thumbnail;
    private String company;
    private String product_name;
    private String salary;
    private  String heading;
    private String content;

    private List<Product> allitems;


    public Product(List<Product> allitems)
    {
        this.allitems = allitems;
    }

    //for  main recyclerview
    public Product(int thumbnail, String company, String product_name, String salary) {
        this.thumbnail = thumbnail;
        this.company = company;
        this.product_name = product_name;
        this.salary = salary;
    }
    public List<Product> getAllItemsInSection() {
        return allitems;
    }

    public void setAllItemsInSection(List<Product> allItemsInSection) {
        this.allitems = allItemsInSection;
    }


    //for overview reyclerview
    public Product(int thumbnail)
    {
        this.thumbnail = thumbnail;
    }


   //for feature recyclerview
    public Product(String text , int thumbnail)
    {
        this.product_name = text;
        this.thumbnail = thumbnail;
    }

    //for spec recyclerview
    public Product(String heading, String content) {
        this.heading = heading;
        this.content = content;
    }

       public void setContent(String content) {this.content =  content;}

    public String getHeading()
    {
        return heading;
    }
    public String getContent()
    {
        return content;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
