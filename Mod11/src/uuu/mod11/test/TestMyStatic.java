package uuu.mod11.test;

import uuu.mod11.entity.MyStatic;

public class TestMyStatic {
	
	public static void main(String[] args) {
		System.out.printf("MyStatic.i : %s\n", MyStatic.getI());
		MyStatic.setI(123);
		
		MyStatic m1 = new MyStatic();
		System.out.printf("m1.i : %s\n", m1.getI()); //123
		System.out.printf("m1.j : %s\n", m1.getJ()); //初值0
		m1.setI(456);
		m1.setJ(789);
		
		MyStatic m2 = new MyStatic();
		System.out.printf("class : %s\n", MyStatic.class);
		System.out.printf("m2.i : %s\n", m2.getI()); //456
		System.out.printf("m2.j : %s\n", m2.getJ()); //初值0
	}
}
