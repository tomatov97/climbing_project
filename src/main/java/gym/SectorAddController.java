package gym;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GymInfoDao;
import vo.SectorInfo;

@WebServlet("/sector/add")
public class SectorAddController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int gymId = Integer.parseInt(request.getParameter("gymId"));
		String sectorName = request.getParameter("sectorName");
		
		SectorInfo sector = new SectorInfo(gymId, sectorName);
		
		GymInfoDao dao = new GymInfoDao();
		int status = dao.insertSectorInfo(sector);
		response.setStatus(status);
		response.sendRedirect("/climbing/main/problemList.jsp");
	}

}
