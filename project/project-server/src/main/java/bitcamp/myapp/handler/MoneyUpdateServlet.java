package bitcamp.myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.vo.Money;

@WebServlet("/money/update")
public class MoneyUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Money money = new Money();
		money.setNo(Integer.parseInt(req.getParameter("no")));
		money.setwheres(req.getParameter("where"));
		money.setPrice(Integer.parseInt(req.getParameter("price")));

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta http-equiv='refresh' content='1;url=/money/list'>");
		out.println("<title>가계부</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>사용내역 변경</h1>");

		try {
			if (InitServlet.moneyDao.update(money) == 0) {
				out.println("<p>회원이 없습니다.</p>");
			} else {
				InitServlet.sqlSessionFactory.openSession(false).commit();
				out.println("<p>변경했습니다!</p>");
			}
		} catch (Exception e) {
			InitServlet.sqlSessionFactory.openSession(false).rollback();
			out.println("<p>변경 실패입니다!</p>");
			e.printStackTrace();
		}

		out.println("</body>");
		out.println("</html>");
	}
}
