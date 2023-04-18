package com.jim.model;

import org.hibernate.annotations.DialectOverride.GeneratedColumn;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int sId;

    private String name;
    
    private String email;

    private String password;

    @Column(name = "mobile_number")
    private long mobileNumber;

    private String address;

    public Student() {
    }

    public Student(int sId, String name, String email, long mobileNumber, String address , String password) {
        this.sId = sId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.password=password;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student [sId=" + sId + ", name=" + name + ", email=" + email + ", password=" + password
                + ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
    }

    
}
