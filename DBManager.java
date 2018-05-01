/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARS;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;

import java.util.List;


public class DBManager {

    //TODO: Implement that class.
//    public class connectDB()
//    {
//
//    }


    public void insertUser(User uObj)
    {
        try{
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            //Connecting

            MongoDatabase db = mongoClient.getDatabase("ars");
            System.out.println("Connecting to the db...");
            MongoCollection collection = db.getCollection("users"); //Choosing the collection to insert
            System.out.println(collection);


            Document inputObj = new Document();
           // inputObj.put("_id", 1123);
            inputObj.put("first-name", uObj.getFirstName());
            inputObj.put("last-name", uObj.getLastName());
            inputObj.put("gender", uObj.getGender());
            inputObj.put("nationality", uObj.getNation());
            inputObj.put("phone-number", uObj.getPhoneNumber());
            inputObj.put("email", uObj.geteMail());
            inputObj.put("password", uObj.getPassword());
            inputObj.put("user-type", "customer");
            collection.insertOne(inputObj);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean findUserByName(String name)
    {
        User uObj;
        int counter=0;

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("ars");
        MongoCollection collection = db.getCollection("users"); //Choosing the collection to insert

        BasicDBObject query = new BasicDBObject();
        query.put("first-name", name);
        MongoCursor cursor = collection.find(query).iterator();

        //Counter gives one if it's give the result
        while(cursor.hasNext())
        {
            System.out.println(cursor.next());
            counter++;
        }

        if(counter == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean deleteUser(String firstName)
    {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("ars");
        MongoCollection collection = db.getCollection("users"); //Choosing the collection to insert

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("first-name", firstName);

        collection.deleteOne(searchQuery);

        if (findUserByName(firstName) == false)
        {
            return true;
        }
        else
            return false;

    }
    
    public int findAllUsers() {

        int counter =0;

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("ars");
        MongoCollection collection = db.getCollection("users"); //Choosing the collection to insert

        BasicDBObject query = new BasicDBObject();


        MongoCursor cursor = collection.find().iterator();
        while (cursor.hasNext())
        {
            System.out.println(cursor.next());
            counter ++;
        }
        return counter;
    }
    
     public boolean findUserByNumber(Long pNo)
    {
        int counter =0;
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("ars");
        MongoCollection collection = db.getCollection("users"); //Choosing the collection to insert

        BasicDBObject query = new BasicDBObject();
        query.put("phone-number", pNo);
        MongoCursor cursor = collection.find(query).iterator();

        while (cursor.hasNext())
        {
            System.out.println(cursor.next());
            counter ++;
        }

        if(counter == 1)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
     
    public boolean findNullForGender()
    {
        User uObj;
        int counter=0;

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("ars");
        MongoCollection collection = db.getCollection("users"); //Choosing the collection to insert

        BasicDBObject query = new BasicDBObject();
        query.put("gender", null);
        MongoCursor cursor = collection.find(query).iterator();

        //Counter gives one if it's give the result
        while(cursor.hasNext())
        {
            System.out.println(cursor.next());
            counter++;
        }

        if(counter >= 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean findUserByEmail(String email, String password)
    {
        User uObj;
        int counter=0;

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("ars");
        MongoCollection collection = db.getCollection("users"); //Choosing the collection to insert

        BasicDBObject query = new BasicDBObject();
        query.put("email", email);
        query.put("password", password);
        MongoCursor cursor = collection.find(query).iterator();

        //Counter gives one if it's give the result
        while(cursor.hasNext())
        {
            System.out.println(cursor.next());
            counter++;
        }

        if(counter == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //TODO: Change it after the implementation of the insertPlane function.
    public void insertFlight(Flight fObj)
    {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            //Connecting

            MongoDatabase db = mongoClient.getDatabase("ars");
            System.out.println("Connecting to the db...");
            MongoCollection collection = db.getCollection("flight"); //Choosing the collection to insert
            System.out.println(collection);


            Document flightObj = new Document();
            flightObj.put("fNO", 1001);
            flightObj.put("departure", "Izmir");
            flightObj.put("arrival", "Istanbul");
            flightObj.put("date", "2017-05-08 12:00:00"); //TODO: Change this dummy date.


            collection.insertOne(flightObj);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertPlane(Plane pObj)
    {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            //Connecting

            MongoDatabase db = mongoClient.getDatabase("ars");
            System.out.println("Connecting to the db...");
            MongoCollection collection = db.getCollection("plane"); //Choosing the collection to insert
            System.out.println(collection);

            List<Object> seatDBList = new BasicDBList();

            Document planeObj = new Document();
            planeObj.put("pNo", 2);
            planeObj.put("flightNo", 2);
            planeObj.put("Type", "Airbus A380");
            for(Seat seatList : pObj.getSeatVector()) //TODO: Change it
            {
                DBObject seatDBObject = new BasicDBObject();
                seatDBObject.put("sNo", seatList.getSeatNumber());
                seatDBObject.put("isEmpty", seatList.getIsEmpty());
                seatDBObject.put("isEconomy", seatList.getIsEconomy());
                seatDBList.add(seatDBObject);
            }
            planeObj.put("Seats", seatDBList);
            collection.insertOne(planeObj);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList findFlight(String departure, String arrival)
    {
       
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("ars");
        MongoCollection collection = db.getCollection("users"); //Choosing the collection to insert

        BasicDBObject query = new BasicDBObject();
        query.put("departure", departure);
        query.put("arrival", arrival);
        MongoCursor cursor = collection.find(query).iterator();

        ArrayList<Flight> flightList = new ArrayList<>();
        //Counter gives one if it's give the result
        while(cursor.hasNext())
        {
            flightList.add((Flight) cursor.next());
        }
        return flightList;
        
    }




}
