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
    public void testSetAndGetBranchId() {
        int branchId = 1;
        resBranch.setBranchId(branchId);
        assertEquals(branchId, resBranch.getBranchId());
    }

    @Test
    public void testAddBranchLoc() {
        int resId = 1;
        Map<Integer, String> locName = new HashMap<>();
        locName.put(1, "Branch A");
        resBranch.addBranchLoc(resId, locName);
        restaurantBranch.put(resId, locName);
        assertEquals(restaurantBranch, resBranch.getResBranch());
    }

    @Test
    public void testGetBranchName() {
        int resId = 1;
        int branchId = 1;
        Map<Integer, String> locName = new HashMap<>();
        locName.put(1, "Branch A");
        resBranch.addBranchLoc(resId, locName);
        assertEquals("Branch A", resBranch.getBranchName(resId, branchId));
    }

    @Test
    public void testAddBranchContact() {
        String contactNumber = "123456789";
        String emailId = "branch@example.com";

        resBranch.addBranchContact(contactNumber, emailId);

        assertEquals(contactNumber, resBranch.getContactNumber());
        assertEquals(emailId, resBranch.getEmailId());
    }

    @Test
    public void testGetResBranchMock() {
        ResBranch resBranchMock = mock(ResBranch.class);
        Map<Integer, Map> mockMap = new HashMap<>();
        Map<Integer, String> locName = new HashMap<>();
        locName.put(1, "Branch A");
        mockMap.put(1, locName);
        when(resBranchMock.getResBranch()).thenReturn(mockMap);
        assertEquals(mockMap, resBranchMock.getResBranch());
    }
}
