package ru;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/TestDbServlet")
public class JDBCConnectionTest extends HttpServlet {

    private static final long serialVersionUID = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = "user";
        String pasword = "password";
        String url = "jdbc:postgresql://localhost:5432/crm";
        String driver = "org.postgresql.Driver";

        try {
            PrintWriter out = resp.getWriter();

            out.println("Connecting to database: " + url);
            Class.forName(driver);

            Connection connection = DriverManager.getConnection(url, user, pasword);

            out.println("SUCCESS!!!");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
