package com.bank.web.daoimpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.pools.Constants;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public void insertCustomer(CustomerBean param) {
		try {
			System.out.println("들어옴");
			File file = new File(Constants.FILE_PATH+"190906.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(param.getId()+","+
						param.getPw()+","+
						param.getName()+","+
						param.getSsn()+"," +
						param.getCredit()+",");
			writer.newLine();
			writer.flush();
			writer.close();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
		try {
		
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		CustomerBean cust = new CustomerBean();
		try {
			File file = new File(Constants.FILE_PATH+"190906.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String login = reader.readLine();
						   reader.close();
			String[] arr = login.split(",");
			
			
			if(arr[0].equals(param.getId())) {
				cust.setId(arr[0]);
				cust.setPw(arr[1]);
				cust.setName(arr[2]);
				cust.setSsn(arr[3]);
				cust.setCredit(arr[4]);
			}else {
				cust = null;
			}
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cust;
	}

}
