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
        // Initializing resBranch object when constructor is invoked.
        resBranch = new ResBranch();
        // Initializing menuItem object when constructor is invoked.
        mi = new menuItem();
    }
    /*
    Overloading constructor
     */
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
    /*
    * Following method getsOrder from the customer and takes in as parameter
    * menuId = order should be from the menu. So, it takes menuid
    * quantity = customer will input the quantity of the menuid.
    * menuItem mi = it passes the entire object of the menuItem as invoked from the main.java
    * */
    void makeOrders(String menuId,int quantity,menuItem mi){
        if(menuId.isBlank() || menuId.isEmpty() || quantity == 0 || mi == null){
            System.out.println("Please enter the correct input format");
        }
        else {
            //sets the menu_name
            String menu_Name = mi.getMenuitemName(menuId);
            //sets the menu_price
            Double menu_Price = mi.getMenuitemPrice(menuId);
            // add the invoked individual order made by the customer to the orderItem object
            orderItem.addtoDetails(menuId, menu_Name, menu_Price, quantity);
            // return the subtotal = price*quantity as defined in the OrderItem class
            double subtotal = orderItem.getSubtotal();
            System.out.println("value of subtotal is" + subtotal);
            // add all the orderItems to the orders list.
            order.addOrder(menuId, orderItem);
            //     System.out.println("Amount to pay"+order.setTotal(orderItem.getSubtotal()));
        }
    }
    /*
    * calculates the totalamount.
    * Internally it calls setTotal, which in turn takes the parameter as getsubTotal method.
     */
    Double amounttoPay(){
        if(!isAmountPaid) {
            amounttoPay = order.setTotal(orderItem.getSubtotal());
            return amounttoPay;
        }
        return 0.0;
    }
    Boolean makePayment(Double customerAmount,Double amounttoPay){
        if(customerAmount == 0.0 || amounttoPay == 0.0){
            isAmountPaid = false;
        }
        else if(customerAmount > 0.0){
            if(customerAmount.doubleValue() == amounttoPay.doubleValue()){
                isAmountPaid = true;
            }else{
                System.out.println("Please pay the appropriate amount"+amounttoPay);
                isAmountPaid = false;
            }
            return isAmountPaid;
        }
        return isAmountPaid;
    }
    String goestoRestaurant(String res_Name){
        return res_Name;
    }
    String goestoRestaurantBranch(String branch_Name){
        return branch_Name;
    }
}
