package list;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class RouteListWithFilterController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNumber = Integer.parseInt(request.getParameter("page"));
		int gymId = Integer.parseInt(request.getParameter("gymId"));
		int sectorId = Integer.parseInt(request.getParameter("sectorId"));
		String hold = request.getParameter("holdColor");
		String level = request.getParameter("levelColor");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		String order = request.getParameter("order");			
		
	}


}
