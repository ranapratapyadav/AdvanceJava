package com.nit.rana.dynamicprogramming;


import java.util.Scanner;

public class Test2_DynamicLoadingInstanctiation 
{
	public static void main(String[] args) throws ClassNotFoundException,InstantiationException,IllegalAccessException
	{
		try (//Reading the class from keyboard
		Scanner scn = new Scanner(System.in)) {
			System.out.print("Enter the class name:");
			String clsName =scn.next();
      //System.out.println(clsName);
			//reflection api Class class
			//1.loading the given class into jvm
			Class cls=Class.forName(clsName);
			System.out.println("class is loaded");
			//2.Creating the object for loaded class
			Object obj=cls.newInstance();
			System.out.println("class is instantiating\n");
			
			//3.Printing the loaded class object
			System.out.println(obj);
		}	
	}
}

//class Test01_DynamicLoading {
//	
//	public static void main(String[] args) 
//					throws ClassNotFoundException,
//							InstantiationException,
//							IllegalAccessException {
//		
//		//reading class	from keyboard
//		String clsName = IO.readln("Enter classname: ");
//		
//		//loading the given class dynamically
//		Class cls = Class.forName(clsName);
//		System.out.println("class "+ clsName + " is loaded");
//		
//		//creating new object from the loaded class
//		Object obj = cls.newInstance();
//		System.out.println("class "+ clsName + " is instantiated");
//
//		//printing object reference
//		System.out.println("obj: "+ obj);
//		
//	}
//}
