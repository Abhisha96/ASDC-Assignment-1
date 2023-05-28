package org.example;

import java.util.*;
/*
This is the main class. Run this class first.
This class is used for storing the restaurant-information and interaction with the customer on console.
 */
public class Main {
    public static void main(String[] args) {
        /*
         Adds a restaurant name. One restaurant id is mapped to only one restaurant name.
         */
        Restaurant r = new Restaurant();

        // Take the input from the user to enter the no. of restaurants
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of restaurants");
        int n_res = sc.nextInt();

        for(int i=1; i<=n_res;i++){
            // Enter the restaurant Id
            System.out.println("Enter the restaurant Id");
            int res_id = sc.nextInt();
            // Enter the restaurant name
            System.out.println("Enter the restaurant name");
            String res_name = sc.next();
            //Bind the restaurant id with the restaurant name
            // e.g. r.addResname(1, "Pizza Pizza");
            r.addResname(res_id,res_name);
        }
        /*
         1 restaurant id can have many branches.
         Here, limitation is that user can add multiple branches for only one restaurant.
         For eg. For restaurant id - 1 - whose res_name is "Pizza Pizza", can have multiple branches.
         */
        ResBranch rb = new ResBranch();
        Map<Integer,String> res_branch_loc = new HashMap<>();

        System.out.println("Enter the restaurant id for which you would like to enter the branch location");
        int res_id_branch = sc.nextInt();

        System.out.println("How many branch locations you would like to add for the restaurant with the id"+""+"res_id_branch+"+""+r.getResnames(res_id_branch));
        int n_branches = sc.nextInt();

        for(int i=1;i<=n_branches;i++){
            System.out.println("Enter the branch id for"+r.getResnames(res_id_branch));
            int branch_id = sc.nextInt();

            System.out.println("Enter the branch name for"+r.getResnames(res_id_branch));
            String branch_name = sc.next();
            res_branch_loc.put(branch_id,branch_name);
        }
        // restaurant id is binded to the above n_branches no. of locations.
        rb.addBranchLoc(res_id_branch,res_branch_loc);
        // Contact number will be common to all the restaurant branches, belonging to one restaurant
        rb.addBranchContact("8128395206", "ab@gmail.com");
        rb.resIdBranchId(res_id_branch,rb.getBranchId());
        // binds the branch to the restaurant name
        r.addResBranch(res_id_branch,rb);

        // Add menu-items to the restaurant
        menuItem mi = new menuItem();

        System.out.println("Enter the restaurant id for which you would like to enter the menuItems");
        int res_id_menu = sc.nextInt();

        System.out.println("How many menuitems you would like to enter for"+""+res_id_menu+""+r.getResnames(res_id_menu));
        int n_menuitems = sc.nextInt();

        for(int i=1;i<=n_menuitems;i++){
            System.out.println("Enter the menuitem Id ( In String )");
            String menu_item_id = sc.next();

            System.out.println("Enter the menuitem Name");
            String menu_item_name = sc.next();

            System.out.println("Enter the price of the menuitem Name");
            double menu_item_price = sc.nextDouble();

            mi.setMenuitemDetails(menu_item_id,menu_item_name, menu_item_price);
        }

       // adds the restaurant menu items to the restaurant.
        r.addResmenu(res_id_menu,mi);

        System.out.println(mi.getMenuitemName("m1"));
        System.out.println(mi.getMenuitemPrice("m1"));

        //   mi.getMenuItemById("m1",mi.getMenuitemName("m1"));
        System.out.println("value is"+r.getResmenulistbyId(1));

        // add customer details to the restaurant
        System.out.println("Enter your name");
        String customer_name = sc.next();
        System.out.println("Enter your contact number");
        String contact_number = sc.next();
        Customer c1 = new Customer("C1",customer_name,contact_number);

        System.out.println("Which restaurant you would like to go from the following");
        int res_id = sc.nextInt();
        System.out.println("which branch you want to visit of this restaurant");
        int branch_id = sc.nextInt();

        System.out.println("Restaurant name is"+c1.goestoRestaurant(r.getResnames(res_id)));
        System.out.println("Branch name is"+c1.goestoRestaurantBranch(rb.getBranchName(res_id,branch_id)));

        System.out.println("how many orders you would like to order");

        int menu_choices = sc.nextInt();
        while(menu_choices!=0) {
            System.out.println("what would like to order");
            String menu_id = sc.next();
            System.out.println("how many quantity");
            int quantity = sc.nextInt();
            c1.makeOrders(menu_id,quantity,mi);
            menu_choices--;
        }
        Double amounttoPay = c1.amounttoPay();
        System.out.println("Amount to pay is"+amounttoPay+"please make the payment in cash");
        System.out.println("Enter the amount that you want to pay");
        Double customerAmount = sc.nextDouble();
        Boolean amountPaid = c1.makePayment(customerAmount,amounttoPay);
        if(amountPaid){
            System.out.println("Amount has been paid successfully. Your order will be ready in few seconds.");
        }else{
            System.out.println("Amount to be paid by customer"+amounttoPay);
        }
    }
}