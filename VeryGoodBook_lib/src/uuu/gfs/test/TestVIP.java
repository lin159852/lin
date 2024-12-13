package uuu.gfs.test;

import java.util.Scanner;

import uuu.gfs.entity.VIP;

public class TestVIP {

	public static void main(String[] args) {
		
		VIP vip = new VIP();
		//Scanner scan = new Scanner(System.in);
		//String input = scan.next();
		vip.setId("A123456789");
		
		//TODO: set其他Customer的必要欄位
		
		vip.setName("敗家王");
		vip.setDiscount(10);
		
		System.out.printf("id: %s\n", vip.getId());
		System.out.printf("name: %s\n", vip.getName());
		
		//TODO: get其他Customer的必要欄位並sysoutf
		
		System.out.printf("discount: %s%% off\n", vip.getDiscount());
		System.out.printf("享有優惠: %s\n", vip.getDiscountString());
		System.out.printf("vip: %s\n",vip);
	}

}
