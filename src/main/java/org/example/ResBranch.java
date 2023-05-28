package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ResBranch {
    private Map<Integer, Map> restaurantBranch;
    private Map<String, String> branchNumber;
    private String contactNumber;
    private String emailId;
    private int branchId;
    private Map<Integer,Integer> resIdBranchId = new HashMap<>();
    public ResBranch(){
        restaurantBranch = new HashMap<>();
    }

    public void setBranchId(int branchId){
        this.branchId = branchId;
    }
    public int getBranchId(){
        return this.branchId;
    }
    public void resIdBranchId(int res_id, int branchId){
        resIdBranchId.put(res_id,branchId);
    }
    public void addBranchLoc(int res_id, Map locName){
        restaurantBranch.put(res_id,locName);
    }
    public String getBranchName(int res_id,int branchId){
        System.out.println(restaurantBranch.get(res_id).get(branchId));
        return restaurantBranch.get(res_id).get(branchId).toString();
    }
    public void addBranchContact(String contactNumber, String emailId){
        this.contactNumber = contactNumber;
        this.emailId = emailId;
    }
    Map getResBranch(){
        return restaurantBranch;
    }
    String getContactNumber(){
        return this.contactNumber;
    }
    String getEmailId(){
        return this.emailId;
    }
}
