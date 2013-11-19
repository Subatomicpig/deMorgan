package deMorgan;

import java.util.Scanner;

public class main {
	
	//The purpose of this class is to print the inverse of a given function
	//read in the data parse into sections
	//inverse the input
	//concatante and return
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String inputString;
		String deMorgan;
		
		System.out.println("Enter String");
		inputString = input.nextLine();
		deMorgan = deMorgan(inputString);
		System.out.println(deMorgan);
	
	}
	
	static String deMorgan(String string){
		
		String outerExpression = null;
		String innerExpression = null;
		String finalExpression = null;
		String[] parts = null;
		String value = null;
		
		int indexOfStartPar = 0;
		int indexOfEndPar = 0;
		
		
		//break into parts because of the main expression to make calculating demorgans easier
		if(string.contains("AND") || string.contains("OR")){
			if(string.contains("AND")){
				parts = string.split("AND");
				value = "AND";
			}
			else if(string.contains("OR")){
				parts = string.split("OR");
				value = "OR";
			}
			outerExpression = parts[0];
			innerExpression = parts[1];
		}
		else
			//when there is only one part set it equal to the final
			finalExpression = string;

		
		//if both null we have only one part
		if(outerExpression == null && innerExpression == null){
			finalExpression = negate(finalExpression);
		}
		//we have two parts to check for negation
		else{
			//checks the inner and outer epxression to see if a switch is needed
			outerExpression = andOR(outerExpression);
			innerExpression = andOR(innerExpression);
			outerExpression = negate(outerExpression);
			innerExpression = negate(innerExpression);
			
		}
		
		
		System.out.println("Value " + value);
		
		if(value == "AND"){
			value = "OR";
		}
		else if(value == "OR"){
			value = "AND";
		}
		
		if(innerExpression != null){
			finalExpression = outerExpression + value + " " + innerExpression;
		}
		
		return finalExpression;
	}
	
	
	static String andOR(String string){
		
	
		if(string.contains("AND")){
			string = string.replace("AND", "OR");
		}
		if(string.contains("OR")){
			string = string.replace("OR", "AND");
		}
		
		return string;
	}
	
	
	
	
	
	
	static String negate(String string){
		//negate the parts if needed
		if(string.contains("NOT")){
			string = string.replace("NOT","");
		}
		else
			string = "NOT " + string;
		
		return string;
	}
	
}
	
	
