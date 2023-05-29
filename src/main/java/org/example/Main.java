package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/*
This is the main class. Run this class first.
This class is used for storing the restaurant-information and interaction with the customer on console.
 */
public class Main {
    static DbService db = new DbService();

    public DbService getDb() {
        return db;
    }

    public void setDb(DbService db) {
        this.db = db;
    }

    public static Boolean saveCustomerInDatabase(DbService db){
        return db.saveCustomer();
    }
    public static Boolean readCustomerId(DbService db){
        return db.readCustomerId();
    }
    public static Boolean readCustomerName(DbService db){
        return db.readCustomerName();
    }
    public static void main(String[] args) {

        String filepath = "C:/Users/AVuser/IdeaProjects/athaker/src/main/java/org/example/instructions.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String readline;
            while ((readline = reader.readLine()) != null) {
                System.out.println(readline);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         Adds a restaurant name. One restaurant id is mapped to only one restaurant name.
         */
        Restaurant r = new Restaurant();

        // Take the input from the user to enter the no. of restaurants
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of restaurants");
        int n_res = sc.nextInt();

        for (int i = 1; i <= n_res; i++) {
            // Enter the restaurant Id
            System.out.println("Enter the restaurant Id");
            int res_id = sc.nextInt();
            // Enter the restaurant name
            System.out.println("Enter the restaurant name");
            String res_name = sc.next();
            //Bind the restaurant id with the restaurant name
            // e.g. r.addResname(1, "Pizza Pizza");
            r.addResname(res_id, res_name);
        }
        /*
         1 restaurant id can have many branches.
         Here, limitation is that user can add multiple branches for only one restaurant.
         For eg. For restaurant id - 1 - whose res_name is "Pizza Pizza", can have multiple branches.
         */
        ResBranch rb = new ResBranch();
        Map<Integer, String> res_branch_loc = new HashMap<>();

        System.out.println("Enter the restaurant id for which you would like to enter the branch location");
        int res_id_branch = sc.nextInt();

        if (r.getResIds().contains(res_id_branch)) {
            System.out.println("How many branch locations you would like to add for the restaurant with the id" + "" + res_id_branch + "" + r.getResnames(res_id_branch));
            int n_branches = sc.nextInt();

            for (int i = 1; i <= n_branches; i++) {
                System.out.println("Enter the branch id for" + r.getResnames(res_id_branch));
                int branch_id = sc.nextInt();

                System.out.println("Enter the branch name for" + r.getResnames(res_id_branch));
                String branch_name = sc.next();
                res_branch_loc.put(branch_id, branch_name);
            }
            // restaurant id is binded to the above n_branches no. of locations.
            rb.addBranchLoc(res_id_branch, res_branch_loc);
            // Contact number will be common to all the restaurant branches, belonging to one restaurant
            rb.addBranchContact("8128395206", "ab@gmail.com");
            rb.resIdBranchId(res_id_branch, rb.getBranchId());
            // binds the branch to the restaurant name
            r.addResBranch(res_id_branch, rb);

            // Add menu-items to the restaurant
            menuItem mi = new menuItem();

            System.out.println("Enter the restaurant id for which you would like to enter the menuItems --- " + "" + r.getResNames().entrySet());
            int res_id_menu = sc.nextInt();

            if (r.getResIds().contains(res_id_menu)) {
                System.out.println("How many menuitems you would like to enter for" + "" + res_id_menu + "" + r.getResnames(res_id_menu));
                int n_menuitems = sc.nextInt();

                String menu_item_id = null;
                String menu_item_name = null;
                double menu_item_price = 0.00;
                for (int i = 1; i <= n_menuitems; i++) {
                    System.out.println("Enter the menuitem Id ( In String )");
                    menu_item_id = sc.next();

                    System.out.println("Enter the menuitem Name");
                    menu_item_name = sc.next();

                    System.out.println("Enter the price of the menuitem Name");
                    menu_item_price = sc.nextDouble();

                    mi.setMenuitemDetails(menu_item_id, menu_item_name, menu_item_price);
                }

                // adds the restaurant menu items to the restaurant.
                r.addResmenu(res_id_menu, mi);

                System.out.println(mi.getMenuitemName(menu_item_id));
                System.out.println(mi.getMenuitemPrice(menu_item_id));

                System.out.println("value is" + r.getResmenulistbyId(res_id_menu).entrySet());

                System.out.println("How many customers are there in the queue");
                int n_customers = sc.nextInt();
                while (n_customers != 0) {
                    System.out.println("Enter the customer id");
                    String customer_id = sc.next();
                    // add customer details to the restaurant
                    System.out.println("Enter your name");
                    String customer_name = sc.next();
                    System.out.println("Enter your contact number");
                    String contact_number = sc.next();
                    Customer customerObj = new Customer(customer_id, customer_name, contact_number);
                    saveCustomerInDatabase(db);

                    System.out.println("Which restaurant you would like to go from the following");
                    System.out.println(r.getResNames().entrySet());
                    System.out.println("Enter the restaurant id of your choice of restaurant from the above list");
                    int res_id = sc.nextInt();

                    if (r.getResIds().contains(res_id)) {

                        System.out.println("how many menuItems you would like to order from the following" + r.getResmenulistbyId(res_id));

                        if (r.getResmenulistbyId(res_id) == null) {
                            System.out.println("Please enter the menuitems first");
                        } else {
                            int menu_choices = sc.nextInt();
                            Double amounttoPay = 0.0;
                            while (menu_choices != 0) {
                                System.out.println("Enter the menu_id of the order that you want to make from the ---" + r.getResmenulist().entrySet());
                                String menu_id = sc.next();
                                System.out.println("how many quantity");
                                int quantity = sc.nextInt();
                                customerObj.makeOrders(menu_id, quantity, mi);
                                amounttoPay = customerObj.amounttoPay();
                                menu_choices--;
                            }
                            System.out.println("Amount to pay is" + amounttoPay + "please make the payment in cash");
                            System.out.println("Enter the amount to pay");
                            Double customerAmount = sc.nextDouble();
                            Boolean amountPaid = customerObj.makePayment(customerAmount, amounttoPay);
                            if (amountPaid) {
                                System.out.println("Amount has been paid successfully. Your order will be ready in few seconds.");
                            } else {
                                System.out.println("Amount to be paid by customer" + amounttoPay);
                                System.out.println("Enter the amount to pay");
                                customerAmount = sc.nextDouble();
                                amountPaid = customerObj.makePayment(customerAmount, amounttoPay);
                                if(amountPaid){
                                    System.out.println("Amount has been paid successfully. Your order will be ready in few seconds.");
                                }else{
                                    System.out.println("Please try again");
                                }
                            }
                        }
                        n_customers--;
                    }
                }
            } else {
                System.out.println("Restaurant Id is incorrect. Please enter the correct restaurant id");
            }
        } else {
            System.out.println("restaurant id is incorrect. please enter the correct restaurant id");
        }
    }
}