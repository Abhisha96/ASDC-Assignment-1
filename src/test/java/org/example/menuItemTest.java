package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class menuItemTest {

    @Test
    void testSetMenuitemDetails() {
        menuItem menuItem = new menuItem();
        menuItem.setMenuitemDetails("m1", "Bread Pizza", 45.0);

        Map<String, menuItem> expectedMenuitemDetails = new HashMap<>();
        expectedMenuitemDetails.put("m1", new menuItem("m1", "Bread Pizza", 45.0));

        assertEquals(menuItem.getmenuItem(),expectedMenuitemDetails);
        // verify(expectedMenuitemDetails).get("m1");
    }

    @Test
    void testGetMenuitemPrice() {
        menuItem menuItem = new menuItem();
        menuItem.setMenuitemDetails("m1", "Bread Pizza", 45.0);

        assertEquals(45.0, menuItem.getMenuitemPrice("m1"));
    }

    @Test
    void testGetMenuitemName() {
        menuItem menuItem = new menuItem();
        menuItem.setMenuitemDetails("m1", "Bread Pizza", 45.0);

        assertEquals("Bread Pizza", menuItem.getMenuitemName("m1"));
    }

    @Test
    void TestgetmenuItem() {
        menuItem menuItem = Mockito.mock(menuItem.class);

        Map<String, menuItem> mockMenuitemDetails = new HashMap<>();
        mockMenuitemDetails.put("m1", new menuItem("m1", "Bread Pizza", 45.0));
        mockMenuitemDetails.put("m2", new menuItem("m2", "Pepperoni Pizza", 50.0));

        when(menuItem.getmenuItem()).thenReturn(mockMenuitemDetails);

        Map<String, menuItem> expectedMenuitemDetails = new HashMap<>();
        expectedMenuitemDetails.put("m1", new menuItem("m1", "Bread Pizza", 45.0));
        expectedMenuitemDetails.put("m2", new menuItem("m2", "Pepperoni Pizza", 50.0));

        assertEquals(menuItem.getmenuItem(),expectedMenuitemDetails);
    }
}
