package com.sandip.wf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sandip.wf.service.WorkerService;
import com.sandip.wf.service.WorkerServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   WorkerService workerService=new WorkerServiceImpl();
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("uname");
		String password=request.getParameter("pass");
		if(userName.equals("admin") && password.equals("admin")){
			HttpSession session=request.getSession(true);
			session.setAttribute("username", userName);
			RequestDispatcher rd=request.getRequestDispatcher("listWorker.jsp");
			request.setAttribute("workerList",workerService.getAllWorkerInfo() );
			rd.forward(request, response);
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			request.setAttribute("LoginFail", "Incorrect Username and password");
			rd.include(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
