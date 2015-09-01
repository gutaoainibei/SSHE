package sy.interceptor;

import org.apache.struts2.ServletActionContext;

import sy.pageModel.SessionInfo;
import sy.util.ResourceUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class sessionInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		SessionInfo sessioninfo=(SessionInfo)ServletActionContext.getRequest().getSession().getAttribute(ResourceUtil.getSessionInfoName());
		if(sessioninfo==null){
			ServletActionContext.getRequest().setAttribute("msg", "您还没登录或者你登录超时，请重新登录！");
		    return "noSession";
		}
		return invocation.invoke();
	}

}
