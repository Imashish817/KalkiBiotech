/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kalki.DBCalls;

import com.mycompany.kalki.BilledMeds;

import java.util.ArrayList;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
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
import com.mongodb.client.result.UpdateResult;
import com.mycompany.kalki.Customer;
import com.mycompany.kalki.Med;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.Arrays;
import java.util.Date;

public class MongoDBCalls {

    public boolean Login(String Password) {
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");

        MongoDatabase db = client.getDatabase("Billing");

        MongoCollection col = db.getCollection("User");

        // Create a filter to query documents where QTY > 0
        Bson filter = Filters.eq("Pass", Password);

        // Execute the find query with the filter
        FindIterable<Document> cursor = col.find(filter);
        String Pass="";
        for (Document doc : cursor) {

            Pass = doc.getString("Pass");

        }
        boolean b=false;
        if(Pass.equals(Password) )
        {
        b=true;
        }

        return b;
    }

    public int[] insertBilledMeds(ArrayList<BilledMeds> billedMeds, String invoiceno, Date date) throws Exception {
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("Billing");
        MongoCollection col = db.getCollection("Sold_Medicines");

//        Document sampleDoc = new Document("_id", "1").append("name", "John Smith");
//
//        col.insertOne(sampleDoc);
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

//    col.close(); // Close the MongoDB client
        // Return the update counts
        return new int[]{result.getInsertedCount()};
    }

    public boolean insertItem(Med med) {
        try {
//        vOwQyDKyB3SEEPKx   ashish
//Database name  ==> Billing
//Collection name ==> Medicine

            String connectionString = "mongodb+srv://ashish:vOwQyDKyB3SEEPKx@kalki.c6mhvhs.mongodb.net/?retryWrites=true&w=majority";
            MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
//mongodb://imashishjaiswal99:aDSvrvt0yZqYuc95@cluster0.xnac6el.mongodb.net/
            MongoDatabase db = client.getDatabase("Billing");

            MongoCollection col = db.getCollection("Medicins");

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
                    .append("GSTPaid", med.getGSTpercentage())
                    .append("MRP", med.getMRP());

            // Insert the document into the collection
            col.insertOne(doc);

            // Close the MongoDB connection
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public ArrayList<Med> getAllMeds() throws Exception {
        ArrayList<Med> meds = new ArrayList<>();
//     MongoClientURI connectionString = new MongoClientURI("mongodb+srv://<username>:<password>@<clustername>.mongodb.net/<dbname>");
//    MongoClient mongoClient = new MongoClient(connectionString);
//    MongoDatabase database = mongoClient.getDatabase("<dbname>");
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        //mongodb://imashishjaiswal99:aDSvrvt0yZqYuc95@cluster0.xnac6el.mongodb.net/
        MongoDatabase db = client.getDatabase("Billing");

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
            Double GSTpaid = doc.getDouble("Rate");
            Double MRP = doc.getDouble("MRP");
            Med medicine = new Med(ID, HSNCode, Product, Pack, Batch, Expire, GST, QTY, Scheme, PTS, PTR, Rate,GSTpaid, MRP);
            meds.add(medicine);
        }

        return meds;
    }

    public boolean AddCustomer(Customer customer) {
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        //mongodb://imashishjaiswal99:aDSvrvt0yZqYuc95@cluster0.xnac6el.mongodb.net/
        MongoDatabase db = client.getDatabase("Billing");
        try{
        MongoCollection col = db.getCollection("Customer");
        Document customerDocument = new Document("Firm_Name", customer.getFirm_Name())
                .append("Address", customer.getAddress())
                .append("Mobile", customer.getMobile())
                .append("tel", customer.getTel())
                .append("email", customer.getEmail())
                .append("GSTno", customer.getGSTno())
                .append("PAN", customer.getPAN())
                .append("DL1", customer.getDL1())
                .append("DL2", customer.getDL2())
                .append("State", customer.getState());

        col.insertOne(customerDocument);
        return true;
        }
        catch(Exception e){
        return false;
        }
        

    }

    public long Customer(Customer c) {
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        //mongodb://imashishjaiswal99:aDSvrvt0yZqYuc95@cluster0.xnac6el.mongodb.net/
        MongoDatabase db = client.getDatabase("Billing");

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
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        //mongodb://imashishjaiswal99:aDSvrvt0yZqYuc95@cluster0.xnac6el.mongodb.net/
        MongoDatabase db = client.getDatabase("Billing");

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

        // Close MongoDB connections
//    cursor.close();
//    mongoClient.close();
        return customers;
    }

    public Customer getlCustomer(Long id) throws Exception {
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        //mongodb://imashishjaiswal99:aDSvrvt0yZqYuc95@cluster0.xnac6el.mongodb.net/
        MongoDatabase db = client.getDatabase("Billing");

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

    public boolean AddBill(String invoiceno, String CustomerName, Long CustomerID, Long ShipingID, Double TotalTaxable, Double GST, Double NetTotal, Double NetProfit, Date date, Double AmountPaid, String Remark, String Transport) {

        try {
            MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
            MongoDatabase db = client.getDatabase("Billing");
            MongoCollection col = db.getCollection("Bills");
            // Create a new document to be inserted
            Document document = new Document();
            document.append("InvoiceNo", invoiceno)
                    .append("CustomerName", CustomerName)
                    .append("CustomerDetails", CustomerID)
                    .append("ShipingDetails", ShipingID)
                    .append("TaxableAmount", TotalTaxable)
                    .append("GST", GST)
                    .append("NetTotal", NetTotal)
                    .append("NetProfit", NetProfit)
                    .append("Date", date.toString())
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

    public void updateitemlist(int QTY, Long id) throws Exception {
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("Billing");
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

    public ArrayList<String> GetAllMedsName() throws Exception {
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("Billing");
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
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("Billing");
        MongoCollection col = db.getCollection("Customer");
        ArrayList<String> CustomersName = new ArrayList<>();
        MongoCursor<Document> cursor = col.find().iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            String customer = document.getString("Firm_Name");
            Long CustomerID = document.getLong("CustomerId");
            CustomersName.add(customer + "=>" + CustomerID);
        }
        cursor.close();

        return CustomersName;

    }

    public ArrayList<Object[]> GetAllBills(Long id) throws Exception {
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("Billing");
        MongoCollection col = db.getCollection("Bills");
        Bson filter = Filters.eq("CustomerDetails", id);

        // Execute the find query with the filter
//        FindIterable<Document> cursor = col.find(filter);
        ArrayList<Object[]> Bills = new ArrayList<Object[]>();
        MongoCursor<Document> cursor = col.find(filter).iterator();
        while (cursor.hasNext()) {

            Document document = cursor.next();
            String InvoiceNo = document.getString("InvoiceNo");
            String CustomerName = document.getString("CustomerName");
            Long CustomerDetails = document.getLong("CustomerDetails");
            Double TaxableAmount = document.getDouble("TaxableAmount");
            Double GST = document.getDouble("GST");
            Double NetTotal = document.getDouble("NetTotal");
            Double NetProfit = document.getDouble("NetProfit");
            String Date = document.getString("Date");
            Double AmountPaid = document.getDouble("AmountPaid");
            String remark = document.getString("remark");

            Object oneBill[] = {Date, InvoiceNo, CustomerName, CustomerDetails, TaxableAmount, GST, NetTotal, NetProfit, AmountPaid, remark};
            Bills.add(oneBill);
        }
        cursor.close();

        return Bills;

    }

    public ArrayList<Double> GetSalesDetails(Date start, Date End) throws Exception {
        ArrayList<Double> SalesDetails = new ArrayList<>();
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("Billing");
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
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("Billing");
        MongoCollection col = db.getCollection("Bills");
        Bson filter = Filters.eq("InvoiceNo", InvoiceNo);
        ArrayList<Object> Customers = new ArrayList<>();
        MongoCursor<Document> cursor = col.find(filter).iterator();
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
            String Date = document.getString("Date");
            String Transport = document.getString("Transport");
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

        }
        cursor.close();
        return Customers;
    }

    public ArrayList<BilledMeds> getBilledMeds(String InvoiceNo) {
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("Billing");
        MongoCollection col = db.getCollection("Sold_Medicines");
        Bson filter = Filters.eq("Invoice", InvoiceNo);

        // Execute the find query with the filter
//        FindIterable<Document> cursor = col.find(filter);
        ArrayList<BilledMeds> Meds = new ArrayList<BilledMeds>();
        MongoCursor<Document> cursor = col.find(filter).iterator();
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
            Double GSTpercentage = document.getDouble("GST");
            Double GST = document.getDouble("GST");
            Double NetTotal = document.getDouble("NetTotal");
            BilledMeds med = new BilledMeds(0l, HSN, Batch, product, Pack, MRP, QTY, Scheme, NetQTY, Expire, PTS, PTR, Discount, TaxableAmount,GSTpercentage, GST, NetTotal, 0.0);
            Meds.add(med);
        }
        cursor.close();

        return Meds;

    }
    
    public Integer getInvoiceCounter(){
     MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("Billing");
        MongoCollection col = db.getCollection("counters");
         Bson filter = Filters.exists("invoice");
         MongoCursor<Document> cursor = col.find(filter).iterator();
         Integer InvoiceNo=0;
      while (cursor.hasNext()) {

            Document document = cursor.next();
             InvoiceNo= document.getInteger("invoice");
    }
      return InvoiceNo;
}
    
    public void updateInvoiceCounter(Integer inv){
    MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("Billing");
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
}
