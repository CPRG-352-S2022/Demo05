package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Test1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Create a session object
        HttpSession session = request.getSession();
        // Create an attribute in the session object
        session.setAttribute("sessionAttribute", "This is an attribute in the session object.");
        
        // Create an attribute in the request object
        request.setAttribute("requestAttribute", "This is an attribute in the request object.");
        
        // load up the JSP
        getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
