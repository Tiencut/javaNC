package UTILS;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loaiMODEL.loai;
import loaiMODEL.loaiBO;

public class utils {
    public static void loadLoaiSach(HttpServletRequest request) {
        loaiBO lBO = new loaiBO();
        ArrayList<loai> listTenLoai = lBO.getListTenLoai();
        request.setAttribute("listTenLoai", listTenLoai);
    }
}
