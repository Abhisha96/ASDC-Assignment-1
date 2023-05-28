package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ResBranchTest {
    private ResBranch resBranch;
    private Map<Integer, Map> restaurantBranch;

    @BeforeEach
    public void setUp() {
        resBranch = new ResBranch();
        restaurantBranch = new HashMap<>();
    }

    @Test
    void setBranchIdTest() {
        int branchId = 1;
        resBranch.setBranchId(branchId);
        assertEquals(branchId, resBranch.getBranchId());
    }

    @Test
    void addBranchLocTest() {
        int resId = 1;
        Map<Integer, String> locName = new HashMap<>();
        locName.put(1, "Halifax");
        resBranch.addBranchLoc(resId, locName);
        restaurantBranch.put(resId, locName);
        assertEquals(restaurantBranch, resBranch.getResBranch());
    }

    @Test
    public void getBranchNameTest() {

        Map<Integer, String> locName = new HashMap<>();
        locName.put(1, "Halifax");
        resBranch.addBranchLoc(1, locName);
        assertEquals("Halifax", resBranch.getBranchName(1, 1));
    }

    @Test
    public void addBranchContactTest() {
        String contactNumber = "123456789";
        String emailId = "branch@example.com";

        resBranch.addBranchContact(contactNumber, emailId);

        assertEquals(contactNumber, resBranch.getContactNumber());
        assertEquals(emailId, resBranch.getEmailId());
    }

    @Test
    public void getResBranchTest() {
        ResBranch mock = mock(ResBranch.class);

        Map<Integer, String> locName = new HashMap<>();
        locName.put(1, "Halifax");

        Map<Integer, Map> mockMap = new HashMap<>();
        mockMap.put(1, locName);

        when(mock.getResBranch()).thenReturn(mockMap);

        assertEquals(mock.getResBranch(), mockMap);
    }
}
