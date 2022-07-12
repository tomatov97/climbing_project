package route;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RouteCountController
 */
@WebServlet("/route/count")
public class RouteCountController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		RouteService service = new RouteService();
		int settingId = Integer.parseInt(request.getParameter("settingId"));
		String hold = request.getParameter("holdColor");
		String level = request.getParameter("levelColor");
		
		int count = service.isAlreadyColors(settingId, hold, level);
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("{\"count\":"+count+"}");
		
		out.close();
	}

	

}
