package com.pooihern.simpleCRUD.account;

import java.math.BigDecimal;

import com.pooihern.simpleCRUD.customer.CustomerEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Account")
public class AccountEntity {
	private static final long serialVersionUID = 1L;
	
	private String accountNum;
	private CustomerEntity customerEntity;
	private String accountType;
	private String accountName;
	private BigDecimal accountBalance;
	
	@Id
	@Column(name="account_number", unique=true, nullable=false, length=30)
	public String getAccountNum() {
		return this.accountNum;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	public CustomerEntity getCustomerEntity() {
		return this.customerEntity;
	}
	
	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	@Column(name="account_type", nullable=false, length=30)
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Column(name="account_name", nullable=false, length=30)
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Column(name="account_balance", nullable=false)
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
}
