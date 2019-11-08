package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="pheader")
//@Table(name="PURCHASE HEADER")
@XmlRootElement

public class PHeader implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="ebeln")
	private int PONumber;
	
	@Column(name="logsy")
	private String LogicalSystem;
	
	@Column(name="bsart")
	private char POType;	
	
	@Column(name="ernam")
	private char POCreatedBy;
	
	@Column(name="bedat")
	@Temporal(TemporalType.TIMESTAMP)
	private Date poDate;
	
	@Column(name="waers")
	private char Currency;
	
	@Column(name="lifnr")
	private String VendorID;
	
	@Column(name="zterm")
	private char PaymentTerms;
	
	@Column(name="inco1")
	private char IncoTerms;
	
	/*
	 * @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy =
	 * "pHeader") private PLineItem item;
	 */
	public PHeader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPONumber() {
		return PONumber;
	}

	public void setPONumber(int pONumber) {
		PONumber = pONumber;
	}

	public String getLogicalSystem() {
		return LogicalSystem;
	}

	public void setLogicalSystem(String logicalSystem) {
		LogicalSystem = logicalSystem;
	}

	public char getPOType() {
		return POType;
	}

	public void setPOType(char pOType) {
		POType = pOType;
	}

	public char getPOCreatedBy() {
		return POCreatedBy;
	}

	public void setPOCreatedBy(char pOCreatedBy) {
		POCreatedBy = pOCreatedBy;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public char getCurrency() {
		return Currency;
	}

	public void setCurrency(char currency) {
		Currency = currency;
	}

	public String getVendorID() {
		return VendorID;
	}

	public void setVendorID(String vendorID) {
		VendorID = vendorID;
	}

	public char getPaymentTerms() {
		return PaymentTerms;
	}

	public void setPaymentTerms(char paymentTerms) {
		PaymentTerms = paymentTerms;
	}

	public char getIncoTerms() {
		return IncoTerms;
	}

	public void setIncoTerms(char incoTerms) {
		IncoTerms = incoTerms;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PHeader [PONumber=" + PONumber + ", LogicalSystem=" + LogicalSystem + ", POType=" + POType
				+ ", POCreatedBy=" + POCreatedBy + ", poDate=" + poDate + ", Currency=" + Currency + ", VendorID="
				+ VendorID + ", PaymentTerms=" + PaymentTerms + ", IncoTerms=" + IncoTerms + "]";
	}

	
	
}
	

	

