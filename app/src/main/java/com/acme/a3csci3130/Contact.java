package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public  String uid;
    public  String name;
    public  String number;
    public  String business;
    public  String address;
    public  String province;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     * Constructor to initialize Contact with fields
     * @param uid the uid of the entry in firebase database
     * @param name name of the business
     * @param number phone number of the business
     * @param business role of the business
     * @param address address of the main location
     * @param province province of operation
     */
    public Contact(String uid, String name, String number, String business,
                   String address, String province){
        this.uid = uid;
        this.name = name;
        this.number = number;
        this.business = business;
        this.address = address;
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("number", number);
        result.put("business", business);
        result.put("address", address);
        result.put("province", province);

        return result;
    }
}
