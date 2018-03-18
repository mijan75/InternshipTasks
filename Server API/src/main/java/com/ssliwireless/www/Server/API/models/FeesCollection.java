package com.ssliwireless.www.Server.API.models;

import com.ssliwireless.www.Server.API.models.Student;

import javax.persistence.*;
import java.util.Date;

@Entity
public class FeesCollection {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;
    @Column(name = "fees_amount")
    public String feesAmount;
    @Column(name = "fees_status")
    public String feesStatus;
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    public Date date;
    @Column(name = "paid_amount")
    public double paidAmount;
    @Column(name = "due_amount")
    public double dueAmount;
    @OneToOne
    Student student;

    public FeesCollection() {
    }

    public FeesCollection(String id, String feesAmount, String feesStatus, double paidAmount, double dueAmount) {
        this.feesAmount = feesAmount;
        this.feesStatus = feesStatus;
        this.paidAmount = paidAmount;
        this.dueAmount = dueAmount;
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
