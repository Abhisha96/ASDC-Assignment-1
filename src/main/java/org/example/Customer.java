package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private String customerId;
    private String customerName;
    private String customerContact;
    ResBranch resBranch;
    Orders order = new Orders();
    menuItem mi;
    String menu_chosen;
    OrderItem orderItem = new OrderItem();
    Double amounttoPay;

    Boolean isAmountPaid = false;
    public Customer(){
        resBranch = new ResBranch();
        mi = new menuItem();
    }
    public Customer(String customerId,String customerName,String customerContact){
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerContact = customerContact;
    }
    void addCustomerId(String customerId){
        this.customerId = customerId;
    }
    String getCustomerId(){
        return customerId;
    }
    void addcustomerName(String customerName){
        this.customerName = customerName;
    }
    String getCustomerName(){
        return this.customerName;
    }
    void addcustomerContact(String customerContact){
        this.customerContact = customerContact;
    }
    String getCustomerContact(){
        return this.customerContact;
    }
    void makeOrders(String menuId,int quantity,menuItem mi){
        String menu_Name = mi.getMenuitemName(menuId);
        Double menu_Price = mi.getMenuitemPrice(menuId);
        // add the order to the orderItem
        orderItem.addtoDetails(menuId,menu_Name,menu_Price,quantity);
        double subtotal = orderItem.getSubtotal();
        System.out.println("value of subtotal is"+subtotal);
        // add the orderItem to the orders list
        order.addOrder(menuId,orderItem);
   //     System.out.println("Amount to pay"+order.setTotal(orderItem.getSubtotal()));
    }
    Double amounttoPay(){
        if(!isAmountPaid) {
            amounttoPay = order.setTotal(orderItem.getSubtotal());
            return amounttoPay;
        }
        return 0.0;
    }
    Boolean makePayment(Double customerAmount,Double amounttoPay){
        if(customerAmount > 0.0){
            if(customerAmount.doubleValue() == amounttoPay.doubleValue()){
                isAmountPaid = true;
            }else{
                System.out.println("Please pay the appropriate amount"+amounttoPay);
                isAmountPaid = false;
            }
            return isAmountPaid;
        }else {
            return isAmountPaid;
        }
    }
    String goestoRestaurant(String res_Name){
        return res_Name;
    }
    String goestoRestaurantBranch(String branch_Name){
        return branch_Name;
    }
    //add the validation to do the
    String getCustomerContact(String i){
        return customerContact;
    }
}
