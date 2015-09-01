package sy.services.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sy.dao.MenuDaoI;
import sy.dao.UserDaoI;
import sy.model.Tmenu;
import sy.model.Tuser;
import sy.services.RepaireServicesI;
import sy.util.Encrypt;
@Service("repaireService")
//@Transactional
public class RepaireServicesImpl implements RepaireServicesI {
    private  UserDaoI userDao;
    private MenuDaoI  menuDao;
    
	public UserDaoI getUserDao() {
		return userDao;
	}
    @Autowired
	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}

	public MenuDaoI getMenuDao() {
		return menuDao;
	}
    @Autowired
	public void setMenuDao(MenuDaoI menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	synchronized public void repaire() {

		repairUser();

		repairMenu();

	}
	private void repairMenu() {
		Tmenu root = new Tmenu();
		root.setId("0");
		root.setText("首页");
		root.setIconCls("icon-save");
		menuDao.saveOrUpdate(root);

		Tmenu sysmanager = new Tmenu();
		sysmanager.setId("sysmanager");
		sysmanager.setTmenu(root);
		sysmanager.setText("系统管理");
		sysmanager.setUrl("");
		sysmanager.setIconCls("icon-reload");
		menuDao.saveOrUpdate(sysmanager);
		
		Tmenu filemanager = new Tmenu();
		filemanager.setId("filemanager");
		filemanager.setTmenu(root);
		filemanager.setText("文件管理");
		filemanager.setUrl("user/filemanager.jsp");
		filemanager.setIconCls("icon-large-clipart");
		menuDao.saveOrUpdate(filemanager);

		Tmenu usermanager = new Tmenu();
		usermanager.setId("usermanager");
		usermanager.setTmenu(sysmanager);
		usermanager.setText("用户管理");
		usermanager.setUrl("user/usermanager.jsp");
		usermanager.setIconCls("icon-search");
		menuDao.saveOrUpdate(usermanager);

		Tmenu rolemanager = new Tmenu();
		rolemanager.setId("rolemanager");
		rolemanager.setTmenu(sysmanager);
		rolemanager.setText("角色管理");
		rolemanager.setUrl("");
		rolemanager.setIconCls("icon-edit");
		menuDao.saveOrUpdate(rolemanager);

		Tmenu powermanager = new Tmenu();
		powermanager.setId("powermanager");
		powermanager.setTmenu(sysmanager);
		powermanager.setText("权限管理");
		powermanager.setIconCls("icon-redo");
		powermanager.setUrl("user/powermanager.jsp");
		menuDao.saveOrUpdate(powermanager);

		Tmenu menumanager = new Tmenu();
		menumanager.setId("menumanager");
		menumanager.setTmenu(sysmanager);
		menumanager.setText("菜单管理");
		menumanager.setIconCls("icon-remove");
		menumanager.setUrl("admin/menumanager.jsp");
		menuDao.saveOrUpdate(menumanager);

		Tmenu BUG = new Tmenu();
		BUG.setId("BUG");
		BUG.setTmenu(sysmanager);
		BUG.setText("BUG管理");
		BUG.setIconCls("icon-tip");
		BUG.setUrl("");
		menuDao.saveOrUpdate(BUG);
	}

	private void repairUser() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("name", "admin");
		Tuser t = userDao.get("from Tuser t where t.name = :name and t.id != '0'", m);
		if (t != null) {
			t.setName(UUID.randomUUID().toString());
		}

		Tuser admin = new Tuser();
		admin.setId("0");
		admin.setName("admin");
		admin.setPwd(Encrypt.e("admin"));
		admin.setModifydatetime(new Date());
		userDao.saveOrUpdate(admin);
	}

}
