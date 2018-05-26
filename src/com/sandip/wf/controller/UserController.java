package com.sandip.wf.controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.sandip.sis.util.EmailUtility;
import com.sandip.wf.dto.UserDto;
import com.sandip.wf.service.UserService;
import com.sandip.wf.service.UserServiceImpl;
import com.sandip.wf.util.EmailUtility;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/createUser.jsp";
	private static String LIST_USER = "/userList.jsp";
	private static String LOGIN = "/login.jsp";
	private static String PREVIOUS_PWD = "/previousUserPassword.jsp";
	private static String USER_PROFILE = "/userprofile.jsp";

	private UserService userService;

	public UserController() {
		super();
		userService = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String name = "";
		HttpSession session = request.getSession(false);
		if (session != null)
			name = (String) session.getAttribute("username");
		else
			name = null;
		if (name != null) {
			String action = request.getParameter("action");

			if (action.equalsIgnoreCase("delete")) {
				int userId = Integer.parseInt(request.getParameter("userid"));
				userService.deleteUser(userId);
				forward = LIST_USER;
				request.setAttribute("users", userService.getAllUsers());
			} else if (action.equalsIgnoreCase("edit")) {
				forward = INSERT_OR_EDIT;
				int userId = Integer.parseInt(request.getParameter("userid"));
				UserDto user = userService.getUserById(userId);
				request.setAttribute("user", user);
			} else if (action.equalsIgnoreCase("listUser")) {
				forward = LIST_USER;
				request.setAttribute("users", userService.getAllUsers());
			}
			else if (action.equalsIgnoreCase("userprofile")) {
			forward = USER_PROFILE;
				int userId = Integer.parseInt(request.getParameter("userid"));
				UserDto user = userService.getUserById(userId);
				request.setAttribute("user", user);
		} else if (action.equalsIgnoreCase("insert")) {
				forward = INSERT_OR_EDIT;
		} else {
				forward = PREVIOUS_PWD;
			}
	} else {
		forward = LOGIN;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDto userDto= new UserDto();
		userDto.setFirstName(request.getParameter("first_name"));
		userDto.setLastName(request.getParameter("last_name"));
		userDto.setUsername(request.getParameter("username"));
		userDto.setPassword(request.getParameter("password"));
		String dateOfBirth = request.getParameter("dob");
		try {
			Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
			userDto.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userDto.setEmail(request.getParameter("email"));
		String userid = request.getParameter("user_id");
		if (userid == null || userid.isEmpty()) {
			userService.saveUser(userDto);
			EmailUtility.sendEmail(userDto.getEmail());
		} else {
			userDto.setUserId(Integer.parseInt(userid));
			userService.updateUser(userDto);
		}

		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("users", userService.getAllUsers());
		view.forward(request, response);
	}
}
