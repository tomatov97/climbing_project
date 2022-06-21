package gym;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.GymInfoDao;
import vo.Gyms;

/**
 * Servlet implementation class GymAddController
 */
@WebServlet("/gym/add")
public class GymAddController extends HttpServlet {
	private static final int MAXIMUM_FILE_SIZE = 1 * 1024 * 1024; // 1MB
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRealPath("images/gym");
		
		MultipartRequest mr = new MultipartRequest(request, path, MAXIMUM_FILE_SIZE, "UTF-8", new DefaultFileRenamePolicy());
		
		String name = mr.getParameter("name");
		String addr = mr.getParameter("addr");
		String tel = mr.getParameter("tel");
		String img = mr.getFilesystemName("img");
		String manager = mr.getParameter("manager");
		LocalDateTime regDate = LocalDateTime.now();
		
		Gyms newGym = new Gyms(name,addr,tel,img,manager,regDate);
		
		GymInfoDao dao = new GymInfoDao();
		int status = dao.insertGymInfo(newGym);
		response.setStatus(status);	
		response.sendRedirect("/climbing/main/problemList.jsp");
		
	}

}
