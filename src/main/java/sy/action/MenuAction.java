package sy.action;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import sy.pageModel.Menu;
import sy.services.MenuServicesI;

import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "menuAction")
public class MenuAction extends BaseAction implements ModelDriven<Menu> {
     private Menu menu=new Menu();
     private MenuServicesI menuService;
	@Override
	public Menu getModel() {
		// TODO Auto-generated method stub
		return menu;
	}
	public MenuServicesI getMenuService() {
		return menuService;
	}
	@Autowired
	public void setMenuService(MenuServicesI menuService) {
		this.menuService = menuService;
	}
	public void logingetTree(){
		super.writeJson(menuService.getTreeCode(menu.getId()));
	}
	public void getTreeDatagrid(){
		super.writeJson(menuService.treegrid(menu));
	}
}
