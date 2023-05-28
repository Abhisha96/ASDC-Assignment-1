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
        orderItemMap.put(menuId,orderItem.getOrderDetails(orderItem.getmenuId()));
        orderId.put(i,menuId);
      //  setTotal(orderItem.getOrderDetails(orderItem.getmenuId()).getSubtotal());
    }
    Map getorderItemMap(){
        return orderItemMap;
    }
    String getOrderId(int i){
        return orderId.get(i);
    }
    Double setTotal(Double subtotal){
       subtotallist.add(subtotal);
       return getTotal(subtotallist);
    }
     private Double getTotal(List subtotallist){
        Double total = 0.0;
        for(int i=0;i<subtotallist.size();i++){
            total +=  (double) subtotallist.get(i);
        }
        return total;
    }
}