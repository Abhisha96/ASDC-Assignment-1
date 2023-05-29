package org.example;

public class DbService {
    boolean saveCustomer(){
        return false;
    }
    boolean readCustomerName(){
        Customer c = new Customer("c1","Abhisha","8128395206");
        if(c.getCustomerName() == "Abhisha")
            return true;
        return false;
    }
    boolean readCustomerId(){
        Customer c = new Customer("c1","Abhisha","8128395206");
        if(c.getCustomerId() == "c1")
            return true;
        return false;
    }
}
