package uuu.gfs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uuu.gfs.entity.Customer;
import uuu.gfs.exception.VGBDataInvalidException;
import uuu.gfs.exception.VGBException;
import uuu.gfs.service.CustomerService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do") // 字串代入組成URL http://localhost:8080/gfs/login.do 因此/不可省略
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errors = new ArrayList<>(); //錯誤清單
    	//1. 取得request中的form data具有name屬性的輸入項: id, password, captcha
    	String id = request.getParameter("id");
    	String password = request.getParameter("password");
    	String captcha = request.getParameter("captcha");
    	if(id==null || id.length()==0) {
    		errors.add("必須輸入帳號");
    	}
    	if(password==null || password.length()==0) {
    		errors.add("必須輸入密碼");
    	}
    	if(captcha==null || captcha.length()==0) {
    		errors.add("必須輸入驗證碼");
    	}
    	
    	if(errors.isEmpty()) {
	    	try {
	    		//2. 呼叫商業邏輯
	    		CustomerService cService = new CustomerService();
	    		Customer c = cService.login(id, password);
	    		
	    		//3-1. 產生成功的html回應
	    		response.setContentType("text/html"); // text/html是MIME Type
	    		response.setCharacterEncoding("utf8");
	    		try(
	    			PrintWriter out = response.getWriter();
	    			){
	    			out.println("<!DOCTYPE html>");
	    			out.println("<html>");
	    			out.println("<body>");
	    			out.print("<h3>歡迎光臨！ " + c.getName() + " 您好！</h3>");
	    			out.print("點擊即可回首頁<a href='./'>首頁</a>");
	    			out.print("</body>");
	    			out.print("</html>");
	    		}
	    		return;
	    	}catch(VGBException e) { 
	    		this.log(e.getMessage(), e); //For admin
	    		errors.add(e.getMessage());
	    	}catch(VGBDataInvalidException e) {
	    		errors.add(e.getMessage());
	    	}catch(Exception e) {
	    		this.log("登入失敗，發生非預期錯誤:", e);
	    		errors.add("登入失敗，發生非預期性錯誤:" + e); //將錯誤訊息加入錯誤清單
	    	}
    	}
    		//3-2. 產生失敗的html回應
    		response.setContentType("text/html"); //text/html是MIME Type
    		response.setCharacterEncoding("utf8");
    		try(PrintWriter out = response.getWriter();){
    			out.println("<!DOCTYPE html>");
    			out.println("<html>");
    			out.println("<body>");
    			out.print("<h3>" + errors + "</h3>");				    			
    			out.print("</body>");
    			out.print("</html>");	    			
    		}
    	
	}

}
