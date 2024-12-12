package uuu.vgb.test;

import java.time.LocalDate;
import uuu.vgb.entity.Customer;

public class TestCustomer {

	public static void main(String[] args) {
		final int i = 100; //final修飾子使常數i不可再更改
		
		Customer customer = new Customer(); //物件建立即賦予記憶體空間
		
		//customer.id = "A123456789";
		customer.setId("A123456788");
		//customer.email = "test@gmail.com";
		customer.setEmail("test@gmail.com");
		customer.setPhone("0987654321");
		//customer.password = "12345;Lkj";
		customer.setPassword("12345;Lkj");
		//customer.name = "王小明";
		customer.setName(null);
		//customer.gender = 'F';
		customer.setGender('F');
		//customer.birthday = LocalDate.parse("2012-10-10");
		//customer.birthday = LocalDate.of(2010,01,23);
		//customer.setBirthday(2012,01,12);
		customer.setBirthday("2000-03-03"); //ISO8601格式
		//customer.address = "台北市松山區復興北路99號14樓";
		customer.setAddress("台北市松山區復興北路99號14樓");
		//customer.subscribed = true;
		customer.setSubscribed(true);
		
		//System.out.println(customer); //顯示customer的記憶體位置
		//System.out.printf("%s\n", customer);
		//System.out.printf("%s\n", customer.toString());
		
		System.out.printf("customer.id :　%s\n", customer.getId());
		System.out.printf("customer.email :　%s\n", customer.getEmail());
		System.out.printf("customer.phone :　%s\n", customer.getPhone());
		System.out.printf("customer.password :　%s\n", customer.getPassword());
		System.out.printf("customer.name :　%s\n", customer.getName());
		System.out.printf("customer.gender :　%s\n", customer.getGender());
		System.out.printf("customer.birthday :　%s\n", customer.getBirthday());
		
		System.out.printf("customer.address :　%s\n", customer.getAddress());
		System.out.printf("customer.subscribed :　%s\n", customer.isSubscribed());
		
		//計算年齡: 今年-出生日期的年份
		int AGE = customer.getAge();
		System.out.printf("age : %s\n", AGE);
		System.out.println(customer);
		
	}

}
