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
public class Med {
   Long ID;
    String HSNCode;
    String Product;
    String Pack;
    String Batch;
    String Expire;
    int GST;
    int QTY;
    String Scheme;
    Double PTS;
    Double PTR;
    Double Rate;
    
    Double MRP;

    public Med() {
    }

    public Double getPTR() {
        return PTR;
    }

    public void setPTR(Double PTR) {
        this.PTR = PTR;
    }

  

    

    public Med(Long ID,String HSNCode, String Product, String Pack, String Batch, String Expire, int GST, int QTY, String Scheme, Double PTS, Double PTR, Double Rate, Double MRP) {
       this.ID=ID;
        this.HSNCode = HSNCode;
        this.Product = Product;
        this.Pack = Pack;
        this.Batch = Batch;
        this.Expire = Expire;
        this.GST = GST;
        this.QTY = QTY;
        this.Scheme = Scheme;
        this.PTS = PTS;
        this.PTR = PTR;
        this.Rate = Rate;
        
        this.MRP = MRP;
    }

   

    public String getHSNCode() {
        return HSNCode;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getProduct() {
        return Product;
    }

    public String getPack() {
        return Pack;
    }

    public String getBatch() {
        return Batch;
    }

    public String getExpire() {
        return Expire;
    }

    public int getGST() {
        return GST;
    }

    public int getQTY() {
        return QTY;
    }

    public String getScheme() {
        return Scheme;
    }

    public Double getPTS() {
        return PTS;
    }

    public Double getRate() {
        return Rate;
    }

    public Double getMRP() {
        return MRP;
    }

    public void setHSNCode(String HSNCode) {
        this.HSNCode = HSNCode;
    }

    public void setProduct(String Product) {
        this.Product = Product;
    }

    public void setPack(String Pack) {
        this.Pack = Pack;
    }

    public void setBatch(String Batch) {
        this.Batch = Batch;
    }

    public void setExpire(String Expire) {
        this.Expire = Expire;
    }

    public void setGST(int GST) {
        this.GST = GST;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public void setScheme(String Scheme) {
        this.Scheme = Scheme;
    }

    public void setPTS(Double PTS) {
        this.PTS = PTS;
    }

    public void setRate(Double Rate) {
        this.Rate = Rate;
    }

    public void setMRP(Double MRP) {
        this.MRP = MRP;
    }

    
}