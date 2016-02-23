package ua.dev.hibernate.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	public UserDetails() {
		
	}
	
	@Id
	@Column(name="ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME")),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
			@AttributeOverride(name = "zipCode", column = @Column(name = "HOME_ZIP_CODE")),
			@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME"))
	})
	private Address homeAddress;
	
	@Embedded
	private Address workAddress;
	
//	getters and setters //
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}

}
