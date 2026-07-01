<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>

   

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

    <link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>
<%@ page import="codewatch.model.*" %>
<%@ page import="org.json.*" %>
<%
Student s=(Student)request.getAttribute("student");

JSONArray submission=(JSONArray)request.getAttribute("submission");

int activeDays =
(Integer)request.getAttribute("activeDays");


%>
<%
Integer longestStreak =
(Integer)request.getAttribute("longestStreak");

if(longestStreak == null)
{
    longestStreak = 0;
}
%>


<div class="container">

    <div class="profile-card">
        <div class="avatar">👩‍💻</div>

        <h2><%= s.getName() %></h2>
        <p><%= s.getLeetcodeUsername() %></p>
			<%
boolean activeToday =
Boolean.TRUE.equals(
    request.getAttribute("activeToday")
);
%>
			
       <span class="status">
<%= activeToday ?
    "🟢 Active Today" :
    "⚪ Not Active Today" %>
</span>
    </div>

    <div class="cards">

        <div class="card">
            <i class="fa-solid fa-fire"></i>
           <h3><%= longestStreak %></h3>
	<p>Longest Streak</p>
        </div>

        <div class="card">
            <i class="fa-solid fa-calendar-days"></i>
            <h3><%= activeDays %></h3>
            <p>Active Days</p>
        </div>

        <div class="card">
            <i class="fa-solid fa-star"></i>
            <h3><%= s.getRank() %></h3>
            <p>Ranking</p>
        </div>

        <div class="card">
            <i class="fa-solid fa-code"></i>
            <h3><%= s.getTotalSolved() %></h3>
            <p>Solved</p>
        </div>

    </div>

    <h3 class="title">Problem Statistics</h3>

    <div class="stats">

        <div class="stat easy">
            <h4>Easy</h4>
            <h2><%= s.getEasySolved() %></h2>
        </div>

        <div class="stat medium">
            <h4>Medium</h4>
            <h2><%= s.getMediumSolved() %></h2>
        </div>

        <div class="stat hard">
            <h4>Hard</h4>
            <h2><%= s.getHardSolved() %></h2>
        </div>

    </div>

    <h3 class="title">Recent Accepted Problems</h3>

    <div class="recent-problems">
		<% if(submission!=null)
		{
			int count=0;
			for(int i=0;i<submission.length();i++)
			{
				JSONObject sub = submission.getJSONObject(i);
				if(sub.getString("statusDisplay")
						.equals("Accepted"))
				{
					count++;
		%>		
		
		<div class="problem">
            <span><%= sub.getString("title") %></span>
            <%
            String status=sub.getString("statusDisplay");
            String badgeClass="medium-badge";
            if(status.equals("Accepted"))
            {
            	badgeClass = "easy-badge";
            }
            else if(status.equals("Wrong Answer"))
            {
            	 badgeClass = "hard-badge";
            }
            %>
            <span class="badge <%= badgeClass %>"> <%= status %></span>
        </div>
        	<%
        	if(count==5)
        		break;
				}
			}
		}
		
		%>
        
        
    </div>

</div>
<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

body{
    background:#f4f7fb;
    padding:15px;
}

.container{
    max-width:900px;
    margin:auto;
}

/* Profile */

.profile-card{
    background:white;
    padding:15px;
    border-radius:12px;
    text-align:center;
    box-shadow:0 2px 8px rgba(0,0,0,0.08);
}

.avatar{
    width:60px;
    height:60px;
    margin:auto;
    border-radius:50%;
    background:#eef3f8;
    display:flex;
    justify-content:center;
    align-items:center;
    font-size:28px;
}

.profile-card h2{
    margin-top:8px;
    color:#1d3557;
    font-size:22px;
}

.profile-card p{
    color:#666;
    font-size:13px;
}

.status{
    display:inline-block;
    margin-top:10px;
    background:#e8fff1;
    color:#2e7d32;
    padding:5px 12px;
    border-radius:20px;
    font-size:12px;
}

/* Cards */

.cards{
    margin-top:15px;
    display:grid;
    grid-template-columns:repeat(4,1fr);
    gap:12px;
}

.card{
    background:white;
    padding:15px;
    border-radius:12px;
    text-align:center;
    box-shadow:0 2px 8px rgba(0,0,0,0.08);
}

.card i{
    font-size:22px;
    color:#1d3557;
    margin-bottom:8px;
}

.card h3{
    color:#1d3557;
    font-size:22px;
}

.card p{
    color:#666;
    font-size:13px;
}

/* Title */

.title{
    margin-top:20px;
    margin-bottom:10px;
    color:#1d3557;
}

/* Statistics */

.stats{
    display:grid;
    grid-template-columns:repeat(3,1fr);
    gap:12px;
}

.stat{
    padding:15px;
    border-radius:12px;
    text-align:center;
    color:white;
}

.stat h2{
    margin-top:5px;
}

.easy{
    background:#4caf50;
}

.medium{
    background:#ff9800;
}

.hard{
    background:#f44336;
}

/* Problems */

.recent-problems{
    background:white;
    padding:15px;
    border-radius:12px;
    box-shadow:0 2px 8px rgba(0,0,0,0.08);
}

.problem{
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:10px 0;
    border-bottom:1px solid #eee;
}

.problem:last-child{
    border-bottom:none;
}

.badge{
    color:white;
    padding:4px 10px;
    border-radius:15px;
    font-size:11px;
}

.easy-badge{
    background:#4caf50;
}

.medium-badge{
    background:#ff9800;
}

.hard-badge{
    background:#f44336;
}

/* Mobile */

@media(max-width:768px){

    .cards{
        grid-template-columns:repeat(2,1fr);
    }

    .stats{
        grid-template-columns:1fr;
    }
}
</style>
</body>
</html>