package uuu.gfs.test;

import uuu.gfs.entity.Customer;

public class TestEquals {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = new String("Hello");
		String s3 = "Hello";
		
		Customer c1 = new Customer("A123456789", "12345;Lkj", "Hello");
		Customer c2 = new Customer("A123456789", "12345;Lkj", "Hello");
		
		System.out.printf("s1 == s2 : %s\n", s1 == s2); //false
		System.out.printf("s1 == s3 : %s\n", s1 == s3); //true
		
		System.out.printf("s1.equals(s2) : %s\n", s1.equals(s2)); //true
		System.out.printf("s1.equals(s3) : %s\n", s1.equals(s3)); //true
		
		//System.out.println(s == c); //無法編譯
		
		System.out.println(c1 == c2); //false
		System.out.printf("c1.equals(c2) : %s\n", c1.equals(c2)); //Override掉Customer類別的equals才會是true
		
	}

}
