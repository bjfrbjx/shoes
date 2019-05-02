package com.shoes.until;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.StandardContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
/**
 * Application Lifecycle Listener implementation class ListenAll
 *
 */
@WebListener
public class ListenAll implements HttpSessionListener,ServletContextListener {
	private Service service =null;
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		System.out.println("ListenAll set service "+service);
		this.service = service;
	}

	public ListenAll() {
		
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
    	service.setAccumVistors((Integer)arg0.getServletContext().getAttribute("AccumVistors"));
    	Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                System.out.println("close success "+String.format("deregistering jdbc driver: %s", driver));
                if(driver instanceof com.mysql.jdbc.Driver){
                	com.mysql.jdbc.AbandonedConnectionCleanupThread.uncheckedShutdown();
                	System.out.println("close success "+String.format("deregistering jdbc .AbandonedConnection : %s", driver));
                }
            } catch (SQLException e) {
            	System.out.println("close fail "+String.format("Error deregistering driver %s", driver));
            	e.printStackTrace();
            }

        }
    
    }


	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	if(this.service==null){
    		this.service=  (Service) WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext()).getBean("service");
    	}
    	arg0.getServletContext().setAttribute("CurrentOnline", new Integer(0));
    	arg0.getServletContext().setAttribute("LoginNum", new Integer(0));
    	try {
    		System.out.println("listensall's service is null ?"+service);
    		Integer AV=service.getAccumVistors();
			//Integer AV=DB.getAccumVistors();
			arg0.getServletContext().setAttribute("AccumVistors", AV);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
}
