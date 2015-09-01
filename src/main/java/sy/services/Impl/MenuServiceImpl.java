package sy.services.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.MenuDaoI;
import sy.model.Tmenu;
import sy.pageModel.Menu;
import sy.services.MenuServicesI;

@Service("menuService")
public class MenuServiceImpl implements MenuServicesI{
    private MenuDaoI menuDao;

	public MenuDaoI getMenuDao() {
		return menuDao;
	}
    @Autowired
	public void setMenuDao(MenuDaoI menuDao) {
		this.menuDao = menuDao;
	}
	@Override
	public List<Menu> getTreeCode(String id) {
		List<Menu> l=new ArrayList<>();
		Map<String,Object> map=new HashMap<String,Object>();
		String hql=null;
		if(id==null||id.trim().equals("")){
			hql="from Tmenu t where t.tmenu is null";
		}else{
			hql="from Tmenu t where t.tmenu.id=:id";
			map.put("id", id);
		}
		List<Tmenu> me=menuDao.find(hql, map);
		if(me!=null&&me.size()>0){
			for(Tmenu t:me){
			 Map<String,Object> attributes=new HashMap<String,Object>();
			 Menu m=new Menu();
			 BeanUtils.copyProperties(t, m);
			 attributes.put("url", t.getUrl());
			 m.setAttributes(attributes);
			 Set<Tmenu> set=t.getTmenus();
			 if(set!=null&&!set.isEmpty()){
				 m.setState("closed");
			 }else{
				 m.setState("open");
			 }
			 l.add(m);
			}
		}
		return l;
		
	}
	@Override
	public List<Menu> treegrid(Menu menu) {
		List<Menu> lm=new ArrayList<Menu>();
		Map<String,Object> map=new HashMap<String,Object>();
		String hql=null;
		if(menu.getId()!=null&&!menu.getId().trim().equals("")){
			hql="from Tmenu t where t.tmenu.id=:id";
			map.put("id", menu.getId());
		}else{
			hql="from Tmenu t where t.tmenu is null";
		}
		List<Tmenu> tm=menuDao.find(hql,map);
		if(tm!=null&&tm.size()>0){
			for(Tmenu t:tm){
			Menu me=new Menu();
			BeanUtils.copyProperties(t, me);
			Set<Tmenu> set=t.getTmenus();
			if(t.getTmenu()!=null){
				me.setPid(t.getTmenu().getId());
			}
			if(set!=null&&!set.isEmpty()){
				me.setState("closed");
			}else{
				me.setState("open");
			}
			lm.add(me);
			}
		}
		return lm;
	}
    
}
