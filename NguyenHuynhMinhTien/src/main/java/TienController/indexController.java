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
 * Servlet implementation class indexController
 */
@WebServlet("/indexController")
public class indexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String searchKey = request.getParameter("search");
		DienThoaiBO dtBO = new DienThoaiBO();
		ArrayList<DienThoai> listDT = null;
	
		if ("thongKe".equals(action)) {
			NCCBO nccBO = new NCCBO();
			ArrayList<NCCThongKe> listNCC = nccBO.getThongKeNCC();
			request.setAttribute("listTK", listNCC);
			request.setAttribute("showThongKe", true);
		} else {
			// search
			if (searchKey != null && !searchKey.trim().isEmpty()) {
				listDT = dtBO.getListDTSearch(searchKey);
				if (listDT.size() == 0) {
					request.setAttribute("errorMessage", "Không tìm thấy sản phẩm nào");
					request.setAttribute("noResults", null);
				}
			} else {
				// mặc định
				listDT = dtBO.getListDT();
			}
			request.setAttribute("listDT", listDT);
			request.setAttribute("showThongKe", false);
		}
	
		request.getRequestDispatcher("TrangChu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
