#Overview

This is a simple and basic restaurant management system.
First, it will read the file which has instructions as to how to operate the program.
File is stored in org.example.instructions.txt for your reference
Pls go through it first

User will first input the restaurant details. Then, the user will input the
branches associated with the restaurant. Then, the user will input the menuitems
associated with the restaurant. Then the user will input the customer details.
Then the user will input the restaurant id from which the customer would like to order.
Then, customer will choose and input the menuitems from that restaurant.
Customer will order the items already in the menu and the menu is already
stored in the existing restaurant by the user.
Order will be generated and each order will be linked with multiple orderItems.
Accordingly, totalamount will be calculated and it will prompt the user to pay
the amount. Once customer inputs the amount, it's considered that payment is made.
Once the payment is made, workflow stops.

#Files and DataStructure
1. instructions.txt - contains instructions to how to run the main class
2. Main.java - Runner Class
2. Restaurant.java - Holds the restaurant details, maps the branches
   to the restaurant, maps the menuitems to the restaurant.
3. ResBranch.java - Holds the details about the restaurant branches, getter
   and setter methods related to that.
4. menuItem.java - Holds the details about the menuitems that are made available
   by the user input in the restaurant. All branches of a restaurant will have the same menu.
5. orderItem.java - Holds individual orders from the menu made by the user, has
   the logic to calculate the total for one item and related
   getter and setter methods.
6. Orders.java - Holds all the orders from the orderitem and has the logic to
   calculate the totalforallitems and related getter and setter methods.
7. Customer.java - Holds the customer details and related getter and setter methods.
   and has the invocation logic that makestheorder, invocation logic to store all the orders to
   orderitems and totalamounttoPay and whether the payment was successful or not.

#Limitation
1. All branches of one restaurant will have the
   same menu.
2. Phone number and Emailid of all the restaurant will remain the same for
   the sake of convenience and simplicity, as my focus is on customer making the orders.
3. No separate user for customer and admin. It's assumed that admin and
   customer will be the same user due to time constraint and for the sake of simplicity.
4. There is no payment class for the sake of simplicity and time constraints. Payment is handled in the customer.java.
   It's assumed that customer will pay via cash.

#Future Scope
1. Will address the limitations.

#References
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object)
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#hashCode()
https://docs.oracle.com/javase/8/docs/api/java/io/File.html
https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
https://site.mockito.org/
https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html
https://junit.org/junit5/docs/current/user-guide/#writing-tests-classes-and-methods
https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
https://docs.oracle.com/javase/8/docs/api/java/util/List.html
https://www.youtube.com/watch?v=lPHjo3EWeGA&list=PLGJny_f99PBLcK-rrOoU1tM3GyRLkFXSg&index=1
https://stackoverflow.com/questions/27785958/iterating-over-key-set-vs-iterating-over-entry-set
