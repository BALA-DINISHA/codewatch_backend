package codewatch.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import codewatch.dao.DBConnection;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM account WHERE email=? AND password=?";

            PreparedStatement statement =
                    connection.prepareStatement(query);

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet =
                    statement.executeQuery();

            if(resultSet.next()) {

                HttpSession session =
                        request.getSession();

                session.setAttribute(
                        "name",
                        resultSet.getString("name"));

                session.setAttribute(
                        "email",
                        resultSet.getString("email"));

                response.sendRedirect("DashboardServlet");

            } else {

                response.sendRedirect(
                        "index.html?error=notfound");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}