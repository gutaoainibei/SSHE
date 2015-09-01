package sy.model;
// default package

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tonline entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tonline", catalog = "sy")
public class Tonline implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Date datatime;
	private String ip;
	private String name;

	// Constructors

	/** default constructor */
	public Tonline() {
	}

	/** full constructor */
	public Tonline(String id, Timestamp datatime, String ip, String name) {
		this.id = id;
		this.datatime = datatime;
		this.ip = ip;
		this.name = name;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datatime", nullable = false, length = 19)
	public Date getDatatime() {
		return this.datatime;
	}

	public void setDatatime(Date date) {
		this.datatime = date;
	}

	@Column(name = "ip", nullable = false, length = 50)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}