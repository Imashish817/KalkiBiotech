/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kalki;

/**
 *
 * @author imash
 */
public class Customer {
    int id;
    String Firm_Name;
    String Address;
    String Mobile;
    String tel;
    String email;
    String GSTno;
    String PAN;
    String DL1;
    String DL2;
    String State;

    public Customer(int id, String Firm_Name, String Address, String Mobile, String tel, String email, String GSTno, String PAN, String DL1, String DL2, String State) {
        this.id = id;
        this.Firm_Name = Firm_Name;
        this.Address = Address;
        this.Mobile = Mobile;
        this.tel = tel;
        this.email = email;
        this.GSTno = GSTno;
        this.PAN = PAN;
        this.DL1 = DL1;
        this.DL2 = DL2;
        this.State = State;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirm_Name() {
        return Firm_Name;
    }

    public void setFirm_Name(String Firm_Name) {
        this.Firm_Name = Firm_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGSTno() {
        return GSTno;
    }

    public void setGSTno(String GSTno) {
        this.GSTno = GSTno;
    }

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public String getDL1() {
        return DL1;
    }

    public void setDL1(String DL1) {
        this.DL1 = DL1;
    }

    public String getDL2() {
        return DL2;
    }

    public void setDL2(String DL2) {
        this.DL2 = DL2;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }
    
    
}
