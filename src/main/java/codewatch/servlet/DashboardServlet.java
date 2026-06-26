package codewatch.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import codewatch.dao.StudentDAO;
import codewatch.model.Student;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 StudentDAO dao = new StudentDAO();

	        List<Student> students = dao.getAllStudent();
	        
	        students.sort((s1, s2) -> {

	            int rank1 = s1.getRank() == 0 ? Integer.MAX_VALUE : s1.getRank();
	            int rank2 = s2.getRank() == 0 ? Integer.MAX_VALUE : s2.getRank();

	            return Integer.compare(rank1, rank2);
	        });

	    request.setAttribute("students", students);

	    if(students.size() > 0)
	        request.setAttribute("top1", students.get(0));

	    if(students.size() > 1)
	        request.setAttribute("top2", students.get(1));

	    if(students.size() > 2)
	        request.setAttribute("top3", students.get(2));

	        request.setAttribute("students", students);

	        request.getRequestDispatcher("admindashboard.jsp")
	               .forward(request, response);
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
