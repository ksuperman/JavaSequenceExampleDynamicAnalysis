
public class SecondClass {
	ThirdClass thirdclass = new ThirdClass();
	public void secondMethod(String test,String test2) {
		secondInnerMethod();
		thirdclass.thirdmethod();
		thirdclass.thirdmethod();
	}
	
	public void secondInnerMethod() {
		secondNestedMethod();
		System.out.println("Second");
	}
	
	public void secondNestedMethod() {
		ThirdClass thirdclass = new ThirdClass();
		thirdclass.thirdmethod();
		System.out.println("Second nested");
	}
	
	public int secondNormalMethod() {
		secondSubNormalMethod();
		return 0;
	}
	
	public boolean secondSubNormalMethod() {
		return true;
	}
}
