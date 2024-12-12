package uuu.mod11.test;

public class TestMath {

	public static void main(String[] args) {
		System.out.printf("%s\n", Math.round(-4.6));
		System.out.printf("%s\n", Math.round(-4.51));
		System.out.printf("%s\n", Math.round(-4.5));
		System.out.printf("%s\n", Math.round(-4.49));
		System.out.printf("%s\n", Math.round(-4.4));
		
		System.out.printf("%s\n", Math.ceil(4.3));
		System.out.printf("%s\n", Math.floor(4.9));
		System.out.printf("%s\n", Math.ceil(-4.3));
		System.out.printf("%s\n", Math.floor(-4.9));
		int a = Integer.MAX_VALUE, b=127;
		System.out.println(a+b);
		System.out.printf("Math.addExact : %s\n", Math.addExact(a, b)); //發生ArithmeticException
	}

}
