package com.jiangle.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
class AdmitAuthenticationFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        HttpSession nu1l;
        boolean isLoggedIn = (session!=null&& session.getAttribute("userList") != null);
        String loginURI = httpRequest.getContextPath() + "/admin/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");
        if (isLoggedIn && (isLoginRequest || isLoginPage) ) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/home");
            dispatcher.forward(request,response);
        } else if (isLoggedIn || isLoginRequest) {
            chain.doFilter(request, response);
        } else{
            httpResponse.sendRedirect(httpRequest. getContextPath()+"/admin/login");
        }
    }

    public void destroy() {     }
    public void init(FilterConfig fConfig) throws ServletException {  }
}