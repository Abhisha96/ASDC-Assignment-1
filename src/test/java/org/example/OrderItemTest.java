package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderItemTest {
    @Test
    void addtoDetailsTest(){
        
        Customer c1 = new Customer();
        menuItem mi = new menuItem();
        mi.setMenuitemDetails("m1","BreadPizza",45.00);
        c1.makeOrders("m1",2,mi);
        OrderItem ordersItem = new OrderItem();
        // Actual
        ordersItem.addtoDetails(mi.getMenuitemId("m1"),mi.getMenuitemName(mi.getMenuitemId("m1")),mi.getMenuitemPrice("m1"),2);

        
        Map<String, OrderItem> mockDetails = new HashMap<>();
        // Mocked
        mockDetails.put("m1", new OrderItem("BreadPizza", 45.00,2,90.0));
        // mocked vs actual
        assertEquals(mockDetails.get("m1"),ordersItem.getorderDetailsById("m1"));
        //check for mocked vs actual
        assertEquals(mockDetails,ordersItem.getorderDetails());
        // check for valid subtotal
        assertEquals(90.0,ordersItem.getSubtotal());
        // check for invalid subtotal
        assertNotEquals(190.0,ordersItem.getSubtotal());
    }
}