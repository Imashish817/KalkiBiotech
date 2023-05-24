/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kalki.DBCalls;

import com.mycompany.kalki.BilledMeds;
import com.mycompany.kalki.Customer;
import com.mycompany.kalki.Med;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author imash MSSQLSERVER
 * Server=localhost;Database=master;Trusted_Connection=True;
 *
 * CREATE TABLE [dbo].[Item] ( [HSN] CHAR (10) NULL, [Product] CHAR (100) NOT
 * NULL, [Pack] CHAR (100) NULL, [Batch] CHAR (100) NOT NULL, [Expire] CHAR
 * (100) NOT NULL, [GST] INT NOT NULL, [Qty] INT NOT NULL, [Scheme] CHAR (100)
 * CONSTRAINT [DEFAULT_Item_Scheme] DEFAULT 0+0 NULL, [PTS] FLOAT (53) NULL
 *
 *
 * CREATE TABLE `kalkibiotech`.`itemslist` ( `HSNCode` VARCHAR(20) NOT NULL,
 * `Product` VARCHAR(45) NOT NULL, `Pack` VARCHAR(45) NULL, `Batch` VARCHAR(45)
 * NOT NULL, `Expire` VARCHAR(45) NOT NULL, `GST` INT NOT NULL, `QTY` INT NOT
 * NULL, `Scheme` VARCHAR(45) NULL, `PTS` VARCHAR(45) NULL);
 *
 * );
 *
 *
 */
public class GetDBData {

//    public static String DB_Name = "kalkibiotech.itemslist";
//    public static String Bill_DB = "kalkibiotech.bills";
//    public static String Customer_DB = "kalkibiotech.customer";
//    public static String Sell_Med_DB = "kalkibiotech.soldmeds";
//
//    public static Connection getConnection() throws Exception {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        return DriverManager.getConnection("jdbc:mysql://localhost:3306/KalkiBiotech", "root", "root");
//    }
//
//    public void Getdata() throws Exception {
//        Connection con = getConnection();
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * FROM " + DB_Name);
//        while (rs.next()) {
//            System.out.println(rs.getString(1) + "  " + rs.getString(2));
//        }
//        st.close();
//        con.close();
//    }
//
//    public Boolean InsertItem(Med med) {
//        try (Connection con = getConnection()) {
//            String Query = " insert into " + DB_Name + " (HSNCode, Product, Pack, Batch, Expire,GST,QTY,Scheme,PTS,PTR,Rate,MRP)"
//                    + " values (?, ?, ?, ?, ?,?,?,?,?,?,?,?)";
//            PreparedStatement preparedStmt = con.prepareStatement(Query);
//            preparedStmt.setString(1, med.getHSNCode());
//            preparedStmt.setString(2, med.getProduct());
//            preparedStmt.setString(3, med.getPack());
//            preparedStmt.setString(4, med.getBatch());
//            preparedStmt.setString(5, med.getExpire());
//            preparedStmt.setInt(6, med.getGST());
//            preparedStmt.setInt(7, med.getQTY());
//            preparedStmt.setString(8, med.getScheme());
//            preparedStmt.setDouble(9, med.getPTS());
//            preparedStmt.setDouble(10, med.getPTR());
//            preparedStmt.setDouble(11, med.getRate());
//            preparedStmt.setDouble(12, med.getMRP());
//
//            preparedStmt.execute();
//            preparedStmt.close();
//            con.close();
//            return true;
//
//        } catch (SQLException ex) {
//
//            return false;
//        } catch (Exception ex) {
//            return false;
//        }
//
//    }
//
//    public ArrayList<String> GetAllMedsName() throws Exception {
//        ArrayList<String> MedsName = new ArrayList<>();
//        Connection con = getConnection();
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * FROM " + DB_Name);
//        while (rs.next()) {
//            MedsName.add(rs.getString("Product"));
//
//        }
//        rs.close();
//        st.close();
//        con.close();
//        return MedsName;
//    }
//
//    public ArrayList<Med> GetAllMeds() throws Exception {
//        ArrayList<Med> Meds = new ArrayList<>();
//        Connection con = getConnection();
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * FROM " + DB_Name + " where QTY>0");
//        while (rs.next()) {
//            int id = rs.getInt("ID");
//            String HSNCode = rs.getString("HSNCode");
//            String Product = rs.getString("Product");
//            String Pack = rs.getString("Pack");
//            String Batch = rs.getString("Batch");
//            String Expire = rs.getString("Expire");
//            int GST = rs.getInt("GST");
//            int QTY = rs.getInt("QTY");
//            String Scheme = rs.getString("Scheme");
//            Double PTS = rs.getDouble("PTS");
//            Double PTR = rs.getDouble("PTR");
//            Double Rate = rs.getDouble("Rate");
//            Double MRP = rs.getDouble("MRP");
//            Med medicine = new Med( HSNCode, Product, Pack, Batch, Expire, GST, QTY, Scheme, PTS, PTR, Rate, MRP);
//            Meds.add(medicine);
//        }
//        rs.close();
//        st.close();
//        con.close();
//        return Meds;
//    }
//    ///////Bill table
//    public boolean AddBill(String invoiceno, String CustomerName, int CustomerID, Double TotalTaxable, Double GST, Double NetTotal, Double NetProfit, Date date,Double AmountPaid,String Remark) {
//        try (Connection con = getConnection()) {
//            String Query = "insert into " + Bill_DB + " (InvoiceNo, CustomerName, CustomerDetails, TaxableAmount, GST,NetTotal,NetProfit,Date,AmountPaid,remark)"
//                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//            PreparedStatement preparedStmt = con.prepareStatement(Query);
//            preparedStmt.setString(1, invoiceno);
//            preparedStmt.setString(2, CustomerName);
//            preparedStmt.setInt(3, CustomerID);
//            preparedStmt.setDouble(4, TotalTaxable);
//            preparedStmt.setDouble(5, GST);
//            preparedStmt.setDouble(6, NetTotal);
//            preparedStmt.setDouble(7, NetProfit);
//            preparedStmt.setDate(8, date);
//            preparedStmt.setDouble(9, AmountPaid);
//            preparedStmt.setString(10, Remark);
//            System.out.println(Query);
//            preparedStmt.execute();
//
//            preparedStmt.close();
//            con.close();
//            return true;
//        } catch (SQLException ex) {
//            System.out.println(ex);
//            return false;
//        } catch (Exception ex) {
//            System.out.println(ex);
//            return false;
//        }
//    }
//
//    public boolean AddCustomer(Customer customer) {
//        try (Connection con = getConnection()) {
//            String Query = "insert into " + Customer_DB + " (Firm_Name, Address, Mobile, tel, email,GSTno,PAN,DL1,DL2,State)"
//                    + " values (?, ?, ?, ?, ?, ?,?,?,?,?)";
//
//            PreparedStatement preparedStmt = con.prepareStatement(Query);
//            preparedStmt.setString(1, customer.getFirm_Name());
//            preparedStmt.setString(2, customer.getAddress());
//            preparedStmt.setString(3, customer.getMobile());
//            preparedStmt.setString(4, customer.getTel());
//            preparedStmt.setString(5, customer.getEmail());
//            preparedStmt.setString(6, customer.getGSTno());
//            preparedStmt.setString(7, customer.getPAN());
//            preparedStmt.setString(8, customer.getDL1());
//            preparedStmt.setString(9, customer.getDL2());
//            preparedStmt.setString(10, customer.getState());
//            System.out.println(Query);
//            preparedStmt.execute();
//
//            preparedStmt.close();
//            con.close();
//            return true;
//        } catch (SQLException ex) {
//            System.out.println(ex);
//            return false;
//        } catch (Exception ex) {
//            System.out.println(ex);
//            return false;
//        }
//    }
//
//    public ArrayList<Customer> GetAllCustomers() throws Exception {
//        ArrayList<Customer> customers = new ArrayList<>();
//        Connection con = getConnection();
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * FROM " + Customer_DB);
//        while (rs.next()) {
////            id, Firm_Name, Address, Mobile, tel, email, GSTno, PAN, DL1, DL2, State
//            int id = rs.getInt("id");
//            String Firm_Name = rs.getString("Firm_Name");
//            String Address = rs.getString("Address");
//            String mobile = rs.getString("Mobile");
//            String tesl = rs.getString("tel");
//            String email = rs.getString("email");
//            String gstno = rs.getString("GSTno");
//            String pan = rs.getString("PAN");
//            String dl1 = rs.getString("DL1");
//            String dl2 = rs.getString("DL2");
//            String state = rs.getString("State");
//            Customer c = new Customer(id, Firm_Name, Address, mobile, tesl, email, gstno, pan, dl1, dl2, state);
//            customers.add(c);
//        }
//        rs.close();
//        st.close();
//        con.close();
//        return customers;
//    }
//
//    public int[] insertBilledMeds(ArrayList<BilledMeds> billedMeds, String invoiceno,Date date) throws Exception {
//        Connection con = getConnection();
//        con.setAutoCommit(false);
//        Statement st = con.createStatement();
//        String INSERT_RECORD = "INSERT INTO " + Sell_Med_DB + " (Invoice, Med, MRP, HSN,Batch, Pack,QTY, Scheme, PTR, NetQTY,Expire,PTS,Discount,TaxableAmount,GST,NetTotal,Date,Profit) "
//                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?, ?, ?, ?, ?, ?, ?, ?);";
//        PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
//        for (int i = 0; i < billedMeds.size(); i++) {
//            BilledMeds medicine = billedMeds.get(i);
//            pstmt.setString(1, invoiceno);
//            pstmt.setString(2, medicine.getProduct());
//            pstmt.setDouble(3, medicine.getMRP());
//            pstmt.setString(4, medicine.getHSNCode());
//            pstmt.setString(5, medicine.getBatch());
//            pstmt.setString(6, medicine.getPack());
//            pstmt.setInt(7, medicine.getQTY());
//            pstmt.setString(8, medicine.getScheme());
//            pstmt.setDouble(9, medicine.getPTR());
//            pstmt.setInt(10, medicine.getNetQTY());
//            pstmt.setString(11, medicine.getExpire());
//            pstmt.setDouble(12, medicine.getPTS());
//            pstmt.setDouble(13, medicine.getDiscount());
//            pstmt.setDouble(14, medicine.getTaxableAmount());
//            pstmt.setDouble(15, medicine.getGST());
//            pstmt.setDouble(16, medicine.getNetTotal());
//            pstmt.setDate(17, date);
//            pstmt.setDouble(18,medicine.getProfit() );
//            pstmt.addBatch();
//        }
//        int[] updateCounts = pstmt.executeBatch();
//
//        con.commit();
//        st.close();
//        con.close();
//        return updateCounts;
//    }
//
//    public void updateitemlist(int QTY, int id) throws Exception {
//        Connection con = getConnection();
//con.setAutoCommit(false);
//        String SQL = "UPDATE " + DB_Name + " SET QTY = QTY - " + QTY + " where ID = " + id;
//        System.out.println(SQL);
//        Statement st = con.prepareStatement(SQL);
//        st.executeUpdate(SQL);
//        con.commit();
//        st.close();
//        con.close();
//    }
//    
//    public ArrayList<Double> GetSalesDetails(Date start, Date End) throws Exception
//    {
//     Connection con = getConnection();
//        Statement st = con.createStatement();
//        String SQL="SELECT * FROM " + Bill_DB +" WHERE Date BETWEEN '"+start+"' AND '"+ End+"'";
//        System.out.println(SQL);
//        ResultSet rs = st.executeQuery(SQL);
//        Double Taxable_Amount=0.0;
//        Double GST_Amount=0.0;
//        Double Net_Amount=0.0;
//        Double Net_Profit=0.0;
//        Double Amount_Paid=0.0;
//        while (rs.next()) {
//            System.out.println(rs.getDouble(9));
//            System.out.println(rs.getString(9));
//            Taxable_Amount=Taxable_Amount+rs.getDouble("TaxableAmount");
//            Net_Amount=Net_Amount+rs.getDouble("NetTotal");
//            GST_Amount=GST_Amount+rs.getDouble("GST");
//            Net_Profit=Net_Profit+rs.getDouble("NetProfit");
//            Amount_Paid=Amount_Paid+rs.getDouble("AmountPaid");  
//        }
//        ArrayList <Double> SalesDetails =new ArrayList<>();
//        System.out.println(Taxable_Amount+"  "+GST_Amount+"  "+Net_Amount+"  "+Net_Profit+"  "+Amount_Paid);
//        SalesDetails.add(Net_Amount);
//        SalesDetails.add(Taxable_Amount);
//        SalesDetails.add(GST_Amount);
//        SalesDetails.add(Amount_Paid);
//        SalesDetails.add(Net_Profit);
//        
//        
//        st.close();
//        con.close();
//        return SalesDetails;
//    }
}
