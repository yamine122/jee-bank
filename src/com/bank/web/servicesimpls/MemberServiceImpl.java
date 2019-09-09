package com.bank.web.servicesimpls;

import java.util.ArrayList;
import java.util.List;

import com.bank.web.daoimpls.MemberDAOImpl;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;

public class MemberServiceImpl implements MemberService {
	
	//private List<CustomerBean> customers;
	//private List<EmployeeBean> employees;
	private MemberDAO dao;
	
	public MemberServiceImpl() {
		//customers = new ArrayList<>();
		//employees = new ArrayList<>();
		dao = new MemberDAOImpl();
	}

	@Override
	public void join(CustomerBean param) {
		//customers.add(param);
		dao.insertCustomer(param);
		
	}

	@Override
	public void register(EmployeeBean param) {
		//employees.add(param);
	}

	/*@Override
	public List<CustomerBean> findAllCustomers() {
		return customers;
		}*/

	/*@Override
	public List<EmployeeBean> findAllAdmins() {
		return employees;
	}*/

	/*@Override
	public List<MemberBean> findByName(String name) {
		int count = 0;
		List<MemberBean> m = new ArrayList<>();
		for(CustomerBean c : customers) {
			if(name.equals(c.getName())) {
				count++;
				break;
			}			
		}
		for(EmployeeBean e : employees) {
			if(name.equals(e.getName())) {
				count++;
				break;
			}
		}
		int j = 0 ;
		for(CustomerBean c : customers) {
			if(name.equals(c.getName())) {
				m.add(c);
				j++;
				if(j==count) {
					return m;
				}
			}
		}
		for(EmployeeBean e : employees) {
			if(name.equals(e.getName())) {
				m.add(e);
				j++;
				if(j == count) {
					break;
				}
			}
		}
		return m;
	}*/

	/*@Override
	public MemberBean findById(String id) {
		MemberBean m = new MemberBean();
		for(CustomerBean c : customers) {
			if(id.equals(c.getId())) {
				m = c;
				return m;
			}
		}
		for(EmployeeBean e : employees) {
			if(id.equals(e.getId())) {
				m = e;
				break;
			}
		}
		return m;
	}*/

	@Override
	public CustomerBean login(CustomerBean param) {
		CustomerBean customer = new CustomerBean();
		
		/*customer.setId(param.getId());
		customer.setPw(param.getPw());*/
		customer = dao.login(param);
		
		
		return customer;
	}

	/*@Override
	public int countCustomers() {
		
		return customers.size();
	}*/

	/*@Override
	public int countAdmins() {
		
	return employees.size();
	}*/

	/*@Override
	public boolean existId(String id) {
		boolean flag = false;
		MemberBean m = findById(id);
		flag = employees.contains(m) || customers.contains(m);
		for(CustomerBean c: customers) {
			if(id.equals(c.getId())) {
				flag = true;
				break;
			}
		}
		for(EmployeeBean e : employees) {
			if(id.equals(e.getId())) {
				flag = true;
				break;
			}
		}
		return flag;
	}*/

	/*@Override
	public void updatePass(MemberBean param) {
		String id = param.getId();
		String oldPw = param.getPw().split(",")[0];
		String newPw = param.getPw().split(",")[1];
		MemberBean m = findById(id);
		if(m.getPw().equals(oldPw)) {
			int idx = (employees.contains(m)) 
					? employees.indexOf(m)
						:customers.indexOf(m);
			if(employees.contains(m)) {
				employees.get(idx).setPw(newPw);
			}else {
				customers.get(idx).setPw(newPw);
			}		
		}
			
	}*/

	/*@Override
	public boolean deleteMember(MemberBean param) {
		boolean flag = false;
		MemberBean m = findById(param.getId());
			return (employees.contains(m))? employees.remove(param):customers.remove(param);
		
		
	}*/
}
