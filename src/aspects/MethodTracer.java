package aspects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class MethodTracer{
	
	private static Stack<MethodInstance> executionStacks = new Stack<MethodInstance>();
	SequenceDiagramGenerator executionSequenceDiagram = null;
	
	public MethodTracer() {
		MethodInstance method = new MethodInstance("Programmer", null , "Output" , "Compile and Execute", null, "");
		executionStacks.push(method);
	}
	
	public void addInstance(String jointPointLongString, String className, String methodName,String methodModifiers,Object[] methodparameters, String returntype) {
		//System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		MethodInstance currentMethod = null;
		MethodInstance previousMethod = null;
		ArrayList<String> methodmodifiersArr = new ArrayList<String>(Arrays.asList(methodModifiers.split(" ")));
		ArrayList<String> methodParametersArr = new ArrayList<String>();
		for(Object parameter : methodparameters) {
			if(parameter instanceof int[]){
				for(int number : (int[])parameter) {
					methodParametersArr.add(Integer.toString(number));
				}
			}else if(parameter instanceof String[]) {
				for(String param : (String[])parameter) {
					methodParametersArr.add(param);
				}
			}else {
				methodParametersArr.add(parameter.toString());
			}
		}
		
		currentMethod = new MethodInstance(className, methodmodifiersArr,returntype, methodName, methodParametersArr, jointPointLongString);
		executionStacks.push(currentMethod);
		
		//System.out.println(executionStacks.peek().toString() + " Added to the Execution stack.");
		
		//System.out.println("Current Stack contents size are ===> " + executionStacks.size() );
/*		Iterator<MethodInstance> executionStackItr = executionStacks.iterator();
		while(executionStackItr.hasNext()) {
			MethodInstance currmethod = executionStackItr.next();
			System.out.println(currmethod.toString());
		}
		//System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
*/		
		previousMethod = executionStacks.get(executionStacks.size()-2);
		
		if(executionSequenceDiagram == null)
			executionSequenceDiagram = new PlantUMLSequenceDiagram(executionStacks);
		else {
			executionSequenceDiagram.instanciateNewMethodFlow(executionStacks);
		}
	}
	
	public void removeInstance(String jointPointLongString, String className, String methodName,String methodModifiers,Object[] methodparameters,String returntype) {
		executionSequenceDiagram.endMethodFlow(executionStacks);
		executionStacks.pop();
/*		System.out.println("----------------------------------------");
		System.out.println(executionStacks.pop().toString() + " is removed to the Execution stack.");
		System.out.println("----------------------------------------");*/
	}
	
}


/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Current Stack contents are ===> 
Current Stack contents size are ===> 6
Programmer : Compile and Execute()
MainClass : public static main("Command Line Argument1")
FirstClass : public firstMethod()
SecondClass : public secondMethod("Sending", "Two")
SecondClass : private secondInnerMethod()
SecondClass : private secondNestedMethod()
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
*/