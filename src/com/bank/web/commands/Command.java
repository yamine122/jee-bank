package com.bank.web.commands;
import javax.servlet.http.HttpServletRequest;
import com.bank.web.pools.Constants;
import lombok.Data;
@Data
//A request is wrapped under an object as command
public class Command implements Order{
	protected HttpServletRequest request;
	protected String action, domain, page, view;
	
	@Override
	public void execute() {
		setDomain();
		setPage();
		System.out.println("리퀘스트가 가야할 길:::"+String.format(Constants.VIEW_PATH, domain,page));
	this.view = String.format(Constants.VIEW_PATH, domain,page);

	}
	public void setDomain() {
		String path = request.getServletPath();
		//서블릿패스   >>>>  /member.do
		System.out.println("서블릿 패스가 뭘까:"+path);
		/*path = path.replace(".do", "");
		domain = path;*/
		domain = path.replace(".do", "");
		domain = domain.substring(1);
		
	}
	public void setPage() {
		page = request.getParameter("page");
	}
}
