package gym;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.GymInfoDao;
import exception.BadParameterException;
import vo.Gyms;

/**
 * Servlet implementation class GymUpdateController
 */
@WebServlet("/gym/update")
public class GymUpdateController extends HttpServlet {	
	private static final int MAXIMUM_FILE_SIZE = 1 * 1024 * 1024;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRealPath("images/gym");
		
		MultipartRequest mr = new MultipartRequest(request, path, MAXIMUM_FILE_SIZE, "UTF-8", new DefaultFileRenamePolicy());
		if (mr.getParameter("idx") == null) throw new BadParameterException();
		
		int idx = Integer.parseInt(mr.getParameter("idx"));
		String name = mr.getParameter("name");
		String addr = mr.getParameter("addr");
		String tel = mr.getParameter("tel");
		String img = mr.getFilesystemName("img");
		if (img == null) img = mr.getParameter("img");
		String manager = mr.getParameter("manager");
		
		Gyms gymInfo = new Gyms(idx, name, addr, tel, img, manager);
		GymInfoDao dao = new GymInfoDao();
		int status = dao.updateGymByIdx(gymInfo);
		
		response.setStatus(status);
	}

}
