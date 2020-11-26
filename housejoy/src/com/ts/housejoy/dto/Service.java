package com.ts.housejoy.dto;

public class Service {

	private int id;
	private String description;
	private float approxPrice;
	private int subCategoryId;
	private boolean deleted;
	private String serviceTypeImage;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getServiceTypeImage() {
		return serviceTypeImage;
	}

	public void setServiceTypeImage(String serviceTypeImage) {
		this.serviceTypeImage = serviceTypeImage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getApproxPrice() {
		return approxPrice;
	}

	public void setApproxPrice(float approxPrice) {
		this.approxPrice = approxPrice;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
