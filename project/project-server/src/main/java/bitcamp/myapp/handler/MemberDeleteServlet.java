package bitcamp.myapp.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class MemberDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			if (InitServlet.memberDao.delete(Integer.parseInt(req.getParameter("no"))) == 0) {
				throw new Exception("해당 번호의 회원이 없습니다.");
			} else {
				resp.sendRedirect("/member/list");
			}
			InitServlet.sqlSessionFactory.openSession(false).commit();

		} catch (Exception e) {
			InitServlet.sqlSessionFactory.openSession(false).rollback();
			throw new RuntimeException(e);
		}
	}

}