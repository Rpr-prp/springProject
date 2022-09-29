package web.shoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.shoppingmall.domain.CustomerVO;
import web.shoppingmall.service.CustomerService;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	@Autowired
	private CustomerService cService;
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	@GetMapping({"/register"})
	public void customerRegister() {}
	
	@PostMapping({"/register"})
	public String customerRegisterPost(CustomerVO customerVO) {
		String encodedPw = pwEncoder.encode(customerVO.getCustomerPw());
		customerVO.setCustomerPw(encodedPw);
		System.out.println("Customer registration(customerVO) : " + customerVO);
		cService.customerRegister(customerVO);
		return "information";
	}
}