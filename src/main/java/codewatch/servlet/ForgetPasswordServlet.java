package codewatch.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import codewatch.dao.DBConnection;

@WebServlet("/forgetpassword")
public class ForgetPasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String newPassword =
                request.getParameter("newpassword");

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "UPDATE account SET password=? WHERE email=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, newPassword);
            ps.setString(2, email);

            int result = ps.executeUpdate();

            if(result > 0) {

                response.sendRedirect(
                        "index.html?reset=success");

            } else {

                response.getWriter().println(
                        "Email not found");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}