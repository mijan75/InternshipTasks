/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientapi;

/**
 *
 * @author mijanur
 */
public class FeesCollection {
    private String id;
    private String feesAmount;
    private String feesStatus;
    private String date;
    private double paidAmount;
    private double dueAmount;
    private Student student;

    public FeesCollection() {
    }

    public FeesCollection(String id, String feesAmount, String feesStatus, String date, double paidAmount, double dueAmount, Student student) {
        this.id = id;
        this.feesAmount = feesAmount;
        this.feesStatus = feesStatus;
        this.date = date;
        this.paidAmount = paidAmount;
        this.dueAmount = dueAmount;
        this.student = student;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeesAmount() {
        return feesAmount;
    }

    public void setFeesAmount(String feesAmount) {
        this.feesAmount = feesAmount;
    }

    public String getFeesStatus() {
        return feesStatus;
    }

    public void setFeesStatus(String feesStatus) {
        this.feesStatus = feesStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "FeesCollection{" + "id=" + id + ", feesAmount=" + feesAmount + ", feesStatus=" + feesStatus + ", date=" + date + ", paidAmount=" + paidAmount + ", dueAmount=" + dueAmount + ", student=" + student + '}';
    }
    
    
}
