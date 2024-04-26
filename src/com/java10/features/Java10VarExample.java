
package com.java10.features;

import java.util.HashMap;

import com.common.classes.Employee;

public class Java10VarExample {

	var a=10;//Instance variable declaration not allowed here

	public Java10VarExample(var param) {
		// Error: Parameter declaration not allowed here 
		// Constructor implementation
		}

	public static void main(String[] args) {
		varKeyword();
	}

	private static void varKeyword() { 
		Object emp = new Employee(21); 
		// emp.getAge();// uncomment this
  
		var emp2 = new Employee(22);
		emp2.getAge();
  
		var map = new HashMap<Integer, String>();
		//var n; // error: cannot use 'var'  on variable without initializer
		//var emptyList = null; // error: variable  initializer is 'null'
		//We'll need to specify the type of array explicitly when initializing it.So, this code results in an error:
		// var arr = { 1, 2,  3 };

	}

	public void myMethod(var param) { // Error: Parameter declaration not allowed here 
  // Method implementation 
		}
  
  // This is not allowed
		public var myMethod() { 
			// Error: Return type declaration not allowed here
			// Method implementation
			}
  
 /**
	 * To put it simply, you can use 'var' for variables inside methods, loops, or
	 * initializers, but not for variables belonging to a class, method inputs,
	 * method outputs, or constructor inputs.
	 */
		  }
