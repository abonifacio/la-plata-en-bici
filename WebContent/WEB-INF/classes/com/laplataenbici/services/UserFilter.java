package com.laplataenbici.services;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter("/*")
public class UserFilter implements Filter {
	
	private static String[] ALLOWED_PATHS = {"/inicio","/login","/registro","/","/admin","/logout","/tests"};
	private static String ASSETS_PATH = "/assets";
	private static String ADMIN_PATH ="/admin";
    /**
     * Default constructor. 
     */
    public UserFilter() {
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
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
				
		String path = request.getRequestURI().substring(request.getContextPath().length());
		
		
		if(pathIsAllowed(path) || isAsset(path) || isAdmin(path) || isApi(path)){
			
			chain.doFilter(request,response);
			return;
		}
		
		HttpSession session =  request.getSession();
        String loginURI = request.getContextPath() + "/login";
        String adminURI = request.getContextPath() + "/admin";
        
        String ssUser = (String) session.getAttribute("loggedUser");
        
        try{
        	UserEntity user = AuthService.getRegisteredUser(ssUser);
        	if(user.isAdmin()) {
        		response.sendRedirect(adminURI);
        		return;
        	}
        	
        	chain.doFilter(request, response);
        }catch(Exception e){
        	response.sendRedirect(loginURI);
        }
	}
	
	private boolean pathIsAllowed(String path){
		for(String tmp : UserFilter.ALLOWED_PATHS){
			if(path.equals(tmp)) return true;
		}
		
		return false;
	}
	
	private boolean isAsset(String path){
		return path.contains(ASSETS_PATH);
	}
	
	private boolean isAdmin(String path){
		return path.contains(ADMIN_PATH);
	}
	
	private boolean isApi(String path){
		return path.contains("rest");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
