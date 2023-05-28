package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OrdersTest {

    @Test
    public void addOrderTest() {

        Customer c1 = new Customer();
        menuItem mi = new menuItem();
        mi.setMenuitemDetails("m1","Bread Pizza",45.00);
        c1.makeOrders("m1",2,mi);
        OrderItem ordersItem = new OrderItem();
        ordersItem.addtoDetails(mi.getMenuitemId("m1"),mi.getMenuitemName(mi.getMenuitemId("m1")),mi.getMenuitemPrice("m1"),2);
        Orders orders = new Orders();
        orders.addOrder(mi.getMenuitemId("m1"),ordersItem);

        // mocked
        Map<String, OrderItem> mockDetails = new HashMap<>();
        mockDetails.put("m1", new OrderItem("Bread Pizza", 45.00,2,90.0));
        Map<String, OrderItem> mockorderDetails = new HashMap<>();
        mockorderDetails.put("m1",mockDetails.get("m1"));
        //mocked vs actual
        assertEquals(mockDetails,orders.getorderItemMap());

        Map<Integer, String> expectedOrderId = new HashMap<>();
        expectedOrderId.put(1, mi.getMenuitemId("m1"));
        assertEquals(expectedOrderId, orders.orderId);
    }

    @Test
    public void setTotalTest() {
        // Create an instance of the class under test
        Orders orders = new Orders();
        Double total = orders.setTotal(10.0);

        assertEquals(10.0, total);
    }
}
