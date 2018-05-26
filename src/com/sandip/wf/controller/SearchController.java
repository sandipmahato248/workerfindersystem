package com.sandip.wf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sandip.wf.dto.WorkerDto;
import com.sandip.wf.service.WorkerService;
import com.sandip.wf.service.WorkerServiceImpl;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SEARCH_FAIL = "/home.jsp";
	private static final String WORKER_SEARCH = "/searchresult.jsp";

	WorkerService workerService = new WorkerServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String address = request.getParameter("address");
		String workerCategory = request.getParameter("work_category");

		if (workerCategory == null || workerCategory.isEmpty()) {
			if (address == null || address.isEmpty()) {
				request.setAttribute("msg", "Empty Input! ");
				RequestDispatcher view = request.getRequestDispatcher(SEARCH_FAIL);
				view.forward(request, response);
			} else {
				List<WorkerDto> list = workerService.getWorkerInfoByWorkAddress(address);
				if (list.isEmpty() || list == null) {
					request.setAttribute("msg", "Result not found! ");
					RequestDispatcher view = request.getRequestDispatcher(SEARCH_FAIL);
					view.forward(request, response);
				}
				RequestDispatcher view = request.getRequestDispatcher(WORKER_SEARCH);
				request.setAttribute("workers", workerService.getWorkerInfoByWorkAddress(address));
				view.forward(request, response);

			}
		} else if (address == null || address.isEmpty()) {
			List<WorkerDto> list = workerService.getWorkerInfoByWorkCategory(workerCategory);
			if (list.isEmpty() || list == null) {
				request.setAttribute("msg", "Result not found! ");
				RequestDispatcher view = request.getRequestDispatcher(SEARCH_FAIL);
				view.forward(request, response);
			}
			RequestDispatcher view = request.getRequestDispatcher(WORKER_SEARCH);
			request.setAttribute("workers", workerService.getWorkerInfoByWorkCategory(workerCategory));
			view.forward(request, response);
		} else {
			List<WorkerDto> list = workerService.getWorkerByCategoryAddress(workerCategory, address);
			if (list.isEmpty() || list == null) {
				request.setAttribute("msg", "Result not found! ");
				RequestDispatcher view = request.getRequestDispatcher(SEARCH_FAIL);
				view.forward(request, response);
			}
			RequestDispatcher view = request.getRequestDispatcher(WORKER_SEARCH);
			request.setAttribute("workers", workerService.getWorkerByCategoryAddress(workerCategory, address));
			view.forward(request, response);
		}

	}
}
