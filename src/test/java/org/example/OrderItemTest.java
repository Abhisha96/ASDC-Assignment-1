package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderItemTest {
    @Test
    void TestaddtoDetails(){
        Customer c1 = new Customer();
        menuItem mi = new menuItem();
        mi.setMenuitemDetails("m1","Bread Pizza",45.00);
        c1.makeOrders("m1",2,mi);
       OrderItem ordersItem = new OrderItem();
       ordersItem.addtoDetails(mi.menuitemId,mi.getMenuitemName(mi.getMenuitemId("m1")),mi.getMenuitemPrice("m1"),2);

        Map<String, OrderItem> mockorderitemDetails = new HashMap<>();
        mockorderitemDetails.put("m1", new OrderItem("Bread Pizza", 45.00,2,90.0));

        assertEquals(mockorderitemDetails.get("m1"),ordersItem.getorderDetailsById("m1"));
        assertEquals(mockorderitemDetails,ordersItem.getorderDetails());
        assertEquals(90.0,ordersItem.getSubtotal());
        assertNotEquals(190.0,ordersItem.getSubtotal());

    }

}