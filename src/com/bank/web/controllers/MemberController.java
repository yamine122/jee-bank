package com.bank.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.domains.CustomerBean;


@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("맥락이 맞아서 여기에 도착함5..");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String credit = request.getParameter("credit");
		
		CustomerBean m = new CustomerBean();
		
		m.setId(id);
		m.setPw(pw);
		m.setName(name);
		m.setSsn(ssn);
		m.setCredit(credit);
		System.out.println("회원정보"+m.toString());
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
