package sy.action;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import sy.pageModel.Json;
import sy.pageModel.SessionInfo;
import sy.pageModel.User;
import sy.services.UserServicesI;
import sy.util.IpUtil;
import sy.util.ResourceUtil;


@ParentPackage("basePackage")
@Namespace("/")
@Action(value="userAction")
public class userAction extends BaseAction implements ModelDriven<User> {
	  // private static final Logger logger = Logger.getLogger(userAction.class);
	   private UserServicesI userServices;
	   private User user=new User(); 
	   @Override
		public User getModel() {
			return user;
	  }
	
	   public UserServicesI getUserServices() {
		  return userServices;
	  }
    @Autowired
	public void setUserServices(UserServicesI userServices) {
		this.userServices = userServices;
	}

	public void save(){
		Json json=new Json();
		System.out.println(user.getName());
		//System.out.println(name+","+password);
		User u=userServices.save(user);
			if(u!=null){
			json.setSuccess(true);
			json.setMsg("添加成功");
			json.setObj(u);
			}else{
				json.setMsg("添加失败");
			}
	    super.writeJson(json);
	}
	public void login(){
		Json json=new Json();
		User u=userServices.get(user);
		if(u!=null){
			SessionInfo sessionInfo=new SessionInfo();		
			sessionInfo.setId(u.getId());
			sessionInfo.setName(u.getName());
			sessionInfo.setLoginPassword(u.getPwd());
			sessionInfo.setIp(IpUtil.getIpAddr(ServletActionContext.getRequest()));
		    ServletActionContext.getRequest().getSession().setAttribute(ResourceUtil.getSessionInfoName(),sessionInfo);
		    json.setObj(sessionInfo);
			json.setSuccess(true);
			json.setMsg("登录成功");
		}else{
			json.setMsg("登录失败！您输入的用户名或密码错误！");
		}
		super.writeJson(json);
	}
	public void datagrid(){
		super.writeJson(userServices.datagrid(user));
	}
	public void remove(){
		int n=userServices.remove(user.getIds());
		Json json=new Json();
		json.setSuccess(true);
		json.setMsg("删除成功");
		super.writeJson(json);
	}
	public void edit(){
		User u=userServices.edit(user);
		Json json=new Json();
		json.setObj(u);
		json.setSuccess(true);
		json.setMsg("修改成功");
		super.writeJson(json);
	}
	public void exituser(){
		ServletActionContext.getRequest().getSession().invalidate();
		Json json=new Json();
		System.out.println("结束了回话");
		json.setSuccess(true);
		super.writeJson(json);
	}
}
