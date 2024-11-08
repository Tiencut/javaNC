package CONTROLLER;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loaiMODEL.loai;
import loaiMODEL.loaiBO;
import sachMODEL.Sach;
import sachMODEL.sachBO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/indexController")
public class indexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public indexController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy danh sách loại từ database truyền vào Attribute "listTenLoai"
		loaiBO loaiBo = new loaiBO();
		ArrayList<loai> listTenLoai = loaiBo.getListTenLoai();
		request.setAttribute("listTenLoai", listTenLoai);

		//
		HttpSession session = request.getSession(false);
		if (session != null) {
			String username = (String) session.getAttribute("username");
			request.setAttribute("username", username);
		}

		// Kiểm tra tham số "action"
		String action = request.getParameter("action");
		if (action == null || (!action.equals("timSach") && !action.equals("sachTheoLoai"))) {
			sachBO sBO = new sachBO();
			ArrayList<Sach> listSach = sBO.getListSach();
			request.setAttribute("listSach", listSach);
		}

		// Chuyển tiếp yêu cầu đến trang index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		sachBO sBO = new sachBO();

		if (action != null) {
			switch (action) {
			case "timSach":
				String maSachCanTim = request.getParameter("maSachCanTim");
				ArrayList<Sach> listSachCanTim = sBO.TimSachTheoMaSach(maSachCanTim);
				request.setAttribute("listSach", listSachCanTim);
				break;
			case "sachTheoLoai":
				String maLoai = request.getParameter("maLoai");
				ArrayList<Sach> sachTheoLoai = sBO.sachTheoLoai(maLoai);
				request.setAttribute("listSach", sachTheoLoai);
				break;
			case "themVaoGio":
//				String maSach = request.getParameter("maSach");
//				HttpSession session = request.getSession();
//				ArrayList<String> gioHang = (ArrayList<String>) session.getAttribute("gioHang");
//				gioHang.add(maSach);
//				session.setAttribute("gioHang", gioHang);
				response.sendRedirect("GioHangController");
				break;
			default:
				break;
			}
		}
	}
}