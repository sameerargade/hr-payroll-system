package com.challenge.hrpayrollsystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "payslip")
public class Payslip extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	Long id;
//	@Column(name = "employeeID", nullable = false)
//	int employeeID;
	@Column(name = "pay_date", nullable = false)
	String payDate;
	@Column(name = "pay_frequency", nullable = false)
	String payFrequency;
	@Column(name = "gross_income", nullable = false)
	String grossIncome;
	@Column(name = "income_tax", nullable = false)
	Double incomeTax;
	@Column(name = "net_income", nullable = false)
	Double netIncome;
	@Column(name = "super", nullable = false)
	Double superPay;
	@Column(name = "pay", nullable = false)
	Double pay;
//	@Column(name = "date_created", nullable = false)
//	String dateCreated;
//	@Column(name = "created_by", nullable = false)
//	String createdBy;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employeeID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Employee employee;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public int getEmployeeID() {
//		return employeeID;
//	}
//
//	public void setEmployeeID(int employeeID) {
//		this.employeeID = employeeID;
//	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getPayFrequency() {
		return payFrequency;
	}

	public void setPayFrequency(String payFrequency) {
		this.payFrequency = payFrequency;
	}

	public String getGrossIncome() {
		return grossIncome;
	}

	public void setGrossIncome(String grossIncome) {
		this.grossIncome = grossIncome;
	}

	public Double getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(Double incomeTax) {
		this.incomeTax = incomeTax;
	}

	public Double getNetIncome() {
		return netIncome;
	}

	public void setNetIncome(Double netIncome) {
		this.netIncome = netIncome;
	}

	public Double getSuperPay() {
		return superPay;
	}

	public void setSuperPay(Double superPay) {
		this.superPay = superPay;
	}

	public Double getPay() {
		return pay;
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

//	public String getDateCreated() {
//		return dateCreated;
//	}
//
//	public void setDateCreated(String dateCreated) {
//		this.dateCreated = dateCreated;
//	}

//	public String getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}

}
