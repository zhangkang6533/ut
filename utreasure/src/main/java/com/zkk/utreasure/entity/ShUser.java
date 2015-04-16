package com.zkk.utreasure.entity;

import java.util.Date;

public class ShUser {

	private String id; 				// �û���ʶ��a
	private String userName;		 // �û�����
	private String loginName; 		// �û���¼��
	private String sex;				 // �û��Ա�
	private String age; 			// �û�����
	private String password; 		// �û�����
	private Date 	createTime; 	// ����ʱ��
	private Date 	updateTime; 	// ����ʱ��
	private String icon; 			// ͷ��
	private String address; 		// �û����ڵ�
	private String identityCardId; 	// ���֤
	private String telePhone; 		// �绰
	private String email; 			// �û�����
	private String userType; 		// �û�����
	private String shBat1; 			//

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date date) {
		this.createTime = date;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date date) {
		this.updateTime = date;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentityCardId() {
		return identityCardId;
	}

	public void setIdentityCardId(String identityCardId) {
		this.identityCardId = identityCardId;
	}

	public String getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getShBat1() {
		return shBat1;
	}

	public void setShBat1(String shBat1) {
		this.shBat1 = shBat1;
	}

	@Override
	public String toString() {
		return "ShUser [id=" + id + ", userName=" + userName + ", loginName="
				+ loginName + ", sex=" + sex + ", age=" + age + ", password="
				+ password + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", icon=" + icon + ", address=" + address
				+ ", identityCardId=" + identityCardId + ", telePhone="
				+ telePhone + ", email=" + email + ", userType=" + userType
				+ "]";
	}
	
	
	

}
