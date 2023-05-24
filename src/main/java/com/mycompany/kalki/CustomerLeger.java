/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kalki;

import com.mycompany.kalki.DBCalls.MongoDBCalls;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author imash
 */
public class CustomerLeger extends javax.swing.JFrame {

    /**
     * Creates new form CustomerLeger
     */
    public CustomerLeger() {
        initComponents();
        jLabel4.setVisible(false);
        this.setResizable(false);
        this.setSize(970, 800);
        try {
            CustomersName = dbCalls.GetAllCustomer();
            for (int i = 0; i < CustomersName.size(); i++) {
                jComboBox1.addItem(CustomersName.get(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerLeger.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    MongoDBCalls dbCalls = new MongoDBCalls();
    ArrayList<String> CustomersName = new ArrayList<>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kalki Biotech || Ledger");
        setBackground(new java.awt.Color(5, 15, 25));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(5, 15, 25));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("End : ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(540, 70, 42, 32);

        jButton1.setBackground(new java.awt.Color(255, 152, 63));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(590, 120, 220, 40);

        jDateChooser1.setBackground(new java.awt.Color(5, 15, 25));
        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(240, 70, 210, 32);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Start : ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(180, 70, 50, 28);

        jDateChooser2.setBackground(new java.awt.Color(5, 15, 25));
        jDateChooser2.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(jDateChooser2);
        jDateChooser2.setBounds(590, 70, 213, 32);

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(240, 120, 210, 38);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Customer : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 120, 80, 38);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "InvoiceNo", "CustomerName", "CustomerDetails", "TaxableAmount", "GST", "NetTotal", "NetProfit", "AmountPaid", "remark"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(38, 182, 880, 320);

        jButton2.setBackground(new java.awt.Color(255, 152, 63));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(50, 650, 872, 39);

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Total Taxable Amount: ");
        jPanel1.add(jLabel42);
        jLabel42.setBounds(630, 520, 157, 17);

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Total GST:");
        jPanel1.add(jLabel43);
        jLabel43.setBounds(630, 560, 153, 17);

        jLabel44.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Grand Total: ");
        jPanel1.add(jLabel44);
        jLabel44.setBounds(630, 600, 153, 17);

        jLabel45.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("0.0");
        jPanel1.add(jLabel45);
        jLabel45.setBounds(800, 520, 120, 17);

        jLabel47.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("0.0");
        jPanel1.add(jLabel47);
        jLabel47.setBounds(800, 560, 120, 17);

        jLabel48.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("0.0");
        jPanel1.add(jLabel48);
        jLabel48.setBounds(800, 600, 100, 17);

        jLabel49.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Amount Paid:");
        jPanel1.add(jLabel49);
        jLabel49.setBounds(230, 560, 135, 17);

        jLabel50.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Amount Left");
        jPanel1.add(jLabel50);
        jLabel50.setBounds(230, 600, 117, 17);

        jLabel51.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel51);
        jLabel51.setBounds(380, 600, 130, 17);

        jLabel52.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel52);
        jLabel52.setBounds(380, 560, 180, 17);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(230, 550, 684, 10);

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(230, 590, 685, 2);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/3WyW.gif"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(220, 0, 500, 730);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Ledger");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 10, 940, 29);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 970, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents
ArrayList<Object[]> Filteredbills = new ArrayList<>();
    Date start;
    Date End;
    long C_id;
    Double TotalTaxable = 0.0;
    Double TotalGST = 0.0;
    Double GrandTotal = 0.0;
    Double Amount_Paid = 0.0;
    Double Amount_Left = 0.0;

    private void setall(boolean b) {
        jLabel1.setVisible(b);
        jLabel2.setVisible(b);
        jLabel3.setVisible(b);
        jLabel42.setVisible(b);
        jLabel43.setVisible(b);
        jLabel44.setVisible(b);
        jLabel45.setVisible(b);
        jLabel47.setVisible(b);
        jLabel48.setVisible(b);
        jLabel49.setVisible(b);
        jLabel50.setVisible(b);
        jLabel51.setVisible(b);
        jLabel52.setVisible(b);

        jDateChooser1.setVisible(b);
        jDateChooser2.setVisible(b);
        jComboBox1.setVisible(b);
        jButton1.setVisible(b);
        jTable1.setVisible(b);
        jScrollPane1.setVisible(b);
        jButton2.setVisible(b);
        jSeparator3.setVisible(b);
        jSeparator4.setVisible(b);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                setall(false);
                jLabel4.setVisible(true);
            }

        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
                    ArrayList<Object[]> bills = new ArrayList<>();
                    System.out.println(jDateChooser1.getDate());
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

                    if (jDateChooser1.getDate() == null) {

                        java.util.Date date = sdf1.parse("2023-01-01".toString());
                        start = new java.sql.Date(date.getTime());
                    } else {
                        start = new java.sql.Date(jDateChooser1.getDate().getTime());
                    }
                    if ((jDateChooser2.getDate() == null)) {
//                java.util.Date date = sdf1.parse("2300-01-01".toString());
                        End = new java.sql.Date(new java.util.Date().getTime());
                    } else {
                        End = new java.sql.Date(jDateChooser2.getDate().getTime());
                    }

                    System.out.println(End + "   " + start);
                    C_id = Long.valueOf(jComboBox1.getSelectedItem().toString().split("=>")[1]);
                    bills = dbCalls.GetAllBills(C_id);

                    for (int i = 0; i < bills.size(); i++) {

                        java.util.Date date = sdf1.parse(bills.get(i)[0].toString());
                        java.sql.Date d = new java.sql.Date(date.getTime());

                        if ((d.after(start) || d.equals(start)) && (d.before(End) || d.equals(End))) {
                            System.out.println(d);
                            Filteredbills.add(bills.get(i));
                            model.addRow(bills.get(i));
                            System.out.println(bills.get(i)[1]);
                            TotalTaxable = TotalTaxable + Double.parseDouble(bills.get(i)[4].toString());
                            TotalGST = TotalGST + Double.parseDouble(bills.get(i)[5].toString());
                            GrandTotal = GrandTotal + Double.parseDouble(bills.get(i)[6].toString());
                            Amount_Paid = Amount_Paid + Double.parseDouble(bills.get(i)[8].toString());
                        }
                    }
                    if (model.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "No bills Found ....");
                    }
                    jLabel45.setText(TotalTaxable.toString());
                    jLabel47.setText(TotalGST.toString());
                    jLabel48.setText(GrandTotal.toString());
                    jLabel52.setText(Amount_Paid.toString());
                    Amount_Left = GrandTotal - Amount_Paid;
                    jLabel51.setText(Amount_Left.toString());

                } catch (Exception ex) {
                    Logger.getLogger(CustomerLeger.class.getName()).log(Level.SEVERE, null, ex);
                }

                setall(true);
                jLabel4.setVisible(false);

            }

        });
        t.start();
        t1.start();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                setall(false);
                jLabel4.setVisible(true);
            }

        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                pCustomerLeger print;
                try {
                    print = new pCustomerLeger(Filteredbills, start, End, C_id, TotalTaxable, TotalGST, GrandTotal, Amount_Paid, Amount_Left);
                    print.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(CustomerLeger.class.getName()).log(Level.SEVERE, null, ex);
                }
                setall(true);
                jLabel4.setVisible(false);
                dispose();

                new JFrame().setVisible(false);
            }

        });
        t.start();
        t1.start();

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerLeger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerLeger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerLeger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerLeger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerLeger().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
