/**
 * 
 * @author Mohamed Jama
 *class Student
 */
public class Student {
	//here variables are created.
	private String name;
	private int age;
	private String sex;
	private boolean StudentFees;
	//Fees is 
	private String Fees;
	
	/**
	 * The Students name age and sex is constructed here.
	 * @param n
	 * @param a
	 * @param s
	 */
	public Student(String n, int a, String s){
		name = n;
		age  = a;
		sex = s;
	}
	public void setName(String newName){
		name = newName;
	}
	
	/**
	 * 
	 * @param payment
	 */
	public void PaidFees(boolean payment){
		StudentFees = payment;
		//Here the student payment status is to be determined.
		if(StudentFees == true){
			
			Fees = "Paid";
		}
		else{
			Fees = "Not Paid";
		}
	}
	/**
	 * print method
	 * here the name age sex and fee status is printed in a single line.
	 */
	public void print(){
		System.out.println(name+"\t"+age+"\t"+sex+"\t"+Fees);
		System.out.println(" ");
	}
	
}
