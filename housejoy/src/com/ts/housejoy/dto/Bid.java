package com.ts.housejoy.dto;

import java.util.*;

public class Bid {
	private Work work;
	private float bidPrice;
	private Date bidDate;
	private Service serviceType;
	private char status;
	private String comments;
	private Force force;

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public float getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(float bidPrice) {
		this.bidPrice = bidPrice;
	}

	public Service getServiceType() {
		return serviceType;
	}

	public void setServiceType(Service serviceType) {
		this.serviceType = serviceType;
	}

	public Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Force getForce() {
		return force;
	}

	public void setForce(Force force) {
		this.force = force;
	}

}
