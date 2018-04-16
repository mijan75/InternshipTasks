package com.example.BillPaymentAdminPanel.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TempUser {
    String searchOption;
    String id;
    String endAmount;
    String startDate;
    String endDate;


    public TempUser() {
    }

    public TempUser(String searchOption, String id, String endAmount, String startDate, String endDate) {
        this.searchOption = searchOption;
        this.id = id;
        this.endAmount = endAmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getSearchOption() {
        return searchOption;
    }

    public void setSearchOption(String searchOption) {
        this.searchOption = searchOption;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(String endAmount) {
        this.endAmount = endAmount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
