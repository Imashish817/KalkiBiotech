/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kalki;

import java.util.Date;



/**
 *
 * @author imash
 */
public class GSTR1Model {
    private String InvoiceNo;
    private Long InvoiceDate;
    private String ClientName;
    private String GSTN;
    private String Nature;
    private String TransactionType;
    private String HSNCode;
    private Integer QTY;
    private Double TaxableAmount;
    private Double GSTrate;
    private Double GSTAmount;
    private Double InvoiceAmount;
    private String Destination;

    public GSTR1Model(String InvoiceNo, Long InvoiceDate, String ClientName, String GSTN, String Nature, String TransactionType, String HSNCode, Integer QTY, Double TaxableAmount, Double GSTrate, Double GSTAmount, Double InvoiceAmount, String Destination) {
        this.InvoiceNo = InvoiceNo;
        this.InvoiceDate = InvoiceDate;
        this.ClientName = ClientName;
        this.GSTN = GSTN;
        this.Nature = Nature;
        this.TransactionType = TransactionType;
        this.HSNCode = HSNCode;
        this.QTY = QTY;
        this.TaxableAmount = TaxableAmount;
        this.GSTrate = GSTrate;
        this.GSTAmount = GSTAmount;
        this.InvoiceAmount = InvoiceAmount;
        this.Destination=Destination;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public Long getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(Long InvoiceDate) {
        this.InvoiceDate = InvoiceDate;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
    }

    public String getGSTN() {
        return GSTN;
    }

    public void setGSTN(String GSTN) {
        this.GSTN = GSTN;
    }

    public String getNature() {
        return Nature;
    }

    public void setNature(String Nature) {
        this.Nature = Nature;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String TransactionType) {
        this.TransactionType = TransactionType;
    }

    public String getHSNCode() {
        return HSNCode;
    }

    public void setHSNCode(String HSNCode) {
        this.HSNCode = HSNCode;
    }

    public Integer getQTY() {
        return QTY;
    }

    public void setQTY(Integer QTY) {
        this.QTY = QTY;
    }

    public Double getTaxableAmount() {
        return TaxableAmount;
    }

    public void setTaxableAmount(Double TaxableAmount) {
        this.TaxableAmount = TaxableAmount;
    }

    public Double getGSTrate() {
        return GSTrate;
    }

    public void setGSTrate(Double GSTrate) {
        this.GSTrate = GSTrate;
    }

    public Double getGSTAmount() {
        return GSTAmount;
    }

    public void setGSTAmount(Double GSTAmount) {
        this.GSTAmount = GSTAmount;
    }

    public Double getInvoiceAmount() {
        return InvoiceAmount;
    }

    public void setInvoiceAmount(Double InvoiceAmount) {
        this.InvoiceAmount = InvoiceAmount;
    }
    
    
    
}
