package com.shoes.until;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Encoding
 */
@WebFilter("/*")
public final class Encoding implements Filter {

    /**
     * Default constructor. 
     */
    public Encoding() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse rep=(HttpServletResponse)response;
		if(isIEBrowser(req)&&req.getMethod().toLowerCase().equals("get")&&req.getParameter("encoded")==null){
			Enumeration ps=req.getParameterNames();
			StringBuilder sb=new StringBuilder(req.getRequestURI()+"?");
			while(ps.hasMoreElements()){
				String name = (String) ps.nextElement();
				String param=new String(req.getParameter(name).getBytes("ISO-8859-1"),"UTF-8");
				sb.append(name+"="+param+"&");
			}
			sb.append("encoded=true");
			rep.sendRedirect(sb.toString());
			System.out.println("浏览器版本："+getBrowserName(req.getHeader("User-Agent").toLowerCase()));
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		response.setCharacterEncoding("utf-8");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	public String getBrowserName(String agent) {
	if(agent.indexOf("msie 7")>0){
		return "ie7";
		}else if(agent.indexOf("msie 8")>0){
		return "ie8";
		}else if(agent.indexOf("msie 9")>0){
		return "ie9";
		}else if(agent.indexOf("msie 10")>0){
		return "ie10";
		}else if(agent.indexOf("msie")>0){
		return "ie";
	}else if(agent.indexOf("opera")>0){
		return "opera";
	}else if(agent.indexOf("opera")>0){
	return "opera";
	}else if(agent.indexOf("firefox")>0){
	return "firefox";
	}else if(agent.indexOf("webkit")>0){
		return "webkit";
	}else if(agent.indexOf("gecko")>0 && agent.indexOf("rv:11")>0){
		return "ie11";
		}else{
			return "Others";
			}
	}

	 //方法功能描述: 判断是否是IE浏览器   
    public boolean isIEBrowser(HttpServletRequest request) {  
        String[] IEBrowserSignals = {"MSIE", "Trident", "Edge"};  
        String userAgent = request.getHeader("User-Agent");  
        for (String signal : IEBrowserSignals) {              
        	if (userAgent.contains(signal)){  
                return true;  
            }  
        }  
        return false;  
    }
}