import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//Anthony Reakoff, Bonus lab 20, 5/2/2018

public class Bonus20 {

	public static void main(String[] args) {
		HashMap<String, Double> menu = new HashMap<>();
		Scanner scnr = new Scanner(System.in);
		ArrayList<String> item = new ArrayList<>();
		ArrayList<Double> price = new ArrayList<>();
		String ans = "y";
		double total = 0;

		menu.put("apple", 0.99);
		menu.put("banana", 0.59);
		menu.put("carrot", 0.79);
		menu.put("donut", 1.99);
		menu.put("elephant ear", 2.99);
		menu.put("fig newton", 3.79);
		menu.put("grapes", 1.59);
		menu.put("hot dogs", 4.99);

		System.out.println("Welcome to Anthony's Market!");
		System.out.println("=================");
		

		do {
			System.out.println("Here is our menu: ");
			for (String thing : menu.keySet()) {
				System.out.printf("%1$-18s %2$-18s%n",thing,menu.get(thing));
			}
					
			System.out.println();
			String s = Validator.getString(scnr, "What item would you like to order? ");
			if (menu.containsKey(s)) {
				System.out.println("Adding " + s + " to cart at " + menu.get(s));
				item.add(s);
				price.add(menu.get(s));
			} else {
				System.out.println("We do not have that item");
			}
			ans = Validator.getString(scnr, "Would you like to add another item? y/n ");
		} while (ans.equalsIgnoreCase("Y"));

		System.out.println("Thank you for your order!");
		System.out.println("Here's what you got:");

		for (int i = 0; i < item.size(); i++) {
			System.out.println(item.get(i) + " " + price.get(i));
			total += price.get(i);

		}
		System.out.println("Your total is " + total + ". Your average cost per item is " + getAvg(total, price.size()));
		System.out.println("Your most expensive item is " + getHighest(price));
		System.out.println("Your least expensive item is " + getLowest(price));

	}

	public static double getAvg(double d, int i) {
		double avg = d / i;
		return avg;
	}

	public static double getHighest(ArrayList<Double> d) {
		double index = 0;
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i) > index) {
				index = d.get(i);
			} else {
				index = index;
			}
		}
		return index;
	}
	public static double getLowest(ArrayList<Double> d) {
		double index = 99999;
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i) < index) {
				index = d.get(i);
			} else {
				index = index;
			}
		}
		return index;
	}
}
