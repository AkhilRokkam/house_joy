package com.ts.housejoy.service;

import java.util.*;

import com.ts.housejoy.dao.*;
import com.ts.housejoy.dto.*;

public class HouseJoyService {

	public boolean addCategory(Category category) {
		return CategoryDAO.add(category);
	}

	public boolean deleteCategory(int categoryId) {
		
	}

	public Category getCategory(int categoryId) {
		
	}

	public List<Category> getCategories() {
		
	}

	public boolean addSubCategory(SubCategory subCategory) {
		
	}

	public boolean deleteSubCategory(int subCategoryId) {
		
	}

	public SubCategory getSubCategory(int subCategoryId) {
		
	}
	
	
	public List<SubCategory> getSubCategories() {
		
	}

	public List<SubCategory> getSubCategories(int categoryId) {
		
	}
	

	public boolean addServiceType(ServiceType serviceType) {
		
	}

	public boolean deleteServiceType(int serviceTypeId) {
		
	}

	public ServiceType getServiceType(int serviceTypeId) {
		
	}

	public List<ServiceType> getServiceTypes(int subCategoryId) {
		
	}
	
	public List<ServiceType> getForceServiceTypes(int userId) {
		
	}
	
	
	public List<ServiceType> getServiceTypes() {
		
	}
	

	public User registerUser(User user) {
		
	}

	public User loginUser(String email, String password) {
		
	}
	
	
	public User loginAdmin(String email, String password) {		
		
	}

	public User getUserDetails(int userId) {
		
	}

	public User getUserDetails(String emailId) {
		
	}	

	public Address addAddress(Address address) {
		
	}

	public boolean deleteAddress(int addressId) {
		
	}

	public Address getAddress(int addressId) {
		
	}

	public List<Address> getAddressList(int userId) {
		
	}

	public boolean updateUserDetails(String password, long mobileNumber, int userId) {
		
	}

	public Force registerForce(Force force) {
		
	}	
	
	public Force loginForce(String email, String password) {
		
	}	

	public Force getForceDetails(int userId) {
		
	}

	public Force getForceDetails(String emailId) {
		
	}

	public boolean approveForce(int userId,int serviceId,char status) {
		
	}	
}
