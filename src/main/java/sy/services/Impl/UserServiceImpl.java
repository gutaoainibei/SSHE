package sy.services.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sy.dao.UserDaoI;
import sy.model.Tuser;
import sy.pageModel.Datagrid;
import sy.pageModel.User;
import sy.services.UserServicesI;
import sy.util.Encrypt;

@Service("userServices")
//@Transactional
public class UserServiceImpl implements UserServicesI {
   private UserDaoI userDao;
  // private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
   public UserDaoI getUserDao() {
	return userDao;
   }
   @Autowired
   public void setUserDao(UserDaoI userDao) {
	this.userDao = userDao;
   }
@Override
public User save(User user) {
	Tuser t=new Tuser();
    BeanUtils.copyProperties(user,t,new String[]{"pwd"});
    t.setId(UUID.randomUUID().toString());
    t.setPwd(Encrypt.e(user.getPwd()));
    t.setCreatedatetime(new Date());
	userDao.saveOrUpdate(t);
	BeanUtils.copyProperties(t, user);
	return user;
}
@Override
public User get(User user) {
	Map<String,Object> map=new HashMap<String,Object>();
	map.put("name", user.getName());
	map.put("pwd", Encrypt.e(user.getPwd()));
	//Tuser t=userDao.get("from Tuser t where t.name='"+user.getName()+"' and t.pwd='"+Encrypt.e(user.getPwd())+"'");
	//Tuser t=userDao.get("from Tuser t where t.name= ? and t.pwd= ?",new Object[]{user.getName(),Encrypt.e(user.getPwd())});
	Tuser t=userDao.get("from Tuser t where t.name= :name and t.pwd= :pwd",map);
	if(t!=null){
		BeanUtils.copyProperties(t, user);
		return user;
	}
	return null;
}
@Override
public Datagrid datagrid(User user) {
	Datagrid datagrid=new Datagrid();
	Map<String,Object> map=new HashMap<String,Object>();
	List<User> l=new ArrayList<User>();
	String hql="from Tuser t ";
	hql = addWhere(user, map, hql);
	String total="select count(*) "+hql;
	hql = addOrder(user, hql);
	List<Tuser> lt=userDao.find(hql,map, user.getPage(), user.getRows());
	changeMode(l, lt);
	datagrid.setTotal(userDao.count(total,map));
	datagrid.setRows(l);
	return datagrid;
}
private void changeMode(List<User> l, List<Tuser> lt) {
	if(lt!=null&&lt.size()>0){
		for(Tuser t:lt){
			User u=new User();
			BeanUtils.copyProperties(t, u);
			l.add(u);
		}
	}
}
private String addOrder(User user, String hql) {
	if(user.getSort()!=null&&!user.getSort().trim().equals("")){
		hql+=" order by "+user.getSort()+" "+user.getOrder();
	}
	return hql;
}
private String addWhere(User user, Map<String, Object> map, String hql) {
	hql+="where name is not null ";
	if(user.getName()!=null && !user.getName().trim().equals("")){
	   hql+=" and t.name like :name";
	   map.put("name", "%%"+user.getName()+"%%");
	}
	if(user.getCreatedatetimeStart()!=null){
		hql+=" and t.createdatetime>=:createdatetimeStart ";
		map.put("createdatetimeStart", user.getCreatedatetimeStart());
	}
	if(user.getCreatedatetimeEnd()!=null){
		hql+=" and t.createdatetime<=:createdatetimeEnd ";
		map.put("createdatetimeEnd", user.getCreatedatetimeEnd());
	}
	if(user.getModifydatetimeStart()!=null){
		hql+=" and t.modifydatetime>=:modifydatetimeStart ";
		map.put("modifydatetimeStart", user.getModifydatetimeStart());
	}
	if(user.getModifydatetimeEnd()!=null){
		hql+=" and t.modifydatetime<=:modifydatetimeEnd ";
		map.put("modifydatetimeEnd", user.getModifydatetimeEnd());
	}
	return hql;
}
@Override
public int remove(String ids) {
	String[] nids=ids.split(",");
	String hql="delete Tuser t where t.id in (";
	for(int i=0;i<nids.length;i++){
		if(i>0){
			hql+=",";
		}
		hql+="'"+nids[i]+"'";
	}
	hql+=")";
	int n=userDao.remove(hql);
	return n;
}
@Override
public User edit(User user) {
	Tuser tu=userDao.get(Tuser.class,user.getId()); 
	user.setModifydatetime(new Date());
	BeanUtils.copyProperties(user, tu ,new String[] {"id","pwd"});
	return user;
}
   

}
