# Campus-Textbook-Store

Write a Java application that will allow a user to manage the inventory of a store that sells textbooks.

The inventory for the video store will contain the following information for each textbook
(each title) in the inventory:
  SKU 	(stock-keeping unit, an integer, must be unique)
  title 	(may contain spaces in it)
  price 	(dollars and cents, greater than 0)
  quantity 	(number of copies in inventory, greater than or equal to 0)

The program should offer the user a menu (do this however you wish) with the following options:
1.	Add a textbook to the inventory (prompt user for input values in this order: sku, title, price, quantity).
2.	Remove a textbook from the inventory (by sku).
3.	Display the information for a textbook (given the sku).
4.	Display the inventory in a table (in any order).

The program should perform the menu operation selected. If the operation fails (i.e. attempt to remove a textbook not in the inventory) your program should display an error message
