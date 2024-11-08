package CONTROLLER;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import KhachHangMODEL.KhachHangBO;

/**
 * Servlet implementation class accountController
 */
@WebServlet("/accountController")
public class accountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public accountController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String action = request.getParameter("action");
		 if ("logout".equals(action)) {
		 	// Xóa session hiện tại
		 	HttpSession session = request.getSession(false);
		 	if (session != null) {
		 		session.invalidate();
		 	}
		 	response.sendRedirect("indexController");
		 } else {
		 	request.getRequestDispatcher("View/account.jsp").forward(request, response);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("Login".equals(action)) {
			handleLogin(request, response);
		} else if ("Register".equals(action)) {
			handleRegister(request, response);
		}
	}

	private void handleLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		KhachHangBO khachHangBO = new KhachHangBO();
		if (khachHangBO.checkLogin(username, password)) {
			// tạo session
			HttpSession session = request.getSession();
			session.setAttribute("username", username);

			// session giỏ hàng not exist -> tạo mới
			if (session.getAttribute("gioHang")== null) {
				session.setAttribute("gioHang", new ArrayList<String>());
			}

			response.sendRedirect("indexController");
		} else {
			request.setAttribute("errorMessage", "Invalid username or password");
			request.getRequestDispatcher("View/account.jsp").forward(request, response);
		}
	}

	private void handleRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!password.equals(confirmPassword)) {
			request.setAttribute("errorMessage", "Password and confirm password do not match");
			return;
		}

		// Kiểm tra username đã tồn tại chưa
		KhachHangBO khBO = new KhachHangBO();
		if (khBO.isUsernameExist(username)) {
			request.setAttribute("errorMessage", "Username already exists");
			request.getRequestDispatcher("accountController").forward(request, response);
			return;
		}

	}

}