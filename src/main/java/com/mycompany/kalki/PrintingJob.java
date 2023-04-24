/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kalki;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author imash
 */
public class PrintingJob {
    Customer BillingDetails;
    Customer ShippingDetails;
    String Inv;
    LocalDate Date;
    public void setBilledDetails(Customer customer)
    {
        System.out.println(customer.getFirm_Name()+customer.getDL1());
        BillingDetails=customer;
    }
    public void setShippingDetails(Customer customer)
    {
        System.out.println(customer.getFirm_Name()+customer.getDL1());
        ShippingDetails=customer;
    }
    public void basicDetails(String InvoiceNo, LocalDate date)
    {
        System.out.println(InvoiceNo+" "+date);
        Inv=InvoiceNo;
        Date=date;
    }
    
    
    public void Meds(ArrayList<BilledMeds> medicins,Double GST, Double Taxable,Double NetTotal,String paid,String Remark,String Amountleft,String Transport)
    {
        
        
        for(int i=0;i<medicins.size();i++)
        {
            System.out.println(medicins.get(i).getProduct());
        }
        if(medicins.isEmpty())
        {
        //this means its a deposit request
          Printbills bill=new Printbills(Inv,Date,BillingDetails,ShippingDetails,medicins,GST,Taxable,NetTotal,paid,Remark,Amountleft,false,1,"");  
          bill.setVisible(true);
        }
        int s=0;
        boolean TBC=true;
        Integer pageNo=1;
        ///////////////////
        while(s!=medicins.size()){
            System.out.println("in while");
            ArrayList<BilledMeds> submedicins=new ArrayList<>();
            for (int j = 0; j < 15; j++) {
                
                if (s + 1 == medicins.size()) {
                    submedicins.add(medicins.get(s));
                    TBC=false;
                    s++;
                    break;
                }
                submedicins.add(medicins.get(s));
                s++;
            }
             Printbills bill=new Printbills(Inv,Date,BillingDetails,ShippingDetails,submedicins,GST,Taxable,NetTotal,paid,Remark,Amountleft,TBC,pageNo, Transport);
            bill.setVisible(true);
            pageNo++;
        }
        
        //////////////
       
        System.out.println("com.mycompany.kalki.PrintingJob.Meds()");
        
    }
}
