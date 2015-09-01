package sy.pageModel;

import java.util.Date;

public class User {
	
	private Integer page;
	private Integer rows;
	private String sort;
	private String order;
	private String ids;
	private Date createdatetimeStart;
	private Date createdatetimeEnd;
	private Date modifydatetimeStart;
	private Date modifydatetimeEnd;
	
	private String id;
	private String name;
	private String pwd;
	private String repwd;
	private Date createdatetime;
	private Date modifydatetime;
	
	
	public Date getCreatedatetimeStart() {
		return createdatetimeStart;
	}
	public void setCreatedatetimeStart(Date createdatetimeStart) {
		this.createdatetimeStart = createdatetimeStart;
	}
	public Date getCreatedatetimeEnd() {
		return createdatetimeEnd;
	}
	public void setCreatedatetimeEnd(Date createdatetimeEnd) {
		this.createdatetimeEnd = createdatetimeEnd;
	}
	public Date getModifydatetimeStart() {
		return modifydatetimeStart;
	}
	public void setModifydatetimeStart(Date modifydatetimeStart) {
		this.modifydatetimeStart = modifydatetimeStart;
	}
	public Date getModifydatetimeEnd() {
		return modifydatetimeEnd;
	}
	public void setModifydatetimeEnd(Date modifydatetimeEnd) {
		this.modifydatetimeEnd = modifydatetimeEnd;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	public Date getModifydatetime() {
		return modifydatetime;
	}
	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}
	

}
