package org.example;

import java.util.*;

public class OrderItem {
    private String menu_item;
    private double price;
    private int quantity;
    private String menuId;
    // map - which binds the menuId with the corresponding menuitemId, price, quantity and subtotal. price
    // and quantity will be as entered by the user in main.java and subtotal will be as calculated by price*quantity

    private Map<String,OrderItem> orderdetails = new HashMap<>();
    private double subtotal;

    public OrderItem(){
    }
    public OrderItem(String menuName, Double menuPrice, int quantity,Double subtotal) {
        this.menu_item = menuName;
        this.price = menuPrice;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }
    void addtoDetails(String menuId,String menu_item,Double price, int quantity){
        this.menuId = menuId;
        this.menu_item = menu_item;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = this.getSubtotal();
        orderdetails.put(this.menuId,new OrderItem(this.menu_item,this.price,this.quantity,this.subtotal));
    }
    OrderItem getorderDetailsById(String menuId){
        return orderdetails.get(menuId);
    }
    Map getorderDetails(){
        return orderdetails;
    }
    String getmenuId(){
        return this.menuId;
    }
    OrderItem getOrderDetails(String menuId){
        return orderdetails.get(menuId);
    }
    public void setMenu_item(String menu_item){
        this.menu_item = menu_item;
    }
    public String getMenu_item() {
        return menu_item;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getSubtotal() {
        return price * quantity;
    }
    public void setMenu_price(Double menuPrice) {
        this.price = menuPrice;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /*
    Below 2 methods are used for testing purpose. Because assertEquals compares the memory location
    of the objects. Therefore, it's override to ensure that it compares the values, instead of comparing
    the memory location.
    References
    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object)
    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#hashCode()
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OrderItem second= (OrderItem) obj;
        return Objects.equals(menu_item, second.menu_item) &&
                Objects.equals(price, second.price) &&
                Objects.equals(quantity, second.quantity) &&
                Objects.equals(subtotal, second.subtotal);

    }
    @Override
    public int hashCode() {
        return Objects.hash(menu_item,price,quantity,subtotal);
    }
}
