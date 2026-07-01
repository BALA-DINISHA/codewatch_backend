package codewatch.servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import codewatch.dao.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Connection connection =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO account(name,email,password) VALUES(?,?,?)";

            PreparedStatement statement =
                    connection.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            int rowsInserted =
                    statement.executeUpdate();

            if (rowsInserted > 0) {

                HttpSession session =
                        request.getSession();

                session.setAttribute("name", name);
                session.setAttribute("email", email);

                response.sendRedirect(
                        request.getContextPath()
                        + "/DashboardServlet");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}