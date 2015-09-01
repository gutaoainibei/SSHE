package sy.dao.Impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sy.dao.BaseDaoI;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T> {
    
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public Serializable save(T o) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().save(o);
	}
	@Override
	public T get(String hql) {
		Query q=this.getCurrentSession().createQuery(hql);
		List<T> l=q.list();
		if(l!=null&&l.size()>0){
			return l.get(0);
		}
		return null;
	}
	@Override
	public T get(String hql, Object[] obj) {
		Query q=this.getCurrentSession().createQuery(hql);
		if(obj!=null&&obj.length>0){
			for(int i=0;i<obj.length;i++){
			    q.setParameter(i, obj[i]);	
			}
		}
		List<T> l=q.list();
		if(l!=null&&l.size()>0){
			return l.get(0);
		}
		return null;
	}
	@Override
	public T get(String hql, Map<String, Object> map) {
		Query q=this.getCurrentSession().createQuery(hql);
		if(map!=null&&!map.isEmpty())
		for(String key : map.keySet()){
			q.setParameter(key,map.get(key));
		}
		List<T> l=q.list();
		if(l!=null&&l.size()>0){
			return l.get(0);
		}
		return null;
	}
	@Override
	public void delete(T o) {
		this.getCurrentSession().delete(o);
	}
	@Override
	public void update(T o) {	
		this.getCurrentSession().update(o);
	}
	@Override
	public void saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);
	}
	@Override
	public List<T> find(String hql) {
		Query q=this.getCurrentSession().createQuery(hql);
		
		return q.list();
	}
	@Override
	public List<T> find(String hql, Map<String, Object> map) {
		Query q=this.getCurrentSession().createQuery(hql);
		if(map!=null&&!map.isEmpty())
		for(String key : map.keySet()){
			q.setParameter(key,map.get(key));
		}
			return q.list();
		}
	@Override
	public List<T> find(String hql, int page, int rows) {
		Query q=this.getCurrentSession().createQuery(hql);
		return q.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}
	@Override
	public List<T> find(String hql, Map<String, Object> map, int page, int rows) {
		Query q=this.getCurrentSession().createQuery(hql);
		if(map!=null&&!map.isEmpty())
			for(String key : map.keySet()){
				q.setParameter(key,map.get(key));
			}
		return q.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}
	@Override
	public Long count(String hql) {
		Query q=this.getCurrentSession().createQuery(hql);
		return (Long)q.uniqueResult();
	}
	@Override
	public Long count(String hql, Map<String, Object> map) {
		Query q=this.getCurrentSession().createQuery(hql);
		if(map!=null&&!map.isEmpty())
			for(String key : map.keySet()){
				q.setParameter(key,map.get(key));
		}
		return (Long)q.uniqueResult();
	}
	@Override
	public int remove(String hql) {
		Query q=this.getCurrentSession().createQuery(hql);
		int n=q.executeUpdate();
		return n;
	}
	@Override
	public T get(Class<T> class1, String id) {
		return  (T)this.getCurrentSession().get(class1, id);
	}

}

