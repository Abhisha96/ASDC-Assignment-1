package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Restaurant {
    String res_name;
    int res_id;
//    Menu menu;
    menuItem menuitem;
    Customer customer;
    Orders orders;
    Map<String, menuItem> res_menu;
    List<String> customer_names;
    Map<Integer,Map> res_menu_list;
    Map<Integer,Map> res_branch_list;
    Map<Integer, Map> res_branch;
    private Map<Integer,String> resNames;
    public Restaurant(){
        res_menu = new HashMap<String, menuItem>();
        res_branch = new HashMap<Integer, Map>();
        resNames = new HashMap<>();
        res_menu_list = new HashMap<>();
        res_branch_list = new HashMap<>();
    }
    /*
    Adds just one restaurant name at a time
     */
    void addResname(int res_id,String res_name){
        this.res_id = res_id;
        this.res_name = res_name;
        addResnames(this.res_id,this.res_name);
    }
    /*
    Adds many restaurant names and stores it in resNames
     */
    void addResnames(int res_id,String res_name){
        resNames.put(res_id,res_name);
    }
    int getResid(){
        return this.res_id;
    }
    String getResname(){
        return this.res_name;
    }
    // returns all the restaurant Ids.
    Set getResIds(){
        return resNames.keySet();
    }
    // returns all the restaurant names
    Map getResNames(){
        return resNames;
    }
    String getResnames(int res_id){
        return resNames.get(res_id);
    }
    /*
    Adds menuitem as per the restaurantid
    */
    void addResmenu(int res_id,menuItem item){
        Map<String,menuItem> mapMenuItem = item.getmenuItem();
        for(String key:mapMenuItem.keySet()){
            res_menu.put(key, mapMenuItem.get(key));
        }
        res_menu_list.put(res_id,res_menu);
        System.out.println(res_menu_list);
    }
    Map getResmenulistbyId(int res_id){
        return res_menu_list.get(res_id);
    }
    Map<Integer,Map> getResmenulist(){
        return res_menu_list;
    }
    /*
    Adds branch of the restaurant by the restaurant id
     */
    void addResBranch(int res_id,ResBranch rb){
        Map<Integer,Map> mapResBranch = rb.getResBranch();
        for(Integer key:mapResBranch.keySet()){
            res_branch.put(key,mapResBranch.get(key));
        }
        res_branch_list.put(res_id,res_branch);
    }
    Object getResBranchById(int res_id){
        return res_branch.get(res_id);
    }
    Map getResBranchList(){
        return res_branch_list;
    }
    Map getResmenu(){
        return res_menu;
    }
}
