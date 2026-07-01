package codewatch.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import codewatch.dao.StudentDAO;
import codewatch.model.Student;

/**
 * Servlet implementation class DeleteServelt
 */
@WebServlet("/DeleteServelt")
public class DeleteServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 StudentDAO dao =
	                new StudentDAO();
		 int id=Integer.parseInt(request.getParameter("id"));
	        boolean result =
	                dao.DeleteStudentId(id);

	        if(result) {
	            response.sendRedirect("DashboardServlet?action=delete&success=true");
	        } else {
	            response.sendRedirect("DashboardServlet?action=delete&success=false");
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
