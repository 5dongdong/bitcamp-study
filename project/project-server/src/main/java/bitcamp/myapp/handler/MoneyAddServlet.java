package bitcamp.myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.vo.Money;

@WebServlet("/money/add")
public class MoneyAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Money m = new Money();
		m.setwheres(req.getParameter("where"));
		m.setPrice(Integer.parseInt(req.getParameter("price")));

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8>");
		out.printf("<meta http-equiv='refresh content='1; url = /money/list>\n");
		out.println("<title>가계부</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>사용한 곳 등록</h1>");
		try {
			InitServlet.moneyDao.insert(m);
			InitServlet.sqlSessionFactory.openSession(false).commit();
			out.println("<p>등록 성공입니다!</p>");

		} catch (Exception e) {
			InitServlet.sqlSessionFactory.openSession(false).rollback();
			out.println("<p>등록 실패입니다!</p>");
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
	}

}
