package sy.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import sy.services.RepaireServicesI;

@Action(value="repaireAction")
public class repaireAction extends BaseAction {
    private RepaireServicesI repaireService;
 
	public RepaireServicesI getRepaireService() {
		return repaireService;
	}
    @Autowired
	public void setRepaireService(RepaireServicesI repaireService) {
		this.repaireService = repaireService;
	}

	public void init(){
       repaireService.repaire();	  
	} 
}
