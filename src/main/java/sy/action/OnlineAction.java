package sy.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import sy.dao.OnlineDaoI;
import sy.pageModel.Online;
import sy.services.OnlineServicesI;

import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value="onlineAction")
public class OnlineAction extends BaseAction implements ModelDriven<Online>{
    private Online online=new Online();
    private OnlineServicesI onlineService;
	@Override
	public Online getModel() {
		// TODO Auto-generated method stub
		return online;
	}
	public OnlineServicesI getOnlineService() {
		return onlineService;
	}
	public void setOnlineService(OnlineServicesI onlineService) {
		this.onlineService = onlineService;
	}
    public void loginOnlineDatagrid(){
    	super.writeJson(onlineService.Onlinedategrid(online));
    }
}
