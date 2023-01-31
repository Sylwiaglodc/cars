/**
 * @author sylw - srglod
 * CIS175 - Spring 2023
 * Jan 30, 2023
 */
package cars;

import java.util.List;
import java.util.Scanner;

import controller.CarListHelper;
import model.CarList;

/**
 * @author sylw
 *
 */
public class StartCarsProgram {

	static Scanner in = new Scanner(System.in);
	static CarListHelper lih = new CarListHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter a model: ");
		String model = in.nextLine();
		System.out.print("Enter a make: ");
		String make = in.nextLine();
		System.out.print("Enter how many cylinders: ");
		int cylinders = in.nextInt();
		System.out.print("Enter how many liters: ");
		double liters = in.nextDouble();
		System.out.print("Do you have a turbo (True or False): ");
		boolean turbo = in.nextBoolean();
		
		
		CarList toAdd = new CarList(make, model, liters, cylinders, turbo);
		lih.insertItem(toAdd);

	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter a model to delete: ");
		String make = in.nextLine();
		System.out.print("Enter a make to delete: ");
		String model = in.nextLine();
		System.out.print("Enter how many liters to delete: ");
		double liters = in.nextDouble();
		System.out.print("Enter how many cylinders to delete: ");
		int cylinders = in.nextInt();
		System.out.print("delete turbo (true or false)?: ");
		boolean turbo = in.nextBoolean();
		
		CarList toDelete = new CarList(make, model, liters, cylinders, turbo);
		lih.deleteItem(toDelete);

	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Make");
		System.out.println("2 : Search by Model");
		int searchBy = in.nextInt();
		in.nextLine();
		List<CarList> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the make name: ");
			String makeName = in.nextLine();
			foundItems = lih.searchForCarByMake(makeName);
		} else {
			System.out.print("Enter the model name: ");
			String modelName = in.nextLine();
			foundItems = lih.searchForCarByModel(modelName);


		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (CarList l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			CarList toEdit = lih.searchForCarById(idToEdit);
			System.out.println("Retrieved " + toEdit.getModel() + " from " + toEdit.getMake());
			System.out.println("1 : Update Model");
			System.out.println("2 : Update Make");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Make: ");
				String newMake = in.nextLine();
				toEdit.setMake(newMake);
			} else if (update == 2) {
				System.out.print("New Model: ");
				String newModel = in.nextLine();
				toEdit.setModel(newModel);
			}

			lih.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Vrrroooommmmm! Let's look at some cars! ---");
		while (goAgain) {
			System.out.println("*  Select an option:");
			System.out.println("*  1 -- Add a car");
			System.out.println("*  2 -- Edit a car");
			System.out.println("*  3 -- Delete a car");
			System.out.println("*  4 -- View all of our cars!");
			System.out.println("*  5 -- Peel out of this program!");
			System.out.print("*  Your choice: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lih.cleanUp();
				System.out.println("   See ya later!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<CarList> allCars = lih.showAllItems();

		for(CarList singleCar: allCars){
		System.out. println(singleCar.returnCarDetails());
		}
		

	}

}

