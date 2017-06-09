package com.example.farazahmed.kefayat;

/**
 * Created by FarazAhmed on 4/18/2017.
 */

public class availibiltydatamodel {

    private String countryname ;
    private String contact_no;
    private String address ;

    public availibiltydatamodel(String countryname, String contact_no, String address) {

        this.countryname = countryname;
        this.contact_no = contact_no;
        this.address = address;

    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
