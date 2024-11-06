package CONTROLLER;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		String action = request.getParameter("action");
		switch (action) {
		case "xemGioHang":
//			request.getRequestDispatcher("View/GioHang.jsp").forward(request, response);
			request.getRequestDispatcher("GioHangController").forward(request, response);
			break;
		case "xacNhanDatMua":
			request.getRequestDispatcher("XacNhanDatMuaController").forward(request, response);
			break;
		case "LichSuMuaHang":
//			request.getRequestDispatcher("LichSuMuaHangController").forward(request, response);
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
