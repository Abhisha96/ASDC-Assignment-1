package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RestaurantTest {
        @Test
        void addResnameTest() {
            Restaurant restaurant = new Restaurant();
            restaurant.addResname(1, "Pizza Pizza");
            // checks whether the restaurant id is equal to 1.
            assertEquals(1, restaurant.getResid());
            //checks whether the restaurant name is matched with restaurant id.
            assertEquals("Pizza Pizza", restaurant.getResnames(1));
        }
        @Test
        void addResNamesTest(){
            Restaurant restaurant = new Restaurant();
            restaurant.addResnames(1,"Pizza Pizza");
            restaurant.addResnames(2,"Subway");
            assertEquals("Pizza Pizza",restaurant.getResnames(1));
            assertEquals("Subway",restaurant.getResnames(2));
        }
        @Test
        void getResidTest(){
            Restaurant restaurant = new Restaurant();
            restaurant.addResname(1,"Pizza Pizza");
            assertEquals(1,restaurant.getResid());
        }
        @Test
        void getResNameTest(){
            Restaurant restaurant = new Restaurant();
            restaurant.addResname(1,"Pizza Pizza");
            assertEquals("Pizza Pizza",restaurant.getResname());
        }
        @Test
        void getResNamesTest(){
            Restaurant restaurant = new Restaurant();
            restaurant.addResname(1,"Pizza Pizza");
            restaurant.addResname(1,"Subway");
            // Because one restaurant id will be mapped to only one restaurant name. Therefore it should be false.
            // cannot use assertEquals because assertEquals is used to test whether two specific values are equal or not.
            assertFalse(Boolean.parseBoolean(restaurant.getResnames(1)));
        }
        @Test
        void addResmenuTest() {
            menuItem menuitem = Mockito.mock(menuItem.class);
            Restaurant restaurant = Mockito.mock(Restaurant.class);

            when(menuitem.getmenuItem()).thenReturn(new HashMap<String, menuItem>() {{
                put("m1", new menuItem("m1", "Bread Pizza", 45.0));
                put("m2", new menuItem("m2", "Pepperoni Pizza", 50.0));
            }});

            restaurant.addResmenu(1, menuitem);
            verify(restaurant).addResmenu(1, menuitem);
        }
        @Test
        void addResBranchTest() {
            ResBranch resBranch = Mockito.mock(ResBranch.class);
            Restaurant restaurant = Mockito.mock(Restaurant.class);

            Map<Integer, String> addBranchLoc = new HashMap<>();
            addBranchLoc.put(101, "Halifax");
            addBranchLoc.put(102, "Dartmouth");

            Map<Integer,Map> abc = new HashMap<Integer,Map>();
            when(resBranch.getResBranch()).thenReturn(new HashMap<>() {{
                abc.put(1,addBranchLoc);
            }});
            restaurant.addResBranch(1, resBranch);
            verify(restaurant).addResBranch(1,resBranch);
        }
}

