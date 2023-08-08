package bitcamp.myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.vo.Money;

@WebServlet("/money/list")
public class MoneyListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>가계부</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>사용 목록</h1>");
		out.println("<div style='margin:5px;'>");
		out.println("<a href='/money/form.html'>새 사용목록</a>");
		out.println("</div>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("  <tr><th>번호</th> <th>쓴 곳</th> <th>돈</th></tr>");
		out.println("</thead>");

		List<Money> list = InitServlet.moneyDao.findAll();
		for (Money m : list) {
			out.printf(
					"<tr>" + " <td>%d</td>" + " <td><a href='/member/detail?no=%d'>%s</a></td>" + " <td>%s</td></tr>\n",
					m.getNo(), m.getNo(), m.getwheres(), m.getPrice());
		}

		out.println("</tbody>");
		out.println("</table>");
		out.println("<a href='/'>메인</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
