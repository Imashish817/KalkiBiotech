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
}
