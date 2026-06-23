package codewatch.servlet;

import java.io.IOException;

import org.json.JSONObject;

import codewatch.dao.StudentDAO;
import codewatch.model.Student;
import codewatch.util.LeetCodeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name =
                request.getParameter("name");

        String username =
                request.getParameter("leetcode");

        String email =
                request.getParameter("email");

        String batch =
                request.getParameter("batch");

        Student s = new Student();

        s.setName(name);
        s.setLeetcodeUsername(username);
        s.setEmail(email);
        s.setBatch(batch);
        try {
			String json=LeetCodeService.getData(username);
			JSONObject obj=new JSONObject(json);
			int easy=obj.getInt("easySolved");
			int medium=obj.getInt("mediumSolved");
			int hard=obj.getInt("hardSolved");
			int total=obj.getInt("solvedProblem");
			s.setEasySolved(easy);
			s.setMediumSolved(medium);
			s.setHardSolved(hard);
			s.setTotalSolved(total);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        StudentDAO dao =
                new StudentDAO();

        boolean result =
                dao.addStudent(s);

        if(result) {

            response.sendRedirect(
                    "success.jsp");

        } else {

            response.sendRedirect(
                    "error.jsp");
        }
    }
}