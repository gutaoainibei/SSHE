package sy.model;
// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tmenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tmenu", catalog = "sy")
public class Tmenu implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Tmenu tmenu;
	private String text;
	private String iconCls;
	private String url;
	private Set<Tmenu> tmenus = new HashSet<Tmenu>(0);

	// Constructors

	/** default constructor */
	public Tmenu() {
	}

	/** minimal constructor */
	public Tmenu(String id, Tmenu tmenu) {
		this.id = id;
		this.tmenu = tmenu;
	}

	/** full constructor */
	public Tmenu(String id, Tmenu tmenu, String text, String iconCls,
			String url, Set<Tmenu> tmenus) {
		this.id = id;
		this.tmenu = tmenu;
		this.text = text;
		this.iconCls = iconCls;
		this.url = url;
		this.tmenus = tmenus;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PID", nullable = true)
	public Tmenu getTmenu() {
		return this.tmenu;
	}

	public void setTmenu(Tmenu tmenu) {
		this.tmenu = tmenu;
	}

	@Column(name = "TEXT", length = 32)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "iconCls", length = 32)
	public String getIconCls() {
		return this.iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	@Column(name = "URL", length = 40)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tmenu")
	public Set<Tmenu> getTmenus() {
		return this.tmenus;
	}

	public void setTmenus(Set<Tmenu> tmenus) {
		this.tmenus = tmenus;
	}

}