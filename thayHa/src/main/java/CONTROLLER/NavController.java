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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		// nếu chưa login thì chuyển về trang login
		String username = (session != null) ? (String) session.getAttribute("username") : null;
		if (username == null) {
			session.setAttribute("errorMessage", "Quên đăng nhập kìa!");
//			response.sendRedirect("accountController");
		}
		
		request.getRequestDispatcher("View/Nav.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		// nếu chưa login thì chuyển về trang login
		String username = (session != null) ? (String) session.getAttribute("username") : null;
		if (username == null) {
			session.setAttribute("errorMessage", "Quên đăng nhập kìa!");
			response.sendRedirect("accountController");
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
		case "Logout":
		 	if (session != null) {
		 		session.invalidate();
		 	}
		 	response.sendRedirect("indexController");
			break;
		default:
			break;
		}		
	}
}