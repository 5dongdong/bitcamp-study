package bitcamp.myapp.handler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.dao.mySQLBoardDao;
import bitcamp.myapp.dao.mySQLMemberDao;
import bitcamp.myapp.dao.mySQLMoneyDao;
import bitcamp.util.SqlSessionFactoryProxy;

@WebServlet(value = "/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static SqlSessionFactory sqlSessionFactory;
	public static BoardDao boardDao;
	public static MemberDao memberDao;
	public static MoneyDao moneyDao;

	@Override
	public void init() throws ServletException {
		System.out.println("InitServlet.init() 호출됨!");

		try {
			sqlSessionFactory = new SqlSessionFactoryProxy(new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("bitcamp/myapp/config/mybatis-config.xml")));

			boardDao = new mySQLBoardDao(sqlSessionFactory);
			memberDao = new mySQLMemberDao(sqlSessionFactory);
			moneyDao = new mySQLMoneyDao(sqlSessionFactory);

		} catch (Exception e) {
			System.out.println("InitServlet.init() 실행 중 오류 발생!");
			e.printStackTrace();
		}
	}
}
