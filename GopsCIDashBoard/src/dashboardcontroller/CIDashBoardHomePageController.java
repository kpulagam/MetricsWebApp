package dashboardcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databasebeans.RegisterCIDetails;

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
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served from Home page servelet!");
		 * String userName = request.getParameter("userid"); String password =
		 * request.getParameter("pwd"); PrintWriter writer =
		 * response.getWriter(); writer.println("<html>"); writer.println(
		 * "The userName is: "+userName); writer.println("<br/>");
		 * writer.println("The Password is: "+password);
		 * writer.println("</html>");
		 */
		String action = request.getParameter("action");

		String page = null;
		if (action == null) {

			page = "/index.jsp";

		} else if (action != null) {

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

			} else {

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

		String suite = request.getParameter("sName");

		String regSubmit = request.getParameter("regsubmit");
		String page = null;

		if (suite == null && regSubmit == null) {

			page = "/error.jsp";

		}

		if (suite != null) {

			page = "/cidata.jsp";

		} else if (suite == null && regSubmit != null) {

			request.setAttribute("teamName", request.getParameter("teamName"));
			request.setAttribute("testSuiteName", request.getParameter("testSuiteName"));
			request.setAttribute("contactPerson", request.getParameter("contactPerson"));
			request.setAttribute("contactEmailAddress", request.getParameter("contactEmailAddress"));
			// request.setAttribute("actionMessage",
			// request.getParameter("validationMessage"));

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

		getServletContext().getRequestDispatcher(page).forward(request, response);
	}

}
