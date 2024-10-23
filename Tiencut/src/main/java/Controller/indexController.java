
package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import loaiModel.loai;
import loaiModel.loaiBO;
import sachModel.sach;
import sachModel.sachBO;

@WebServlet("/indexController")
public class indexController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public indexController() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // lấy list loại đưa vào request
        List<loai> loaiList = (new loaiBO()).getLoai();
        request.setAttribute("loaiList", loaiList);

        List<sach> sachList = (List<sach>) request.getAttribute("sachList");
        if (sachList == null || sachList.isEmpty()) {
            try {
				sachList = (new sachBO()).getSach();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            request.setAttribute("sachList", sachList);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action != null && action.equals("timSach")) {
//            String sachCanTim = request.getParameter("sachCanTim");
//            ArrayList<sach> list_sach = (new sachBO()).TimMa(sachCanTim);
//            if (list_sach != null && !list_sach.isEmpty()) {
//                request.setAttribute("sachList", list_sach);
//            } else {
//                list_sach = (new sachBO()).TimLoai(sachCanTim);
//                request.setAttribute("sachList", list_sach);
//            }
//        } else if (action != null && action.equals("sachTheoLoai")) {
//            String maLoai = request.getParameter("maLoai");
//            List<sach> sachTheoLoai = (new sachBO()).TimLoai(maLoai);
//            request.setAttribute("sachList", sachTheoLoai);
//        }
        doGet(request, response);
    }
}