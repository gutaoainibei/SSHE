package sy.services;

import sy.pageModel.Datagrid;
import sy.pageModel.User;


public interface UserServicesI {
   public User save(User user);
   public User get(User user);
   public Datagrid datagrid(User user);
   public int remove(String ids);
   public User edit(User user);
   
}
