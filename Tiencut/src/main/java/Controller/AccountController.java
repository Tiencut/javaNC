package Controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AccountController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            handleLogin(request, response);
        } else if ("signup".equals(action)) {
            handleSignup(request, response);
        } else if ("logout".equals(action)) {
            handleLogout(request, response);
        } else {
            request.getRequestDispatcher("view/account.jsp").forward(request, response);
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Logic kiểm tra đăng nhập
        if ("admin".equals(username) && "admin".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("dn", username);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("thongBao", "Tên đăng nhập hoặc mật khẩu không đúng.");
            request.getRequestDispatcher("view/auth.jsp").forward(request, response);
        }
    }

    private void handleSignup(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// Logic xử lý đăng ký (ví dụ: lưu thông tin vào cơ sở dữ liệu)
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            request.setAttribute("thongBao", "Mật khẩu và xác nhận mật khẩu không khớp.");
            request.getRequestDispatcher("view/account.jsp").forward(request, response);
            return;
        }

        // Lưu thông tin người dùng vào cơ sở dữ liệu
        // ...

        response.sendRedirect("account.jsp");
    }

    private void handleLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("dn");
        response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}