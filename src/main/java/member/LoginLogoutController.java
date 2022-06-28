package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.BadParameterException;
import util.MemberValidator;
import vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginLogoutController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUserInfo");		
		response.sendRedirect("/climbing/main");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			/*
			 * MemberValidator validator = new MemberValidator(); if
			 * (!validator.idValidator(id)) throw new BadParameterException(); else if
			 * (!validator.pwValidator(pw)) throw new BadParameterException();
			 */

			Member loginInfo = new Member();
			loginInfo.setId(id);
			loginInfo.setPw(pw);

			MemberService service = new MemberService();
			if (service.selectLoginInfo(loginInfo) != null) {
				
				loginInfo = service.selectLoginInfo(loginInfo);
				
				HttpSession session = request.getSession();
				session.setAttribute("loginUserInfo", loginInfo);
				response.setStatus(HttpServletResponse.SC_OK);
			} else	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		} catch (BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
