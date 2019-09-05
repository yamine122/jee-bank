package com.bank.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.pools.Constants;
import com.bank.web.services.MemberService;
import com.bank.web.servicesimpls.MemberServiceImpl;


@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
			String action = request.getParameter("action");
			System.out.println("액션 : "+action);
			String dest = request.getParameter("dest");
			System.out.println("목적지"+dest);
			CustomerBean param = new CustomerBean();
			MemberService service = new MemberServiceImpl();
			
			
		switch (action) {
		case "move":
			 request.getRequestDispatcher
             (String.format(
            		 Constants.VIEW_PATH, 
            		 "customer", 
            		 request.getParameter("dest")))
             .forward(request, response);
			 
			 break;

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
			
			request.getRequestDispatcher
            (String.format(
           		 Constants.VIEW_PATH, 
           		 "customer", 
           		 request.getParameter("dest")))
            .forward(request, response);
			

			break;
		case "login":
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			param.setId(id);
			param.setPw(pw);
			System.out.printf("로그인서비스진입  아이디 :%s 비밀번호 : %s" , id , pw );
			
			CustomerBean customer = service.login(param);
			
			if(id.equals(customer.getId())) {
				request.setAttribute("customer", customer);
				
				request.getRequestDispatcher
	            (String.format(
	           		 Constants.VIEW_PATH, 
	           		 "customer", 
	           		 request.getParameter("dest")))
	            .forward(request, response);
				
			}else {
				request.getRequestDispatcher
	            (String.format(
	           		 Constants.VIEW_PATH, 
	           		 "customer", 
	           		 request.getParameter("action")))
	            .forward(request, response);
				
			}
			
			
			
			
			break;
		case "existId" :
			
			break;
		
			
		case "mypage" :
			
			
			break;
			
		}
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
