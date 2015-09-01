package sy.services;

import java.util.List;

import sy.pageModel.Menu;

public interface MenuServicesI {

	public List<Menu> getTreeCode(String id);

	public List<Menu> treegrid(Menu menu);

}
