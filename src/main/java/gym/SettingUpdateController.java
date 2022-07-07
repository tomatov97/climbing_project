package gym;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GymInfoDao;
import vo.Sectors;
import vo.Settings;

@WebServlet("/setting/update")
public class SettingUpdateController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int sectorId = Integer.parseInt(request.getParameter("sectorId"));
		LocalDate setDate = LocalDate.parse(request.getParameter("setDate"));
		LocalDate removeDate = LocalDate.parse(request.getParameter("removeDate"));
		
		Settings setting = new Settings(sectorId, setDate, removeDate);
		
		GymInfoDao dao = new GymInfoDao();
		int status = dao.updateSettingById(setting);
		response.setStatus(status);
		response.sendRedirect("/rockmate/main/routeList.jsp");
	}

}
