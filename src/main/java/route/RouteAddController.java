package route;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.RouteInfoDao;
import vo.Routes;

/**
 * Servlet implementation class RouteAddController
 */
@WebServlet("/route/add")
public class RouteAddController extends HttpServlet {
	private static final int MAXIMUM_FILE_SIZE = 1 * 1024 * 1024; // 1MB	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getRealPath("images/route");
		
		MultipartRequest mr = new MultipartRequest(request, path, MAXIMUM_FILE_SIZE, "UTF-8", new DefaultFileRenamePolicy());
		RouteService service = new RouteService();
		
		int routeId = service.createId();
		int settingId = Integer.parseInt(mr.getParameter("settingId"));
		String hold = mr.getParameter("holdColor");
		String level = mr.getParameter("levelColor");
		String name = service.createName(settingId, hold, level);
		String comment = mr.getParameter("comment");		
		String img = mr.getFilesystemName("img");
		int gymId = Integer.parseInt(mr.getParameter("gymId"));
		
		Routes newRoute = new Routes(routeId, settingId, name, hold, level, comment, img);
		
		RouteInfoDao dao = new RouteInfoDao();
		int status = dao.insertRouteInfo(newRoute);
		response.setStatus(status);	
		response.sendRedirect("/rockmate/main/routeList.jsp?pageNumber=1&gymId="+gymId);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int gymId = Integer.parseInt(req.getParameter("gymId"));
		req.setAttribute("gymId", gymId);
		
		RequestDispatcher rd = req.getRequestDispatcher("../addAndUpdate/routeAdd.jsp");
		rd.forward(req, resp);
	}
	
	

}
