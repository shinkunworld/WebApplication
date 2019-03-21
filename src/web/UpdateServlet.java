package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SampleDAO dao = new SampleDAO();
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		int income = Integer.parseInt(request.getParameter("income"));
		int expense = Integer.parseInt(request.getParameter("expense"));
		String details = request.getParameter("details");

		HttpSession session = request.getSession();
		// 処理結果に応じてメッセージを変える
		if (dao.update(id, income, expense, details) == 0) {
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
