package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MemberInfoDao;
import exception.BadParameterException;
import vo.Member;

/**
 * Servlet implementation class UpdateMemberInfo
 */
@WebServlet("/member/update")
public class MemberUpdateController extends HttpServlet {
	private static final int MAXIMUM_FILE_SIZE = 1 * 1024 * 1024;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRealPath("images/member");
		
		MultipartRequest mr = new MultipartRequest(request, path, MAXIMUM_FILE_SIZE, "UTF-8", new DefaultFileRenamePolicy());
		if (mr.getParameter("idx") == null) throw new BadParameterException();
		
		int idx = Integer.parseInt(mr.getParameter("idx"));
		String id = mr.getParameter("id");
		String name = mr.getParameter("name");
		String email = mr.getParameter("email");
		String nickname = mr.getParameter("nickname");
		String img = mr.getFilesystemName("img");
		if (img == null) {
			img = mr.getParameter("img");
		}
		
		Member memberInfo = new Member(idx, id, name, email, nickname, img);
		MemberInfoDao dao = new MemberInfoDao();
		int status = dao.updateByIdx(memberInfo);
		
		response.setStatus(status);
	
	}

}
