package sy.services;

import sy.model.Tonline;
import sy.pageModel.Datagrid;
import sy.pageModel.Online;

public interface OnlineServicesI {
   public void saveOnline(String username,String ip);

   public Datagrid Onlinedategrid(Online online);
   
   public Tonline delete(String username,String ip); 
}
