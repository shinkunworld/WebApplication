package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public InsertServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SampleDAO dao = new SampleDAO();
		request.setCharacterEncoding("UTF-8");

		//パラメータを受け取る
		String details=request.getParameter("details");
		String remark=request.getParameter("remark");
		String payment=request.getParameter("payment");
		int amount=Integer.parseInt(request.getParameter("amount"));
		HttpSession session = request.getSession();
		//処理結果に応じてメッセージを変える
		if(dao.insert(details,remark,payment,amount) == 0 ) {
			session.setAttribute("message", "登録失敗");
		}else {
			session.setAttribute("message", "登録完了");
		}

		RequestDispatcher d = request.getRequestDispatcher("/result.jsp");
		d.forward(request, response);

		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}



		}


	