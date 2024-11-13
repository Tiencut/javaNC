package CONTROLLER;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sachMODEL.Sach;
import sachMODEL.sachBO;
import sachMODEL.sachDAO;

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
		UTILS.utils.loadLoaiSach(request);

		// 
		// HttpSession session = request.getSession(false);
		// if (session != null) {
		// 	String username = (String) session.getAttribute("username");
		// 	request.setAttribute("username", username);
		// }

		// phân trang
		setPhanTrang(request);
		// Kiểm tra tham số "action"
		int index = request.getParameter("index") == null ? 1 : Integer.parseInt(request.getParameter("index"));
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
			default:
				break;
			}
		} else {
			request.setAttribute("index", index);
			ArrayList<Sach> listSach = (new sachBO()).getListSachPhanTrang(index);
			request.setAttribute("listSach", listSach);
		}

		// Chuyển tiếp yêu cầu đến trang index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void setPhanTrang(HttpServletRequest request) {
		int soLuongSach = (new sachDAO()).getSoLuongSach();
		int soLuongSachTrenTrang = 9;
		int soTrang = (int) Math.ceil((double) soLuongSach / soLuongSachTrenTrang);
		request.setAttribute("soTrang", soTrang);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}