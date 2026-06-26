package codewatch.servlet;

import jakarta.servlet.ServletException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import codewatch.dao.StudentDAO;
import codewatch.model.Student;
import codewatch.util.LeetCodeService;

/**
 * Servlet implementation class StudentProfileServlet
 */
@WebServlet("/StudentProfileServlet")
public class StudentProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		StudentDAO dao=new StudentDAO();
		Student student =dao.getStudentId(id);
		JSONArray submission =null;
		JSONObject profileObj =null;
		JSONObject calendar =null;
		int activeDays =0;
		long lastActiveTimestamp = 0;
		try {
			String json =
			        LeetCodeService.getRecentSubmission(
			            student.getLeetcodeUsername());
			JSONObject obj=new JSONObject(json);
			 submission =obj.getJSONArray("submission");
			 String profileJson =
				        LeetCodeService.getProfile(
				                student.getLeetcodeUsername());
			 profileObj =
				        new JSONObject(profileJson);
			 calendar =
				        profileObj.getJSONObject(
				                "submissionCalendar");
			 
			 activeDays =
				        calendar.length();
			 
			 for(String key : calendar.keySet())
			 {
			     long ts = Long.parseLong(key);

			     if(ts > lastActiveTimestamp)
			     {
			         lastActiveTimestamp = ts;
			     }
			 }
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String lastActiveDate =
			    Instant.ofEpochSecond(lastActiveTimestamp)
			           .atZone(ZoneId.systemDefault())
			           .format(
			               DateTimeFormatter.ofPattern("dd-MM-yyyy")
			           );
		
		long today =
			    java.time.LocalDate.now()
			    .atStartOfDay(java.time.ZoneId.systemDefault())
			    .toEpochSecond();

			boolean activeToday =
			    calendar.has(String.valueOf(today));

			request.setAttribute(
			    "activeToday",
			    activeToday
			);
			List<Long> days = new ArrayList<>();
			for(String key : calendar.keySet())
			{
			    days.add(Long.parseLong(key));
			}
			Collections.sort(days);

			int longestStreak = 0;
			int currentStreak = 1;
				
			for(int i=1; i<days.size(); i++)
			{
			    long diff = days.get(i) - days.get(i-1);

			    // 86400 seconds = 1 day
			    if(diff == 86400)
			    {
			        currentStreak++;
			    }
			    else
			    {
			        longestStreak =
			            Math.max(longestStreak, currentStreak);

			        currentStreak = 1;
			    }
			}
				
			longestStreak =
				    Math.max(longestStreak, currentStreak);


			
		request.setAttribute("student", student);
		request.setAttribute("submission", submission);
		request.setAttribute(
		        "activeDays",
		        activeDays);
		request.setAttribute(
			    "lastActiveTimestamp",
			    lastActiveTimestamp
			);
		request.setAttribute(
			    "lastActiveDate",
			    lastActiveDate
			);
		request.setAttribute(
			    "longestStreak",
			    longestStreak
			);
		request.getRequestDispatcher("studentProfile.jsp").forward(request, response);
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
