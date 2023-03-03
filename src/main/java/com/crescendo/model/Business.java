package com.crescendo.model;

import javax.persistence.*;

@Entity
public class Business {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

        @Column
        private String businessName;

        @Column
        private String address;

        @Column
        private String phone;

    public Business() {
    }

    public Business(String businessName, String address, String phone) {
        this.businessName = businessName;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
