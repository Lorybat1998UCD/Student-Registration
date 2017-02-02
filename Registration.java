import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Mohamed Jama
 *Registration
 */
public class Registration {
	static ArrayList<Student>ComputerScience = new ArrayList<Student>(); 		//Computer Science ArrayList
	
	static ArrayList<Student>GameDesign= new ArrayList<Student>();				//Game Design ArrayList
	
	static Scanner input = new Scanner(System.in);
	
	static DecimalFormat df2 = new DecimalFormat("0.00");
	
	static Student c;

	static boolean PaidFees;
	
	public static void main(String[] args) {
		
		menu();
	}
/**
 * Menu Method here user may choose from a list of commands.
 */
	private static void menu() {
		//A try catch method is implemented here to continue the flow of the machine, without interruption.
		
		/*x is used for the do while loop. if the loop reaches the end of the code x turns into 2 which stops the while from repeating
		 *itself. if it doesn't reach the end the do while loops as long as x equals 1.
		 */
		int x = 1;
		
		do{
		try {															
			Scanner input = new Scanner(System.in);
			System.out.println("Press 1 to Register a Student.");
			System.out.println("Press 2 to View Course.");	
			System.out.println("Press 3 to pay fees.");
			System.out.println("Press 4 to Enter Admin Mode.");
			
			int choice = input.nextInt();
			
			switch(choice){
				case 1:{
					//Add method is called.
					Add();
					menu();
					break;
				}
				case 2:{
					//View method is called.
					View();
					break;
				}
				case 3:{
					//PayStudentFees method is called.
					PayStudentFees();
					break;
				}
				case 4:{
					Admin();
					//Do a total number of Students enrolled,
					break;
				}
				default:{
					System.out.println("Error please choose from 1-4");
				}
			}
			//Once the program reaches here x turns to 2 which stops the while loop from looping the code again. 
			x = 2;
			input.close();
		} 
		
		catch (Exception e) {
			System.out.println("Error Please 1-4 Menu");
		}
		}while(x==1);
		//if x==1 while loop is performed else the program continues to the next series of instruction.
	}
	
	/**
	 * Add method
	 */
	private static void Add() {
		
		//Change to a Firstname, SurName format!
		
		try {
			//The Add method captures Student information. such as name age and course choice
			System.out.println("Please enter first name of student.");		//Identity Input
			String L= input.next();
			System.out.println("Please enter Surname of student.");
			String F=input.next();
			String n = F+" "+L;
			System.out.println("Please Enter Age of Student"); 	
			int a = input.nextInt();
			System.out.println("\tSex:\t1.Male"); 			
			System.out.println("\t\t2.Female");
			int Sex = input.nextInt();
			/*if statement is used so if user input is greater or less than desired input an error message is prompted
			 * and program goes back to the Add() method.
			*/
			if(Sex >2 || Sex < 1){
				System.out.println("Error Invalid Data Entry");
				Add();
			}
			//Here s is set to null ion order to initialize it
			String s = null;							
			if(Sex == 1){
				/*Instead of having User input misspelling male, Int is used for Sex which then using assigns the s String to the appropriate 
				 * Value.The same is done for female.
				*/
				s = "Male";
			}
			else if(Sex==2){
				s = "Female";
			}
			//Here the Course choice menu is displayed.
			System.out.println("Which Course to enroll them in?");		
			System.out.println("Press 1 to enroll on Computer Science.");
			System.out.println("Press 2 to enroll on Game Design.");
			System.out.println("");
			int Course = input.nextInt();
			
			switch(Course){
				case 1:{
					//a PayFees() method is invoked to ask if user wants to pay now or later.
					PayFees();
					//A new Student object is created and values assigned.
					c =new Student(n, a, s);
					if(PaidFees == true){
						//Here if user paid accepted the PayFees() method and payed fees PayedFees.
						boolean payment = true;
						c.PaidFees(payment);
					}
					else{
						//if payment is false then false is passed through which displays Not Paid
						boolean payment = false;
						c.PaidFees(payment);
					}
					CSEnroll();
					break;
				}
				case 2:{
					//a PayFees() method is invoked to ask if user wants to pay now or later.
					PayFees();
					//A new Student object is created and values assigned.
					c =new Student(n, a, s);
					if(PaidFees == true){
						//Here if user paid accepted the PayFees() method and payed fees PayedFees.
						boolean payment = true;
						c.PaidFees(payment);
					}
					else{
						boolean payment = false;
						c.PaidFees(payment);
					}
					GDEnroll();
					menu();
					break;
				}
				default:{																	
					System.out.println("Error Invalid Data Input");
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error Invalid data input try again");
			Add();
		}
	
	}
	private static void PayFees() {
		
		//Pay fees menu display
		try {
			System.out.println("Whould you like to pay fees fully now?");
			System.out.println("Press 1 for Yes.");
			System.out.println("Press 2 for No, pay Later.");
			int PayFees = input.nextInt();
			 
			switch(PayFees){
				case 1:{
					//if user chooses yes they continue with the payment process.
					Transaction();
					break;
				}
				case 2:{
					System.out.println("You chose to pay later");
					//if else user does not chooses to pay now PaidFees is declared as false, meaning not paid and they continue on with the program.
					PaidFees = false;
					break;
				}
				default:{
					System.out.println("Error invalid data entry, please choose from 1-2");
				}
			}
		} catch (Exception e) {
			//if an invalid data type is inserted the Exception is caught here and an error message is prompted.
			System.out.println("Error Systemt Exit!");
			PayFees();
		}

	}
/**
 * The transaction is completed here.
 * Transaction Method
 */
	private static void Transaction() {
			/*test is used for the do while loop. if the loop reaches the end of the code test turns into 2 which stops the while from repeating
			 *itself. if it doesn't reach the end the do while loops as long as test equals 1.
			 */
			int test = 1;
		do{	
		try {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("Amount is $500");
			
			//price is set here.
			double price = 500.00;
			
			double Money$ = input.nextDouble();
			
			/*if Money$ is less than price then the program calculates how much is left by subtracting it from price.
			 * The user is asked to input the remaining value, again if Money$ is less than price the program subtract
			 * it from the price and gives out how much remains. This loops until the program is satisfied.
			 */
			while(Money$ < price){
				System.out.println("Remaining amount is "+  df2.format((float)price-Money$));
				System.out.println("Or type a letter to cancel transaction.");
				double cashInput = input.nextDouble();
				
				if(cashInput > 0){
					//cashInput is greater than zero therefore it is added to numEnt
					Money$ = Money$+cashInput;
				}
					
			}
			
			if(Money$>=price){

				double Change = Money$-price;
				System.out.println("Change: "+ df2.format((float)Change));
				PaidFees = true;	
			}
			//if the program runs successfully to this point test is turned to 2 which when it reaches the while it stops.
			test = 2; 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error data entry");
		}
		}
		while(test==1);
			//if test is turned to 2 while loop ends.	
	}
	private static void CSEnroll() {
		//Here the Student c is add to the ComputerScience Course ArrayList.
		ComputerScience.add(c);
	}
	private static void GDEnroll() {
		//Here the Student c is add to the GameDesign Course ArrayList.
		GameDesign.add(c); 
	}
	/******
	 * here user is able to view students enrolled in ComputerScience or GameDesign
	 * View method
	 */
	private static void View() {
		System.out.println("Choose class to view");
		System.out.println("1. Computer Science");
		System.out.println("2. Game Design");
		int viewChoice = input.nextInt();
		
		switch(viewChoice){
			case 1:{
				System.out.println("Computer Science");
				for(Student i:ComputerScience){
					i.print();
				}
				break;
			}
			case 2:{
				System.out.println("Game Design");
				for(Student i:GameDesign){
					i.print();
				}
				break;
			}
			default:{
				System.out.println("Error");
				View();
				break;
			}
		}
		
		menu();
	}
	/**
	 * able to choose which course student to pay.
	 * PayStudentFees Method
	 */
	private static void PayStudentFees() {
		try {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("Choose Course of Student.");
			System.out.println("Press 1 for Computer Science.");
			System.out.println("Press 2 for Game Design.");
			int CourseChoice = input.nextInt();
			
			switch(CourseChoice){
				case 1:{
					//if user chooses to pay for Computer Science course student CompSciStudentFees() method is called.
					CompSciStudentFees();
					menu();
					break;
				}
				case 2:{
					//if user chooses to pay for Game Design course student GDStudentFees() method is called.
					GDStudentFees();
					menu();
					break;
				}
				default:{
					System.out.println("Error please choose from 1-2");
					PayStudentFees();
				}
			}
		} catch (Exception e) {
			System.out.println("Error invalid data type.");
			menu();
		}
	}
	private static void GDStudentFees() {
		//Here index is set to 0.
		try {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			int index = 0;
			for(Student i:GameDesign){
				//Game Design course is displayed with the index number every loop.
				System.out.println("Roll No \t"+index+"\t");
				i.print();
				//Once loop completes index is added by one.
				index++;
			}
			System.out.println("Choose Roll No of student to pay for");
			int RollNo = input.nextInt();
			index = 0;
			for(Student i:GameDesign){
				if(RollNo == index){
					System.out.println("transaction:!!");//Header
					Transaction();
					//payment is set to true therefore making authenticating the payment as valid.
					boolean payment = true;
					//PaidFees on i is added as true payment.
					i.PaidFees(payment);
				}
				//Index is incremented by. 
				index++;
			}
		} catch (Exception e) {
			//if user inputed wrong data type an error message is displayed, the program then goes back to the menu.
			System.out.println("Error invalid data entry");
		}
	}
	private static void CompSciStudentFees() {
				try {
					@SuppressWarnings("resource")
					Scanner input = new Scanner(System.in);
					int index = 0;
					for(Student i:ComputerScience){
						//here the index is printed by each individual students name age fee status.
						System.out.print("Roll No \t"+index+"\t");
						i.print();
						index++;
						//Once loop completes index is added by one.
					}
					System.out.println("Choose roll number of student to pay for.");
					int RollNo = input.nextInt();
					index = 0;
					for(Student i:ComputerScience){
					//If the user input equals to the index payment for that specific student is made, only.
					if(RollNo == index){
						System.out.println("**transaction**");//Header
						Transaction();
						//payment is set to true therefore making authenticating the payment as valid.
						boolean payment = true;
						//PaidFees on i is added as true payment.
						i.PaidFees(payment);
					}
					//index is incremented here. 
					index++;
					}
				} catch (Exception e) {
					//if user inputed wrong data type an error message is displayed, the program then goes back to the menu.
					System.out.println("Error invalid data entry");
				}
	}
	private static void Admin() {
		try {
			System.out.println("Press 1 to change Student Details.");
			System.out.println("Press 2 to delete Student from Course.");
			System.out.println("Press 3 to go back to menu.");
			int AdminChoice = input.nextInt();
			//user input is captured here
			switch(AdminChoice){
				case 1:{
					EditDetails();
					menu();
					break;
				}
				case 2:{
					DeleteStudent();
					menu();
					break;
				}
				case 3:{
					menu();
					break;
				}
				default:{
					System.out.println("Error please enter from 1-3");
				}
			}
		} catch (Exception e) {
			System.out.println("Error Invalid data entry");
			Admin();
		}
	}
	private static void EditDetails() {
		try {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("Choose the student Course which you want to edit student details.");
			System.out.println("Press 1 for Computer Science.");
			System.out.println("Press 2 for Game Design.");
			int EditCourse = input.nextInt();
			
			switch(EditCourse){
				case 1:{
					//if user chooses to pay for Computer Science course student CompSciStudentFees() method is called.
					//Here i initialize index as 1.
					int index = 0;
					for(Student i:ComputerScience){
						
						System.out.print("Roll No \t"+index+"\t");
						i.print();
						//index is incremented here to go to add 1 to next student Roll No.
						index++;
					
						//Once loop completes index is added by one.
					}
					System.out.println("Choose Roll No of student to edit details.");
					int edit = input.nextInt();
					index = 0;
					for(Student i:ComputerScience){
						if(index == edit){
							System.out.println("Edit First name");
							String f = input.next();
							System.out.println("Change Surname.");
							String s = input.next();
							String newName = f+" " + s;
							i.setName(newName);
						}
						//index is incremented by one so program prints correct rollno.
						index++;
					}
					break;
				}
				case 2:{
					//if user chooses to pay for Game Design course student GDStudentFees() method is called.
					//Here i initialize index as 1.
					int index = 0;
					for(Student i:GameDesign){
						
						System.out.print("Roll No \t"+index+"\t");
						i.print();
						//index is incremented here to go to add 1 to next student Roll No.
						index++;
					}
					System.out.println("Choose Roll No of student to edit details.");
					int edit = input.nextInt();
					index = 0;
					for(Student i:GameDesign){
						if(index == edit){
							System.out.println("Edit First name");
							String f = input.next();
							System.out.println("Change Surname.");
							String s = input.next();
							String newName = f+" " + s;
							i.setName(newName);
						}
						//index is incremented by one so program prints correct rollno.
						index++;
				
					}
					break;
				}
				default:{
					System.out.println("Error please choose from 1-2");
					EditDetails();
				}
			}
		} catch (Exception e) {
			System.out.println("Error invalid data entry.");
			menu();
		}
		
	}
	private static void DeleteStudent() {
		try {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("Choose the student Course which you want to delete from.");
			System.out.println("Press 1 for Computer Science.");
			System.out.println("Press 2 for Game Design.");
			int DeleteCourse = input.nextInt();
			
			switch(DeleteCourse){
				case 1:{
					//if user chooses to pay for Computer Science course student CompSciStudentFees() method is called.
					//Here i initialize index as 1.
					int index = 1;
					for(Student i:ComputerScience){
						
						System.out.print("Roll No \t"+index+"\t");
						i.print();
						//index is incremented here to go to add 1 to next student Roll No.
						index++;
					}
					System.out.println("Choose Roll No of student to delete.");
					int delete = input.nextInt();
					//the user enters the roll no to delete. that index is then removed from the ComputerScience list.
					ComputerScience.remove(delete-1);
					break;
				}
				case 2:{
					//if user chooses to pay for Game Design course student GDStudentFees() method is called.
					int index = 1;
					for(Student i:GameDesign){
						
						System.out.print("Roll No \t"+index+"\t");
						i.print();
						//index is incremented here to go to add 1 to next student Roll No.
						index++;
					}
					System.out.println("Choose Roll No of student to delete.");
					int delete = input.nextInt();
					
					GameDesign.remove(delete-1);
					break;
				}
				default:{
					System.out.println("Error please choose from 1-2");
					DeleteStudent();
				}
			}
		} catch (Exception e) {
			System.out.println("Error invalid data entry.");
			menu();
		}
	}
}
