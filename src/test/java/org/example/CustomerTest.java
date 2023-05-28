package org.example;
import org.junit.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerTest {
    @Test
    void AddCustomerIdTest() {
        Customer customer = new Customer();
        customer.addCustomerId("90912");
        assertEquals("90912", customer.getCustomerId());
    }

    @Test
    void AddCustomerNameTest() {
        Customer customer = new Customer();
        customer.addcustomerName("Abhisha Thaker");
        assertEquals("Abhisha Thaker", customer.getCustomerName());
    }

    @Test
    void AddCustomerContactTest() {
        Customer customer = new Customer();
        customer.addcustomerContact("ab@gmail.com");
        assertEquals("ab@gmail.com", customer.getCustomerContact());
    }

    @Test
    void goestoRestaurantTest(){
        Customer customer = new Customer();
        customer.goestoRestaurant("PizzaPizza");
        assertEquals("PizzaPizza",customer.goestoRestaurant("PizzaPizza"));
    }
    @Test
    void goestoRestaurantBranchTest() {
        Customer customer = new Customer();
        customer.goestoRestaurantBranch("Satadhar");
        assertEquals("Satadhar", customer.goestoRestaurant("Satadhar"));
    }
    @Test
    void makeOrdersTest() {
        Customer customer = new Customer();

        // 1st comparison
        menuItem menuItemMock = Mockito.mock(menuItem.class);
        when(menuItemMock.getMenuitemName("m1")).thenReturn("BreadPizza");
        when(menuItemMock.getMenuitemPrice("m1")).thenReturn(45.0);
        customer.makeOrders("m1", 2, menuItemMock);
        // verify the when and thenReturn
        verify(menuItemMock).getMenuitemName("m1");
        verify(menuItemMock).getMenuitemPrice("m1");

        // 2nd comparison - compare the above with the following
        OrderItem orderItem = new OrderItem();
        Orders orders = new Orders();
        orderItem.addtoDetails("m1","BreadPizza",45.0,2);

        Map<String, OrderItem> mockorderitemDetails = new HashMap<>();
        mockorderitemDetails.put("m1", new OrderItem("BreadPizza", 45.0,2,90.0));

        // compare the 1st comparison with the 2nd comparison
        assertEquals(mockorderitemDetails,orderItem.getorderDetails());
        // verify the subtotal value
        assertEquals(90.0,orderItem.getSubtotal());
    }
    @Test
    void amounttoPayTest(){
        boolean isAmountPaid = false;

        OrderItem orderItem = new OrderItem();
        Orders orders = new Orders();
        orderItem.addtoDetails("m1","Bread Pizza",80.0,1);
        orders.setTotal(orderItem.getSubtotal());
        orderItem.addtoDetails("m2","Bread Pizza",90.0,1);

        // compare 170 with the value returned from orders.setTotal
        assertEquals(170,orders.setTotal(orderItem.getSubtotal()));
    }

    @Test
    void makePaymentTest() {
        Customer customer = new Customer();
        // compare whether the payment is equal and thereby the method returns true.
        boolean isAmountPaid = customer.makePayment(90.0,90.0);
        assertTrue(isAmountPaid);
    }
    @Test
    void amounttoPayInvalidTest() {
        Customer customer = new Customer();
        // compare the payment is unequal and thereby the method returns false.
        boolean isAmountPaid1 = customer.makePayment(50.0,90.0);
        // compare the payment is unequal and thereby the method returns false.
        boolean isAmonuntPaid2 = customer.makePayment(90.0,50.0);
        assertFalse(isAmountPaid1);
        assertFalse(isAmonuntPaid2);
    }
}
