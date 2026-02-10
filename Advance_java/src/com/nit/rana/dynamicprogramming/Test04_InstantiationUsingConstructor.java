package com.nit.rana.dynamicprogramming;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Test04_InstantiationUsingConstructor {

	public static void main(String[] args) throws ClassNotFoundException,InstantiationException,IllegalAccessException,NoSuchMethodException,InvocationTargetException
	{
		Scanner scn=new Scanner(System.in);
		System.out.print("Enter the class : ");
		Class cls=Class.forName(scn.next());
		System.out.println();
		
		Constructor npc=cls.getDeclaredConstructor();//1.Obtaining  npc object
		Object obj1=npc.newInstance();//2.invoking and executing npc
		System.out.println(obj1);
		
		Object obj2=npc.newInstance();
		System.out.println(obj2);
		
		System.out.println("==========================================================");
		
		Constructor ipc=cls.getDeclaredConstructor(int.class);//Obtaining ipc object
		Object obj3=ipc.newInstance(50);//invoked and executed object
		System.out.println(obj3);
		
		System.out.println();
		
		Object obj4=ipc.newInstance(60);
		System.out.println(obj4);
		System.out.println();
		
		A a1=(A)obj1;
		A a2=(A)obj2;
		A a3=(A)obj3;
		A a4=(A)obj4;
		
		System.out.println("a1.x : "+a1.x);
		System.out.println("a2.x : "+a2.x);
		System.out.println("a3.x : "+a3.x);
		System.out.println("a4.x : "+a4.x);
		
		
	}

}
