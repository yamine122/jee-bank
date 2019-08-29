package com.bank.services;
import java.util.List;

import com.bank.domains.*;

public interface MemberService {
	public void join(CustomerBean param);
	public void register(EmployeeBean param);
	public List<CustomerBean> findAllCustomers();
	public List<EmployeeBean> findAllAdmins();
	public List<MemberBean> findByName(String name); // 고객, 사원 공용메소드
	public MemberBean findById(String id); // 고객, 사원 공용메소드
	public boolean login(MemberBean param); // 고객, 사원 공용메소드
	public int countCustomers(); // 고객수
	public int countAdmins(); // 직원수
	public boolean existId(String id);
	public void updatePass(MemberBean param);
	public boolean deleteMember(MemberBean param);
}
