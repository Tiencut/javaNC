package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import giohangmodal.giohangBO;


/**
 * Servlet implementation class NavController
 */
@WebServlet("/NavController")
public class NavController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public NavController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		// đăng xuất
		if (action != null && action.equals("logout")) {
			session.removeAttribute("dn");
			return;
		}
		
		// lấy số lượng hàng trong giỏ hàng
		giohangBO gioHang = (giohangBO) request.getSession().getAttribute("gh");
		int soLuongHang = (gioHang != null) ? gioHang.ds.size() : 0;
		request.setAttribute("soLuongHang", soLuongHang);
		
		request.getRequestDispatcher("view/account.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("xemGioHang")) {
			
		} else if (action != null && action.equals("xemGioHang")) {
			
		} else if (action != null && action.equals("xemGioHang")) {
		}
		doGet(request, response);
	}

}