/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kalki;

import com.mycompany.kalki.DBCalls.MongoDBCalls;
import java.util.Calendar;

/**
 *
 * @author imash
 */
public class Utility {

    public Utility() {
    }

    public static boolean isNumeric(String[] checks) {
        boolean b=true;
        for (int i = 0; i < checks.length; i++) {
            try {
                Double.parseDouble(checks[i]);
            } catch (NumberFormatException nfe) {
                b= false;
                break;
            }
           
        }
         return b;
    }
    public static String getfinancialyear() {
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
        String financialyear="";
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        if (month < 3) {
            financialyear= (year - 1) + "-" + year.toString().substring(2);
        } else {
            financialyear= year + "-" + (++year).toString().substring(2);
        }
        return financialyear;
    }
     public static String generatefinancialyear(String ddMMYYYY) {
        Integer year = Integer.valueOf(ddMMYYYY.split("-")[2]);
        String financialyear="";
        int month = Integer.valueOf(ddMMYYYY.split("-")[1]);
        if (month < 3) {
            financialyear= (year - 1) + "-" + year.toString().substring(2);
        } else {
            financialyear= year + "-" + (++year).toString().substring(2);
        }
        return financialyear;
    }
    public static String getInvoiceNo(){
        MongoDBCalls DBCalls =new MongoDBCalls();
        String invoiceno=DBCalls.getInvoiceCounter().toString();
        while(invoiceno.length() !=4)
        {
        invoiceno="0"+invoiceno;
        }
        return invoiceno;
    }
    
    public static String NumberToWord (String number)
            {
               
            String twodigitword="";
            String word="";
            String[] HTLC = {"", "Hundred", "Thousand", "Lakh", "Crore"}; //H-hundread , T-Thousand, ..
            int split[]={0,2, 3, 5, 7,9};
            String[] temp=new String[split.length];
            boolean addzero=true;
            int len1=number.length();
            if (len1>split[split.length-1]) { System.out.println("Error. Maximum Allowed digits "+ split[split.length-1]);
            System.exit(0);
            }
            for (int l=1 ; l<split.length; l++ )
            if (number.length()==split[l] ) addzero=false;
            if (addzero==true) number="0"+number;
            int len=number.length();
            int j=0;
            //spliting & putting numbers in temp array.
            while (split[j]<len)
            {
                int beg=len-split[j+1];
                int end=beg+split[j+1]-split[j];
                temp[j]=number.substring(beg , end);
                j=j+1;
            }
             
            for (int k=0;k<j;k++)
            {
                twodigitword=ConvertOnesTwos(temp[k]);
                if (k>=1){
                if (twodigitword.trim().length()!=0) word=twodigitword+" " +HTLC[k] +" "+word;
                }
                else word=twodigitword ;
                }
               return (word);
            }
     
    private static String ConvertOnesTwos(String t)
    {
        final String[] ones ={"", "One", "Two", "Three", "Four", "Five","Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve","Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty","Ninety"};
     
    String word="";
    int num=(int)Math.round(Double.parseDouble(t));
    if (num%10==0) word=tens[num/10]+" "+word ;
    else if (num<20) word=ones[num]+" "+word ;
    else
    {
        word=tens[(num-(num%10))/10]+word ;
        word=word+" "+ones[num%10] ;
    }
    return word;
    }
}
    
    

//        
//        if (strNum == null) {
//            return false;
//        }
//        try {
//            Double.parseDouble(strNum);
//        } catch (NumberFormatException nfe) {
//            return false;
//        }
//        return true;
//    }

