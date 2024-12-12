package uuu.vgb.test;

import java.util.Random;
import java.util.Scanner;

public class TestGuessDoWhile {

	public static void main(String[] args) {
		//用亂數產生1~10之間的整數
		Random random = new Random();
		int target = random.nextInt(10); //產生0~9之間的整數
		target += 1; //a=a+1
		System.out.println(target);
		
		final int MAX_TIMES = 3;
		int times = 0;
		
		System.out.println("遊戲開始！");
		Scanner scanner = new Scanner(System.in);
		int guess = 0;
		
		do {
			if(times>MAX_TIMES) {
				System.out.printf("機會用完了，遊戲結束\n");
				scanner.close();
				return;
			}
			System.out.printf("還有%s次機會，請%s猜一個1~10之間的整數: \n",MAX_TIMES-times++ , times<2?"":"再"); //MAX_TIMES會先減掉times再++
			guess = scanner.nextInt();
			
		}while(guess!=target);
		System.out.println("恭喜！你猜對了！");
		scanner.close();
	}

}
