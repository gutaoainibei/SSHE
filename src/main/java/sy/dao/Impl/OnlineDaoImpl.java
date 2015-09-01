package sy.dao.Impl;

import org.springframework.stereotype.Repository;

import sy.dao.OnlineDaoI;
import sy.model.Tonline;

@Repository("onlineDao")
public class OnlineDaoImpl extends BaseDaoImpl<Tonline> implements OnlineDaoI{

}
