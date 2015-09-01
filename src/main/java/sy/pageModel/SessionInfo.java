package sy.pageModel;

import java.io.Serializable;

public class SessionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private String id;// 用户ID
		private String name;// 用户登录名称
		private String loginPassword;// 登录密码
		private String ip;// IP地址
		private String authIds;// 拥有的权限ID集合
		private String authNames;// 拥有的权限名称
		private String authUrls;//权限对应的url
		private String roleIds;//角色ID
		private String roleNames;//角色名称，如：超级管理员
		
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
		public String getLoginPassword() {
			return loginPassword;
		}
		public void setLoginPassword(String loginPassword) {
			this.loginPassword = loginPassword;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public String getAuthIds() {
			return authIds;
		}
		public void setAuthIds(String authIds) {
			this.authIds = authIds;
		}
		public String getAuthNames() {
			return authNames;
		}
		public void setAuthNames(String authNames) {
			this.authNames = authNames;
		}
		public String getAuthUrls() {
			return authUrls;
		}
		public void setAuthUrls(String authUrls) {
			this.authUrls = authUrls;
		}
		public String getRoleIds() {
			return roleIds;
		}
		public void setRoleIds(String roleIds) {
			this.roleIds = roleIds;
		}
		public String getRoleNames() {
			return roleNames;
		}
		public void setRoleNames(String roleNames) {
			this.roleNames = roleNames;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		
}
