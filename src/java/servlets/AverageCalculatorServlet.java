package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AverageCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set up the session
        HttpSession session = request.getSession();
        
        // Retrieve the parameter from the reset form
        String operation = request.getParameter("operation");
        // if the operation parameter exists and equals "reset"
        // we should reset the form
        if( operation != null && operation.equals("reset") ){
            session.invalidate();
            session = request.getSession();
        }
        
        // If there is a numberlist already in the session, get the current numberList
        ArrayList<Integer> numberList = (ArrayList<Integer>)session.getAttribute("numberList");
        // if there is no arraylist, create one!
        if(numberList == null){
            numberList = new ArrayList<Integer>();
            //singleton pattern
        }
        // check if the incoming number parameter is empty
        if( request.getParameter("number") != null ){
            // capture the incoming number parameter
            int number = Integer.parseInt(request.getParameter("number"));
            // add the number to the number list
            numberList.add(number);
            //save the number list back into the session
            session.setAttribute("numberList", numberList);
        }
        // math time!
        double average = 0.0;
        for(int number : numberList){
            average += number;
        }
        if( numberList.size() > 0 ){
            average /= numberList.size();
        }
        // set the average as an attribute in the request object
        // we want the average to be recalculated on every page view
        request.setAttribute("average", average);
        // load the JSP
        getServletContext().getRequestDispatcher("/WEB-INF/average.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // not used...
    }

}
