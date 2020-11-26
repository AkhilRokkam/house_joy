package com.ts.housejoy.dto;

public class Skill {

	private User user;
	private Service serviceType;
	private int experience;
	private String certificateImage;
	private boolean approved;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Service getServiceType() {
		return serviceType;
	}

	public void setServiceType(Service serviceType) {
		this.serviceType = serviceType;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getCertificateImage() {
		return certificateImage;
	}

	public void setCertificateImage(String certificateImage) {
		this.certificateImage = certificateImage;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

}
