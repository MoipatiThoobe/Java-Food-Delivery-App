/**
 * This is code for a food delivery system.
 * The user can create a profile as well as update it
 * The user can place an order and search their order history
 * All of the information stored in a database called QuickFoodMS
 * <p>
 * @author Moipati Thoobe
 * @version 3.0
 */
package task20;
import java.util.Scanner;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.*;




public class Main {
	public static void main(String[] args) {
		//declaring attributes 
		/**
		 * String value to store user input
		 */
		String input;
		/**
		 * Scanner object for user input
		 */
		Scanner scanner = new Scanner(System.in);
		/**
		 * String value for menu item selection
		 */
		String item;
		/**
		 * String value for restaurant selection
		 */
		String rest;
		/**
		 * Integer value to store restaurant id
		 */
		int rid = 0;
		/**
		 * String value for customer invoice
		 */
		String invoice;
		/**
		 * Integer value to store customer's id
		 */
		int cid;
		/**
		 * Integer value to store the driver's id
		 */
		int driverid;
		/**
		 * Integer value to test if query has executed
		 */
		int x;
		
		
		
		
		/**
		 * arraylist to store menu items from Restuarant 1 
		 */
		ArrayList<String> menu1 = new ArrayList<String>();
		menu1.add("A.Chicken Alfredo");
		menu1.add("B. Sushi Platter");
		menu1.add("C.Lambshank & mash");
				
		/**
		 * arraylist to store menu items from restuarant 2 
		 */
		ArrayList<String> menu2 = new ArrayList<String>();
		menu2.add("D. Margerita Pizza");
		menu2.add("E. MeatLover's Delight");
		menu2.add("F. Pepperoni Pizza");
				
		/**
		 * arraylist to store menu items from restuarant 3 
		 */
		ArrayList<String>menu3 = new ArrayList<String>();
		menu3.add("G.Original Burger");
		menu3.add("H. Spicy Chicken Burger");
		menu3.add("I. Double Cheese Burger");
				
				
		/**
		 *The welcome page of the app	
		 */
		System.out.println("Welcome to the delivery app");
		System.out.println("Please note you cannot place an order without having a customer profile");
		System.out.println("1.Create customer profile");
		System.out.println("2.Place an order");
		System.out.println("3.Update customer profile");
		System.out.println("4.Search order history");
		System.out.println("5.Quit");
				
		/**
		 * user input to select an option
		 */
		input = scanner.nextLine();
		
		/**
		 * do while loop for the for the different options of the app
		 */
		do {
			/**
			 * if the user selects 1 they will create their user profile
			 */
			if(input.equals("1")) {
				/**
				 * Customer enters their details
				 */
				Customer c1 = new Customer();
				System.out.println("Please enter your name: ");
				c1.setCustName(scanner.nextLine());
				System.out.println("Please enter your phone number: ");
				c1.setCustNum(scanner.nextLine());
				System.out.println("Please enter your address: ");
				c1.setCustAddress(scanner.nextLine());
				System.out.println("Please enter your location");
				c1.setCustLocation(scanner.nextLine());
				System.out.println("Please enter your email address: ");
				c1.setCustEmail(scanner.nextLine());
			
				//storing the customer details in variables
				/**
				 * String value for customer name
				 */
				String cName = c1.getCustName();
				/**
				 * String value for customer phone number
				 */
				String cNum = c1.getCustNum();
				/**
				 * String value for customer address
				 */
				String cAddress = c1.getCustAddress();
				/**
				 * String value for customer location
				 */
				String cLocation = c1.getCustLocation();
				/**
				 * String value for customer email address
				 */
				String cEmail = c1.getCustEmail();
				
			
			/**
			 * try catch to insert the customer into the database
			 */
			try {
				/**
				 * connecting to the database
				 */
				Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=QuickFoodMS",
						"moi123", "12345");
				/**
				 * String value for the insert statement
				 */
				String insert = "INSERT INTO customers VALUES(?,?,?,?,?);";
				
				/**
				 * create the sql preparedstatement
				 */
				PreparedStatement instmt = connection.prepareStatement(insert);
				instmt.setString(1, cName);
				instmt.setString(2, cNum);
				instmt.setString(3, cAddress);
				instmt.setString(4, cLocation);
				instmt.setString(5, cEmail);
				
				/**
				 * execute the preparedstatement
				 */
				 x = instmt.executeUpdate();
				
				/**
				 * if statement to test if the query executed
				 */
				if(x == 0) 
					System.out.println("Your customer profile was not created");
				else
					System.out.println("Your customer profile was created");
					break;
			}
			/**
			 * @exception catch SQLException
			 */
			catch (SQLException e) {
				e.printStackTrace();
				System.out.println("There is an error");
			}
			
			}
			/**
			 * <p>
			 * if the user selects 2 they will place an order
			 */
			if(input.equals("2")) {
				/**
				 * the user is asked if they have a customer profile
				 */
				System.out.println("Do you have a customer profile?(y/n)");
				/**
				 * String value for the user input
				 */
				String ans = scanner.nextLine();
				//if they do not they are asked to create a customer profile
				if(ans.equals("n")) {
					System.out.println("Please create a customer profile before placing an order");
					break;
				}
				/**
				 * <p>
				 * if they have one they are asked to enter their name
				 */
				else if(ans.equals("y")) 
					System.out.println("Please enter your name:");
					/**
					 * String value for the customer's name
					 */
					String cName = scanner.nextLine();
					/**
					 * store the customer's id
					 */
					cid = getCustomerid(cName);
				

				/**
				 * user selects a restaurant by entering a number
				 */
				System.out.println("Please press a number to select a restuarant");
				System.out.println("1.The Olive Tree");
				System.out.println("2.Le Pizzeria");
				System.out.println("3.The Burger Place");
				
				/**
				 * String value for the user input
				 */
				rest = scanner.nextLine();
				Restuarant r1 = new Restuarant();
				switch(rest) {
				case "1":
					r1.setRestName("The Olive Tree");
					r1.setRestLocation("Johannesburg");
					r1.setRestContact("0126789435");
					System.out.println("Please select the letter of a  menu item");
					System.out.println(menu1);
					rid = 1;
					break;
				case "2":
					r1.setRestName("Le Pizzeria");
					r1.setRestLocation("Johannesburg");
					r1.setRestContact("0127549863");
					System.out.println("Please select the letter of a menu item");
					System.out.println(menu2);
					rid = 2;
					break;
				case"3":
					r1.setRestName("The Burger Place");
					r1.setRestLocation("Johannesburg");
					r1.setRestContact("0128856709");
					System.out.println("Please select the letter of a menu item");
					System.out.println(menu3);
					rid = 3;
					break;
				default:
					r1.setRestName(null);
					r1.setRestLocation(null);
					r1.setRestContact(null);
				
				}
				
				/**
				 * String value for user input
				 */
				item = scanner.nextLine();
				
				/**
				 * switch statement to choose a menu item
				 */
				switch(item) {
				case "A":
					r1.setMealItem("Chicken Alfredo");
					r1.setMealPrice(85);
					System.out.println("How many would you like?");
					r1.setMealQuantity(scanner.nextInt());
					System.out.println("Any special instructions");
					r1.setInstructions(scanner.next());
					break;
				case "B":
					r1.setMealItem("Sushi Platter");
					r1.setMealPrice(120);
					System.out.println("How many would you like?");
					r1.setMealQuantity(scanner.nextInt());
					System.out.println("Any special instructions");
					r1.setInstructions(scanner.next());
					break;
				case "C":
					r1.setMealItem("Lamb Shank & Mash");
					r1.setMealPrice(160);
					System.out.println("How many would you like?");
					r1.setMealQuantity(scanner.nextInt());
					System.out.println("Any special instructions");
					r1.setInstructions(scanner.next());
					break;
				case "D":
					r1.setMealItem("Margerita Pizza");
					r1.setMealPrice(80);
					System.out.println("How many would you like?");
					r1.setMealQuantity(scanner.nextInt());
					System.out.println("Any special instructions");
					r1.setInstructions(scanner.next());
					break;
				case "E":
					r1.setMealItem("Meatlover's Delight");
					r1.setMealPrice(110);
					System.out.println("How many would you like?");
					r1.setMealQuantity(scanner.nextInt());
					System.out.println("Any special instructions");
					r1.setInstructions(scanner.next());
					break;
				case "F":
					r1.setMealItem("Pepperoni Pizza");
					r1.setMealPrice(90);
					System.out.println("How many would you like?");
					r1.setMealQuantity(scanner.nextInt());
					System.out.println("Any special instructions");
					r1.setInstructions(scanner.next());
					break;
				case "G":
					r1.setMealItem("Original Burger");
					r1.setMealPrice(65);
					System.out.println("How many would you like?");
					r1.setMealQuantity(scanner.nextInt());
					System.out.println("Any special instructions");
					r1.setInstructions(scanner.next());
					break;
				case "H":
					r1.setMealItem("Spicy Chicken Burger");
					r1.setMealPrice(75);
					System.out.println("How many would you like?");
					r1.setMealQuantity(scanner.nextInt());
					System.out.println("Any special instructions");
					r1.setInstructions(scanner.next());
					break;
				case "I":
					r1.setMealItem("Double Cheese Burger");
					r1.setMealPrice(85);
					System.out.println("How many would you like?");
					r1.setMealQuantity(scanner.nextInt());
					System.out.println("Any special instructions");
					r1.setInstructions(scanner.next());
					break;
				default:
					r1.setMealItem(null);
					r1.setMealPrice(0);
					break;
				}
				
				//declaring variables for the customer's order
				/**
				 * String value for the order number
				 */
				String orderNum = r1.getOrderNum();
				/**
				 * String value for the meal item
				 */
				String mealItem = r1.getMealItem();
				/**
				 * Float value for the meal price
				 */
				float mealPrice = r1.getMealPrice();
				/**
				 * Integer value for the meal quantity
				 */
				int qty = r1.getMealQuantity();
				/**
				 * Float value for the total price
				 */
				float totalPrice = mealPrice * qty;
				/**
				 * String value for the instructions
				 */
				String instructions = r1.getInstructions();
				/**
				 * String value for the restaurant's location
				 */
				String rLocation = r1.getRestLocation();
				/**
				 * Integer value to store the driver's id
				 */
				driverid = getDriverid(rLocation);
				
				/**
				 * try catch to insert the order into the database
				 */
				try {
					/**
					 * connect to the database
					 */
					Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=QuickFoodMS",
							"moi123", "12345");
					
					/**
					 * the INSERT statement
					 */
					String insert = "INSERT INTO mealOrders VALUES(?,?,?,?,?,?,?,?)";
					
					/**
					 * Create the sql preparedstatement
					 */
					PreparedStatement inState = connection.prepareStatement(insert);
					inState.setString(1, orderNum);
					inState.setString(2, mealItem);
					inState.setFloat(3, totalPrice);
					inState.setInt(4, qty);
					inState.setString(5, instructions);
					inState.setInt(6, cid);
					inState.setInt(7, rid);
					inState.setInt(8, driverid);
					
					/**
					 * execute the preparedstatement
					 */
					x = inState.executeUpdate();
					
					/**
					 * the invoice the customer receives when the order is complete
					 */
					invoice = "Customer name: " + cName;
					invoice += "\nYou have ordered: " + mealItem;
					invoice += "\nYou need to pay: R" + totalPrice;
					
					
					/**
					 * if statement to test if the query executed
					 */
					if(x == 0) 
						System.out.println("Something went wrong...");
					else
						System.out.println(invoice);
						break;
			
				}
				/**
				 * @exception catch SQLException
				 */
				catch(SQLException e) {
					e.printStackTrace();
					System.out.println("There has been an error");
				}
				
				
			}
			/**
			 * if the user selects 3 they can update their customer profile
			 */
			if(input.equals("3")) {
				/**
				 * the user is asked to enter the name of the customer they would like to update
				 */
				System.out.println("Please enter the full name of the customer you want to update");
				/**
				 * String value to store the name
				 */
				String name = scanner.nextLine();
				//the user is asked to enter the new details
				System.out.println("Please enter the new details");
				System.out.println("Your phone number:");
				/**
				 * String value to store the phone number
				 */
				String number = scanner.nextLine();
				System.out.println("Your address:");
				/**
				 * String value to store the address
				 */
				String address = scanner.nextLine();
				System.out.println("Your location:");
				/**
				 * String value to store the location
				 */
				String location = scanner.nextLine();
				System.out.println("Your email:");
				/**
				 * String value to store the email address
				 */
				String email = scanner.nextLine();
				
				/**
				 * try catch to update the customer information in the database
				 */
				try {
					/**
					 * connect to the database
					 */
					Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=QuickFoodMS",
							"moi123", "12345");
					
					/**
					 * String value to store the update statement
					 */
					String update = "Update customers SET cNum = ?, cAddress = ?, cLocation = ?, cEmail = ? WHERE cName = ?";
					
					/**
					 * create the sql preparedstatement
					 */
					PreparedStatement upstmt = connection.prepareStatement(update);
					upstmt.setString(1, number);
					upstmt.setString(2, address);
					upstmt.setString(3, location);
					upstmt.setString(4, email);
					upstmt.setString(5, name);
					
					/**
					 * execute the preparedstatement
					 */
					x = upstmt.executeUpdate();
					
					/**
					 * if statement to test if the query executed
					 */
					if(x == 0)
						System.out.println("Customer information could not be updated");
					else
						System.out.println("Customer information was updated");
						break;
				}
				/**
				 * @exception catch SQLException
				 */
				catch(SQLException e) {
					e.printStackTrace();
					System.out.println("There is an error");
					
				}
				
			}
			/**
			 * <p>
			 * if the user selects 4 they can search their order history
			 */
			if(input.equals("4")) {
				/**
				 * the user is asked to enter their name
				 */
				System.out.println("Please enter your name:");
				/**
				 * String value to store the user input
				 */
				String cName = scanner.nextLine();
				/**
				 * get the customer's id
				 */
				cid = getCustomerid(cName);
				
				/**
				 * try catch to search for the orders in the database
				 */
				try {
					/**
					 * connect to the database
					 */
					Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=QuickFoodMS",
							"moi123", "12345");
					
					/**
					 * the results of the queries
					 */
					ResultSet results;
					
					/**
					 * String value to for SELECT statement
					 */
					String search = "SELECT ordernum, mealItem, mealPrice, qty, instructions FROM mealOrders WHERE CID = ?";
					
					/**
					 * create the sql preparedstatement
					 */
					PreparedStatement searchState = connection.prepareStatement(search);
					searchState.setInt(1, cid);
					
					/**
					 * execute the preparedstatement and store it in results
					 */
					results = searchState.executeQuery();
					
					/**
					 * while loop to print out the results of the query
					 */
					while(results.next()) {
						System.out.println(results.getString("ordernum") + " " + results.getString("mealItem")
						+ " " + results.getFloat("mealPrice") + " " + results.getInt("qty") + " " + results.getString("instructions"));
					}
					break;
				}
				/**
				 * @exception catch SQLException
				 */
				catch(SQLException e) {
					e.printStackTrace();
					System.out.println("There is an error");
				}
				
			}
		/**
		 * End the do while loop
		 */
		}while(!input.equals("5"));
		
		
	}

/**
 * method to get the id of the driver based on their location
 * @param location restaurant location value
 * @return returns the driverid
 */
public static int getDriverid(String location) {
		/**
		 * Integer value for the driverid
		 */
		int driverid = 0;
		/**
		 * try catch to get the driver's id in the driver table
		 */
		try {
			/**
			 * connect to the database
			 */
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=QuickFoodMS",
					"moi123", "12345");
			/**
			 * store the results
			 */
			ResultSet results;
			
			/**
			 * String value for the select statement
			 */
			String getDriver = "SELECT TOP (1) driverid FROM drivers WHERE dLocation = ?";
			
			/**
			 * create the sql preparedstatement
			 */
			PreparedStatement pstate = connection.prepareStatement(getDriver);
			pstate.setString(1, location);
			
			/**
			 * execute the query and store the results
			 */
			results = pstate.executeQuery();
			
			/**
			 * loop through the results and store in the variable
			 */
			while(results.next()) {
				driverid = results.getInt("driverid");
			}
		}
		/**
		 * @exception catch SQLException
		 */
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return driverid;
		
		
	}

	
/**
 * method to get the customer's id	
 * @param name customer name value
 * @return returns the customer id
 */
public static int getCustomerid(String name) {
	/**
	 * variable to store the customer id
	 */
	int cid = 0;
	
	/**
	 * try catch to get the customer's id in the customer table
	 */
	try {
		/**
		 * connect to the database
		 */
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=QuickFoodMS",
				"moi123", "12345");
		/**
		 * store the results
		 */
		ResultSet results;
		
		/**
		 * String value for the select statement
		 */
		String getCID = "SELECT CID FROM customers WHERE cName= ?";
		
		/**
		 * create the sql preparedstatement
		 */
		PreparedStatement pstate = connection.prepareStatement(getCID);
		pstate.setString(1, name);
		
		/**
		 * execute the preparedstatement and store in results
		 */
		results = pstate.executeQuery();
		
		/**
		 * loop through the results and store in the variable
		 */
		while(results.next()) {
			cid = results.getInt("CID");
		}
	}
	/**
	 * @exception catch SQLException
	 */
	catch(SQLException e) {
		e.printStackTrace();
	}
	
	return cid;
	
	
}

	
		

}
				
		
		
		
		

	


	