package com.ts.housejoy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.housejoy.dao.AddressDAO;
import com.ts.housejoy.dao.BidDAO;
import com.ts.housejoy.dao.CategoryDAO;
import com.ts.housejoy.dao.ServiceDAO;
import com.ts.housejoy.dao.SubCategoryDAO;
import com.ts.housejoy.dao.UserDAO;
import com.ts.housejoy.dto.Address;
import com.ts.housejoy.dto.Category;
import com.ts.housejoy.dto.Service;
import com.ts.housejoy.dto.SubCategory;
import com.ts.housejoy.dto.User;
import com.ts.housejoy.service.HouseJoyService;

@WebServlet("/HouseJoyController")
public class HouseJoyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sub_id = null;
		int id = 0;

		String action = request.getParameter("action");

		if (action == null) {

			request.setAttribute("category", CategoryDAO.getCategories());
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}

		if (action != null && action.equals("user_home")) {
			HttpSession session = request.getSession(false);
			request.setAttribute("categories", CategoryDAO.getCategories());
			RequestDispatcher rd = request.getRequestDispatcher("userhome.jsp");
			rd.forward(request, response);
		}
		if (action != null && action.equals("addAddress")) {

			request.setAttribute("category", CategoryDAO.get(new Category().getId()));
			request.setAttribute("SubCategory", SubCategoryDAO.get(new SubCategory().getId()));
			request.setAttribute("service", ServiceDAO.get(new Service().getId()));
			RequestDispatcher rd = request.getRequestDispatcher("address.jsp");
			rd.forward(request, response);
		}
		if (action != null && action.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("categories", CategoryDAO.getCategories());
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);

		}
		if (action != null) {
			sub_id = action;
			if (action.length() <= 4) {
				id = Integer.parseInt(action);
			}

		}

		if (sub_id != null && id > 100 && id < 200) {
			request.setAttribute("category", CategoryDAO.get(id));
			request.setAttribute("subcategories", SubCategoryDAO.getSubCategories(id));
			RequestDispatcher rd = request.getRequestDispatcher("subcategories.jsp");
			rd.forward(request, response);

		}
		if (action != null && id > 1000 && id < 2000) {

			HttpSession session = request.getSession(false);
			User uid = (User) session.getAttribute("user");

			request.setAttribute("category", CategoryDAO.get(new Category().getId()));
			request.setAttribute("subcategory", SubCategoryDAO.get(Integer.parseInt(action)));
			request.setAttribute("services", ServiceDAO.getServices(Integer.parseInt(action)));
			request.setAttribute("addresslist", AddressDAO.getAddressList(Integer.parseInt(action)));
			RequestDispatcher rd = request.getRequestDispatcher("services.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");

		if (action.equals("Login As User")) {
			User user = UserDAO.login(request.getParameter("loginEmail"), request.getParameter("loginPassword"));

			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				request.setAttribute("categories", CategoryDAO.getCategories());
				RequestDispatcher rd = request.getRequestDispatcher("userhome.jsp");
				rd.forward(request, response);
			}

			else {

				out.println("<script type=\"text/javascript\">");
				out.println("alert('Email or password is incorrect')");
				out.println("</script>");

				request.setAttribute("categories", CategoryDAO.getCategories());
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.include(request, response);

			}
		}

		if (action.equals("confirm")) {

			request.setAttribute("services", ServiceDAO.getServices());

		}

		if (action.equals("signUpUser")) {
			User user = new User();

			if (action.equals("signUpUser")) {
				user.setName(request.getParameter("uname"));
				user.setEmailId(request.getParameter("uemail"));
				user.setMobileNumber(Long.parseLong(request.getParameter("phone")));
				user.setPassword(request.getParameter("upwd"));
				user.setName(request.getParameter("uname"));
				user.setRole("user");
				Calendar calendar = Calendar.getInstance();
				java.util.Date currentDate = calendar.getTime();
				java.sql.Date date = new java.sql.Date(currentDate.getTime());
				user.setRegistrationDate(date);
				User register = UserDAO.register(user);

				if (register != null) {

					request.setAttribute("user", register);
					RequestDispatcher rd = request.getRequestDispatcher("address.jsp");
					rd.forward(request, response);
				}
			}

		}

		if (action.equals("add_address")) {

			int id = Integer.parseInt(request.getParameter("id"));

			Address address = new Address();
			address.setDoorno(request.getParameter("address1"));
			address.setStreet(request.getParameter("address2"));
			address.setCity(request.getParameter("city"));
			address.setState(request.getParameter("state"));
			address.setPostalCode(request.getParameter("zip"));
			address.setUserId(id);
			Address add = AddressDAO.add(address);

			if (add != null) {

				request.setAttribute("category", CategoryDAO.get(new Category().getId()));
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);

			}
		}

	}

}