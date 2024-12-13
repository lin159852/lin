package uuu.gfs.test;

import uuu.gfs.entity.Customer;
import uuu.gfs.entity.VIP;

public class Test_instanceof {

	public static void main(String[] args) {
		Customer c = null;
		System.out.println(c instanceof Object);   //false
		System.out.println(c instanceof Customer); //false
		System.out.println(c instanceof VIP);      //false
//		System.out.println(c instanceof String);   //CompileTimeException
		System.out.println("----------");
		
		Object o = new Object();
		c = new Customer();
		VIP v = new VIP();
		String s = "Hello";
		
		System.out.println(o instanceof Object);   //true
		System.out.println(o instanceof Customer); //false
		System.out.println(o instanceof VIP);      //false
		System.out.println(o instanceof String);   //false
		System.out.println("----------");
		
		System.out.println(c instanceof Object);   //true
		System.out.println(c instanceof Customer); //true
		System.out.println(c instanceof VIP);      //false
//		System.out.println(c instanceof String);   //CompileTimeException
		System.out.println("----------");
		
		System.out.println(v instanceof Object);   //true
		System.out.println(v instanceof Customer); //true
		System.out.println(v instanceof VIP);      //true
//		System.out.println(v instanceof String);   //CompileTimeException
		System.out.println("----------");
		
		System.out.println(s instanceof Object);   //true
//		System.out.println(s instanceof Customer); //CompileTimeException
//		System.out.println(s instanceof VIP);      //CompileTimeException
		System.out.println(s instanceof String);   //true
		System.out.println("----------");
	}

}
