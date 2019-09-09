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
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Receiver.init(request);
		Receiver.cmd.execute();
		Sender.forward(request, response);
	}
}
