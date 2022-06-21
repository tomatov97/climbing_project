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
import vo.Sectors;

/**
 * Servlet implementation class GymUpdateController
 */
@WebServlet("/sector/update")
public class SectorUpdateController extends HttpServlet {	
	private static final int MAXIMUM_FILE_SIZE = 1 * 1024 * 1024;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int sectorId = Integer.parseInt(request.getParameter("sectorId"));
		int gymId = Integer.parseInt(request.getParameter("gymId"));
		String sectorName = request.getParameter("sectorName");
		
		Sectors sector = new Sectors(sectorId, gymId, sectorName);
		
		GymInfoDao dao = new GymInfoDao();
		int status = dao.updateSectorById(sector);
		response.setStatus(status);
		response.sendRedirect("/climbing/main/problemList.jsp");
	}

}
