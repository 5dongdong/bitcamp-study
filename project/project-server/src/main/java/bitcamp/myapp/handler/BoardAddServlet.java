package bitcamp.myapp.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;

@WebServlet
public class BoardAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Member loginUser = (Member) req.getSession().getAttribute("loginUser");
		if (loginUser == null) {
			resp.sendRedirect("/auth/form.html");
			return;
		}

		Board board = new Board();
		board.setTitle(req.getParameter("title"));
		board.setContent(req.getParameter("content"));
		board.setWriter(loginUser);
	}

}
