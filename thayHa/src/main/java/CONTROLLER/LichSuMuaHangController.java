package CONTROLLER;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import LichSuMODEL.LichSu;
import LichSuMODEL.LichSuBO;

/**
 * Servlet implementation class LichSuMuaHangController
 */
@WebServlet("/LichSuMuaHangController")
public class LichSuMuaHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LichSuMuaHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

        // check user đã đăng nhập chưa
        String username = (session != null) ? (String) session.getAttribute("username") : null;
        if (username == null) {
            if (session != null)
                session.setAttribute("errorMessage", "Quên đăng nhập kìa!");
            response.sendRedirect("accountController");
            return;
        }

		//
		LichSuBO lichSuBO = new LichSuBO();
		// 
		ArrayList<LichSu> listLichSuDaMua = lichSuBO.getLichSu(20, 1);
		request.setAttribute("listLichSuDaMua", listLichSuDaMua);
		//
		ArrayList<LichSu> listLichSuChuaMua = lichSuBO.getLichSu(20, 0);
		request.setAttribute("listLichSuChuaMua", listLichSuChuaMua);

		//
		request.getRequestDispatcher("View/LichSuMuaHang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
