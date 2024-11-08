package CONTROLLER;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class NavController
 */
@WebServlet("/NavController")
public class NavController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String username = (session != null) ? (String) session.getAttribute("username") : null;

		if (username == null) {
			session = request.getSession(false);
			request.setAttribute("errorMessage", "Quên đăng nhập kìa!");
			response.sendRedirect("accountController");
			// return;
		}
		request.getRequestDispatcher("View/Nav.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");

		if (username == null) {
			response.sendRedirect("accountController");
			return;
		}

		//
		String action = request.getParameter("action");
		switch (action) {
		case "xemGioHang":
			response.sendRedirect("GioHangController");
			break;
		case "xacNhanDatMua":
			response.sendRedirect("XacNhanDatMuaController");
			break;
		case "LichSuMuaHang":
			response.sendRedirect("LichSuMuaHangController");
			break;
		case "LoginOrRegister":
			response.sendRedirect("View/account.jsp");
			break;
		default:
			break;
		}		
	}
}