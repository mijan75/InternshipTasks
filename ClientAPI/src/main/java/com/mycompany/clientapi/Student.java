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
public class Student {
    public String id;
    public String name;
    public String roll;
    public String address;

    public Student() {
    }

    public Student(String id, String name, String roll, String address) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", roll=" + roll + ", address=" + address + '}';
    }
    
    
}
