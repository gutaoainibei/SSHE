package sy.services.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.OnlineDaoI;
import sy.model.Tonline;
import sy.pageModel.Datagrid;
import sy.pageModel.Online;
import sy.services.OnlineServicesI;
@Service("onlineService")
public class OnlineServicesImpl implements OnlineServicesI {
    private OnlineDaoI onlineDao;

	public OnlineDaoI getOnlineDao() {
		return onlineDao;
	}
    @Autowired
	public void setOnlineDao(OnlineDaoI onlineDao) {
		this.onlineDao = onlineDao;
	}

	@Override
	public void saveOnline(String username,String ip) {
		Tonline t=onlineDao.get("from Tonline t where t.name=? and t.ip=?",new Object[]{username,ip});
		if(t!=null){
			t.setDatatime(new Date());
		}else{
			Tonline o=new Tonline();
			o.setId(UUID.randomUUID().toString());
			o.setName(username);
			o.setIp(ip);
			o.setDatatime(new Date());
			onlineDao.save(o);
		}
	}
	@Override
	public Datagrid Onlinedategrid(Online online) {
		Datagrid onlinedatagrid=new Datagrid();
		onlinedatagrid.setRows(find(online));
		onlinedatagrid.setTotal(total(online));
		return onlinedatagrid;
	}
	private Long total(Online online) {
		String hql="select count(*) from Tonline t where name is not null ";
		Map<String,Object> map=new HashMap<String,Object>();
		hql=addWhere(online, hql, map);
		return onlineDao.count(hql, map);
	}
	private List<Tonline> find(Online online) {
		String hql="from Tonline t where name is not null ";
		Map<String,Object> map=new HashMap<String,Object>();
		hql = addWhere(online, hql, map);
		hql=addOrder(online,hql);
		return onlineDao.find(hql, map, online.getPage(), online.getRows());
	}
	public String addWhere(Online online, String hql, Map<String, Object> map) {
		if(online.getName()!=null&&!online.getName().trim().equals("")){
			hql+=" and t.name=:name ";
			map.put("name", online.getName());
		}
		return hql;
	}
	public String addOrder(Online online, String hql) {
		if(online.getSort()!=null&&!online.getSort().trim().equals("")){
			 hql+=" order by "+online.getSort()+" "+online.getOrder();
		}
		return hql;
	}
	@Override
	public Tonline delete(String username,String ip) {
		Tonline on=onlineDao.get(" from Tonline t where t.name=? and t.ip=? ",new Object[]{username,ip});
		if(on!=null){
			onlineDao.delete(on);
		}
		return on;
	}
	
     
}
