package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OrdersTest {

    @Test
    public void testAddOrder() {

        Customer c1 = new Customer();
        menuItem mi = new menuItem();
        mi.setMenuitemDetails("m1","Bread Pizza",45.00);
        c1.makeOrders("m1",2,mi);
        OrderItem ordersItem = new OrderItem();
        ordersItem.addtoDetails(mi.menuitemId,mi.getMenuitemName(mi.getMenuitemId("m1")),mi.getMenuitemPrice("m1"),2);
        Orders orders = new Orders();
        orders.addOrder(mi.getMenuitemId("m1"),ordersItem);

        Map<String, OrderItem> mockorderitemDetails = new HashMap<>();
        mockorderitemDetails.put("m1", new OrderItem("Bread Pizza", 45.00,2,90.0));
        Map<String, OrderItem> mockorderDetails = new HashMap<>();
        mockorderDetails.put("m1",mockorderitemDetails.get("m1"));


        assertEquals(mockorderitemDetails,orders.getorderItemMap());

        // Create a mock of the OrderItem class

        // Set up the mock behavior

        // Verify that the orderId map contains the expected entry
        Map<Integer, String> expectedOrderIdMap = new HashMap<>();
        expectedOrderIdMap.put(1, mi.menuitemId);
        assertEquals(expectedOrderIdMap, orders.orderId);
    }

    @Test
    public void testSetTotal() {
        // Create an instance of the class under test
        Orders orders = new Orders();

        Double subtotal = 10.0;
        Double total = orders.setTotal(subtotal);

        assertEquals(subtotal, total);
        assertEquals(1, orders.subtotallist.size());
        assertEquals(subtotal, orders.subtotallist.get(0));
    }
}
