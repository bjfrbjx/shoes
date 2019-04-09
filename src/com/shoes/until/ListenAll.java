package com.shoes.until;

import java.sql.SQLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * Application Lifecycle Listener implementation class ListenAll
 *
 */
@WebListener
public class ListenAll implements HttpSessionListener,ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenAll() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	//arg0.getSession().setMaxInactiveInterval(60*79);
    	Integer CO=(Integer)arg0.getSession().getServletContext().getAttribute("CurrentOnline");
    	arg0.getSession().getServletContext().setAttribute("CurrentOnline", ++CO);
    	Integer AV=(Integer)arg0.getSession().getServletContext().getAttribute("AccumVistors");
    	arg0.getSession().getServletContext().setAttribute("AccumVistors", ++AV);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	Integer CO=(Integer)arg0.getSession().getServletContext().getAttribute("CurrentOnline");
    	arg0.getSession().getServletContext().setAttribute("CurrentOnline", --CO);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	;
    	DB.setAccumVistors((Integer)arg0.getServletContext().getAttribute("AccumVistors"));
    }


	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	arg0.getServletContext().setAttribute("CurrentOnline", new Integer(0));
    	arg0.getServletContext().setAttribute("LoginNum", new Integer(0));
    	try {
			Integer AV=DB.getAccumVistors();
			arg0.getServletContext().setAttribute("AccumVistors", AV);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
	
}
