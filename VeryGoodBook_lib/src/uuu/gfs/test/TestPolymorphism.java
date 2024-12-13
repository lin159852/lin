package uuu.gfs.test;

import uuu.gfs.entity.Customer;
import uuu.gfs.entity.Product;
import uuu.gfs.entity.SpecialOffer;
import uuu.gfs.entity.VIP;

public class TestPolymorphism {

	public static void main(String[] args) {
		{
		Object o = new Object(); // 一般宣告與指派
		String s = "Hello";
		Customer c = new Customer("A123456789", "12345;Lkj", "Jack");
		
		System.out.printf("o: %s\n", o);
		System.out.printf("s: %s\n", s); // String類別有Override toString方法
		System.out.printf("s.length(): %s\n", s.length());
		System.out.printf("c: %s\n", c); // Customer類別有Override toString方法
		System.out.printf("c.getName(): %s\n", c.getName());
		}
		
		{ //舊功能升級，新功能不知道
		Object o = new Object(); // 多型宣告與指派
		Object o1 = "Hello"; // 多型宣告與指派
		Object o2 = new Customer("A123456789", "12345;Lkj", "Jack"); // 多型宣告與指派
		Customer c = new VIP("A123123123", "123456789", "Mary", 10); // 多型宣告與指派
		VIP v = new VIP("A123123123", "123456789", "Mary", 10); // 多型宣告與指派
		Product p = new SpecialOffer(1, "ZGMF-X10A 自由鋼彈", 1000, 21); // 多型宣告與指派
		
		System.out.printf("o: %s\n", o);
		System.out.printf("o1: %s\n", o1);
		System.out.printf("((String)o1).length(): %s\n", ((String)o1).length());
		System.out.printf("o2: %s\n", o2); // Customer類別有Override toString方法
		
		if(o2 instanceof Customer) { //若無檢查則下一行的casting可能會發生java.lang.ClassCastException
			System.out.printf("o2.getName(): %s\n", ((Customer)o2).getName());
		}
		
		//System.out.printf("c: %s\n", c.getDiscount()); 無法編譯，getDiscount()不是Customer定義的方法，需強轉成VIP類別才能看見
		System.out.printf("c強轉VIP才看得到新方法getDiscount(): %s\n", ((VIP)c).getDiscount());
		System.out.printf("v.getDiscount(): %s\n", v.getDiscount());
		System.out.printf("p.getDiscount(): %s\n", p);
		System.out.printf("p.getDiscount(): %s\n", ((SpecialOffer)p).getDiscount());
		}
	}

}
