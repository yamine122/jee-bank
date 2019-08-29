package com.bank.servicesimpls;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.bank.domains.AccountBean;
import com.bank.services.AccountService;

public class AccountServiceImpl implements AccountService{
	
	private List<AccountBean> accounts;
	
	public AccountServiceImpl() {
		accounts = new ArrayList<>();
	}
	@Override
	public void createAccount(int money) {
		AccountBean ac = new AccountBean();
		ac.setAccountNum(createAccountNum());
		ac.setMoney(money+"");
		ac.setRegDate(findDate());
		
		
	}

	@Override
	public String createAccountNum() {
		String accountNum = "";
		Random r = new Random();
		int num = r.nextInt(10);
		for(int i = 0 ; i < 10 ; i++) {
			if( i== 4) {
				accountNum += "-";
			}else {
				accountNum += num;
			}
			}
		
		
		return accountNum;
	}

	@Override
	public List<AccountBean> findAll() {
		
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean ac = new AccountBean();
			for(AccountBean ac2 : accounts) {
				if(accountNum.equals(ac2.getAccountNum())) {
					ac = ac2;
				}
			}
		
		return ac;
	}

	@Override
	public int countAccounts() {
		return accounts.size();
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean flag = false;
		for(AccountBean ac : accounts) {
			if(accountNum.equals(ac.getAccountNum())) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}

	@Override
	public String findDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ss hh:mm");

		return sdf.format(date);
	}

	@Override
	public void depositMoney(AccountBean param) {
		int money = 0;
		for(AccountBean ac : accounts) {
			if(ac.getAccountNum().equals(param.getMoney())) {
				money = Integer.parseInt(ac.getMoney()) + Integer.parseInt(param.getMoney());
				
				ac.setMoney(String.valueOf(money));
				ac.setRegDate(findDate());
				
				accounts.add(accounts.indexOf(ac), ac);
			}
		}
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		int money = 0;
		for(AccountBean ac : accounts) {
			if(ac.getAccountNum().equals(param.getMoney())) {
				money = Integer.parseInt(ac.getMoney()) - Integer.parseInt(param.getMoney());
				
				ac.setMoney(String.valueOf(money));
				ac.setRegDate(findDate());
				
				accounts.add(accounts.indexOf(ac), ac);
			}
		}
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		accounts.remove(findByAccountNum(accountNum));
	}

}
