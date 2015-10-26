import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
	
	private static BufferedReader inputReader;
	private static String input;
	
	public static void main(String[] args) {
		inputReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Welcome to the El");
			while((input = inputReader.readLine()) != null && !input.equals("exit")) {
				switch(input) {
				case "1" :
					execFlow1();
					break;
					
				case "2" :
					execFlow2();
					break;
					
				case "3" :
					execFlow3();
					break;
					
				default:
					break;
					
				}
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
