/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kalki;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author imash
 */
public class Printbills extends javax.swing.JFrame {

    public Printbills() {
       
    }
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public Printbills(String Inv, LocalDate Date, Customer BillingDetails, Customer ShippingDetails, ArrayList<BilledMeds> medicins,Double GST, Double Taxable,Double NetTotal,String paid,String Remark,String Amountleft,Boolean TBC, Integer pageNo,String Transport, ArrayList<Double[]> GSTdetails) {
        
        initComponents();
        jLabel48.setText("<html>HSN<br>Code</html>");
        jLabel60.setText("<html>Taxable<br>Amount</html>");
        jLabel55.setText("<html>Net<br>QTY</html>");
      
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(Color.white);
        this.setSize(1306, 680);
        jTable1.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        jPanel7.setVisible(!TBC);
        jPanel10.setVisible(!TBC);
        jLabel71.setText(Inv);
        jLabel73.setText(Date.toString());
        jLabel7.setText(BillingDetails.getFirm_Name());
        jLabel8.setText(jLabel8.getText()+BillingDetails.getAddress());
        jLabel9.setText(jLabel9.getText()+BillingDetails.getMobile());
        jLabel10.setText(jLabel10.getText()+BillingDetails.getEmail());
        
        jLabel12.setText(ShippingDetails.getFirm_Name());
        jLabel13.setText(jLabel13.getText()+ShippingDetails.getAddress());
        jLabel14.setText( jLabel14.getText()+ShippingDetails.getMobile());
        jLabel15.setText(jLabel15.getText()+ShippingDetails.getEmail());
        
        jLabel63.setText(ShippingDetails.getFirm_Name());
        jLabel64.setText(ShippingDetails.getGSTno());
        jLabel65.setText(ShippingDetails.getPAN());
        jLabel66.setText(ShippingDetails.getDL1());
        jLabel67.setText(ShippingDetails.getDL2());
        jLabel68.setText(ShippingDetails.getState());
        jLabel28.setText(Transport);
       
        jLabel36.setText(df.format(Taxable));
        jLabel37.setText(df.format(GST));
        jLabel38.setText(df.format(NetTotal));
        jLabel39.setText(Remark);
        jLabel40.setText(df.format(Double.valueOf(paid)));
        jLabel41.setText(df.format(Double.valueOf(Amountleft)));
        
        jLabel42.setVisible(TBC);
        jLabel44.setText(pageNo.toString());
        String n=String.valueOf((int)Math.round(NetTotal));
        String Amount=Utility.NumberToWord(n);
        jLabel117.setText("Total Round Off: " +Amount+" Only");
        //setting GST 
        jLabel91.setText(df.format(GSTdetails.get(0)[0]));
        jLabel95.setText(df.format(GSTdetails.get(0)[1]));
        jLabel99.setText(df.format(GSTdetails.get(0)[2]));
        jLabel103.setText(df.format(GSTdetails.get(0)[3]));
        jLabel107.setText(df.format(GSTdetails.get(0)[4]));
        
        jLabel92.setText(df.format(GSTdetails.get(1)[0]));
        jLabel96.setText(df.format(GSTdetails.get(1)[1]));
        jLabel100.setText(df.format(GSTdetails.get(1)[2]));
        jLabel104.setText(df.format(GSTdetails.get(1)[3]));
        jLabel108.setText(df.format(GSTdetails.get(1)[4]));
        
        jLabel93.setText(df.format(GSTdetails.get(2)[0]));
        jLabel97.setText(df.format(GSTdetails.get(2)[1]));
        jLabel101.setText(df.format(GSTdetails.get(2)[2]));
        jLabel105.setText(df.format(GSTdetails.get(2)[3]));
        jLabel109.setText(df.format(GSTdetails.get(2)[4]));
        
        jLabel94.setText(df.format(GSTdetails.get(3)[0]));
        jLabel98.setText(df.format(GSTdetails.get(3)[1]));
        jLabel102.setText(df.format(GSTdetails.get(3)[2]));
        jLabel106.setText(df.format(GSTdetails.get(3)[3]));
        jLabel110.setText(df.format(GSTdetails.get(3)[4]));
        
        Double sum1=GSTdetails.get(0)[0]+GSTdetails.get(1)[0]+GSTdetails.get(2)[0]+GSTdetails.get(3)[0];
        jLabel112.setText(df.format(sum1));
        Double sum2=GSTdetails.get(0)[1]+GSTdetails.get(1)[1]+GSTdetails.get(2)[1]+GSTdetails.get(3)[1];
        jLabel113.setText(df.format(sum2));
        Double sum3=GSTdetails.get(0)[2]+GSTdetails.get(1)[2]+GSTdetails.get(2)[2]+GSTdetails.get(3)[2];
        jLabel114.setText(df.format(sum3));
        Double sum4=GSTdetails.get(0)[3]+GSTdetails.get(1)[3]+GSTdetails.get(2)[3]+GSTdetails.get(3)[3];
        jLabel115.setText(df.format(sum4));
        Double sum5=GSTdetails.get(0)[4]+GSTdetails.get(1)[4]+GSTdetails.get(2)[4]+GSTdetails.get(3)[4];
        jLabel116.setText(df.format(sum5));
        
        ////
        int sno=1;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < medicins.size(); i++) {
            BilledMeds med= medicins.get(i);
            Object[] row = {
                9*(pageNo-1)+sno,
                med.getHSNCode(),//hsn
                med.getBatch(),
                med.getProduct(),
                med.getPack(),
                med.getMRP(),
                med.getQTY(),//QTY
                med.getScheme(),//scheme
                med.NetQTY,//net QTY
                "<html>"+med.getExpire().split("/")[0]+"<br>"+med.getExpire().split("/")[1]+"</html>",
                med.getPTS(),//rate/pts
                med.getPTR(),//PTR
                med.getDiscount(),
                med.TaxableAmount,
               "<html>"+med.getGSTPercentage().toString()+"<br>"+med.getGST().toString()+"</html>",
                med.NetTotal,
                };
            model.addRow(row);
            jTable1.setRowHeight(40);
            sno++;
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel117 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel11 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 152, 63));
        jButton1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Print the Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 0, 560, 40);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setMaximumSize(new java.awt.Dimension(3276, 3276));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(3308, 2180));
        jPanel6.setLayout(null);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No", "HSN Code", "Batch", "Product", "Pack", "MRP", "QTY", "Scheme", "Net QTY", "Expire", "PTS/Rate", "PTR", "Discount", "Taxable  Amount", "GST", "Net Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jPanel6.add(jTable1);
        jTable1.setBounds(30, 410, 1260, 370);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(180);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(11).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(12).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(13).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(14).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(15).setPreferredWidth(70);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel5.setText("WEBSITE: kalkibiotech.com");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 110, 370, 17);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        jLabel1.setText("KALKI BIOTECH");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(11, 1, 375, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setText("Badhara Chauraha, Deoria");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 40, 346, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel3.setText("Uttar Pradesh, 274001");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 60, 346, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel4.setText("EMAIL: Biotechkalki@gmail.com");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 90, 375, 17);

        jPanel6.add(jPanel2);
        jPanel2.setBounds(30, 30, 390, 140);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Phone No        9161666611");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("GST No           09ABAFK0025G1ZT ");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("D.L No1          UP5220B000817                            ");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("D.L No2          UP5221B000815");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Food Lic No     22723854000164");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel4);
        jPanel4.setBounds(30, 180, 390, 170);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel70.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel70.setText("Invoice No ");

        jLabel71.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel71.setText("jLabel71");

        jLabel72.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel72.setText("Date ");

        jLabel73.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel73.setText("jLabel73");

        jLabel74.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel74.setText("Bank Details ");

        jLabel75.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel75.setText("Kalki Biotech");

        jLabel76.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel76.setText("A/C no : 188211010000122");

        jLabel77.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel77.setText("IFSC Code : UBIN0818828");

        jLabel78.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel78.setText("UPI Id : kalkibiotech@unionbank");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel75)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel77)
                                    .addComponent(jLabel78)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jLabel73))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel76)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel77)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel78)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel8);
        jPanel8.setBounds(890, 180, 400, 170);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Some Medical Hall");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Address: ");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Mobile No: ");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Email id: ");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Ship to Address:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel3);
        jPanel3.setBounds(890, 30, 400, 140);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Bill to Address :");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Some Medical Hall");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Address: ");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Mobile No: ");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Email id: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(1, 1, 1)
                .addComponent(jLabel10)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel1);
        jPanel1.setBounds(430, 30, 450, 140);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("DELIVERY AT");

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("GST NO ");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("PAN");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("D.L No1");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("D.L No2 ");

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setText("Goods Through");

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setText("State");

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setText("jLabel28");

        jLabel63.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel63.setText("jLabel63");

        jLabel64.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel64.setText("jLabel64");

        jLabel65.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel65.setText("jLabel65");

        jLabel66.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel66.setText("jLabel66");

        jLabel67.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel67.setText("jLabel67");

        jLabel68.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel68.setText("jLabel68");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel29))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel22))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 16, Short.MAX_VALUE))
                            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel66)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel68))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel5);
        jPanel5.setBounds(430, 180, 450, 170);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(null);

        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setText("Total Taxable: ");
        jPanel7.add(jLabel30);
        jLabel30.setBounds(450, 0, 130, 30);

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setText("Total GST:");
        jPanel7.add(jLabel31);
        jLabel31.setBounds(450, 40, 88, 17);

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setText("Grand Total: ");
        jPanel7.add(jLabel32);
        jLabel32.setBounds(450, 70, 97, 17);

        jLabel36.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel36.setText("jLabel36");
        jPanel7.add(jLabel36);
        jLabel36.setBounds(610, 10, 69, 17);

        jLabel37.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel37.setText("0.0");
        jPanel7.add(jLabel37);
        jLabel37.setBounds(610, 40, 78, 17);

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setText("0.0");
        jPanel7.add(jLabel38);
        jLabel38.setBounds(610, 70, 78, 17);

        jLabel35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel35.setText("Payment remark :");
        jPanel7.add(jLabel35);
        jLabel35.setBounds(180, 10, 135, 17);

        jLabel33.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel33.setText("Amount Paid:");
        jPanel7.add(jLabel33);
        jLabel33.setBounds(180, 40, 135, 17);

        jLabel34.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel34.setText("Amount Left");
        jPanel7.add(jLabel34);
        jLabel34.setBounds(180, 70, 117, 17);

        jLabel41.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel41.setText("jLabel41");
        jPanel7.add(jLabel41);
        jLabel41.setBounds(320, 70, 72, 17);

        jLabel40.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel40.setText("jLabel40");
        jPanel7.add(jLabel40);
        jLabel40.setBounds(320, 40, 72, 17);

        jLabel39.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel39.setText("jLabel39");
        jPanel7.add(jLabel39);
        jLabel39.setBounds(320, 10, 110, 17);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.add(jSeparator1);
        jSeparator1.setBounds(180, 30, 517, 10);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.add(jSeparator2);
        jSeparator2.setBounds(180, 60, 551, 2);

        jLabel117.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel117.setText("jLabel117");
        jPanel7.add(jLabel117);
        jLabel117.setBounds(10, 100, 640, 30);

        jLabel69.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel69.setText("Customer Signatory");
        jPanel7.add(jLabel69);
        jLabel69.setBounds(470, 160, 180, 17);

        jLabel118.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("Authorized Signatory");
        jPanel7.add(jLabel118);
        jLabel118.setBounds(-10, 160, 180, 17);

        jLabel45.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("(Kalki Biotech)");
        jPanel7.add(jLabel45);
        jLabel45.setBounds(-10, 180, 180, 17);

        jPanel6.add(jPanel7);
        jPanel7.setBounds(590, 790, 680, 200);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel9);
        jPanel9.setBounds(10, 680, 430, 50);

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setText("Page No: ");
        jPanel6.add(jLabel43);
        jLabel43.setBounds(1170, 10, 70, 17);

        jLabel44.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel6.add(jLabel44);
        jLabel44.setBounds(1234, 10, 40, 17);

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel47.setText(" S.No");
        jPanel6.add(jLabel47);
        jLabel47.setBounds(30, 370, 40, 30);

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel48.setText("HSN ");
        jPanel6.add(jLabel48);
        jLabel48.setBounds(80, 370, 70, 40);

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel49.setText("Batch");
        jPanel6.add(jLabel49);
        jLabel49.setBounds(170, 370, 50, 30);

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel51.setText("  Pack");
        jPanel6.add(jLabel51);
        jLabel51.setBounds(430, 370, 70, 30);

        jLabel55.setBackground(new java.awt.Color(255, 255, 255));
        jLabel55.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel55.setText("   Net ");
        jPanel6.add(jLabel55);
        jLabel55.setBounds(740, 360, 60, 50);

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel56.setText("  Expiry");
        jPanel6.add(jLabel56);
        jLabel56.setBounds(800, 370, 60, 30);

        jLabel57.setBackground(new java.awt.Color(255, 255, 255));
        jLabel57.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel57.setText("  PTS");
        jPanel6.add(jLabel57);
        jLabel57.setBounds(870, 370, 50, 30);

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel58.setText(" PTR");
        jPanel6.add(jLabel58);
        jLabel58.setBounds(940, 370, 50, 30);

        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
        jLabel59.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel59.setText("Discount");
        jPanel6.add(jLabel59);
        jLabel59.setBounds(1008, 370, 70, 30);

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel60.setText("Taxable ");
        jPanel6.add(jLabel60);
        jLabel60.setBounds(1080, 370, 70, 40);

        jLabel61.setBackground(new java.awt.Color(255, 255, 255));
        jLabel61.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel61.setText("  GST");
        jPanel6.add(jLabel61);
        jLabel61.setBounds(1150, 370, 60, 30);

        jLabel62.setBackground(new java.awt.Color(255, 255, 255));
        jLabel62.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel62.setText("Net Amount");
        jPanel6.add(jLabel62);
        jLabel62.setBounds(1200, 370, 90, 30);

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setText("To be Continue .......");
        jPanel6.add(jLabel42);
        jLabel42.setBounds(30, 970, 280, 17);

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(jSeparator3);
        jSeparator3.setBounds(-10, 990, 1380, 20);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel10.setLayout(null);

        jLabel81.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel81.setText(" GST");
        jPanel10.add(jLabel81);
        jLabel81.setBounds(11, 12, 50, 17);

        jLabel82.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel82.setText("TOTAL");
        jPanel10.add(jLabel82);
        jLabel82.setBounds(97, 12, 74, 17);

        jLabel83.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel83.setText("SGST");
        jPanel10.add(jLabel83);
        jLabel83.setBounds(178, 12, 50, 17);

        jLabel84.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel84.setText("CGST");
        jPanel10.add(jLabel84);
        jLabel84.setBounds(265, 12, 78, 17);

        jLabel85.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel85.setText("IGST");
        jPanel10.add(jLabel85);
        jLabel85.setBounds(363, 12, 66, 17);

        jLabel86.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel86.setText("TOTAL GST");
        jPanel10.add(jLabel86);
        jLabel86.setBounds(461, 12, 82, 17);

        jLabel87.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel87.setText(" 0.00");
        jLabel87.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel10.add(jLabel87);
        jLabel87.setBounds(11, 35, 68, 19);

        jLabel88.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel88.setText(" 5.00");
        jPanel10.add(jLabel88);
        jLabel88.setBounds(11, 60, 80, 17);

        jLabel89.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel89.setText(" 12.00");
        jPanel10.add(jLabel89);
        jLabel89.setBounds(11, 83, 80, 17);

        jLabel90.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel90.setText(" 18.00");
        jPanel10.add(jLabel90);
        jLabel90.setBounds(11, 106, 70, 17);

        jLabel91.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel91.setText("0.0");
        jPanel10.add(jLabel91);
        jLabel91.setBounds(97, 36, 70, 17);

        jLabel92.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel92.setText("0.0");
        jPanel10.add(jLabel92);
        jLabel92.setBounds(97, 60, 70, 17);

        jLabel93.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel93.setText("0.0");
        jPanel10.add(jLabel93);
        jLabel93.setBounds(97, 83, 70, 17);

        jLabel94.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel94.setText("0.0");
        jPanel10.add(jLabel94);
        jLabel94.setBounds(97, 106, 70, 17);

        jLabel95.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel95.setText("0.0");
        jPanel10.add(jLabel95);
        jLabel95.setBounds(178, 37, 70, 17);

        jLabel96.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel96.setText("0.0");
        jPanel10.add(jLabel96);
        jLabel96.setBounds(178, 60, 70, 17);

        jLabel97.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel97.setText("0.0");
        jPanel10.add(jLabel97);
        jLabel97.setBounds(178, 83, 70, 17);

        jLabel98.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel98.setText("0.0");
        jPanel10.add(jLabel98);
        jLabel98.setBounds(178, 106, 70, 17);

        jLabel99.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel99.setText("0.0");
        jPanel10.add(jLabel99);
        jLabel99.setBounds(265, 37, 80, 17);

        jLabel100.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel100.setText("0.0");
        jPanel10.add(jLabel100);
        jLabel100.setBounds(265, 60, 70, 17);

        jLabel101.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel101.setText("0.0");
        jPanel10.add(jLabel101);
        jLabel101.setBounds(265, 83, 80, 17);

        jLabel102.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel102.setText("0.0");
        jPanel10.add(jLabel102);
        jLabel102.setBounds(265, 106, 80, 17);

        jLabel103.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel103.setText("0.0");
        jPanel10.add(jLabel103);
        jLabel103.setBounds(367, 37, 80, 17);

        jLabel104.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel104.setText("0.0");
        jPanel10.add(jLabel104);
        jLabel104.setBounds(365, 60, 80, 17);

        jLabel105.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel105.setText("0.0");
        jPanel10.add(jLabel105);
        jLabel105.setBounds(365, 83, 80, 17);

        jLabel106.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel106.setText("0.0");
        jPanel10.add(jLabel106);
        jLabel106.setBounds(365, 106, 80, 17);

        jLabel107.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel107.setText("0.0");
        jPanel10.add(jLabel107);
        jLabel107.setBounds(460, 30, 72, 30);

        jLabel108.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel108.setText("0.0");
        jPanel10.add(jLabel108);
        jLabel108.setBounds(461, 63, 80, 17);

        jLabel109.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel109.setText("0.0");
        jPanel10.add(jLabel109);
        jLabel109.setBounds(461, 86, 70, 17);

        jLabel110.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel110.setText("0.0");
        jPanel10.add(jLabel110);
        jLabel110.setBounds(461, 109, 80, 17);

        jLabel111.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel111.setText("TOTAL");
        jPanel10.add(jLabel111);
        jLabel111.setBounds(10, 150, 61, 17);

        jLabel112.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel112.setText("0.0000");
        jPanel10.add(jLabel112);
        jLabel112.setBounds(100, 150, 70, 17);

        jLabel113.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel113.setText("0.0000");
        jPanel10.add(jLabel113);
        jLabel113.setBounds(180, 150, 70, 17);

        jLabel114.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel114.setText("0.0000");
        jPanel10.add(jLabel114);
        jLabel114.setBounds(260, 150, 80, 17);

        jLabel115.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel115.setText("0.0000");
        jPanel10.add(jLabel115);
        jLabel115.setBounds(360, 150, 80, 17);

        jLabel116.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel116.setText("0.0000");
        jPanel10.add(jLabel116);
        jLabel116.setBounds(460, 150, 91, 17);

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel10.add(jSeparator5);
        jSeparator5.setBounds(0, 140, 551, 20);

        jPanel6.add(jPanel10);
        jPanel10.setBounds(30, 790, 550, 170);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel50.setText(" Product");

        jLabel52.setBackground(new java.awt.Color(255, 255, 255));
        jLabel52.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel52.setText("MRP");

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel53.setText("  QTY");

        jLabel54.setBackground(new java.awt.Color(255, 255, 255));
        jLabel54.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel54.setText("Scheme");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(562, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel11);
        jPanel11.setBounds(30, 360, 1260, 50);

        jLabel46.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Invoice");
        jPanel6.add(jLabel46);
        jLabel46.setBounds(10, -6, 1260, 40);

        jScrollPane2.setViewportView(jPanel6);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 0, 1330, 1050);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");
        job.setPrintable((Graphics pg, PageFormat pf, int pageNum) -> {
            if (pageNum > 0) {
                return Printable.NO_SUCH_PAGE;
            }
            Graphics2D g2 = (Graphics2D) pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            g2.scale(0.60, 0.60);
            jPanel6.paint(g2);
            return Printable.PAGE_EXISTS;
        });
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Printbills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Printbills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Printbills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Printbills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Printbills().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
