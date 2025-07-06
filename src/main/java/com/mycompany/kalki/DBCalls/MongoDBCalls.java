/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kalki.DBCalls;

import com.mycompany.kalki.Models.BilledMeds;

import java.util.ArrayList;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.util.List;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mycompany.kalki.Models.Customer;
import com.mycompany.kalki.GSTR1Model;
import com.mycompany.kalki.IAM;
import com.mycompany.kalki.Med;

import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.Arrays;
import java.util.Date;
import org.bson.types.ObjectId;

public class MongoDBCalls {

    private String db_name = "";
    private static final MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
    private static MongoDatabase db;
    private static final MongoDatabase Zyrodb = client.getDatabase("Zyro_Admin");
    private static String CustomrName = "";
    private static String Address1 = "";
    private static String Address2 = "";
    private static String Email = "";
    private static String AccountNo = "";
    private static String DL1 = "";
    private static String DL2 = "";
    private static String FoodLicienceNo = "";
    private static String GSTNo = "";
    private static String IFSCCode = "";
    private static String PhoneNo = "";
    private static String UPIId = "";

    public static IAM iam = new IAM();

    public boolean Login(String Password) {

        MongoCollection col = Zyrodb.getCollection("Users");
        Bson filter = Filters.eq("Pass", Password);

        // Execute the find query with the filter
        FindIterable<Document> cursor = col.find(filter);
        String Pass = "";
        String db_name = "";
        for (Document doc : cursor) {

            Pass = doc.getString("Pass");
            db_name = doc.getString("DB");
            iam.setCustomrName(doc.getString("Name"));
            iam.setAddress1(doc.getString("Address1"));
            iam.setAddress2(doc.getString("Address2"));
            iam.setEmail(doc.getString("Email"));
            iam.setAccountNo(doc.getString("AccountNo"));
            iam.setDL1(doc.getString("DL1"));
            iam.setDL2(doc.getString("DL2"));
            iam.setFoodLicienceNo(doc.getString("FoodLicienceNo"));
            iam.setGSTNo(doc.getString("GSTNo"));
            iam.setIFSCCode(doc.getString("IFSCCode"));
            iam.setPhoneNo(doc.getString("PhoneNo"));
            iam.setUPIId(doc.getString("UPIId"));
            iam.setWebsite(doc.getString("Website"));
            iam.setEntitlements(doc.getList("Entitlement", String.class));
            System.out.println(doc.getList("Entitlement", String.class)); 
        }
        

        if (!"".equals(db_name)) {
            db = client.getDatabase(db_name);
        }
        boolean b = false;
        if (Pass.equals(Password)) {
            b = true;
        }
        return b;
    }

    public static IAM getIAM() {
        return iam;
    }

    public static String getInvoiceDialog() {
        String[] names = iam.getCustomrName().split(" ");
        System.out.print(CustomrName + " ---- " + names[0].charAt(0) + names[1].charAt(0));
        return names[0].charAt(0) + "" + names[1].charAt(0);
    }

    public int[] insertBilledMeds(ArrayList<BilledMeds> billedMeds, String invoiceno, Long date) throws Exception {
        MongoCollection col = db.getCollection("Sold_Medicines");
        List<InsertOneModel<Document>> bulkWrites = new ArrayList<>(); // Use InsertOneModel for inserts
        for (int i = 0; i < billedMeds.size(); i++) {
            BilledMeds medicine = billedMeds.get(i);
            Document document = new Document("Invoice", invoiceno)
                    .append("Med", medicine.getProduct())
                    .append("MRP", medicine.getMRP())
                    .append("HSN", medicine.getHSNCode())
                    .append("Batch", medicine.getBatch())
                    .append("Pack", medicine.getPack())
                    .append("QTY", medicine.getQTY())
                    .append("Scheme", medicine.getScheme())
                    .append("PTR", medicine.getPTR())
                    .append("NetQTY", medicine.getNetQTY())
                    .append("Expire", medicine.getExpire())
                    .append("PTS", medicine.getPTS())
                    .append("Discount", medicine.getDiscount())
                    .append("TaxableAmount", medicine.getTaxableAmount())
                    .append("GSTpercentage", medicine.getGSTPercentage())
                    .append("GST", medicine.getGST())
                    .append("NetTotal", medicine.getNetTotal())
                    .append("Date", date)
                    .append("Profit", medicine.getProfit());

            bulkWrites.add(new InsertOneModel<>(document));
        }

        BulkWriteResult result = col.bulkWrite(bulkWrites); // Execute the bulk write operation
        return new int[]{result.getInsertedCount()};
    }

    public int[] insertRBilledMeds(ArrayList<BilledMeds> billedMeds, String invoiceno, Long date) throws Exception {
        MongoCollection col = db.getCollection("Sold_Medicines");
        List<InsertOneModel<Document>> bulkWrites = new ArrayList<>(); // Use InsertOneModel for inserts
        for (int i = 0; i < billedMeds.size(); i++) {
            BilledMeds medicine = billedMeds.get(i);
            Document document = new Document("Invoice", invoiceno)
                    .append("Med", medicine.getProduct())
                    .append("MRP", medicine.getMRP())
                    .append("HSN", medicine.getHSNCode())
                    .append("Batch", medicine.getBatch())
                    .append("Pack", medicine.getPack())
                    .append("QTY", medicine.getQTY())
                    .append("Scheme", medicine.getScheme())
                    .append("PTR", medicine.getPTR())
                    .append("NetQTY", medicine.getRQty())
                    .append("Expire", medicine.getExpire())
                    .append("PTS", medicine.getPTS())
                    .append("Discount", medicine.getDiscount())
                    .append("TaxableAmount", -medicine.getTaxableAmount())
                    .append("GSTpercentage", medicine.getGSTPercentage())
                    .append("GST", -medicine.getNewGSTAmount())
                    .append("NetTotal", -(medicine.getNewGSTAmount() + medicine.getTaxableAmount()))
                    .append("Date", date)
                    .append("Profit", -medicine.getProfitDecline());

            bulkWrites.add(new InsertOneModel<>(document));
        }

        BulkWriteResult result = col.bulkWrite(bulkWrites); // Execute the bulk write operation
        return new int[]{result.getInsertedCount()};
    }
    
        public Long getMedicineCounter() {
        MongoCollection col = db.getCollection("counters");
        Bson filter = Filters.exists("Customer");
        MongoCursor<Document> cursor = col.find(filter).iterator();
        Long medicineid = 0l;
        while (cursor.hasNext()) {

            Document document = cursor.next();
            medicineid = document.getLong("Customer");
        }
        return medicineid;
    }

    public void updateMedicineCounter(Long inv) {
        MongoCollection col = db.getCollection("counters");
        Bson filter = Filters.eq("Medicine", inv);
        Bson update = Updates.inc("Medicine", +1);
        UpdateResult result = col.updateOne(filter, update);

        if (result.getModifiedCount() > 0) {
            System.out.println("updateMedicineCounter: Update successful");
        } else {
            System.out.println("updateMedicineCounter: No documents were updated");
        }
    }
    
    public boolean insertItem(Med med, String Company, String AgainstInvoice, Long BillDate) {
        Long id= getMedicineCounter();
        try {
            MongoCollection col = db.getCollection("Medicins");
            // Create a document to insert
            Document doc = new Document("HSNCode", med.getHSNCode())
                    .append("MedicineId", id)
                    .append("Product", med.getProduct())
                    .append("Pack", med.getPack())
                    .append("Batch", med.getBatch())
                    .append("Expire", med.getExpire())
                    .append("GST", med.getGST())
                    .append("QTY", med.getQTY())
                    .append("Scheme", med.getScheme())
                    .append("PTS", med.getPTS())
                    .append("PTR", med.getPTR())
                    .append("Rate", med.getRate())
                    .append("MRP", med.getMRP())
                    .append("Company", Company)
                    .append("AgainstInvoice", AgainstInvoice)
                    .append("BillDate", BillDate);

            // Insert the document into the collection
            col.insertOne(doc);
            updateMedicineCounter(id);
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public ArrayList<Med> getAllMeds() throws Exception {
        ArrayList<Med> meds = new ArrayList<>();
        MongoCollection col = db.getCollection("Medicins");
        // Create a filter to query documents where QTY > 0
        Bson filter = Filters.gt("QTY", 0);

        // Execute the find query with the filter
        FindIterable<Document> cursor = col.find(filter);

        // Iterate through the result cursor and map the document fields to Med object
        for (Document doc : cursor) {
            Long ID = doc.getLong("MedicineId");
            String HSNCode = doc.getString("HSNCode");
            String Product = doc.getString("Product");
            String Pack = doc.getString("Pack");
            String Batch = doc.getString("Batch");
            String Expire = doc.getString("Expire");
            int GST = doc.getInteger("GST");
            int QTY = doc.getInteger("QTY");
            String Scheme = doc.getString("Scheme");
            Double PTS = doc.getDouble("PTS");
            Double PTR = doc.getDouble("PTR");
            Double Rate = doc.getDouble("Rate");
            Double MRP = doc.getDouble("MRP");
            Med medicine = new Med(ID, HSNCode, Product, Pack, Batch, Expire, GST, QTY, Scheme, PTS, PTR, Rate, MRP);
            meds.add(medicine);
        }

        return meds;
    }
    
    public Long getCustomerCounter() {
        MongoCollection col = db.getCollection("counters");
        Bson filter = Filters.exists("Customer");
        MongoCursor<Document> cursor = col.find(filter).iterator();
        Long Customerid = 0l;
        while (cursor.hasNext()) {

            Document document = cursor.next();
            Customerid = document.getLong("Customer");
        }
        System.out.println("Customerid.getClass()=>"+Customerid.getClass());
        return Customerid;
    }

    public void updateCustomerCounter(Long inv) {
        MongoCollection col = db.getCollection("counters");
        Bson filter = Filters.eq("Customer", inv);
        Bson update = Updates.inc("Customer", +1);
        UpdateResult result = col.updateOne(filter, update);

        if (result.getModifiedCount() > 0) {
            System.out.println("updateCustomerCounter: Update successful");
        } else {
            System.out.println("updateCustomerCounter: No documents were updated");
        }
    }
    public boolean AddCustomer(Customer customer) {
        try {
            MongoCollection col = db.getCollection("Customer");
            Long cid=getCustomerCounter();
            Document customerDocument = new Document(
                    "Firm_Name", customer.getFirm_Name())
                    .append("CustomerId", cid)
                    .append("Address", customer.getAddress())
                    .append("Mobile", customer.getMobile())
                    .append("tel", customer.getTel())
                    .append("email", customer.getEmail())
                    .append("GSTno", customer.getGSTno())
                    .append("PAN", customer.getPAN())
                    .append("DL1", customer.getDL1())
                    .append("DL2", customer.getDL2())
                    .append("State", customer.getState());

            InsertOneResult result =col.insertOne(customerDocument);
            updateCustomerCounter(cid);
            return true;
        } catch (Exception e) {
            System.out.println("com.mycompany.kalki.DBCalls.MongoDBCalls.AddCustomer()"+e);
            return false;
        }

    }

    public long Customer(Customer c) {
        MongoCollection col = db.getCollection("Customer");

        Bson filter = Filters.and(
                Filters.eq("Firm_Name", c.getFirm_Name()),
                Filters.eq("GSTno", c.getGSTno()),
                Filters.eq("PAN", c.getPAN()),
                Filters.eq("DL1", c.getDL1()),
                Filters.eq("DL2", c.getDL2())
        );

        // Execute the find query with the filter
        FindIterable<Document> cursor = col.find(filter);
        Long Id = 0l;
        // Iterate through the result cursor and map the document fields to Med object
        for (Document doc : cursor) {
            Id = doc.getLong("CustomerId");

        }

        return Id;
    }

    public ArrayList<Customer> getAllCustomers() throws Exception {
        MongoCollection col = db.getCollection("Customer");
        ArrayList<Customer> customers = new ArrayList<>();
        FindIterable<Document> cursor = col.find();
        for (Document doc : cursor) {
            Long id = doc.getLong("CustomerId");
            String firmName = doc.getString("Firm_Name");
            String address = doc.getString("Address");
            String mobile = doc.getString("Mobile");
            String tel = doc.getString("tel");
            String email = doc.getString("email");
            String gstno = doc.getString("GSTno");
            String pan = doc.getString("PAN");
            String dl1 = doc.getString("DL1");
            String dl2 = doc.getString("DL2");
            String state = doc.getString("State");
            Customer c = new Customer(id, firmName, address, mobile, tel, email, gstno, pan, dl1, dl2, state);
            customers.add(c);
        }
        return customers;
    }

    public Customer getlCustomer(Long id) throws Exception {
        MongoCollection col = db.getCollection("Customer");

        // Create a filter to query documents where QTY > 0
        Bson filter = Filters.eq("CustomerId", id);

        // Execute the find query with the filter
        FindIterable<Document> cursor = col.find(filter);
        Customer c = null;
        // Iterate through the result cursor and map the document fields to Med object
        for (Document doc : cursor) {
            String firmName = doc.getString("Firm_Name");
            String address = doc.getString("Address");
            String mobile = doc.getString("Mobile");
            String tel = doc.getString("tel");
            String email = doc.getString("email");
            String gstno = doc.getString("GSTno");
            String pan = doc.getString("PAN");
            String dl1 = doc.getString("DL1");
            String dl2 = doc.getString("DL2");
            String state = doc.getString("State");
            c = new Customer(id, firmName, address, mobile, tel, email, gstno, pan, dl1, dl2, state);
        }

        return c;
    }

    public boolean AddBill(String invoiceno, String CustomerName, Long CustomerID, String Destination, Long ShipingID, String GSTIN, Double TotalTaxable, Double GST, Double NetTotal, Double NetProfit, Long date, Double AmountPaid, String Remark, String Transport) {

        try {
            MongoCollection col = db.getCollection("Bills");
            // Create a new document to be inserted
            Document document = new Document();
            document.append("InvoiceNo", invoiceno)
                    .append("CustomerName", CustomerName)
                    .append("CustomerDetails", CustomerID)
                    .append("GSTIN", GSTIN)
                    .append("Destination", Destination)
                    .append("ShipingDetails", ShipingID)
                    .append("TaxableAmount", TotalTaxable)
                    .append("GST", GST)
                    .append("NetTotal", NetTotal)
                    .append("NetProfit", NetProfit)
                    .append("Date", date)
                    .append("AmountPaid", AmountPaid)
                    .append("remark", Remark)
                    .append("Transport", Transport);

            // Insert the document into the collection
            col.insertOne(document);

            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

    }
    
    public boolean UpdateCashPayment(String inv, double paymentAmount){
     MongoCollection col = db.getCollection("Bills");
        Bson filter = Filters.eq("InvoiceNo", inv);
        Bson update = Updates.inc("AmountPaid", +paymentAmount); // Decrement QTY by the specified value
        UpdateResult result = col.updateOne(filter, update);

        if (result.getModifiedCount() > 0) {
            System.out.println("Update successful");
            return true;
        } else {
            System.out.println("No documents were updated");
        }
        return false;
    }
    
    public boolean AddRBill(String invoiceno, String CustomerName, Long CustomerID, String Destination, Long ShipingID, String GSTIN, Double TotalTaxable, Double GST, Double NetTotal, Double NetProfit, Long date, Double AmountPaid, String Remark, String Transport, String Original_Invoice) {

        try {
            MongoCollection col = db.getCollection("Bills");
            // Create a new document to be inserted
            Document document = new Document();
            document.append("InvoiceNo", invoiceno)
                    .append("CustomerName", CustomerName)
                    .append("CustomerDetails", CustomerID)
                    .append("GSTIN", GSTIN)
                    .append("Destination", Destination)
                    .append("ShipingDetails", ShipingID)
                    .append("TaxableAmount", TotalTaxable)
                    .append("GST", GST)
                    .append("NetTotal", NetTotal)
                    .append("NetProfit", NetProfit)
                    .append("Date", date)
                    .append("AmountPaid", AmountPaid)
                    .append("remark", Remark)
                    .append("Transport", Transport)
                    .append("Original_Invoice", Original_Invoice);
            // Insert the document into the collection
            col.insertOne(document);

            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

    }

    public void updateitemlist(int QTY, Long id) throws Exception {
        MongoCollection col = db.getCollection("Medicins");
        Bson filter = Filters.eq("MedicineId", id);
        Bson update = Updates.inc("QTY", -QTY); // Decrement QTY by the specified value
        UpdateResult result = col.updateOne(filter, update);

        if (result.getModifiedCount() > 0) {
            System.out.println("Update successful");
        } else {
            System.out.println("No documents were updated");
        }
    }
    public void updateitemlist(String Product,int QTY, String Batch, String Expire,Double MRP ) throws Exception {
        MongoCollection col = db.getCollection("Medicins");
        Bson filter = Filters.and(
                Filters.eq("Product", Product),
                Filters.eq("Batch", Batch),
                Filters.eq("Expire", Expire),
                Filters.eq("MRP", MRP));
        Bson update = Updates.inc("QTY", -QTY); // Decrement QTY by the specified value
        UpdateResult result = col.updateOne(filter, update);

        if (result.getModifiedCount() > 0) {
            System.out.println("Update successful");
        } else {
            System.out.println("No documents were updated");
        }
    }

    public void updateitemlistforReturnBill(int QTY, String Batch, String Product, String Expire, String Scheme) throws Exception {
        MongoCollection col = db.getCollection("Medicins");
 
        Bson filter = Filters.and(
                Filters.eq("Product", Product),
                Filters.eq("Batch", Batch),
                Filters.eq("Expire", Expire)
        );
        Bson update = Updates.inc("QTY", +QTY); // Decrement QTY by the specified value
        UpdateResult result = col.updateOne(filter, update);

        if (result.getModifiedCount() > 0) {
            System.out.println("Update successful");
        } else {
            System.out.println("No documents were updated");
        }
    }

    public ArrayList<String> GetAllMedsName() throws Exception {
        MongoCollection col = db.getCollection("Medicins");
        ArrayList<String> MedsName = new ArrayList<>();
        MongoCursor<Document> cursor = col.find().iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            String product = document.getString("Product");
            MedsName.add(product);
        }
        cursor.close();

        return MedsName;

    }

    public ArrayList<String> GetAllCustomer() throws Exception {
        MongoCollection col = db.getCollection("Customer");
        ArrayList<String> CustomersName = new ArrayList<>();
        try (MongoCursor<Document> cursor = col.find().iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                String customer = document.getString("Firm_Name");
                Long CustomerID = document.getLong("CustomerId");
                CustomersName.add(customer + "=>" + CustomerID);
            }
        }

        return CustomersName;

    }

    public ArrayList<Object[]> GetAllBills(Long id) throws Exception {
        MongoCollection col = db.getCollection("Bills");
        Bson filter = Filters.eq("CustomerDetails", id);

        // Execute the find query with the filter
        ArrayList<Object[]> Bills = new ArrayList<>();
        try (MongoCursor<Document> cursor = col.find(filter).iterator()) {
            while (cursor.hasNext()) {

                Document document = cursor.next();
                String InvoiceNo = document.getString("InvoiceNo");
                String CustomerName = document.getString("CustomerName");
                Long CustomerDetails = document.getLong("CustomerDetails");
                Double TaxableAmount = Math.round(document.getDouble("TaxableAmount") * 100) / 100.0;
                Double GST = Math.round(document.getDouble("GST") * 100) / 100.0;
                Double NetTotal = Math.round(document.getDouble("NetTotal") * 100) / 100.0;
                Double NetProfit = Math.round(document.getDouble("NetProfit") * 100) / 100.0;
                Long Date = document.getLong("Date");
                Double AmountPaid = Math.round(document.getDouble("AmountPaid") * 100) / 100.0;
                String remark = document.getString("remark");

                Object oneBill[] = {Date, InvoiceNo, CustomerName, CustomerDetails, TaxableAmount, GST, NetTotal, NetProfit, AmountPaid, remark};
                Bills.add(oneBill);
            }
        }

        return Bills;

    }
    
    public Boolean CashEntry(String Inv, Double Amount){
    try {
            MongoCollection col = db.getCollection("CashEntry");
            // Create a new document to be inserted
            Document document = new Document();
            document.append("InvoiceNo", Inv)
                    
                    .append("Date", new Date().getTime() )
                    .append("PaymentAmount", Amount);

            // Insert the document into the collection
            col.insertOne(document);

            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public ArrayList<Double> GetSalesDetails(long start, long End) throws Exception {
        ArrayList<Double> SalesDetails = new ArrayList<>();
        MongoCollection col = db.getCollection("Bills");
        // Construct filter for Date range
        Bson filter = Filters.and(
                Filters.gte("Date", start),
                Filters.lte("Date", End)
        );

        // Construct aggregation pipeline
        List<Bson> pipeline = Arrays.asList(
                Aggregates.match(filter),
                Aggregates.group(null, Accumulators.sum("TaxableAmount", "$TaxableAmount"),
                        Accumulators.sum("NetAmount", "$NetTotal"), Accumulators.sum("GSTAmount", "$GST"),
                        Accumulators.sum("NetProfit", "$NetProfit"), Accumulators.sum("AmountPaid", "$AmountPaid"))
        );

        // Execute aggregation pipeline
        AggregateIterable<Document> result = col.aggregate(pipeline);
        Document doc = result.first();

        // Extract and add values to SalesDetails ArrayList
        if (doc != null) {
            SalesDetails.add(doc.getDouble("NetAmount"));
            SalesDetails.add(doc.getDouble("TaxableAmount"));
            SalesDetails.add(doc.getDouble("GSTAmount"));
            SalesDetails.add(doc.getDouble("AmountPaid"));
            SalesDetails.add(doc.getDouble("NetProfit"));
        }

        return SalesDetails;
    }

    public ArrayList<Object> getbillDetails(String InvoiceNo) {
        MongoCollection col = db.getCollection("Bills");
        Bson filter = Filters.eq("InvoiceNo", InvoiceNo);
        ArrayList<Object> Customers = new ArrayList<>();
        try (MongoCursor<Document> cursor = col.find(filter).iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                String customer = document.getString("CustomerName");
                Long BillingCustomerID = document.getLong("CustomerDetails");
                Long ShippingCustomerID = document.getLong("ShipingDetails");
                Double TaxableAmount = document.getDouble("TaxableAmount");
                Double GST = document.getDouble("GST");
                Double NetTotal = document.getDouble("NetTotal");
                Double AmountPaid = document.getDouble("AmountPaid");
                String Remark = document.getString("remark");
                Long Date = document.getLong("Date");
                String Transport = document.getString("Transport");
                String Destination = document.getString("Destination");
                String GSTIN = document.getString("GSTIN");
                Customers.add(customer);
                Customers.add(BillingCustomerID);
                Customers.add(ShippingCustomerID);
                Customers.add(TaxableAmount);
                Customers.add(GST);
                Customers.add(NetTotal);
                Customers.add(AmountPaid);
                Customers.add(Remark);
                Customers.add(Date);
                Customers.add(Transport);
                Customers.add(Destination);
                Customers.add(GSTIN);

            }
        }
        return Customers;
    }
    
    public ArrayList<Object> getbillDetail(String InvoiceNo) {
        MongoCollection col = db.getCollection("Bills");
        Bson filter = Filters.eq("InvoiceNo", InvoiceNo);
        ArrayList<Object> BillDetail = new ArrayList<>();
        try (MongoCursor<Document> cursor = col.find(filter).iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                String customer = document.getString("CustomerName");
                Double NetTotal = document.getDouble("NetTotal");
                Double AmountPaid = document.getDouble("AmountPaid");
                String Remark = document.getString("remark");
                Long Date = document.getLong("Date");
                BillDetail.add(customer);
                BillDetail.add(NetTotal);
                BillDetail.add(AmountPaid);
                BillDetail.add(Remark);
                BillDetail.add(Date);
            }
        }
        return BillDetail;
    }
    
    public ArrayList<BilledMeds> getBilledMeds(String InvoiceNo) {
        MongoCollection col = db.getCollection("Sold_Medicines");
        Bson filter = Filters.eq("Invoice", InvoiceNo);

        // Execute the find query with the filter
//        FindIterable<Document> cursor = col.find(filter);
        ArrayList<BilledMeds> Meds = new ArrayList<>();
        try (MongoCursor<Document> cursor = col.find(filter).iterator()) {
            while (cursor.hasNext()) {

                Document document = cursor.next();

                String product = document.getString("Med");
                Double MRP = document.getDouble("MRP");
                String HSN = document.getString("HSN");
                String Batch = document.getString("Batch");
                String Pack = document.getString("Pack");
                int QTY = document.getInteger("QTY");
                String Scheme = document.getString("Scheme");
                Double PTR = document.getDouble("PTR");
                int NetQTY = document.getInteger("NetQTY");
                String Expire = document.getString("Expire");
                Double PTS = document.getDouble("PTS");
                Double Discount = document.getDouble("Discount");
                Double TaxableAmount = document.getDouble("TaxableAmount");
                Double GSTpercentage = document.getDouble("GSTpercentage");
                Double GST = document.getDouble("GST");
                Double NetTotal = document.getDouble("NetTotal");
                Double Profit = document.getDouble("Profit");
                BilledMeds med = new BilledMeds(0l, HSN, Batch, product, Pack, MRP, QTY, Scheme, NetQTY, Expire, PTS, PTR, Discount, TaxableAmount, GSTpercentage, GST, NetTotal, Profit);
                Meds.add(med);
            }
        }

        return Meds;

    }

    public Integer getInvoiceCounter() {
        MongoCollection col = db.getCollection("counters");
        Bson filter = Filters.exists("invoice");
        MongoCursor<Document> cursor = col.find(filter).iterator();
        Integer InvoiceNo = 0;
        while (cursor.hasNext()) {

            Document document = cursor.next();
            InvoiceNo = document.getInteger("invoice");
        }
        return InvoiceNo;
    }

    public void updateInvoiceCounter(Integer inv) {
        MongoCollection col = db.getCollection("counters");
        Bson filter = Filters.eq("invoice", inv);
        Bson update = Updates.inc("invoice", +1);
        UpdateResult result = col.updateOne(filter, update);

        if (result.getModifiedCount() > 0) {
            System.out.println("Update successful");
        } else {
            System.out.println("No documents were updated");
        }
    }

    public boolean insertSeller(String Name, String Address, String Phone_No, String Branch, String State) {
        try {
            MongoCollection col = db.getCollection("Seller");
            // Create a document to insert
            Document doc = new Document("Seller_Name", Name)
                    .append("Address", Address)
                    .append("Phone_No", Phone_No)
                    .append("Branch", Branch)
                    .append("State", State);
            col.insertOne(doc);
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public ArrayList<String> getAllSellers() {
        MongoCollection col = db.getCollection("Seller");
        ArrayList<String> SellerName = new ArrayList<>();
        try (MongoCursor<Document> cursor = col.find().iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                String Seller_Name = document.getString("Seller_Name");
                String Branch = document.getString("Branch");
                SellerName.add(Seller_Name + " => " + Branch);
            }
        }

        return SellerName;
    }

    public boolean insertPurcheseItem(Med med, String Seller, String InvoiceNo, String date, String GST, String IGST, String Total) {
        try {
            MongoCollection col = db.getCollection("purchases");

            // Create a document to insert
            Document doc = new Document("HSNCode", med.getHSNCode())
                    .append("Product", med.getProduct())
                    .append("Pack", med.getPack())
                    .append("Batch", med.getBatch())
                    .append("Expire", med.getExpire())
                    .append("GST", med.getGST())
                    .append("QTY", med.getQTY())
                    .append("Scheme", med.getScheme())
                    .append("PTS", med.getPTS())
                    .append("PTR", med.getPTR())
                    .append("Rate", med.getRate())
                    .append("MRP", med.getMRP())
                    .append("Seller", Seller)
                    .append("InvoiceNo", InvoiceNo)
                    .append("date", date)
                    .append("GST", GST)
                    .append("IGST", IGST)
                    .append("Total", Total);

            // Insert the document into the collection
            col.insertOne(doc);

            // Close the MongoDB connection
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public ArrayList<GSTR1Model> SoldMedicinesDataforGST(Long start, Long end) {
        MongoCollection col = db.getCollection("Sold_Medicines");
        Bson filter = Filters.and(
                Filters.gte("Date", start),
                Filters.lte("Date", end)
        );

        // Execute the find query with the filter
//        FindIterable<Document> cursor = col.find(filter);
        ArrayList<GSTR1Model> soldmed = new ArrayList<>();
        MongoCursor<Document> cursor = col.find(filter).iterator();
        while (cursor.hasNext()) {

            Document document = cursor.next();
            String InvoiceNo = document.getString("Invoice");
            String HSN = document.getString("HSN");

            int NetQTY = document.getInteger("NetQTY");

            Double TaxableAmount = document.getDouble("TaxableAmount");
            Double GSTpercentage = document.getDouble("GSTpercentage");
            Double GST = document.getDouble("GST");
            Double NetTotal = document.getDouble("NetTotal");
            Long date = document.getLong("Date");
            String TransactionType = "Return";
            if (TaxableAmount > 0) {
                TransactionType = "Sales";
            }
            GSTR1Model one = new GSTR1Model(InvoiceNo, date, "", "", "", TransactionType, HSN, NetQTY, TaxableAmount, GSTpercentage, GST, NetTotal, "");
            soldmed.add(one);
        }
        cursor.close();

        return soldmed;
    }

    public ArrayList<GSTR1Model> BillsDataforGST(Long start, Long end) {
        MongoCollection col = db.getCollection("Bills");
        Bson filter = Filters.and(
                Filters.gte("Date", start),
                Filters.lte("Date", end)
        );

        ArrayList<GSTR1Model> soldmed = new ArrayList<>();
        MongoCursor<Document> cursor = col.find(filter).iterator();
        while (cursor.hasNext()) {

            Document document = cursor.next();
            String InvoiceNo = document.getString("InvoiceNo");
            String CustomerName = document.getString("CustomerName");
            String Destination = document.getString("Destination");
            String GSTIN = document.getString("GSTIN");
            String Nature = "B2B";
            if (GSTIN == null || GSTIN.length() == 0) {
                Nature = "B2C";
            }

            GSTR1Model one = new GSTR1Model(InvoiceNo, 0l, CustomerName, GSTIN, Nature, "", "", 0, 0.0, 0.0, 0.0, 0.0, Destination);
            soldmed.add(one);
        }
        cursor.close();

        return soldmed;
    }

    public boolean deleteFromBillTable(String Invoice) {
        // Delete document by _id
        MongoCollection col = db.getCollection("Bills");
        Document filter = new Document("InvoiceNo", Invoice);
        DeleteResult result = col.deleteOne(filter);
        if (result.getDeletedCount() > 0) {
            return true;
        }
        return false;

    }

    public boolean deleteFromSoldMedicineTable(String Invoice) {
        // Delete document by _id
        MongoCollection col = db.getCollection("Sold_Medicines");
        Document filter = new Document("Invoice", Invoice);
        DeleteResult result = col.deleteMany(filter);

        if (result.getDeletedCount() > 0) {
            System.err.println("deleteFromSoldMedicineTable ==>result.getDeletedCount()==>"+result.getDeletedCount());
            return true;
        }
        return false;

    }
}
