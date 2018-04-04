package com.example.backenduitlity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StakeHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String contact_person_name;
    private String contact_person_mobile;
    private int status;

    public StakeHolder() {
    }

    public StakeHolder(String name, String address, String contact_person_name, String contact_person_mobile, int status) {
        this.name = name;
        this.address = address;
        this.contact_person_name = contact_person_name;
        this.contact_person_mobile = contact_person_mobile;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_person_name() {
        return contact_person_name;
    }

    public void setContact_person_name(String contact_person_name) {
        this.contact_person_name = contact_person_name;
    }

    public String getContact_person_mobile() {
        return contact_person_mobile;
    }

    public void setContact_person_mobile(String contact_person_mobile) {
        this.contact_person_mobile = contact_person_mobile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
