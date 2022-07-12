package gym;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setting/search")
public class SettingSearchController extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int sectorId = Integer.parseInt(request.getParameter("sectorId"));
		GymService service = new GymService();
		String data = service.loadSettingToJson(sectorId);
		if (data.equals("NO CONTENTS")) response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();		
		out.print(data);		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
