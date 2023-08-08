package bitcamp.myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.vo.Member;

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Member member = new Member();
		member.setNo(Integer.parseInt(req.getParameter("no")));
		member.setName(req.getParameter("name"));
		member.setEmail(req.getParameter("email"));
		member.setPassword(req.getParameter("password"));
		member.setGender(req.getParameter("gender").charAt(0));

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta http-equiv='refresh' content='1;url=/member/list'>");
		out.println("<title>회원</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>회원 변경</h1>");

		try {
			if (InitServlet.memberDao.update(member) == 0) {
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
