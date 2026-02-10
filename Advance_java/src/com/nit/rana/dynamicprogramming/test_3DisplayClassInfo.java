package com.nit.rana.dynamicprogramming;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class test_3DisplayClassInfo {

	public static void main(String[] args) throws ClassNotFoundException 
	{
		@Deprecated
		Scanner scn=new Scanner(System.in);
		System.out.print("Enter the class name : ");
		Class cls=Class.forName(scn.next());//Just loading the class in byte code
		
		
		//reading and printing loading class information 
		System.out.println("Module name : "+cls.getModule());
		System.out.println("Package name : "+cls.getPackageName());
		System.out.println("Annotation : "+Arrays.toString(cls.getAnnotations()));
		System.out.println("Modifiers : "+Modifier.toString(cls.getModifiers()));
		
		
		System.out.println("==============================================================================");
		
		//class and superclass and interface
		
		System.out.println("Class name : "+cls.getName());
		System.out.println("Class name : "+cls.getSimpleName());
		System.out.println("Super class : "+cls.getSuperclass());
		System.out.println("Interface : "+Arrays.toString(cls.getInterfaces()));
		
		
		System.out.println("=================================================================================");
		
		//Fields
		
		System.out.println("Fields : "+Arrays.toString(cls.getFields()));
		System.err.println("Fields : "+Arrays.toString(cls.getDeclaredFields()));
		
		
		System.out.println("==================================================================================");
		
		//Constructions
		System.out.println("Constructor : "+Arrays.toString(cls.getConstructors()));
		System.out.println("Constructions : "+Arrays.toString(cls.getDeclaredConstructors()));
		
		
		System.out.println("==================================================================================");
		
		//Methods
		
		System.out.println("Methods : "+Arrays.toString(cls.getMethods()));
		System.out.println("Methods : "+Arrays.toString(cls.getDeclaredMethods()));
		
	}
}	