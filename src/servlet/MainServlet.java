package servlet;

import javax.servlet.*;	
import javax.servlet.http.*;

import bean.Person;
import data.PersonData;

import java.io.*;

@SuppressWarnings("serial")
public class MainServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException 
	{  
        String action = request.getParameter("action") != null && !request.getParameter("action").toString().isEmpty() ? request.getParameter("action").toString() : "";
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        if(action.equalsIgnoreCase("delete"))
        {
        	int personId = Integer.parseInt(request.getParameter("personId").toString() != null && !request.getParameter("personId").toString().isEmpty() ? request.getParameter("personId").toString() : "-1");
        	boolean result = PersonData.delete(personId);
        	if(result)
        	{
        		out.print("<p>Record deleted successfully!</p><a href='/CrudApp'>Home</a>");  
        	}
        	else
        	{
        		out.println("Sorry! unable to delete record");
        	}
            out.close();
        }
    }  
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException 
	 {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String action = request.getParameter("requestType") != null && !request.getParameter("requestType").toString().isEmpty() ? request.getParameter("requestType").toString() : "";
	        String name=request.getParameter("name");  
	        String address=request.getParameter("address");  
	        String email=request.getParameter("email");  
	        String contact=request.getParameter("contact");  
	          
	        if(action.equalsIgnoreCase("update"))
	        {
	        	int personId = Integer.parseInt(request.getParameter("personId").toString() != null && !request.getParameter("personId").toString().isEmpty() ? request.getParameter("personId").toString() : "-1");
	        	Person person=new Person();  
		        person.setName(name);  
		        person.setEmail(email);  
		        person.setContact(contact);
		        person.setAddress(address);
		        person.setId(personId);
		        
		        PersonData.update(person);
		        out.print("<p>Record Updated successfully!</p>");  
	            request.getRequestDispatcher("viewPersons.jsp").forward(request, response);;
	        }
	        else if(action.equalsIgnoreCase("insert"))
	        {
		        Person person=new Person();  
		        person.setName(name);  
		        person.setEmail(email);  
		        person.setContact(contact);
		        person.setAddress(address);
		          
		        boolean status = PersonData.save(person);  
		        if(status)
		        {  
		            out.print("<p>Record saved successfully!</p>");  
		            request.getRequestDispatcher("index.html").include(request, response);  
		        }
		        else
		        {  
		            out.println("Sorry! unable to save record");  
		        }
	        }
	          
	        out.close();  
	    }  
}