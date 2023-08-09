package bitcamp.myapp.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Member loginUser = (Member) req.getSession().getAttribute("loginUser");
		if (loginUser == null) {
			resp.sendRedirect("/auth/form.html");
			return;
		}

		Board b = new Board();
		b.setNo(Integer.parseInt(req.getParameter("no")));
		b.setWriter(loginUser);

		try {
			if (InitServlet.boardDao.delete(b) == 0) {
				System.out.println("해당 번호의 게시글이 없거나 삭제 권한이 없습니다.");
			} else {
				resp.sendRedirect("/board/list");
			}
			InitServlet.sqlSessionFactory.openSession(false).commit();
		} catch (Exception e) {
			InitServlet.sqlSessionFactory.openSession(false).rollback();
			throw new RuntimeException(e);
		}
	}
}
