Case Study using OOP concepts and collections in java



Design a software application software for an automated vending machine that manages product inventory, accepts currency(coins and notes), calculates balances, dispenses items, returns proper change, and handles error conditions.

Functional requirements:

* product catalog: supports multiple products with unique names and prices(soda, chips, chocolates)
* inventory tracking: maintain the quantity of each product item and available currency inside the machine
* payment processing: accepts enormous cards and online upi
* selection and dispensing: allow the user to select the products based on item availability dispense the selected item and decrement the stock
* allow the user to cancel the transaction anytime before dispensing
* if the money is less than the price then raise user defines exception that no sufficient fund
* if there is no proper change for the money given by user then raise user defined exception that no proper change available or insufficient change
* if the selected item has 0 stock then raise sold out exception
* if the quantity > stock then raise exception insufficientQuantity



