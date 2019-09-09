package com.bank.web.commands;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	
	
	public MoveCommand(HttpServletRequest request) throws Exception{
		setRequest(request);
		setDomain(domain);
		setAction((request.getParameter("action")==null)
				?"move":
					request.getParameter("action"));
		execute();
	
	}
	public void execute(){
		super.execute();
		request.setAttribute("page",request.getParameter("page"));
	}
}
