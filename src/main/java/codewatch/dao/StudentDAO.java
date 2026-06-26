package codewatch.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import codewatch.model.Student;

public class StudentDAO {

    public boolean addStudent(Student student) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO students(name,leetcode_username,email,batch,easy_solved,medium_solved,hard_solved,total_solved,lc_ranking) VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getLeetcodeUsername());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getBatch());
            ps.setInt(5,student.getEasySolved());
            ps.setInt(6, student.getMediumSolved());
            ps.setInt(7, student.getHardSolved());
            ps.setInt(8, student.getTotalSolved());
            ps.setInt(9,student.getRank() );

            int row = ps.executeUpdate();

            if(row > 0) {
                status = true;
            }
            System.out.println("Status = " + status);

        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
    public boolean updateLeetCodeStats(String username,int easy, int medium, int hard, int total)
    {
    	boolean status=false;
    	try
    	{
    		Connection con =DBConnection.getConnection();
    		 String q=
    		            "UPDATE students SET " +
    		            "easy_solved=?, " +
    		            "medium_solved=?, " +
    		            "hard_solved=?, " +
    		            "total_solved=? " +
    		            "WHERE leetcode_username=?";
    		PreparedStatement ps=con.prepareStatement(q);
    		ps.setInt(1,easy);
    		ps.setInt(2,medium);
    		ps.setInt(3,hard );
    		ps.setInt(4, total);
    		ps.setString(5,username);
    		int row=ps.executeUpdate();
    		if(row>0)
    		{
    			status=true;
    		}
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return status;
    }
    public List<Student> getAllStudent()
    {
    	List<Student> list= new ArrayList<>();
    	try
    	{
    		Connection con =DBConnection.getConnection();
    		String q="select * from students";
    		PreparedStatement ps=con.prepareStatement(q);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			Student s=new Student();
    			s.setId(rs.getInt("id"));
    			s.setName(rs.getString("name"));
    			s.setLeetcodeUsername(rs.getString("leetcode_username"));
    			s.setEasySolved(rs.getInt("easy_solved"));
    			s.setMediumSolved(rs.getInt("medium_solved"));
    			s.setHardSolved(rs.getInt("hard_solved"));
    			s.setTotalSolved(rs.getInt("total_solved"));
    			s.setRank(rs.getInt("lc_ranking"));
    			s.setBatch(rs.getString("batch"));
    			list.add(s);
    			
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return list;
    }
    
    public Student getStudentId(int id)
    {
    	Student s=null;
    	try
    	{
    		Connection con =DBConnection.getConnection();
    		String q="select * from students where id=?";
    		PreparedStatement ps=con.prepareStatement(q);
    		ps.setInt(1, id);
    		ResultSet rs=ps.executeQuery();
    		if(rs.next())
    		{
    			s=new Student();
    			s.setId(rs.getInt("id"));
    			s.setName(rs.getString("name"));
    			s.setLeetcodeUsername(rs.getString("leetcode_username"));
    			s.setEasySolved(rs.getInt("easy_solved"));
    			s.setMediumSolved(rs.getInt("medium_solved"));
    			s.setHardSolved(rs.getInt("hard_solved"));
    			s.setTotalSolved(rs.getInt("total_solved"));
    			s.setRank(rs.getInt("lc_ranking"));
    		}
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return s;
    }
    public boolean DeleteStudentId(int id)
    {
    	boolean status = false;
    	try
    	{
    		Connection con =DBConnection.getConnection();
    		String q="delete from students where id=?";
    		PreparedStatement ps=con.prepareStatement(q);
    		ps.setInt(1,id);
    		 int row = ps.executeUpdate();

             if(row > 0) {
                 status = true;
             }
             System.out.println("Status = " + status);
             
    		    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return status;
    }
}
