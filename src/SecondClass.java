
public class SecondClass {
	ThirdClass thirdclass = new ThirdClass();
	public void secondMethod(String test,String test2) {
		secondInnerMethod();
		thirdclass.thirdmethod();
		thirdclass.thirdmethod();
	}
	
	private void secondInnerMethod() {
		secondNestedMethod();
		System.out.println("Second");
	}
	
	private void secondNestedMethod() {
		ThirdClass thirdclass = new ThirdClass();
		thirdclass.thirdmethod();
		System.out.println("Second nested");
	}
}
