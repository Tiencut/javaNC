package TienController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import DTModal.DienThoai;
import DTModal.DienThoaiBO;
import NCCModal.NCCBO;
import NCCModal.NCCThongKe;

/**
 * Servlet implementation class indexController2
 */
@WebServlet("/indexController2")
public class indexController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public indexController2() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String searchKey = request.getParameter("search");
		DienThoaiBO dtBO = new DienThoaiBO();
		ArrayList<DienThoai> listDT = null;

		//// thống kê
		request.setAttribute("showThongKe", false);
		if ("thongKe".equals(action)) {
			NCCBO nccBO = new NCCBO();
			ArrayList<NCCThongKe> listNCC = nccBO.getThongKeNCC();
			request.setAttribute("listTK", listNCC);
			request.setAttribute("showThongKe", true);
		}

		// search
		if (searchKey != null && !searchKey.trim().isEmpty()) {
			listDT = dtBO.getListDTSearch(searchKey);
		} else {
			// mặc định
			listDT = dtBO.getListDT();
		}
		request.setAttribute("listDT", listDT);

		request.getRequestDispatcher("TrangChu2.jsp").forward(request, response);
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
