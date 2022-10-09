package web.shoppingmall.service;

import web.shoppingmall.domain.MemberVO;

public interface CustomerService {
	public void customerRegister(MemberVO customerVO);
	public MemberVO customerInformation(String customerId);
	public void customerCorrection(MemberVO customerVO);
	public void customerDelete(String customerId);
}
