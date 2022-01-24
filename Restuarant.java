//For help creating a random 4 digit number I used Stack Over flow
//Here is a link to the website: https://stackoverflow.com/questions/33577737/how-to-generate-a-random-long-with-4-digits-in-java
package task20;
/**
 * This class stores the information about the restaurant
 * @author Moipati Thoobe
 * @version 3.0
 */

import java.util.Random;

public class Restuarant {
	/**
	 * String value for the restaurant name
	 */
	String restName;
	/**
	 * String value for the restaurant location
	 */
	String restLocation;
	/**
	 * String value for the restaurant contact number
	 */
	String restContact;
	/**
	 * String value for the meal item
	 */
	String mealItem;
	/**
	 * Integer value for the meal quantity
	 */
	int mealQuantity;
	/**
	 * Float value for the meal price
	 */
	float mealPrice;
	/**
	 * String value for the instructions
	 */
	String instructions;
	/**
	 * Float value for the totalAmount
	 */
	float totalAmount;
	
	/**
	 * creating a randomized order number
	 */
	Random rand = new Random();
	/**
	 * String value for the order number
	 */
	String orderNum = String.format("%4d", rand.nextInt(10000));

	/**
	 * method to get the order number
	 * @return returns the order number
	 */
	public String getOrderNum() {
			
		return orderNum;
	}
	
	/**
	 * method to get the restuarant name
	 * @return returns the restuarant name
	 */
	public String getRestName() {
		return restName;
	}
	
	/**
	 * method to set the restuarant name
	 * @param restName restuarant name value
	 */
	public void setRestName(String restName) {
		this.restName = restName;
	}
	
	/**
	 * method to get the restuarant location
	 * @return returns restuarant location
	 */
	public String getRestLocation() {
		return restLocation;
	}
	
	/**
	 * method to set the restuarant location
	 * @param restLocation restuarant location value
	 */
	public void setRestLocation(String restLocation) {
		this.restLocation = restLocation;
	}
	
	/**
	 * method to get the restuarant's contact number
	 * @return returns the restuarant contact number
	 */
	public String getRestContact() {
		return restContact;
	}
	
	/**
	 * method to set the restuarant's contact number
	 * @param restContact restuarant contact value
	 */
	public void setRestContact(String restContact) {
		this.restContact = restContact;
	}
	
	/**
	 * method to get the meal item
	 * @return returns the meal item
	 */
	public String getMealItem() {
		return mealItem;
	}
	
	/**
	 * method to set the meal item
	 * @param mealItem meal item value
	 */
	public void setMealItem(String mealItem) {
		this.mealItem = mealItem;
	}
	
	/**
	 * method to get the meal quantity
	 * @return returns the meal quantity
	 */
	public int getMealQuantity() {
		return mealQuantity;
	}
	
	/**
	 * method to set the meal quantity
	 * @param mealQuantity meal quantity value
	 */
	public void setMealQuantity(int mealQuantity) {
		this.mealQuantity = mealQuantity;
	}
	
	/**
	 * method to get the meal price
	 * @return returns the meal price
	 */
	public float getMealPrice() {
		return mealPrice;
	}
	
	/**
	 * method to set the meal price
	 * @param mealPrice meal price value
	 */
	public void setMealPrice(float mealPrice) {
		this.mealPrice = mealPrice;
	}
	
	/**
	 * method to get any special instructions
	 * @return returns the instructions
	 */
	public String getInstructions() {
		return instructions;
	}

	/**
	 * method to set the special instructions
	 * @param instructions instructions value
	 */
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	/**
	 * method to get the total amount due
	 * @return returns the total amount
	 */
	public float getTotalAmount() {
		return totalAmount;
	}
	
	/**
	 * method to set the total amount due
	 * @param totalAmount total amount value
	 */
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	


}

