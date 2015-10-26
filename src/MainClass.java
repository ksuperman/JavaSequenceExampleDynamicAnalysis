import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
	
	private static BufferedReader inputReader;
	private static String input;
	
	public static void main(String[] args) {
		inputReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Welcome to the Test Harness for Dynamic Sequence Diagram generator");
			System.out.println("Select one of the test below to generate to analyse the flow");
			System.out.println("1) Execute the 'execFlow1' function");
			System.out.println("2) Execute the 'execFlow2' function");
			System.out.println("3) Execute the 'execFlow3' function");
			System.out.println("Enter 'exit' to quit the test Harness!!");
			System.out.println("Please make your choice and press enter !!!");
			while((input = inputReader.readLine()) != null && !input.equals("exit")) {
				switch(input) {
				case "1" :
					System.out.println("Executing the 'execFlow1' function");
					execFlow1();
					System.out.println("Sequence Diagram is Updated, Please check !!!");
					break;
					
				case "2" :
					System.out.println("Executing the 'execFlow2' function");
					execFlow2();
					System.out.println("Sequence Diagram is Updated, Please check !!!");
					break;
					
				case "3" :
					System.out.println("Executing the 'execFlow3' function");
					execFlow3();
					System.out.println("Sequence Diagram is Updated, Please check !!!");
					break;
					
				default:
					System.out.println("This is not a valid Option, please try again!");
					break;
					
				}
				System.out.println("\n\nWelcome to the Test Harness for Dynamic Sequence Diagram generator");
				System.out.println("Select one of the test below to generate to analyse the flow");
				System.out.println("1) Execute the 'execFlow1' function");
				System.out.println("2) Execute the 'execFlow2' function");
				System.out.println("3) Execute the 'execFlow3' function");
				System.out.println("Enter 'exit' to quit the test Harness!!");
				System.out.println("Please make your choice and press enter !!!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private static void execFlow1() {
		
		FirstClass firstClass = new FirstClass();
		firstClass.firstMethod();
		
	}
	
	private static void execFlow2() {
		SecondClass second = new SecondClass();
		second.secondMethod("Second", "flow");
	}
	
	private static void execFlow3() {
		ThirdClass thirdclass = new ThirdClass();
		thirdclass.thirdmethod();
	}

}
