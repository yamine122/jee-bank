package com.bank.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.CustomerBean;
import com.bank.web.services.MemberService;
import com.bank.web.servicesimpls.MemberServiceImpl;

public class LoginCommand extends MoveCommand{
	
	public LoginCommand(HttpServletRequest request) throws Exception{
		super(request);
	}
	@Override
	public void execute() {
		
		super.execute();
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		param.setId(id);
		param.setPw(pw);
		System.out.printf("로그인서비스진입  아이디 :%s 비밀번호 : %s" , id , pw );
		
		CustomerBean customer= service.login(param);
		String page2 = "";
		String domain2 = "";
		
		if(customer == null) {
			page2 = "login";
			domain2 = "customer";
			
		}else {
			page2 = "mypage";
			domain2 = "customer";
		}
		
		request.setAttribute("customer", customer);
	
		Receiver.cmd.setView(domain2, page2);
		System.out.println("로그인후 가야할 페이지:"+Receiver.cmd.getView());
	}
}
