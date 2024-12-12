package uuu.vgb.test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.vgb.entity.Customer;
import uuu.vgb.exception.VGBDataInvalidException;
import uuu.vgb.exception.VGBException;
import uuu.vgb.service.CustomerService;

public class TestCustomerService_login {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("請輸入id:");
		String id = scanner.next();
		System.out.println("請輸入密碼");
		String password = scanner.next();
		scanner.close();
		
		//呼叫商業邏輯
		CustomerService cService = new CustomerService();
		Customer c;
		try {
			c = cService.login(id, password);    //呼叫商業邏輯
			System.out.printf("登入成功: %s\n", c);//輸出結果
		} catch (VGBException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(), e);// for admin, developer, tester senior
			System.err.println(e.getMessage() + ", 請聯絡管理員");// for tester junior, user
		} catch (VGBDataInvalidException e) {
			System.err.println(e.getMessage());// for tester junior, user
		} catch (Exception e) {
			Logger.getLogger("").log(Level.SEVERE, "發生非預期錯誤", e);// for admin, developer, tester senior
			System.err.println("發生系統錯誤" + e.getMessage() + ", 請聯絡管理員");// for tester junior, user
		}
		System.out.println("程式結束！");
	}

}
