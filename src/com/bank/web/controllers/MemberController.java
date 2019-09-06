package com.bank.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.commands.Sender;
import com.bank.web.commands.Command;
import com.bank.web.commands.MoveCommand;
import com.bank.web.commands.Order;
import com.bank.web.commands.Receiver;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.pools.Constants;
import com.bank.web.services.MemberService;
import com.bank.web.servicesimpls.MemberServiceImpl;


@WebServlet("/customer.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
			/*String action = request.getParameter("action");
			System.out.println("액션 : "+action);
			String dest = request.getParameter("dest");
			System.out.println("목적지"+dest);*/
			CustomerBean param = new CustomerBean();
			MemberService service = new MemberServiceImpl();
			
			Receiver.init(request);
			
			Receiver.cmd.execute();
			
			if(Receiver.cmd.getAction()==null) {
				Receiver.cmd.setPage();
			}
			
			
		switch (Receiver.cmd.getAction()) {
		

		case "join":
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String credit = request.getParameter("credit");


			param.setId(id);
			param.setPw(pw);
			param.setName(name);
			param.setSsn(ssn);
			param.setCredit(credit);

			
			service.join(param);
			System.out.println(param.toString());
			
			Receiver.cmd.setPage("login");
			

			break;
		case "login":
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			param.setId(id);
			param.setPw(pw);
			System.out.printf("로그인서비스진입  아이디 :%s 비밀번호 : %s" , id , pw );
			
			CustomerBean customer= service.login(param);
			
			if(customer == null) {
				
				Receiver.cmd.setPage("login");
				
				
				
				
				
			}else {
				Receiver.cmd.setPage("mypage");
			}
			
			request.setAttribute("customer", customer);
			
			
			
			break;
		case "existId" :
			
			break;
		
			
		case "mypage" :
			
			
			break;
			
		}
		
		Sender.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
