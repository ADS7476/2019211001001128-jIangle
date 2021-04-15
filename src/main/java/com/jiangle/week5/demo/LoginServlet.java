package com.jiangle.week5.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null; //class variable

    @Override
    public void init() throws ServletException {
        super.init();
        //only one connection
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
        //String username="jl1";
        //String password="123456";
        //code like this is bad way --because change in not easy
        //for example change password of db = change in java code

        //get servletconfig --> getInitParameters --no change
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");


        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->" + con); //ok(use java code) -ok (use config in web.xml) -ok --use(@webservlet)
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter writer = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sql = "select * from [user]" + "WHERE username='" + username + "'" + " AND " + "password = '" + password + "'" + ';';
        ResultSet rs = null;
        try {
            rs = con.createStatement().executeQuery(sql);
            if (rs.next()) {
                //out.print("Login successful!!! ");
                //out.print("Welcome "+username) ;
                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("username", rs.getString("username"));
                request.setAttribute("password", rs.getString("password"));
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("gender ", rs.getString("gender "));
                request.setAttribute("birthDate ", rs.getString("binthdate"));
                //forward to user info jsp
                request.getRequestDispatcher("userList.jsp").forward(request, response);
            } else {
                //writer.print("Username or password Error! ! ! ");
                request.setAttribute("message", "Username or Password Error!! ! ");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            try {
                if (rs.next()) {
                } else {
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}