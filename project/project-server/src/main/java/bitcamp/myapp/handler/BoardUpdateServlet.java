package bitcamp.myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;

@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Member loginUser = (Member) req.getSession().getAttribute("loginUser");
		if (loginUser == null) {
			resp.sendRedirect("/auth/form.html");
			return;
		}

		int category = Integer.parseInt(req.getParameter("category"));

		Board board = new Board();
		board.setNo(Integer.parseInt(req.getParameter("no")));
		board.setTitle(req.getParameter("title"));
		board.setContent(req.getParameter("content"));
		board.setWriter(loginUser);
		board.setCategory(category);

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.printf("<meta http-equiv='refresh' content='1;url=/board/list?category=%d'>\n", category);
		out.println("<title>게시글</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>게시글 변경</h1>");
		try {
			if (InitServlet.boardDao.update(board) == 0) {
				out.println("<p>게시글이 없거나 변경 권한이 없습니다.</p>");
			} else {
				out.println("<p>변경했습니다!</p>");
			}
			InitServlet.sqlSessionFactory.openSession(false).commit();

		} catch (Exception e) {
			InitServlet.sqlSessionFactory.openSession(false).rollback();
			out.println("<p>게시글 변경 실패입니다!</p>");
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
	}
}
