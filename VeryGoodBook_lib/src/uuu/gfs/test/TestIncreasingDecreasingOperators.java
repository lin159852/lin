package uuu.gfs.test;

public class TestIncreasingDecreasingOperators {

	public static void main(String[] args) {
		//遞增Increasing: ++          遞減Decreasing: --
		byte a = 127;
		System.out.printf("++a: %s\n", ++a); //a=(byte)(a+1):-128, print:-128
		System.out.printf("a++: %s\n", a++); //print: -128, a=(byte)(a+1): -127 in memory
		System.out.printf("a: %s\n", a);
		
	}

}
