package org.example;
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
    void testAddCustomerId() {
        Customer customer = new Customer();
        customer.addCustomerId("90912");
        assertEquals("90912", customer.getCustomerId());
    }

    @Test
    void testAddCustomerName() {
        Customer customer = new Customer();
        customer.addcustomerName("Abhisha Thaker");
        assertEquals("Abhisha Thaker", customer.getCustomerName());
    }

    @Test
    void testAddCustomerContact() {
        Customer customer = new Customer();
        customer.addcustomerContact("ab@gmail.com");
        assertEquals("ab@gmail.com", customer.getCustomerContact());
    }

    @Test
    void testgoestoRestaurant(){
        Customer customer = new Customer();
        customer.goestoRestaurant("Pizza Pizza");
        assertEquals("Pizza Pizza",customer.goestoRestaurant("Pizza Pizza"));
    }
    @Test
    void testgoestoRestaurantBranch() {
        Customer customer = new Customer();
        customer.goestoRestaurantBranch("Satadhar");
        assertEquals("Satadhar", customer.goestoRestaurant("Satadhar"));
    }
    @Test
    public void testMakeOrders() {
            // Create an instance of the Customer class for testing
        Customer customerTest = new Customer();

            // Create a mock menuItem
        menuItem menuItemMock = Mockito.mock(menuItem.class);

            // Set up mock behavior for getting menu item details
        when(menuItemMock.getMenuitemName("m1")).thenReturn("Bread Pizza");
        when(menuItemMock.getMenuitemPrice("m1")).thenReturn(45.0);
            // Invoke the method being tested
        customerTest.makeOrders("m1", 2, menuItemMock);

        verify(menuItemMock).getMenuitemName("m1");
        verify(menuItemMock).getMenuitemPrice("m1");

        OrderItem orderItem = new OrderItem();
        Orders orders = new Orders();
        orderItem.addtoDetails("m1","Bread Pizza",45.0,2);

        Map<String, OrderItem> mockorderitemDetails = new HashMap<>();
        mockorderitemDetails.put("m1", new OrderItem("Bread Pizza", 45.0,2,90.0));

        // Verify that the orderItem and orders are properly updated
        assertEquals(mockorderitemDetails,orderItem.getorderDetails());
            // Verify that the necessary mock methods are called
        assertEquals(90.0,orderItem.getSubtotal());
    }
    @Test
    void amounttoPay(){
        boolean isAmountPaid = false;

        OrderItem orderItem = new OrderItem();
        Orders orders = new Orders();
        orderItem.addtoDetails("m1","Bread Pizza",80.0,1);
        orders.setTotal(orderItem.getSubtotal());
        orderItem.addtoDetails("m2","Bread Pizza",90.0,1);

        assertEquals(170,orders.setTotal(orderItem.getSubtotal()));
    }

    @Test
    public void testMakePayment() {
            // Create an instance of the Customer class for testing
            Customer customerTest = new Customer();
            // Invoke the method being tested
            boolean isAmountPaid = customerTest.makePayment(90.0,90.0);
            // Verify that the payment is successfully processed
            assertTrue(isAmountPaid);
        }
        @Test
        public void testInvalidAmountPay() {
            // Create an instance of the Customer class for testing
            Customer customerUnderTest = new Customer();
            // Invoke the method being tested with an invalid amount
            boolean isAmountPaid1 = customerUnderTest.makePayment(50.0,90.0);
            boolean isAmonuntPaid2 = customerUnderTest.makePayment(90.0,50.0);
            // Verify that the payment is not processed and appropriate message is printed
            assertFalse(isAmountPaid1);
            assertFalse(isAmonuntPaid2);
    }
    @Test
    void testGoesToRestaurant() {
        Customer customer = new Customer();
        String restaurantName = "Pizza Pizza";
        assertEquals(restaurantName, customer.goestoRestaurant(restaurantName));
    }

    @Test
    void testGoesToRestaurantBranch() {
        Customer customer = new Customer();
        String branchName = "Satadhar";

        assertEquals(branchName, customer.goestoRestaurantBranch(branchName));
    }

}
