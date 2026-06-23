package codewatch.servlet;

import java.io.IOException;

import org.json.JSONObject;

import codewatch.dao.StudentDAO;
import codewatch.util.LeetCodeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/leetcode")
public class LeetCodeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        try {
        	

            String result =
                LeetCodeService.getData("lavanyaaKR");
            
            JSONObject obj = new JSONObject(result);
            
            int easy = obj.getInt("easySolved");
            int medium = obj.getInt("mediumSolved");
            int hard = obj.getInt("hardSolved");
            int total = obj.getInt("solvedProblem");
            StudentDAO dao=new StudentDAO();
            boolean status=dao.updateLeetCodeStats("lavanyaaKR", easy, medium, hard, total);
            System.out.println(status);
            resp.setContentType("application/json");
            resp.getWriter().println(result);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}