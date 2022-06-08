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
import vo.MemberInfo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 파라미터 꺼내기
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			// 2. 입력값 검증
			MemberValidator validator = new MemberValidator();
			if 		(!validator.idValidator(id)) throw new BadParameterException();
			else if (!validator.pwValidator(pw)) throw new BadParameterException();
			
			// 3. 꺼낸 파라미터를 하나의 정보로 뭉치기
			MemberInfo loginInfo = new MemberInfo();
			loginInfo.setId(id);
			loginInfo.setPw(pw);
			
			// 4-1. 로그인 여부 확인 후, 성공시 로그인 유저 정보를 세션에 저장, 200으로 응답
			// 4-2. 로그인 실패시:
			// 		4-2-1. 전달받은 값이 규칙에 맞지 않을 때 : 400으로 응답
			//		4-2-2. 아이디 또는 비밀번호가 틀렸을 때 : 401로 응답
			MemberService service = new MemberService();
			if (service.selectLoginInfo(loginInfo) != null) {
				
				loginInfo = service.selectLoginInfo(loginInfo);
				
				HttpSession session = request.getSession();
				session.setAttribute("loginUserInfo", loginInfo);
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		} catch (BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
