package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public UpdateServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO dao = new DAO();
		request.setCharacterEncoding("UTF-8");
		
		String details=request.getParameter("details");
		String remark=request.getParameter("remark");
		String payment=request.getParameter("payment");
		int amount=Integer.parseInt(request.getParameter("amount"));
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		// 処理結果に応じてメッセージを変える
		if (dao.update(details, remark, payment, amount,id) == 0) {
			session.setAttribute("message", "更新失敗");
		} else {
			session.setAttribute("message", "更新完了");
		}
		RequestDispatcher d = request.getRequestDispatcher("/result.jsp");
		d.forward(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
