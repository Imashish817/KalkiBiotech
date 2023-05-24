/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kalki.DBCalls;

import java.io.*;
import java.net.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class NewClass {

    public static void main(String[] args) throws UnknownHostException, IOException {
//String uri = "mongodb+srv://imashishjaiswal99:aDSvrvt0yZqYuc95@cluster0.xnac6el.mongodb.net/?retryWrites=true&w=majority";
//        try (MongoClient mongoClient = MongoClients.create(uri)) {
//            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
//            MongoCollection<Document> collection = database.getCollection("movies");
////            Document doc = collection.find("title", "Back to the Future").first();
////            if (doc != null) {
////                System.out.println(doc.toJson());
////            } else {
//                System.out.println("No matching documents found.");
////            }
//        }
        /////////////////
       
        MongoClient client = MongoClients.create("mongodb+srv://ashish:J4Rk7hpeEpfF6jdn@newcluster.9pycrns.mongodb.net/?retryWrites=true&w=majority");
//mongodb://imashishjaiswal99:aDSvrvt0yZqYuc95@cluster0.xnac6el.mongodb.net/
        MongoDatabase db = client.getDatabase("Billing");

        MongoCollection col = db.getCollection("Medicins");

        Document sampleDoc = new Document("_id", "1").append("name", "John Smith");

        col.insertOne(sampleDoc);

    }
}