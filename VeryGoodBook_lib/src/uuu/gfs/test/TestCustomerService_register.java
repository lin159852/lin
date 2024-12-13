package uuu.gfs.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.gfs.entity.Customer;
import uuu.gfs.exception.VGBDataInvalidException;
import uuu.gfs.exception.VGBException;
import uuu.gfs.service.CustomerService;

public class TestCustomerService_register {

	public static void main(String[] args) {
		try {
			Customer customer = new Customer();
			customer.setId("D116531707");
			customer.setEmail("test222222@gmail.com");
			customer.setPhone("0987123321");
			customer.setPassword("12345;Lkj");
			customer.setName("該死的換行aaa");
			customer.setGender('M');
			customer.setBirthday("2002-02-02");
			
			customer.setAddress("台北市松山區復興北路22號2樓");
			customer.setSubscribed(true);
			
			CustomerService cService = new CustomerService();
			cService.register(customer);
			System.out.printf("註冊成功: %s\n", customer);//輸出結果
		} catch (VGBException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(), e);
			System.err.println(e.getMessage());// for user
		} catch (VGBDataInvalidException e) {
			System.err.println(e.getMessage());// for user
		} catch (Exception e) {
			Logger.getLogger("").log(Level.SEVERE, "發生非預期錯誤", e);
			System.err.println("發生系統錯誤" + e.getMessage());// for user
		}
		System.out.println("程式結束！");
	}

}
