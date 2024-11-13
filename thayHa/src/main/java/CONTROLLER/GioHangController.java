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

    public GioHangController() {
        super();
    }

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

        
        String action = request.getParameter("action");
        if ("themVaoGio".equals(action)) {
            themVaoGio(request, session);
        }

        // 
        UTILS.utils.loadLoaiSach(request);
        loadGioHang(request, session);

        request.getRequestDispatcher("View/GioHang.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "xoaDaChon":
                xoaDaChon(request);
                response.sendRedirect("GioHangController");
                break;
            case "xoaKhoiGio":
                xoaKhoiGio(request);
                response.sendRedirect("GioHangController");
                break;
            case "xacNhanDatMua":
                response.sendRedirect("XacNhanDatMuaController");
                break;
            default:
                break;
        }
    }

    private void themVaoGio(HttpServletRequest request, HttpSession session) {
        String maSach = request.getParameter("maSach");
        ArrayList<Sach> gioHang = getGioHang(session);

        boolean checkSachCoTrongGio = gioHang.stream().anyMatch(sach -> sach.getMaSach().equals(maSach));

        if (!checkSachCoTrongGio) {
            sachBO sBO = new sachBO();
            Sach sach = sBO.getThongTinSach(maSach);
            sach.setSoLuong(1);
            gioHang.add(sach);
        } else {
            for (Sach sach : gioHang) {
                if (sach.getMaSach().equals(maSach)) {
                    sach.setSoLuong(sach.getSoLuong() + 1);
                    break;
                }
            }
        }

        session.setAttribute("gioHang", gioHang);
    }

    private void xoaDaChon(HttpServletRequest request) {
        String[] listMaSachCanXoa = request.getParameterValues("listMaSachCanXoa");
        if (listMaSachCanXoa != null) {
            // 
            for (String maSach : listMaSachCanXoa) {
                System.out.println("Mã sách được chọn" + maSach);
            }

            HttpSession session = request.getSession();
            sachBO sBO = new sachBO();
            ArrayList<Sach> gioHang = getGioHang(session);
            for (String maSachCanXoa : listMaSachCanXoa) {
                gioHang = sBO.xoaSach(gioHang, maSachCanXoa);
            }
            session.setAttribute("gioHang", gioHang);
        }
    }

    private void xoaKhoiGio(HttpServletRequest request) {
        String maSachXoa = request.getParameter("maSachXoa");
        HttpSession session = request.getSession();
        sachBO sBO = new sachBO();
        ArrayList<Sach> gioHang = getGioHang(session);
        gioHang = sBO.xoaSach(gioHang, maSachXoa);
        session.setAttribute("gioHang", gioHang);
    }

    private ArrayList<Sach> getGioHang(HttpSession session) {
        return (ArrayList<Sach>) (session.getAttribute("gioHang") != null
                ? session.getAttribute("gioHang")
                : new ArrayList<Sach>());
    }

    // private void loadLoaiSach(HttpServletRequest request) {
    //     loaiBO lBO = new loaiBO();
    //     ArrayList<loai> listTenLoai = lBO.getListTenLoai();
    //     request.setAttribute("listTenLoai", listTenLoai);
    // }

    private void loadGioHang(HttpServletRequest request, HttpSession session) {
        ArrayList<Sach> gioHang = getGioHang(session);
        request.setAttribute("gioHang", gioHang);
    }
}