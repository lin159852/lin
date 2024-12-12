package uuu.vgb.service;

import uuu.vgb.entity.Customer;
import uuu.vgb.exception.VGBDataInvalidException;
import uuu.vgb.exception.VGBException;

public class CustomerService {
	private CustomersDAO dao = new CustomersDAO();
	
	//Login功能
	public Customer login(String id, String password) throws VGBException {
		Customer customer = dao.selectCustomerById(id);
		if(customer!=null && customer.getPassword().equals(password)) { //同時檢查帳號是否正確以及密碼是否正確
			return customer;
		}else 
			throw new VGBDataInvalidException("登入失敗, 帳號或密碼不正確"); //為防範盜帳號因此失敗訊息要兩個都寫
	}
	//新增客戶功能
	public void register(Customer c) throws VGBException {
		if(c==null)
			throw new IllegalArgumentException("註冊會員時，Customer物件不得為null");
		dao.insert(c);
	}
}
