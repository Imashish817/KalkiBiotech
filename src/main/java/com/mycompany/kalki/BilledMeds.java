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
public class BilledMeds {
    Long id;
     String HSNCode;
     String Batch;
    String Product;
    String Pack;
     Double MRP;
     int QTY;
     String Scheme;
     int NetQTY;
    String Expire;
    Double PTS;
    Double PTR;
    Double Discount;
    Double TaxableAmount;
    Double GSTPercentage;
    Double GST;
    Double NetTotal;
    Double Profit;
    //for return
    int RQty;
    Double ReturnRate;
    Double NewGSTAmount;
    Double ProfitDecline;

    public BilledMeds(String HSNCode, String Batch, String Product, String Pack, Double MRP, String Scheme, int NetQTY, String Expire, Double PTS, Double PTR, Double TaxableAmount, Double GSTPercentage, Double GST, int RQty, Double ReturnRate,Double NewGSTAmount,Double ProfitDecline) {
        this.HSNCode = HSNCode;
        this.Batch = Batch;
        this.Product = Product;
        this.Pack = Pack;
        this.MRP = MRP;
        this.Scheme = Scheme;
        this.NetQTY = NetQTY;
        this.Expire = Expire;
        this.PTS = PTS;
        this.PTR = PTR;
        this.TaxableAmount = TaxableAmount;
        this.GSTPercentage = GSTPercentage;
        this.GST = GST;
        this.RQty = RQty;
        this.ReturnRate=ReturnRate;
        this.NewGSTAmount=NewGSTAmount;
        this.ProfitDecline=ProfitDecline;
    }

    public Double getProfitDecline() {
        return ProfitDecline;
    }

    public void setProfitDecline(Double ProfitDecline) {
        this.ProfitDecline = ProfitDecline;
    }

    public Double getNewGSTAmount() {
        return NewGSTAmount;
    }

    public void setNewGSTAmount(Double NewGSTAmount) {
        this.NewGSTAmount = NewGSTAmount;
    }

    public Double getReturnRate() {
        return ReturnRate;
    }

    public void setReturnRate(Double ReturnRate) {
        this.ReturnRate = ReturnRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRQty() {
        return RQty;
    }

    public void setRQty(int RQty) {
        this.RQty = RQty;
    }

    

    public BilledMeds(Long id,String HSNCode, String Batch, String Product, String Pack, Double MRP, int QTY, String Scheme, int NetQTY, String Expire, Double PTS, Double PTR, Double Discount, Double TaxableAmount,Double GSTPercentage, Double GST, Double NetTotal,Double Profit) {
        this.id=id;
        this.HSNCode = HSNCode;
        this.Batch = Batch;
        this.Product = Product;
        this.Pack = Pack;
        this.MRP = MRP;
        this.QTY = QTY;
        this.Scheme = Scheme;
        this.NetQTY = NetQTY;
        this.Expire = Expire;
        this.PTS = PTS;
        this.PTR = PTR;
        this.Discount = Discount;
        this.TaxableAmount = TaxableAmount;
        this.GSTPercentage=GSTPercentage;
        this.GST = GST;
        this.NetTotal = NetTotal;
        this.Profit=Profit;
    }

    public Double getProfit() {
        return Profit;
    }

    public void setProfit(Double Profit) {
        this.Profit = Profit;
    }

    public Double getDiscount() {
        return Discount;
    }

    public Double getGSTPercentage() {
        return GSTPercentage;
    }

    public void setGSTPercentage(Double GSTPercentage) {
        this.GSTPercentage = GSTPercentage;
    }

    public void setDiscount(Double Discount) {
        this.Discount = Discount;
    }

    public void setHSNCode(String HSNCode) {
        this.HSNCode = HSNCode;
    }

    public void setBatch(String Batch) {
        this.Batch = Batch;
    }

    public void setProduct(String Product) {
        this.Product = Product;
    }

    public void setPack(String Pack) {
        this.Pack = Pack;
    }

    public void setMRP(Double MRP) {
        this.MRP = MRP;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public void setScheme(String Scheme) {
        this.Scheme = Scheme;
    }

    public void setNetQTY(int NetQTY) {
        this.NetQTY = NetQTY;
    }

    public void setExpire(String Expire) {
        this.Expire = Expire;
    }

    public void setPTS(Double PTS) {
        this.PTS = PTS;
    }

    public void setPTR(Double PTR) {
        this.PTR = PTR;
    }

    public void setTaxableAmount(Double TaxableAmount) {
        this.TaxableAmount = TaxableAmount;
    }

    public void setGST(Double GST) {
        this.GST = GST;
    }

    public void setNetTotal(Double NetTotal) {
        this.NetTotal = NetTotal;
    }

    public String getHSNCode() {
        return HSNCode;
    }

    public String getBatch() {
        return Batch;
    }

    public String getProduct() {
        return Product;
    }

    public String getPack() {
        return Pack;
    }

    public Double getMRP() {
        return MRP;
    }

    public int getQTY() {
        return QTY;
    }

    public String getScheme() {
        return Scheme;
    }

    public int getNetQTY() {
        return NetQTY;
    }

    public String getExpire() {
        return Expire;
    }

    public Double getPTS() {
        return PTS;
    }

    public Double getPTR() {
        return PTR;
    }

    public Double getTaxableAmount() {
        return TaxableAmount;
    }

    public Double getGST() {
        return GST;
    }

    public Double getNetTotal() {
        return NetTotal;
    }

    
   
}
