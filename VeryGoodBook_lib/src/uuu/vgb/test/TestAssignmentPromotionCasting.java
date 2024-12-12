package uuu.vgb.test;

public class TestAssignmentPromotionCasting {

	public static void main(String[] args) {
		int i = 100;
		double j = i; //promotion(基本型別)
		
		byte x = -128;
		char y = (char)x; //casting強迫轉換型別
		int z = y; //promotion
		
		System.out.printf("x: %s\n", x);
		System.out.printf("y: %s\n", y);
		System.out.printf("z: %s\n", z);
		
		System.out.printf("ﾀ: %s\n", (int)'ﾀ');
		System.out.printf("ﾀ: %s\n", 'ﾀ'+0);
		
		String s = "Hello";
		String s1 = s;
		String s2 = s + "World"; //polymorphism(參考型別)
		
		
	}

}
