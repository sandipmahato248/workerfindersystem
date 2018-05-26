package com.sandip.wf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sandip.wf.dto.WorkerDto;
import com.sandip.wf.service.WorkerService;
import com.sandip.wf.service.WorkerServiceImpl;

@WebServlet("/WorkerController")
public class WorkerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LIST_PAGE = "/listWorker.jsp";
	private static final String CREATE_PAGE = "/createWorker.jsp";

	WorkerService workerService = new WorkerServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actions = request.getParameter("actions");
		String forward ="";
		if (actions.equalsIgnoreCase("edit")) {
			int id= Integer.parseInt(request.getParameter("id"));
			WorkerDto dto=workerService.getWorkerInfoById(id);
			request.setAttribute("worker", dto);
			forward = CREATE_PAGE;
		} else if (actions.equalsIgnoreCase("listWorker")) {
			request.setAttribute("workerList", workerService.getAllWorkerInfo());
			forward = LIST_PAGE;
		} else if (actions.equalsIgnoreCase("add")) {
			forward = CREATE_PAGE;
		}else if (actions.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			workerService.deleteWorkerInfo(id);
			request.setAttribute("workerList", workerService.getAllWorkerInfo());
			forward = LIST_PAGE;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);

		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		WorkerDto workerDto = new WorkerDto();
		workerDto.setWorkerName(request.getParameter("wname"));
		workerDto.setWorkCategory(request.getParameter("workcategory"));
		workerDto.setPhone(Long.parseLong(request.getParameter("phone")));
		workerDto.setGender(request.getParameter("gender"));
		workerDto.setWages(Integer.parseInt(request.getParameter("wages")));
		workerDto.setAddress(request.getParameter("address"));
		String workerId = request.getParameter("id");
		if (workerId == null || workerId.isEmpty()) {
			workerService.saveWorkerInfo(workerDto);
			request.setAttribute("msg", "Registration successfull.");
		} else {
			workerDto.setId(Integer.parseInt(workerId));
			workerService.updateWorkerInfo(workerDto);
			request.setAttribute("msg", "Update successfull.");
		}

		RequestDispatcher rd = request.getRequestDispatcher(CREATE_PAGE);
		
		request.setAttribute("workerList", workerService.getAllWorkerInfo());
		rd.forward(request, response);
	}
}
