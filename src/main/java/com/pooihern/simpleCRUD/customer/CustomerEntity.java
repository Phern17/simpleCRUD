package com.pooihern.simpleCRUD.customer;

import java.util.List;

import com.pooihern.simpleCRUD.account.AccountEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomerEntity {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String phoneNum;
	private String address;
	private List<AccountEntity> accountEntities;
	
	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="phone_number", nullable=false, length=30)
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@OneToMany(mappedBy="customerEntity", fetch = FetchType.LAZY)
	public List<AccountEntity> getAccountEntities() {
		return accountEntities;
	}
	
	public void setAccountEntities(List<AccountEntity> accountEntities) {
		this.accountEntities = accountEntities;
	}
	
	
}
