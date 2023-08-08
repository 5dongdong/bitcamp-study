package bitcamp.myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.vo.Money;

@WebServlet()
public class MoneyDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Money money = InitServlet.moneyDao.findBy(Integer.parseInt(req.getParameter("no")));

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>용돈</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>용</h1>");

		if (money == null) {
			out.println("<p>해당 번호의 회원이 없습니다!</p>");

		} else {
			out.println("<form action='/member/update' method='post'>");
			out.println("<table border='1'>");
			out.printf(
					"<tr><th style='width:120px;'>번호</th>"
							+ " <td style='width:300px;'><input type='text' name='no' value='%d' readonly></td></tr>\n",
					money.getNo());
			out.printf("<tr><th style='width:120px;'>사용기록</th>"
					+ " <td style='width:300px;'><input type='text' name='where' value='%d' readonly></td></tr>\n",
					money.getwheres());
			out.println("</table>");
			out.println("<div>");
			out.println("<button>변경</button>");
			out.println("<button type='reset'>초기화</button>");
			out.printf("<a href='/member/delete?no=%d'>삭제</a>\n", money.getNo());
			out.println("<a href='/member/list'>목록</a>\n");
			out.println("</div>");
			out.println("</form>");
		}

		out.println("</body>");
		out.println("</html>");
	}

}
