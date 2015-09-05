package com.paypal.test.gops.admin.cidashboard.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.paypal.test.gops.admin.cidashboard.model.DashBoardDAOFactory;
import com.paypal.test.gops.admin.cidashboard.model.GetCIDataDAO;
import com.paypal.test.gops.admin.cidashboard.model.RegisterCIDetails;

/**
 * Servlet implementation class HomePage
 */
public class CIDashBoardHomePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CIDashBoardHomePageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession newSession = request.getSession();
		
		DashBoardDAOFactory daoFactory = DashBoardDAOFactory.getDAOFactroy(DashBoardDAOFactory.MONGO);		
		GetCIDataDAO ciData = (GetCIDataDAO) newSession.getAttribute("ciData");
		
		if (ciData == null) {
			ciData =daoFactory.getCIDataDAO();
		}
		
		
		newSession.setAttribute("ciData", ciData);
		String action = request.getParameter("action");

		String page = null;
		if (action == null) {

			page = "/index.jsp";

		}

		else if (action != null) {

			if (action.equals("register")) {

				request.setAttribute("teamName", "");
				request.setAttribute("testSuiteName", "");
				request.setAttribute("contactPerson", "");
				request.setAttribute("contactEmailAddress", "");
				request.setAttribute("actionMessage", "");

				page = "/registeration.jsp";

			} else if (action.equals("getData")) {

				page = "/fetchcidata.jsp";

			} else if (action.equals("contact")) {

				page = "/contactus.jsp";

			} else if (action.equals("admin")) {

				page = "/adminlogin.jsp";

			}

			else {

				page = "/error.jsp";

			}

		}

		getServletContext().getRequestDispatcher(page).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		Integer hits = (Integer) context.getAttribute("hits");
		if (hits == null) {
			hits = 0;

		} else {
			hits++;

		}

		context.setAttribute("hits", hits);
		String suite = request.getParameter("sName");

		String regSubmit = request.getParameter("regsubmit");
		/*
		 * String runNumber = request.getParameter("runNum"); String get =
		 * request.getParameter("gLRun");
		 */

		String page = null;

		if (suite == null && regSubmit == null) {

			page = "/error.jsp";

		}

		// ciData is the GetCIDataBean object which is used across the pages in
		// one session
		if (suite != null) {
			
			

			page = "/cidata.jsp";

		} else if (suite == null && regSubmit != null) {

			request.setAttribute("teamName", request.getParameter("teamName"));
			request.setAttribute("testSuiteName", request.getParameter("testSuiteName"));
			request.setAttribute("contactPerson", request.getParameter("contactPerson"));
			request.setAttribute("contactEmailAddress", request.getParameter("contactEmailAddress"));

			if (regSubmit.equals("register")) {

				RegisterCIDetails registerDetails = new RegisterCIDetails(request.getParameter("teamName"),
						request.getParameter("testSuiteName"), request.getParameter("contactPerson"),
						request.getParameter("contactEmailAddress"));

				if (registerDetails.validateDetails()) {

					page = "/registrationsuccessfull.jsp";

				}

				else {
					request.setAttribute("actionMessage", registerDetails.getActionMessage());
					page = "/registeration.jsp";

				}

			}

		}

		String userName = request.getParameter("uName");
		String password = request.getParameter("password");

		if (userName != null && password != null) {

			if (context.getInitParameter("userName").equals(userName.trim())
					&& context.getInitParameter("password").equals(password.trim())) {
				page = "/statistics.jsp";
			} else {
				page = "/unauthorised.jsp";
			}

		}

		getServletContext().getRequestDispatcher(page).forward(request, response);
	}

}
