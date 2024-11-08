package CONTROLLER;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sachMODEL.Sach;
import sachMODEL.sachBO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<String> gioHang = (ArrayList<String>) session.getAttribute("gioHang");

		// dựa tren list ma sach, lay ra list sach tu database
		if (gioHang != null && !gioHang.isEmpty()) {
			sachBO sBO = new sachBO();
			ArrayList<Sach> listSachTrongGio = sBO.getListSachTheoGio(gioHang);
			request.setAttribute("listSachTrongGio", listSachTrongGio);
		} else {
			request.setAttribute("listSachTrongGio", new ArrayList<Sach>());
		}
		
		request.getRequestDispatcher("View/GioHang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
