package com.jiangle.week5.demo;

import com.jiangle.dao.UserDao;
import com.jiangle.model.User;

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
    Connection con=null; //class variable
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
        //only one connection
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
        //String username="sa";
        //String password="123456";
        //code like this is bad way --because change in not easy
        //for example change password of db = change in java code

        //get servletconfig --> getInitParameters --no change
       /* String driver= getServletContext().getInitParameter("driver");
        String url= getServletContext().getInitParameter("url");
        String username= getServletContext().getInitParameter("username");
        String password= getServletContext().getInitParameter("password");


        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con); //ok(use java code) -ok (use config in web.xml) -ok --use(@webservlet)
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter writer = response.getWriter();

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        UserDao userDao=new UserDao();
        try {
            User user= userDao.findByUsernamePassword(con,username,password);

            if (user!=null){
                String rememberMe=request.getParameter("rememberMe");
                if(rememberMe!=null&&rememberMe.equals("1")){
                    Cookie usernameCookies=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookies=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMECookies=new Cookie("cRememberMe ",rememberMe);
                    passwordCookies.setMaxAge(5);
                    usernameCookies.setMaxAge(5);
                    rememberMECookies.setMaxAge(5);
                    response.addCookie(usernameCookies);
                    response.addCookie(passwordCookies);
                    response.addCookie(rememberMECookies);
                }
                HttpSession session=request.getSession();
                System.out.println("sessionid -->"+session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);

            }else {
                request.setAttribute("message","Username or Password Error");
//               request.setAttribute("message","Username or Password Error");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        /*String sql_1="select * from [user] "+
                "WHERE username='"+username+"'"+" AND "+
                "password = '"+password+"'"+
                ';';
        //System.out.println(sql_1);
        ResultSet rs= null;
        try {
            rs = con.createStatement().executeQuery(sql_1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(rs.next()){
                request.setAttribute("ID",rs.getString("id"));
                request.setAttribute("Username",rs.getString("username"));
                request.setAttribute("Password",rs.getString("password"));
                request.setAttribute("Email",rs.getString("email"));
                request.setAttribute("Sex",rs.getString("sex"));
                request.setAttribute("Birthday",rs.getString("birthday"));
                request.getRequestDispatcher("./userinfo.jsp").forward(request,response);
                *//*writer.println("Login Success!!!");
                writer.println("Welcome ChenLiang");*//*

            }
            else
            {
                request.setAttribute("msg","l");
                request.getRequestDispatcher("./login.jsp").forward(request,response);
               // writer.println("????????????????????????");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }
}