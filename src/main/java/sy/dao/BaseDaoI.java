package sy.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import sy.model.Tuser;

public interface BaseDaoI<T>{
    public Serializable save(T o);
    
    public T get(String hql);
    
    public T get(String hql,Object[] obj);
    
    public T get(String hql,Map<String,Object> map);
    
    public T get(Class<T> class1, String id);
    
    public void delete(T o);
    
    public void update(T o);
    
    public void saveOrUpdate(T o);
    
    public List<T> find(String hql);
    
    public List<T> find(String hql,Map<String,Object> map);
   
    public List<T> find(String hql,int page,int rows);
    
    public List<T> find(String hql,Map<String,Object> map,int page,int rows);
    
    public Long count(String hql);
    
    public Long count(String hql,Map<String,Object> map);
    
    public int remove(String hql);
    
}
