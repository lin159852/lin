package uuu.gfs.test;

public class TestBitwiseOperators {

	public static void main(String[] args) {
		//運算元為整數型別: 5
		byte a = 5;
		byte b = 6;
		System.out.printf("~a: %s\n", ~a); //~ 求補數
		System.out.printf("b & a: %s\n", b & a); //& AND
		System.out.printf("b | a: %s\n", b | a); //| OR
		System.out.printf("b ^ a: %s\n", b ^ a); //^ XOR
		
		//位移運算子
		int c = 32;
		System.out.printf("c << 2: %s\n", c << 2); //<< 左移幾位(先轉換成2進制，右邊補0，乘以2的n次方
		System.out.printf("c >> 2: %s\n", c >> 2); //<< 右移幾位(先轉換成2進制，左邊補0，除以2的n次方
		System.out.printf("-32 >> 2: %s\n", -32 >> 2); //<< 右移幾位(先轉換成2進制，左邊補1
		
		System.out.printf("c >>> 2: %s\n", c >>> 2); //<< Unsigned右移幾位(先轉換成2進制，左邊必補0
		System.out.printf("-32 >>> 2: %s\n", -32 >>> 2); //<< Unsigned右移幾位(先轉換成2進制，左邊必補0
		
		// +=, -=, *=, /=, %=,     &=, |=, ^=, <<=, >>=, >>>=
		byte x = 1;
		//x += 1.5/2*4L+c;
		x = (byte)(x + (1.5/2*4L+c)); //上面一行其實就是這樣，指派運算子自帶轉回原本型別的功能
		System.out.printf("x: %s\n", x);
	}

}
