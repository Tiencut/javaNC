package Controller;

import java.io.IOException;

import giohangmodal.giohangBO;
import giohangmodal.hang;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GioHangSuaController
 */
@WebServlet("/GioHangSuaController")
public class GioHangController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GioHangController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	giohangBO giohang = (giohangBO) session.getAttribute("gh");

        if (giohang == null) {
        	giohang = new giohangBO();
            session.setAttribute("gh", giohang);
        }

        long tongTien = giohang.Tong();
        request.setAttribute("tongTien", tongTien);
        
        request.setAttribute("gh", giohang);
        request.getRequestDispatcher("htgio.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        giohangBO giohoang = (giohangBO) session.getAttribute("gh");

        if (giohoang == null) {
            giohoang = new giohangBO();
            session.setAttribute("gh", giohoang);
        }

        String action = request.getParameter("action");
        String maSP = request.getParameter("maSP");

        if ("xoa".equals(action) && maSP != null) {
            giohoang.Xoa(maSP);
        } else if ("sua".equals(action)) {
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));

            // tính số lượng trong giỏ
            int soLuongTrongGio = 0;
            for (hang h : giohoang.ds) {
                if (h.getMasach().equals(maSP)) {
                    soLuongTrongGio += h.getSoLuong();
                }
            }

            if (maSP == null || maSP.isEmpty()) {
                response.getWriter().println("MaSP không hợp lệ");
            } else if ((soLuongTrongGio + soLuong) < 0) {
                response.getWriter().println("Số lượng không hợp lệ");
            } else {
                try {
                    giohoang.Them(maSP, soLuong);
                } catch (Exception e) {
                    response.getWriter().println("Sửa thất bại");
                }
            }
        } else if ("them".equals(action)) {
            try {
                String maSach = request.getParameter("maSach");
                String tenSach = request.getParameter("tenSach");
                String gia = request.getParameter("gia");

                if (maSach == null || tenSach == null || gia == null) {
                    response.getWriter().println("Dữ liệu không hợp lệ");
                } else {
                    giohoang.Them(maSach, tenSach, Long.parseLong(gia), 1);
                    session.setAttribute("gh", giohoang);
                }
            } catch (Exception e) {
                response.getWriter().println("Thêm thất bại");
            }
        }

        request.setAttribute("giohang", giohoang);
        request.getRequestDispatcher("htgio.jsp").forward(request, response);
    }
}