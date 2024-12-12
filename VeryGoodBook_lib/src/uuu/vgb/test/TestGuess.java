package uuu.vgb.test;

import java.util.Random;
import java.util.Scanner;

public class TestGuess {

	public static void main(String[] args) {
		//用亂數產生1~10之間的整數
		Random random = new Random();
		int target = random.nextInt(10); //產生0~9之間的整數
		target += 1; //a=a+1
		System.out.println(target);
		
		final int MAX_TIMES = 3;
		int times = 0;
		
		System.out.println("請猜一個1~10之間的整數");
		Scanner scanner = new Scanner(System.in);
		int guess = scanner.nextInt();
		/*if(guess==target) {
			System.out.println("猜對了");
		}else {
			System.out.println("猜錯了");
		}*/
		
//		while(guess!=target) {
//			System.out.println("猜錯了，請再猜一個1~10之間的數字");
//			int guess1 = scanner.nextInt();
//			while(guess1!=target) {
//				System.out.println("猜錯了，請再猜一個1~10之間的數字");
//				int guess2 = scanner.nextInt();
//				while(guess2!=target) {
//					System.out.println("猜錯了，已經猜3次囉");
//					scanner.close();
//					return;
//				}
//			}
//		}
//		System.out.println("猜對了");
//		scanner.close();
		
		while(guess!=target) {
			times++;
			if(times<MAX_TIMES) {
				System.out.printf("猜錯了，你還有%s次機會，請再猜一個1~10之間的整數: \n", MAX_TIMES-times);
				guess = scanner.nextInt();
			}else {
				System.out.printf("機會用完了，遊戲結束\n");
				scanner.close();
				return;
			}
		}
		System.out.println("恭喜！你猜對了！");
		scanner.close();
	}

}
