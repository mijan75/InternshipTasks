package com.example.VoiceSMS.model;

import javax.persistence.*;

@Entity
public class PhoneNumber {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String phoneNumber;
    @ManyToOne
    WMVFile wmvFile;

    public PhoneNumber() {
    }

    public PhoneNumber(String phoneNumber, WMVFile wmvFile) {
        this.phoneNumber = phoneNumber;
        this.wmvFile = wmvFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public WMVFile getWmvFile() {
        return wmvFile;
    }

    public void setWmvFile(WMVFile wmvFile) {
        this.wmvFile = wmvFile;
    }
}
