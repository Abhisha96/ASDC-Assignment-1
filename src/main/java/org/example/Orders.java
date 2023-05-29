package org.example;

import java.util.*;
public class Orders {
    OrderItem orderItem = new OrderItem();

    Map<String,OrderItem> orderItemMap = new HashMap<>();

    List<Double> subtotallist = new ArrayList<>();
    Map<Integer,String> orderId = new HashMap<>();
    int i = 0;
    public Orders(){
        i += 1;
    }
    void addOrder(String menuId,OrderItem orderItem){
        // binds the menuId with orderItem's map orderdetails by the menuId
        orderItemMap.put(menuId,orderItem.getOrderDetails(orderItem.getmenuId()));
        orderId.put(i,menuId);
    }
    Map getorderItemMap(){
        return orderItemMap;
    }
    String getOrderId(int i){
        return orderId.get(i);
    }
    Double setTotal(Double subtotal){
        // adds all the subtotal to the subtotallist.
       subtotallist.add(subtotal);
       // returns the total by invoking a private method
       return getTotal(subtotallist);
    }
    Double getTotal(List subtotallist){
        Double total = 0.0;
        for(int i=0;i<subtotallist.size();i++){
            total +=  (double) subtotallist.get(i);
        }
        return total;
    }
}