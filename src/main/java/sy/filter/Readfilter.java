package sy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sy.pageModel.SessionInfo;
import sy.util.ResourceUtil;
/**
 * 这个过滤器实现拦截非法进入页面的，必须登录后才能
 * **/
public class Readfilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		    HttpServletRequest req=(HttpServletRequest)request;
		    //这里强调一个问题，只有将request转化为HttpServRequest，才可以获得session，ServletRequest是得不到session的
		    HttpSession session=req.getSession();
		    //获得session
		    String requestpath=req.getServletPath();
		    //获得访问的路径
		    SessionInfo sessioninfo=(SessionInfo)session.getAttribute(ResourceUtil.getSessionInfoName());
	        //获取session中记录的登录信息
		    if(sessioninfo==null&&!requestpath.endsWith("/index.jsp")&&!requestpath.endsWith("/south.jsp")&&!requestpath.endsWith("/east.jsp")){
	        	request.getRequestDispatcher("/error/404.jsp").forward(request, response);
	        }else{
	        	chain.doFilter(request, response);
	        } 
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
