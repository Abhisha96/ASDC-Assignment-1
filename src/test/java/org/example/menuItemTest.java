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
    void setMenuitemDetailsTest() {
        menuItem menuItem = new menuItem();
        // compare - 1
        menuItem.setMenuitemDetails("m1", "BreadPizza", 45.0);

        Map<String, menuItem> expected = new HashMap<>();
        // compare - 2
        expected.put("m1", new menuItem("m1", "BreadPizza", 45.0));

        //compare 1 with 2
        assertEquals(expected,menuItem.getmenuItem());
    }

    @Test
    void getMenuitemPriceTest() {
        menuItem menuItem = new menuItem();
        menuItem.setMenuitemDetails("m1", "BreadPizza", 45.0);
        assertEquals(45.0, menuItem.getMenuitemPrice("m1"));
    }

    @Test
    void getMenuitemNameTest() {
        menuItem menuItem = new menuItem();
        menuItem.setMenuitemDetails("m1", "BreadPizza", 45.0);
        assertEquals("BreadPizza", menuItem.getMenuitemName("m1"));
    }

    @Test
    void getmenuItemTest() {
        menuItem menuItem = Mockito.mock(menuItem.class);

        // compare 1 - mock the menuItem -
        Map<String, menuItem> mockDetails = new HashMap<>();
        mockDetails.put("m1", new menuItem("m1", "Bread Pizza", 45.0));
        mockDetails.put("m2", new menuItem("m2", "Pepperoni Pizza", 50.0));
        when(menuItem.getmenuItem()).thenReturn(mockDetails);

        // compare 2
        Map<String, menuItem> expectedDetails = new HashMap<>();
        expectedDetails.put("m1", new menuItem("m1", "Bread Pizza", 45.0));
        expectedDetails.put("m2", new menuItem("m2", "Pepperoni Pizza", 50.0));

        assertEquals(expectedDetails,menuItem.getmenuItem());
    }
}
