/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalki;

import java.util.List;

/**
 *
 * @author imash
 */
public class IAM {
    private String CustomrName  = "";
    private String Address1  = "";
    private String Address2  = "";
    private String Email  = "";
    private String AccountNo  = "";
    private String DL1  = "";
    private String DL2  = "";
    private String FoodLicienceNo  = "";
    private String GSTNo  = "";
    private String IFSCCode  = "";
    private String PhoneNo  = "";
    private String UPIId  = "";
    private String Website  = "";
    private List Entitlements = null;

    public List getEntitlements() {
        return Entitlements;
    }

    public void setEntitlements(List<String> Entitlements) {
        this.Entitlements = Entitlements;
    }

    public IAM() {
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String Website) {
        this.Website = Website;
    }

    public String getCustomrName() {
        return CustomrName;
    }

    public void setCustomrName(String CustomrName) {
        this.CustomrName = CustomrName;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String Address1) {
        this.Address1 = Address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String Address2) {
        this.Address2 = Address2;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String AccountNo) {
        this.AccountNo = AccountNo;
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

    public String getFoodLicienceNo() {
        return FoodLicienceNo;
    }

    public void setFoodLicienceNo(String FoodLicienceNo) {
        this.FoodLicienceNo = FoodLicienceNo;
    }

    public String getGSTNo() {
        return GSTNo;
    }

    public void setGSTNo(String GSTNo) {
        this.GSTNo = GSTNo;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String PhoneNo) {
        this.PhoneNo = PhoneNo;
    }

    public String getUPIId() {
        return UPIId;
    }

    public void setUPIId(String UPIId) {
        this.UPIId = UPIId;
    }

    
    
}
